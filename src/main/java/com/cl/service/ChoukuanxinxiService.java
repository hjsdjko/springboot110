package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChoukuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChoukuanxinxiView;


/**
 * 筹款信息
 *
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
public interface ChoukuanxinxiService extends IService<ChoukuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChoukuanxinxiView> selectListView(Wrapper<ChoukuanxinxiEntity> wrapper);
   	
   	ChoukuanxinxiView selectView(@Param("ew") Wrapper<ChoukuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChoukuanxinxiEntity> wrapper);
   	

}

