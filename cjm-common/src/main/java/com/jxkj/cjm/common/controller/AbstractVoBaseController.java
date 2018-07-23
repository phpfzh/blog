package com.jxkj.cjm.common.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.IService;
import com.jxkj.cjm.common.response.AjaxResult;
import com.jxkj.cjm.common.util.HibernateValidatorUtil;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.common.util.TransferUtil;
import com.jxkj.cjm.model.vo.GroupGet;
import com.jxkj.cjm.model.vo.GroupSave;
import com.jxkj.cjm.model.vo.GroupUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractVoBaseController<Entity, EntityVo> extends BaseController<Entity> {
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

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

    protected final Class<EntityVo> entityVoClass;


    @SuppressWarnings("unchecked")
    protected AbstractVoBaseController() {
        Type parentType = this.getClass().getGenericSuperclass();
        // 转成参数类型接口
        ParameterizedType paramterType = (ParameterizedType) parentType;
        // 得到泛型类型
        Type[] types = paramterType.getActualTypeArguments();
        // 得到传入泛型的类
        entityClass = (Class<Entity>) types[0];

        entityVoClass = (Class<EntityVo>) types[1];
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

    public AjaxResult preSaveEntity(Entity entity, EntityVo entityVo) {
        AjaxResult ajaxResult = new AjaxResult();
        HibernateValidatorUtil<EntityVo> validatorUtil = new HibernateValidatorUtil<>();
        String msg = validatorUtil.valida(entityVo, GroupSave.class);
        if (StringUtil.isNotEmpty(msg)) {
            ajaxResult.setMessage(msg);
            ajaxResult.setCode(AjaxResult.FAIL_CODE);
            return ajaxResult;
        }

        //do someting

        try {
            entity = copyEntityByEntityVo(entity, entityVo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            ajaxResult.setMessage(AjaxResult.MESSAGE);
            ajaxResult.setCode(AjaxResult.FAIL_CODE);
            return ajaxResult;
        }

        ajaxResult.setMessage(AjaxResult.SUCCESS_MESSAGE);
        ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
        return ajaxResult;
    }

    /**
     * 新增
     *
     * @param entityVo
     * @return
     */
    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public AjaxResult saveEntity(EntityVo entityVo) {
        try {
            Entity entity = entityClass.newInstance();

            AjaxResult ajaxResult = preSaveEntity(entity, entityVo);
            if (ajaxResult.getCode().equals(AjaxResult.FAIL_CODE)) {
                return ajaxResult;
            }

            boolean ff = baseService.insert(entity);
            if (ff) {
                return AjaxResult.successAjaxResult("保存成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("保存失败");
    }

    public AjaxResult preDelEntity(Long id) {
        AjaxResult ajaxResult = new AjaxResult();
        if (id == null) {
            ajaxResult.setMessage("id 不能为空");
            ajaxResult.setCode(AjaxResult.FAIL_CODE);
            return ajaxResult;
        }

        //do someting
        ajaxResult.setMessage(AjaxResult.SUCCESS_MESSAGE);
        ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
        return ajaxResult;
    }

    /**
     * 删
     *
     * @return
     */
    @RequestMapping(value = "/del", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public AjaxResult delEntity(Long id) {
        try {

            AjaxResult ajaxResult = preDelEntity(id);
            if (ajaxResult.getCode().equals(AjaxResult.FAIL_CODE)) {
                return ajaxResult;
            }

            boolean ff = baseService.deleteById(id);
            if (ff) {
                return AjaxResult.successAjaxResult("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("删除失败");
    }

    public AjaxResult preUpdateEntity(Entity entity, EntityVo entityVo) {
        AjaxResult ajaxResult = new AjaxResult();
        HibernateValidatorUtil<EntityVo> validatorUtil = new HibernateValidatorUtil<>();
        String msg = validatorUtil.valida(entityVo, GroupUpdate.class);
        if (StringUtil.isNotEmpty(msg)) {
            ajaxResult.setMessage(msg);
            ajaxResult.setCode(AjaxResult.FAIL_CODE);
            return ajaxResult;
        }

        //do someting

        try {
            entity = copyEntityByEntityVo(entity, entityVo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            ajaxResult.setMessage(AjaxResult.MESSAGE);
            ajaxResult.setCode(AjaxResult.FAIL_CODE);
            return ajaxResult;
        }

        ajaxResult.setMessage(AjaxResult.SUCCESS_MESSAGE);
        ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
        return ajaxResult;
    }

    /**
     * @param entityVo 修改
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    public AjaxResult updateEntity(EntityVo entityVo) {
        try {
            Entity entity = entityClass.newInstance();
            AjaxResult ajaxResult = preUpdateEntity(entity, entityVo);
            if (ajaxResult.getCode().equals(AjaxResult.FAIL_CODE)) {
                return ajaxResult;
            }

            boolean ff = baseService.updateById(entity);
            if (ff) {
                return AjaxResult.successAjaxResult("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("修改失败");
    }

    public AjaxResult preGetEntity(Entity entity, EntityVo entityVo) {
        AjaxResult ajaxResult = new AjaxResult();
        HibernateValidatorUtil<EntityVo> validatorUtil = new HibernateValidatorUtil<>();
        String msg = validatorUtil.valida(entityVo, GroupGet.class);
        if (StringUtil.isNotEmpty(msg)) {
            ajaxResult.setMessage(msg);
            ajaxResult.setCode(AjaxResult.FAIL_CODE);
            return ajaxResult;
        }

        //do someting

        try {
            entity = copyEntityByEntityVo(entity, entityVo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            ajaxResult.setMessage(AjaxResult.MESSAGE);
            ajaxResult.setCode(AjaxResult.FAIL_CODE);
            return ajaxResult;
        }

        ajaxResult.setMessage(AjaxResult.SUCCESS_MESSAGE);
        ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
        return ajaxResult;
    }

    /**
     * @param entityVo 修改
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getEntity", method = {RequestMethod.POST, RequestMethod.GET})
    public AjaxResult getEntity(EntityVo entityVo) {
        try {
            Entity entity = entityClass.newInstance();
            AjaxResult ajaxResult = preGetEntity(entity, entityVo);
            if (ajaxResult.getCode().equals(AjaxResult.FAIL_CODE)) {
                return ajaxResult;
            }

            List<Entity> lists = baseService.selectByMap(TransferUtil.beanToMap(entity));
            if (lists.size() > 1) {
                throw new IllegalArgumentException("查询出两条以上数据,查询条件：" + JSON.toJSONString(entity));
            }
            if (lists.size() > 0) {
                Entity entity1 = lists.get(0);
                EntityVo entityVo1 = entityVoClass.newInstance();
                entityVo1 = copyEntityVoByEntity(entity1, entityVo1);
                return AjaxResult.successAjaxResult("查询成功", entityVo1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("查询失败");
    }

    public AjaxResult preList(Entity entity, EntityVo entityVo) {
        AjaxResult ajaxResult = new AjaxResult();
        try {
            entity = copyEntityByEntityVo(entity, entityVo);


            // 处理分页请求
            String pageNum = request.getParameter("pageNum");
            String pageSize = request.getParameter("pageSize");
            Map<String, Object> map = new HashMap<>();
            initPage(map, pageNum, pageSize);
            List<Entity> lists = baseService.selectByMap(TransferUtil.beanToMap(entity));
            List<EntityVo> voLists = new ArrayList<>();
            for (Entity entity1 : lists) {
                EntityVo en = entityVoClass.newInstance();
                voLists.add(copyEntityVoByEntity(entity1, en));
            }
            //PageInfo<Object> pagehelper = initPagehelper(map, lists);
            Map<String, Object> ha = new HashMap<>();
            ha.put("list", voLists);
            ha.put("total", voLists.size());
            ha.put("entity", entityVo);
            ajaxResult.setMessage(AjaxResult.SUCCESS_MESSAGE);
            ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
            ajaxResult.setData(ha);
            return ajaxResult;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
         } catch (InstantiationException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        ajaxResult.setMessage(AjaxResult.MESSAGE);
        ajaxResult.setCode(AjaxResult.FAIL_CODE);
        return ajaxResult;
    }

    /**
     * @param entityVo 修改
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public AjaxResult list(EntityVo entityVo) {
        try {
            Entity entity = entityClass.newInstance();
            return preList(entity, entityVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.failAjaxResult("查询失败");
    }

    /**
     * 把前端数据复制到持久化实体类上
     *
     * @param entity   持久化实体类
     * @param entityVo 前端接收数据实体类
     */
    protected Entity copyEntityByEntityVo(Entity entity, EntityVo entityVo) throws IllegalAccessException {
        Field[] entityFields = entity.getClass().getDeclaredFields();
        Field[] entityVoFields = entityVo.getClass().getDeclaredFields();
        for (Field field : entityVoFields) {
            field.setAccessible(true); // 设置些属性是可以访问的
            String name = field.getName();
            Object val = field.get(entityVo);
            Type tpye = field.getGenericType();
            if (!tpye.toString().contains("class")) {//判断是否是属性
                continue;
            }

            if (val == null || "".equals(val)) {
                continue;
            }

            for (Field field1 : entityFields) {
                if (field1.getName().equals(name)) {
                    field1.setAccessible(true); // 设置些属性是可以访问的
                    field1.set(entity, val);
                    break;
                }
            }
        }
        System.out.println(JSON.toJSONString(entity));
        return entity;
    }

    /**
     * 把持久化实体类数据复制到Vo实体类上
     *
     * @param entity   持久化实体类
     * @param entityVo 前端接收数据实体类
     */
    protected EntityVo copyEntityVoByEntity(Entity entity, EntityVo entityVo) throws IllegalAccessException {
        Field[] entityFields = entity.getClass().getDeclaredFields();
        Field[] entityVoFields = entityVo.getClass().getDeclaredFields();
        for (Field field : entityFields) {
            field.setAccessible(true); // 设置些属性是可以访问的
            String name = field.getName();
            Object val = field.get(entity);
            Type tpye = field.getGenericType();
            if (!tpye.toString().contains("class")) {//判断是否是属性
                continue;
            }

            if (val == null || "".equals(val)) {
                continue;
            }

            for (Field field1 : entityVoFields) {
                if (field1.getName().equals(name)) {
                    field1.setAccessible(true); // 设置些属性是可以访问的
                    field1.set(entityVo, val);
                    break;
                }
            }
        }
        System.out.println(JSON.toJSONString(entityVo));
        return entityVo;
    }

}
