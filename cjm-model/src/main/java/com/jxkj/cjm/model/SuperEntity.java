package com.jxkj.cjm.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@SuppressWarnings("rawtypes")
public class SuperEntity<T extends Model> extends Model<T>{
	
	@TableId(type=IdType.AUTO)
 	private Long id;
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Serializable pkVal() {
 		return this.id;
	}

}
