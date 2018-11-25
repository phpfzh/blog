package com.jxkj.cjm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxkj.cjm.common.response.ProcessBack;
import com.jxkj.cjm.common.util.AttachUtil;
import com.jxkj.cjm.common.util.DateUtils;
import com.jxkj.cjm.common.util.StringUtil;
import com.jxkj.cjm.mapper.ForumThreadMapper;
import com.jxkj.cjm.mapper.ForumThreadReplyMapper;
import com.jxkj.cjm.mapper.UserMapper;
import com.jxkj.cjm.model.ForumThread;
import com.jxkj.cjm.model.ForumThreadReply;
import com.jxkj.cjm.model.ForumThreadReplyAttach;
import com.jxkj.cjm.model.User;
import com.jxkj.cjm.model.vo.ForumThreadReplyVo;
import com.jxkj.cjm.model.vo.GroupSave;
import com.jxkj.cjm.model.vo.GroupUpdate;
import com.jxkj.cjm.service.ForumThreadReplyAttachService;
import com.jxkj.cjm.service.ForumThreadReplyService;
import com.jxkj.cjm.service.ForumThreadService;


@Service
public class ForumThreadReplyServiceImpl extends ServiceImpl<ForumThreadReplyMapper, ForumThreadReply> implements ForumThreadReplyService {

    private Lock saveLock = new ReentrantLock();
    private Lock updateLock = new ReentrantLock();
    @Value("${cjm.fdfs.host}")
    private String fdfsurl;//图片服务器路径
    
    @Value("${cjm.app.host}")
    private String appsurl;//应用服务器路径
 
    @Resource
    private ForumThreadReplyAttachService forumThreadReplyAttachService;
    
     @Resource
    private ForumThreadService forumThreadService;

    @Resource
    private ForumThreadMapper forumThreadMapper;
    
    @Resource
    private UserMapper userMapper;
    
