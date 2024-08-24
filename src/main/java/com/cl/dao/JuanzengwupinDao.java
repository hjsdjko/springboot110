package com.cl.dao;

import com.cl.entity.JuanzengwupinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JuanzengwupinView;


/**
 * 捐赠物品
 * 
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
public interface JuanzengwupinDao extends BaseMapper<JuanzengwupinEntity> {
	
	List<JuanzengwupinView> selectListView(@Param("ew") Wrapper<JuanzengwupinEntity> wrapper);

	List<JuanzengwupinView> selectListView(Pagination page,@Param("ew") Wrapper<JuanzengwupinEntity> wrapper);
	
	JuanzengwupinView selectView(@Param("ew") Wrapper<JuanzengwupinEntity> wrapper);
	

}
