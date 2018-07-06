package com.jxkj.cjm.common.controller;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
/**
 * 
* @ClassName: AbstractBaseControler 
* @Description: TODO(通用 Controller) 
* @author cjm
* @date 2018年4月20日 下午2:15:02 
 * @param <Entity>
 * 
 * 注意：
 * 这里只实现Controller 的列表，新增，修改，删除 页面显示,操作保存数据库请继承另外实现
 * 
 */
public abstract class AbstractBaseControler<Entity> extends BaseController<Entity>{
	
	/*
	 * 页面后缀
	 */
	public static final String VIEW_LIST   = "_List";
	public static final String VIEW_INSERT = "_Insert";
	public static final String VIEW_UPDATE = "_Update";
	public static final String VIEW_DELETE = "_Delete";
	public static final String VIEW_DETAIL = "_Detail";
	
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private String viewPrefix;

	protected IService<Entity> baseService;


	/**
	 * 注入baseService
	 *
	 * @param baseService
	 */
	@Autowired
	public void setBaseService(IService<Entity> baseService) {
		this.baseService = baseService;
	}

	/**
	 * 实体类型
	 */
	protected final Class<Entity> entityClass;

	@SuppressWarnings("unchecked")
	protected AbstractBaseControler() {
		Type parentType = this.getClass().getGenericSuperclass();
		// 转成参数类型接口
		ParameterizedType paramterType = (ParameterizedType) parentType;
		// 得到泛型类型
		Type[] types = paramterType.getActualTypeArguments();
		// 得到传入泛型的类
		entityClass = (Class<Entity>) types[0];

		setViewPrefix(defaultViewPrefix());
	}

	/**
	 * 为泛型创建对象
	 *
	 * @return
	 */
	protected Entity newEntity() {
		try {
			return entityClass.newInstance();
		} catch (Exception e) {
			throw new IllegalStateException("can not instantiated model : " + this.entityClass, e);
		}
	}

	/**
	 * 获取Controller层RequestMapping中的路径
	 *
	 * @return
	 */
	protected String defaultViewPrefix() {
		String currentViewPrefix = "";
		RequestMapping requestMapping = AnnotationUtils.findAnnotation(getClass(), RequestMapping.class);
		if (requestMapping != null && requestMapping.value().length > 0) {
			currentViewPrefix = requestMapping.value()[0];
		}
		return currentViewPrefix;
	}

	/**
	 * 根据id调用service得到对象
	 *
	 * @param id
	 * @return
	 */
	public Entity get(Long id) {
		if (StringUtil.isNotEmpty(id)) {
			return baseService.selectById(id);
		} else {
			return newEntity();
		}
	}

	/**
	 * 当前模块 视图的前缀 默认 1、获取当前类头上的@RequestMapping中的value作为前缀
	 */
	public void setViewPrefix(String viewPrefix) {
		if (viewPrefix.startsWith("/")) {
			viewPrefix = viewPrefix.substring(1);
		}
		this.viewPrefix = viewPrefix;
	}

	public String getViewPrefix() {
		return viewPrefix;
	}

	/**
	 * 获取视图名称：prefixViewName + "/" + simpleName + suffixName
	 * admin/entity(小写)/entity(驼峰)+ suffixName(_List/_Insert/_Update/_Detail)
	 * admin/platformaccountinfo/platformAccountInfo_List
	 * 
	 * @return
	 */
	public String display(String suffixName) {
		return getViewPrefix().toLowerCase() + "/" + getSimpleName() + suffixName;
	}

	/**
	 * 获取首字母小写的实体类名 ： 比如StudentName-->studentName
	 * 
	 * @return
	 */
	protected String getSimpleName() {
		String simpleName = newEntity().getClass().getSimpleName();
		return simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);
	}

	/**
	 * 把查询条件对象的属性值为空字符串（""）的属性赋值为null
	 * 
	 * @param entity
	 * @return
	 * @throws IllegalAccessException
	 */
	protected Entity changeNullStringToNull(Entity entity) throws IllegalAccessException {
		Field[] fs = entity.getClass().getDeclaredFields();

		for (int i = 0; i < fs.length; i++) {

			Field f = fs[i];

			f.setAccessible(true); // 设置些属性是可以访问的

			Object val = f.get(entity); // 得到此属性的值

			if ("".equals(val)) {
				f.set(entity, null);
			}
		}
		return entity;
	}

	/**
	 * list 运行之前
	 * 
	 * @param model
	 *            数据的载体(可把要传到jsp的数据放入model内)
	 * @param entity
	 *            实体类
	 * @param orderBy
	 *            按某个字段排序如："addTime desc" 如果按默认，就传空字符串""
	 * @throws IllegalAccessException
	 */
	protected void preList(Model model, Entity entity, String orderBy) throws IllegalAccessException {
		// 把查询条件对象的属性值为空字符串（""）的属性赋值为null
		Entity afterHandleEntity = changeNullStringToNull(entity);
		// 处理分页请求
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		Map<String, Object> map = new HashMap<>();
		if (orderBy != null && !orderBy.equals("")) {
			PageHelper.orderBy(orderBy);
		}
		initPage(map, pageNum, pageSize);
		List<Entity> lists = baseService.selectByMap(TransferUtil.beanToMap(afterHandleEntity));

		// PageAjax pageAjax = new PageAjax<Entity>(lists);
		PageInfo<Object> pagehelper = initPagehelper(map, lists);
		model.addAttribute("pagehelper", pagehelper);
		model.addAttribute("sf", sf);
		// 回显查询条件
		model.addAttribute(getSimpleName(), afterHandleEntity);
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model, Entity entity) throws IllegalAccessException {
		preList(model, entity, "");
		//System.out.println(display(Constant.VIEW_LIST));
		return display(VIEW_LIST);
	}

	/**
	 * 根据id查看详情前
	 *
	 * @param model
	 * @param id
	 */
	protected void preDetail(Model model, Long id) {
		Entity entity = get(id);
		model.addAttribute(getSimpleName(), entity);
		model.addAttribute("sf", sf);
	}

	/**
	 * 根据id查看详情
	 *
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "detail/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String view(Model model, @PathVariable("id") Long id) {
		preDetail(model, id);
		return display(VIEW_DETAIL);
	}

	/**
	 * 新增页面前
	 *
	 * @param model
	 */
	protected void preInsertView(Model model) {
		
	}

	/**
	 * 新增页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "insertView", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertView(Model model) {
		preInsertView(model);
		return display(VIEW_INSERT);
	}
 

	/**
	 * 更新前
	 *
	 * @param model
	 * @param id
	 */
	protected void preUpdateView(Model model, Long id) {
		Entity entity = get(id);
		model.addAttribute(getSimpleName(), entity);
	}

	/**
	 * 编辑页面
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateView/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateView(@PathVariable("id") Long id, Model model) {
		preUpdateView(model, id);
		return display(VIEW_UPDATE);
	}
 

	/**
	 * 删除前
	 *
	 * @param model
	 * @param id
	 */
	protected void preDeleteView(Model model, Long id) {
		Entity entity = get(id);
		model.addAttribute(getSimpleName(), entity);
	}

	/**
	 * 删除页面
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteView/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteView(@PathVariable("id") Long id, Model model) {
		preDeleteView(model, id);
		return display(VIEW_DELETE);
	}
 
}
