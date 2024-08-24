package com.cl.entity.view;

import com.cl.entity.ZhaopinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 招聘信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
@TableName("zhaopinxinxi")
public class ZhaopinxinxiView  extends ZhaopinxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhaopinxinxiView(){
	}
 
 	public ZhaopinxinxiView(ZhaopinxinxiEntity zhaopinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, zhaopinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
