package com.cl.dao;

import com.cl.entity.ChoukuanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChoukuanxinxiView;


/**
 * 筹款信息
 * 
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
public interface ChoukuanxinxiDao extends BaseMapper<ChoukuanxinxiEntity> {
	
	List<ChoukuanxinxiView> selectListView(@Param("ew") Wrapper<ChoukuanxinxiEntity> wrapper);

	List<ChoukuanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChoukuanxinxiEntity> wrapper);
	
	ChoukuanxinxiView selectView(@Param("ew") Wrapper<ChoukuanxinxiEntity> wrapper);
	

}
