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


import com.cl.dao.JuanzengwupinDao;
import com.cl.entity.JuanzengwupinEntity;
import com.cl.service.JuanzengwupinService;
import com.cl.entity.view.JuanzengwupinView;

@Service("juanzengwupinService")
public class JuanzengwupinServiceImpl extends ServiceImpl<JuanzengwupinDao, JuanzengwupinEntity> implements JuanzengwupinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JuanzengwupinEntity> page = this.selectPage(
                new Query<JuanzengwupinEntity>(params).getPage(),
                new EntityWrapper<JuanzengwupinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JuanzengwupinEntity> wrapper) {
		  Page<JuanzengwupinView> page =new Query<JuanzengwupinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JuanzengwupinView> selectListView(Wrapper<JuanzengwupinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JuanzengwupinView selectView(Wrapper<JuanzengwupinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
