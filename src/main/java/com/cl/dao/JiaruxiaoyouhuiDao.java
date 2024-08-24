package com.cl.dao;

import com.cl.entity.JiaruxiaoyouhuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaruxiaoyouhuiView;


/**
 * 加入校友会
 * 
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
public interface JiaruxiaoyouhuiDao extends BaseMapper<JiaruxiaoyouhuiEntity> {
	
	List<JiaruxiaoyouhuiView> selectListView(@Param("ew") Wrapper<JiaruxiaoyouhuiEntity> wrapper);

	List<JiaruxiaoyouhuiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaruxiaoyouhuiEntity> wrapper);
	
	JiaruxiaoyouhuiView selectView(@Param("ew") Wrapper<JiaruxiaoyouhuiEntity> wrapper);
	

}