    /**
  	 * 
  	* @Title: insertForumThreadReplay 
  	* @Description: TODO(保存回复) 
  	* @param @param text
  	* @param @return    设定文件 
  	* @return String    返回类型 
  	* @throws
  	 */
    @Transactional
    @Override
    public ProcessBack insertForumThreadReplay(User user, ForumThreadReplyVo forumThreadReplyVo) {
        ProcessBack processBack = new ProcessBack();
        try {
            saveLock.lock();
  
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<ForumThreadReplyVo>> constraintViolations = validator.validate(forumThreadReplyVo, GroupSave.class);
            if (constraintViolations.iterator().hasNext() && constraintViolations.iterator().next().getMessage() != null) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage(constraintViolations.iterator().next().getMessage());
                return processBack;
            }

            ForumThreadReply parentForumThreadReply = null;
            if (forumThreadReplyVo.getParentid() != null) {
                parentForumThreadReply = baseMapper.selectById(forumThreadReplyVo.getParentid());
                if (parentForumThreadReply == null) {
                    processBack.setCode(ProcessBack.FAIL_CODE);
                    processBack.setMessage("parentid 错误");
                    return processBack;
                }
            }
            
            Long Tbaseid = null;
            if(forumThreadReplyVo.getReplytype() != null && forumThreadReplyVo.getReplytype().equals(1)){
             	ForumThread forumThread = forumThreadMapper.selectById(forumThreadReplyVo.getTid());
            	if (forumThread == null) {
            		processBack.setCode(ProcessBack.FAIL_CODE);
            		processBack.setMessage("主题信息找不到");
            		return processBack;
            	}
            	Tbaseid = forumThread.getBaseid();
            }
            
            String fusername = "";//回复目标用户

            String firstmark = StringUtil.getNo();
            Long dateLine = System.currentTimeMillis();
            ForumThreadReply forumThreadReply = new ForumThreadReply();
            forumThreadReply.setFirst(1);
            forumThreadReply.setTbaseid(forumThreadReplyVo.getTbaseid());
            forumThreadReply.setParentid((long) 0);
            forumThreadReply.setFirstmark(firstmark);
            forumThreadReply.setTid(forumThreadReplyVo.getTid());
            forumThreadReply.setBaseid(user.getId());
            forumThreadReply.setDatetime(dateLine);
            forumThreadReply.setMessage(forumThreadReplyVo.getMessage());
            forumThreadReply.setUserip(forumThreadReplyVo.getUserip());
            forumThreadReply.setStatus(0);//是否通过审核 -1审核中 -2 审核失败 0审核通过
            forumThreadReply.setLike(0);
            forumThreadReply.setHate(0);
            forumThreadReply.setIsdelete(0);
            forumThreadReply.setReplytype(1);
            if(forumThreadReplyVo.getReplytype() != null){
            	 forumThreadReply.setReplytype(forumThreadReplyVo.getReplytype());
            }
            
            if (parentForumThreadReply != null) {
 	 			User fuser = userMapper.selectById(parentForumThreadReply.getBaseid());
	 			fusername = fuser.getUsername();
                
                if(parentForumThreadReply.getFirst().equals(1)){
                 	forumThreadReply.setFirst(2);
                }else{
                	forumThreadReply.setFirst(3);
                }	
                
                forumThreadReply.setTbaseid(parentForumThreadReply.getBaseid());
                forumThreadReply.setParentid(parentForumThreadReply.getId());
                forumThreadReply.setFirstmark(parentForumThreadReply.getFirstmark());
            } else {
                forumThreadReply.setTbaseid(Tbaseid);//首次评论主题
            }
            
            List<ForumThreadReplyAttach> attachs = new ArrayList<>();
            String  content = forumThreadReplyVo.getMessage();
            //判断是否有图片
            AttachUtil attachUtil = new AttachUtil();
            Map<String, String> map = attachUtil.getImgSrcList(content);
            //替换成attach标签
            for (Map.Entry<String, String> entry : map.entrySet()) {
            	String imgStr = entry.getValue();
            	String attach = imgStr.substring(this.fdfsurl.length());
        	    ForumThreadReplyAttach fttach = forumThreadReplyAttachService.getForumThreadReplyAttachByAttach(attach);
                if (fttach != null) {
                     content = content.replaceFirst(entry.getKey(), "[attach]" + fttach.getId() + "[/attach]");
                     attachs.add(fttach);
                }
            }

            if (forumThreadReplyVo.getImgs() != null && StringUtil.isNotEmpty(forumThreadReplyVo.getImgs())) {
                String[] imgs = forumThreadReplyVo.getImgs().split(",");
                for (String s : imgs) {
                    String attach = s.substring(this.fdfsurl.length());
                    ForumThreadReplyAttach fttach = forumThreadReplyAttachService.getForumThreadReplyAttachByAttach(attach);
                    if (fttach != null) {
                         content = content+"[attach]" + fttach.getId() + "[/attach]"; 
                         attachs.add(fttach);
                    }
                }
            }

            int count = 0;
            count = baseMapper.insert(forumThreadReply);
            if (!(count > 0)) {
                throw new IllegalArgumentException("保存失败");
            }
            
            for(ForumThreadReplyAttach replyAttach :attachs){
            	replyAttach.setBaseid(user.getId());
            	replyAttach.setReplyid(forumThreadReply.getId());
            	replyAttach.setStatus(1);
            	replyAttach.setIsdelete(0);
            }
            
            if(attachs.size() > 0){
             	boolean ff = forumThreadReplyAttachService.updateBatchById(attachs);
            	if (!ff) {
            		throw new IllegalArgumentException("回复图片记录更新失败");
            	}
            }
              
    		String message = parseAttach(content);
	 		String datestr = DateUtils.formatYYMMddHHMM(forumThreadReply.getDatetime());//回复时间
        	Map<String,String> mapss = new HashMap<>();
        	mapss.put("message", message);//回复内容
        	mapss.put("id", forumThreadReply.getId().toString());//id
        	mapss.put("parentid", forumThreadReplyVo.getParentid()+"");//id
        	
        	mapss.put("datestr", datestr);//回复时间
        	mapss.put("username", user.getUsername());//回复用户
        	mapss.put("fusername", fusername);//回复目标用户
        	mapss.put("headurl", this.fdfsurl+user.getImg());//回复用户头像
        	mapss.put("signature", user.getSignature() == null ? "":user.getSignature());//个性签名
        	
            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("保存成功");
            processBack.setData(mapss);
            return processBack;
        } catch (RuntimeException e) {
        	 e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            saveLock.unlock();
        }

        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }
    
    /**
  	 * 
  	* @Title: updateForumThreadReplay 
  	* @Description: TODO(回复修改) 
  	* @param @param text
  	* @param @return    设定文件 
  	* @return String    返回类型 
  	* @throws
  	 */
    @Transactional
    @Override
    public ProcessBack updateForumThreadReplay(User user, ForumThreadReplyVo forumThreadReplyVo) {
        ProcessBack processBack = new ProcessBack();
        try {
        	updateLock.lock();
  
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<ForumThreadReplyVo>> constraintViolations = validator.validate(forumThreadReplyVo, GroupUpdate.class);
            if (constraintViolations.iterator().hasNext() && constraintViolations.iterator().next().getMessage() != null) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage(constraintViolations.iterator().next().getMessage());
                return processBack;
            }
              
            List<ForumThreadReplyAttach> attachs = new ArrayList<>();
            String  content = forumThreadReplyVo.getMessage();
            //判断是否有图片
            AttachUtil attachUtil = new AttachUtil();
            Map<String, String> map = attachUtil.getImgSrcList(content);
             //替换成attach标签
            for (Map.Entry<String, String> entry : map.entrySet()) {
            	String imgStr = entry.getValue();
            	if(imgStr.contains("static/images/face/")){
	 				continue;//表情忽略
	 			}
            	String attach = imgStr.substring(this.fdfsurl.length());
        	    ForumThreadReplyAttach fttach = forumThreadReplyAttachService.getForumThreadReplyAttachByAttach(attach);
                if (fttach != null) {
                     content = content.replaceFirst(entry.getKey(), "[attach]" + fttach.getId() + "[/attach]");
                     attachs.add(fttach);
                }
            }

            if (forumThreadReplyVo.getImgs() != null && StringUtil.isNotEmpty(forumThreadReplyVo.getImgs())) {
                String[] imgs = forumThreadReplyVo.getImgs().split(",");
                for (String s : imgs) {
                	if(s.contains("static/images/face/")){
    	 				continue;//表情忽略
    	 			}
                	
                    String attach = s.substring(this.fdfsurl.length());
                    ForumThreadReplyAttach fttach = forumThreadReplyAttachService.getForumThreadReplyAttachByAttach(attach);
                    if (fttach != null) {
                         content = content+"[attach]" + fttach.getId() + "[/attach]"; 
                         attachs.add(fttach);
                    }
                }
            }
            
            //获取表情
	 		Map<String,String> emtSrcs = attachUtil.getImgEmtList(content);
	 		 //替换表情
	 		for(Map.Entry<String,String> entry2 : emtSrcs.entrySet()){
				//替换标签
				content = content.replaceFirst(entry2.getKey(), "[emt]"+entry2.getValue()+"[/emt]");
			}
	 		
	 		Long dateLine = System.currentTimeMillis();
	 		ForumThreadReply forumThreadReply = new ForumThreadReply();
	 		forumThreadReply.setId(forumThreadReplyVo.getId());
	 		forumThreadReply.setOperdatetime(dateLine);
	 		forumThreadReply.setOpermanid(user.getId());
            int count = 0;
            forumThreadReply.setMessage(content);
            count = baseMapper.updateById(forumThreadReply);
            if (!(count > 0)) {
                throw new IllegalArgumentException("回复更新失败");
            }
            
            for(ForumThreadReplyAttach replyAttach :attachs){
            	replyAttach.setBaseid(user.getId());
            	replyAttach.setReplyid(forumThreadReply.getId());
            	replyAttach.setStatus(1);
            	replyAttach.setIsdelete(0);
            }
            
            if(attachs.size() > 0){
             	boolean ff = forumThreadReplyAttachService.updateBatchById(attachs);
            	if (!ff) {
            		throw new IllegalArgumentException("回复图片记录更新失败");
            	}
            }
          
            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("修改成功");
             return processBack;
        } catch (RuntimeException e) {
        	e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	updateLock.unlock();
        }

        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }
    
    /**
	 * 条件查询回复记录
	 * @param pageNum
	 * @param pageSize
	 * @param replyVo
	 * @return
	 */
	@Override
	public ProcessBack findPrePortalReplys(String pageNum,String pageSize,ForumThreadReplyVo replyVo){
		ProcessBack back = new ProcessBack();
		try{
			
 			Integer num = 1;
			Integer size = 20;//默认20条
 			if (pageNum != null && !"".equals(pageNum)) {
				num = Integer.parseInt(pageNum);
			}
			if (pageSize != null && !"".equals(pageSize)) {
				size = Integer.parseInt(pageSize);
			}
			//设置分页
  			PageHelper.startPage(num, size);
  			
  			PageHelper.orderBy("datetime ASC");
  			
  			Wrapper<ForumThreadReply>  wrapper = Condition.create();
  			if(replyVo.getBaseid() != null && replyVo.getBaseid().intValue() > 0){
  				wrapper.eq("baseid", replyVo.getBaseid());//用户id
  			}
  			
  			if(replyVo.getReplytype() != null){
  				wrapper.eq("replytype", replyVo.getReplytype());//1帖子
  			}
  			
  			if(replyVo.getTid() != null){
  				wrapper.eq("tid", replyVo.getTid());//帖子id
  			}
  			
  			if(replyVo.getFirst() != null){
  				wrapper.eq("first", replyVo.getFirst());//回复类型 1 首次回复主题 2 二次回复 3多次回复
  			}
  			
  			if(replyVo.getFirstmark() != null){
  				wrapper.eq("firstmark", replyVo.getFirstmark());//首次回复标识 帖子下的首次回复
  			}
  			
  			if(replyVo.getStatus() != null){
  				wrapper.eq("status", replyVo.getStatus());//0审核通过 -1 审核中 -2 审核失败
  			}
  			
  			if(replyVo.getNotequalrt() != null){
  				wrapper.ne("first", replyVo.getNotequalrt());//查多次回复 不需要首次回复的数据
  				PageHelper.orderBy("first ASC,datetime ASC");
  			}
  			
   			List<ForumThreadReply> lists = baseMapper.selectList(wrapper);
   			List<ForumThreadReplyVo> vos = new ArrayList<>();
   			for(ForumThreadReply reply:lists){
   				String tusername = "";
   				if(reply.getTbaseid() != null){
     				User tuser = userMapper.selectById(reply.getTbaseid());
     				if(tuser != null){
     					tusername = tuser.getUsername();
     				}
   				}
 	 			
   				String username = "";
   				String signature = "";
   				User user = userMapper.selectById(reply.getBaseid());
	 			if(user != null){
   	 				username = user.getUsername();
   	 				signature = user.getSignature();
	 			}
   				
	 			ForumThreadReplyVo vo = new ForumThreadReplyVo();
   				vo.setId(reply.getId());//id
   				vo.setBaseid(reply.getBaseid());//用户id
   				vo.setUsername(username);//用户名
   				vo.setTbaseid(reply.getTbaseid());//回复目标用户id
   				vo.setTusername(tusername);//回复目标用户名
    			vo.setFirstmark(reply.getFirstmark());//首次回复标识 
   				vo.setReplytype(reply.getReplytype());//回复类型 1 首次回复主题 2 二次回复 3多次回复
   				vo.setTid(reply.getTid());//1 帖子id
   				vo.setReplytype(reply.getReplytype());//1帖子
   				vo.setFirst(reply.getFirst());
   				String datestr = DateUtils.formatYYMMddHHMM(reply.getDatetime());//回复时间
   				vo.setDatestr(datestr);
   				String con = parseAttach(reply.getMessage());
    			vo.setMessage(con);//回复内容
   				if(reply.getReplytype() == 1){//首次回复前端才显示用户头像
   					String avatarpath = this.fdfsurl+user.getImg();
     			    vo.setHeadurl(avatarpath);//用户头像
      					//个性签名
    				vo.setSignature(signature);
    			}
   				vos.add(vo);
   				
   				if(reply.getReplytype().equals(1)){
   	             	forumThreadService.updateForumThreadReplies(reply.getTid());
   	            }
    		}
   			
    		PageInfo<ForumThreadReply> pagehelper = new PageInfo<ForumThreadReply>(lists);
      		
   			//计算页码
  			pagehelper.setNavigateFirstPage(1);
			Integer lastPageNum =0;
  			if(pagehelper.getTotal()%size==0){
				lastPageNum = (int)pagehelper.getTotal()/size;
			}else{
				lastPageNum = (int)pagehelper.getTotal()/size + 1 ;
			}
  			pagehelper.setNavigateLastPage(lastPageNum);
  			
  			Map<String,Object> map = new HashMap<>();
  			map.put("vos", vos);
  			map.put("pagehelper", pagehelper);
     		back.setCode(ProcessBack.SUCCESS_CODE);
  			back.setMessage("查询成功");
  			back.setData(map);
  			return back;
		}catch(Exception e){
			e.printStackTrace();
		}
		back.setCode(ProcessBack.FAIL_CODE);
		back.setMessage(ProcessBack.EXCEPTION_MESSAGE);
		return back;
	}
	
	
    
    
    /**
  	 * 
  	* @Title: delForumThreadReplay 
  	* @Description: TODO(单个删除) 
  	* @param @param text
  	* @param @return    设定文件 
  	* @return String    返回类型 
  	* @throws
  	 */
    @Transactional
    @Override
    public ProcessBack delForumThreadReplay(Long repayId) {
        ProcessBack processBack = new ProcessBack();
        try {

            if (repayId == null) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage("repayId 不能为空");
                return processBack;
            }

            Wrapper<ForumThreadReplyAttach> forumThreadReplyAttachWrapper = Condition.create();
            forumThreadReplyAttachWrapper.eq("replyid", repayId);
            List<ForumThreadReplyAttach> lists = forumThreadReplyAttachService.selectList(forumThreadReplyAttachWrapper);
            for (ForumThreadReplyAttach forumThreadReplyAttach : lists) {
                forumThreadReplyAttach.setIsdelete(1);
                forumThreadReplyAttachService.updateById(forumThreadReplyAttach);
            }
            int count = 0;
            count = baseMapper.deleteById(repayId);
            if (!(count > 0)) {
                throw new IllegalArgumentException("删除失败");
            }

            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("删除成功");
            return processBack;

        } catch (RuntimeException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }
    /**
  	 * 
  	* @Title: auditBatchForumThreadReplay 
  	* @Description: TODO(批量审核) 
  	* @param @param text
  	* @param @return    设定文件 
  	* @return String    返回类型 
  	* @throws
  	 */
    @Override
    @Transactional
    public ProcessBack auditBatchForumThreadReplay(Long baseid, String repayIds, String status, String remark) {
        ProcessBack processBack = new ProcessBack();
        try {

            if (StringUtil.isEmpty(repayIds)) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage("repayIds 不能为空");
                return processBack;
            }

            if (StringUtil.isEmpty(status)) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage("status 不能为空");
                return processBack;
            }

            String[] strs = repayIds.split(",");
            Long dateline = System.currentTimeMillis();
            for (String s : strs) {
                Long res = Long.valueOf(s);
                ForumThreadReply forumThreadReply = baseMapper.selectById(res);
                if (forumThreadReply != null) {
                    forumThreadReply.setStatus(-2);//默认审核不通过
                    forumThreadReply.setOpermanid(baseid);
                    forumThreadReply.setOperdatetime(dateline);
                    forumThreadReply.setRemark(remark);
                    if (status.equals("1")) {//审核通过
                        forumThreadReply.setStatus(0);
                        forumThreadReply.setIsdelete(0);
                    }
                    int count = 0;
                    count = baseMapper.updateById(forumThreadReply);
                    if (!(count > 0)) {
                        throw new IllegalArgumentException("更新失败");
                    }
                    
                    if(forumThreadReply.getReplytype().equals(1)){
                     	forumThreadService.updateForumThreadReplies(forumThreadReply.getTid());
                    }
                }
            }
            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("操作成功");
            return processBack;
        } catch (RuntimeException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }
    /**
	 * 
	* @Title: delBatchForumThreadReplay 
	* @Description: TODO(批量删除) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
    @Override
    @Transactional
    public ProcessBack delBatchForumThreadReplay(String repayIds) {
        ProcessBack processBack = new ProcessBack();
        try {

            if (StringUtil.isEmpty(repayIds)) {
                processBack.setCode(ProcessBack.FAIL_CODE);
                processBack.setMessage("repayIds 不能为空");
                return processBack;
            }

            String[] strs = repayIds.split(",");
            for (String s : strs) {
                Long repayId = Long.valueOf(s);
                Wrapper<ForumThreadReplyAttach> forumThreadReplyAttachWrapper = Condition.create();
                forumThreadReplyAttachWrapper.eq("replyid", repayId);
                List<ForumThreadReplyAttach> lists = forumThreadReplyAttachService.selectList(forumThreadReplyAttachWrapper);
                for (ForumThreadReplyAttach forumThreadReplyAttach : lists) {
                    forumThreadReplyAttach.setIsdelete(1);
                    forumThreadReplyAttachService.updateById(forumThreadReplyAttach);
                }
               
                int count = 0;
                count = baseMapper.deleteById(repayId);
                if (!(count > 0)) {
                    throw new IllegalArgumentException("删除失败");
                }
             }
            processBack.setCode(ProcessBack.SUCCESS_CODE);
            processBack.setMessage("操作成功");
            return processBack;
        } catch (RuntimeException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//数据回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        processBack.setCode(ProcessBack.FAIL_CODE);
        processBack.setMessage(ProcessBack.EXCEPTION_MESSAGE);
        return processBack;
    }
    
    /**
	 * 
	* @Title: parseAttach 
	* @Description: TODO(返回给前端前进行attach 解析) 
	* @param @param text
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@Override
	public String parseAttach(String text){
		   //判断是否有图片
        AttachUtil attachUtil = new AttachUtil();
        if(StringUtil.isEmpty(text)){
			return text;
		}
		
		List<String> attachs = attachUtil.getAttachAidByContent(text);
		for(String str : attachs){
			Long aid  = Long.valueOf(str);
			ForumThreadReplyAttach attach = forumThreadReplyAttachService.selectById(aid);
			if(attach != null){
				if(attach.getAttach() != null){
					String wattachment = this.fdfsurl + attach.getAttach() ;
					text = text.replaceFirst("\\[attach]"+str+"\\[/attach]", "<p><img id='pilaimg_"+str+"' aid='"+str+"' src='"+wattachment+"' class='pil_zoom'></p>");
				} 
			}
		}
 		
		List<String> emts = attachUtil.getemtByContent(text);
		if(emts.size() > 0){
 			for(String str : emts){
 				text = text.replaceFirst("\\[emt]"+str+"\\[/emt]", "<img src='"+this.appsurl+"static/images/face/"+str+".gif' \\/>");
  			}
		}
 		return text;
	}
	
	/**
	 * 获取总回复数
	 * @param replyVo
	 * @return
	 */
	@Override
	public int findForumThreadReplyTotal(ForumThreadReplyVo replyVo){
		Wrapper<ForumThreadReply> wrapper = Condition.create();
		if(replyVo.getBaseid() != null && replyVo.getBaseid().intValue() > 0){
			wrapper.eq("baseid", replyVo.getBaseid());//用户id
		}
		
		if(replyVo.getReplytype() != null){
			wrapper.eq("replytype", replyVo.getReplytype());//1帖子
		}
		
		if(replyVo.getTid() != null){
			wrapper.eq("tid", replyVo.getTid());//帖子id
		}
		
		if(replyVo.getReplytype() != null){
			wrapper.eq("replytype", replyVo.getReplytype());//回复类型 1 首次回复帖子  2 二次回复 3多次回复
		}
		
		if(replyVo.getFirstmark() != null){
			wrapper.eq("firstmark", replyVo.getFirstmark());//首次回复标识 帖子下的首次回复
		}
		
		if(replyVo.getStatus() != null){
			wrapper.eq("status", replyVo.getStatus());//0审核通过 -1 审核中 -2 审核失败
		}
  		return baseMapper.selectCount(wrapper);
	}
	 
}
