package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.XiaoyouhuiDao;
import com.cl.entity.XiaoyouhuiEntity;
import com.cl.service.XiaoyouhuiService;
import com.cl.entity.view.XiaoyouhuiView;

@Service("xiaoyouhuiService")
public class XiaoyouhuiServiceImpl extends ServiceImpl<XiaoyouhuiDao, XiaoyouhuiEntity> implements XiaoyouhuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoyouhuiEntity> page = this.selectPage(
                new Query<XiaoyouhuiEntity>(params).getPage(),
                new EntityWrapper<XiaoyouhuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoyouhuiEntity> wrapper) {
		  Page<XiaoyouhuiView> page =new Query<XiaoyouhuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiaoyouhuiView> selectListView(Wrapper<XiaoyouhuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoyouhuiView selectView(Wrapper<XiaoyouhuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
