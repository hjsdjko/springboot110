package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaruxiaoyouhuiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaruxiaoyouhuiView;


/**
 * 加入校友会
 *
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
public interface JiaruxiaoyouhuiService extends IService<JiaruxiaoyouhuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaruxiaoyouhuiView> selectListView(Wrapper<JiaruxiaoyouhuiEntity> wrapper);
   	
   	JiaruxiaoyouhuiView selectView(@Param("ew") Wrapper<JiaruxiaoyouhuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaruxiaoyouhuiEntity> wrapper);
   	

}

