package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JuankuanxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JuankuanxinxiView;


/**
 * 捐款信息
 *
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
public interface JuankuanxinxiService extends IService<JuankuanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JuankuanxinxiView> selectListView(Wrapper<JuankuanxinxiEntity> wrapper);
   	
   	JuankuanxinxiView selectView(@Param("ew") Wrapper<JuankuanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JuankuanxinxiEntity> wrapper);
   	

}

