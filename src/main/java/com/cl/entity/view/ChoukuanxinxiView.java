package com.cl.entity.view;

import com.cl.entity.ChoukuanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 筹款信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
@TableName("choukuanxinxi")
public class ChoukuanxinxiView  extends ChoukuanxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChoukuanxinxiView(){
	}
 
 	public ChoukuanxinxiView(ChoukuanxinxiEntity choukuanxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, choukuanxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
