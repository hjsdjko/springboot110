package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JuanzengwupinEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JuanzengwupinView;


/**
 * 捐赠物品
 *
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
public interface JuanzengwupinService extends IService<JuanzengwupinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JuanzengwupinView> selectListView(Wrapper<JuanzengwupinEntity> wrapper);
   	
   	JuanzengwupinView selectView(@Param("ew") Wrapper<JuanzengwupinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JuanzengwupinEntity> wrapper);
   	

}

