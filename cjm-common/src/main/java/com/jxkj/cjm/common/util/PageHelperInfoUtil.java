package com.jxkj.cjm.common.util;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class PageHelperInfoUtil {

		//初始化分页相关信息
		public void initPage(Map<String,Object> map, String pageNum, String pageSize){
			Integer num = 1;
			Integer size = 20;

			if (pageNum != null && !"".equals(pageNum)) {
				num = Integer.parseInt(pageNum);
			}
			if (pageSize != null && !"".equals(pageSize)) {
				size = Integer.parseInt(pageSize);
			}
  			PageHelper.startPage(num, size);
 			map.put("pageSize", size);
 
		}
		
		public  PageInfo<Object> initPagehelper(Map<String,Object> map,List list){
			PageInfo<Object> pagehelper = new PageInfo<Object>(list);
 			pagehelper.setNavigateFirstPage(1);
			Integer lastPageNum =0;
			Integer size = (Integer)map.get("pageSize");

			if(pagehelper.getTotal()%size==0){
				lastPageNum = (int)pagehelper.getTotal()/size;
			}else{
				lastPageNum = (int)pagehelper.getTotal()/size + 1 ;
			}
  			pagehelper.setNavigateLastPage(lastPageNum);
 			return pagehelper;
		}
}
