package com.cl.dao;

import com.cl.entity.XiaoyouhuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaoyouhuiView;


/**
 * 校友会
 * 
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
public interface XiaoyouhuiDao extends BaseMapper<XiaoyouhuiEntity> {
	
	List<XiaoyouhuiView> selectListView(@Param("ew") Wrapper<XiaoyouhuiEntity> wrapper);

	List<XiaoyouhuiView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoyouhuiEntity> wrapper);
	
	XiaoyouhuiView selectView(@Param("ew") Wrapper<XiaoyouhuiEntity> wrapper);
	

}
