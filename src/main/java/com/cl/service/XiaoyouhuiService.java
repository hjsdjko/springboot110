package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiaoyouhuiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaoyouhuiView;


/**
 * 校友会
 *
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
public interface XiaoyouhuiService extends IService<XiaoyouhuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoyouhuiView> selectListView(Wrapper<XiaoyouhuiEntity> wrapper);
   	
   	XiaoyouhuiView selectView(@Param("ew") Wrapper<XiaoyouhuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoyouhuiEntity> wrapper);
   	

}

