package com.cl.dao;

import com.cl.entity.JuankuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JuankuanxinxiView;


/**
 * 捐款信息
 * 
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
public interface JuankuanxinxiDao extends BaseMapper<JuankuanxinxiEntity> {
	
	List<JuankuanxinxiView> selectListView(@Param("ew") Wrapper<JuankuanxinxiEntity> wrapper);

	List<JuankuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JuankuanxinxiEntity> wrapper);
	
	JuankuanxinxiView selectView(@Param("ew") Wrapper<JuankuanxinxiEntity> wrapper);
	

}
