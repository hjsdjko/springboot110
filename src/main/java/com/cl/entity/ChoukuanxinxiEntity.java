package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 筹款信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
@TableName("choukuanxinxi")
public class ChoukuanxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChoukuanxinxiEntity() {
		
	}
	
	public ChoukuanxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 筹款标题
	 */
					
	private String choukuanbiaoti;
	
	/**
	 * 筹款副标题
	 */
					
	private String choukuanfubiaoti;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 筹款描述
	 */
					
	private String choukuanmiaoshu;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：筹款标题
	 */
	public void setChoukuanbiaoti(String choukuanbiaoti) {
		this.choukuanbiaoti = choukuanbiaoti;
	}
	/**
	 * 获取：筹款标题
	 */
	public String getChoukuanbiaoti() {
		return choukuanbiaoti;
	}
	/**
	 * 设置：筹款副标题
	 */
	public void setChoukuanfubiaoti(String choukuanfubiaoti) {
		this.choukuanfubiaoti = choukuanfubiaoti;
	}
	/**
	 * 获取：筹款副标题
	 */
	public String getChoukuanfubiaoti() {
		return choukuanfubiaoti;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：筹款描述
	 */
	public void setChoukuanmiaoshu(String choukuanmiaoshu) {
		this.choukuanmiaoshu = choukuanmiaoshu;
	}
	/**
	 * 获取：筹款描述
	 */
	public String getChoukuanmiaoshu() {
		return choukuanmiaoshu;
	}

}
