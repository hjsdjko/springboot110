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


import com.cl.dao.ChoukuanxinxiDao;
import com.cl.entity.ChoukuanxinxiEntity;
import com.cl.service.ChoukuanxinxiService;
import com.cl.entity.view.ChoukuanxinxiView;

@Service("choukuanxinxiService")
public class ChoukuanxinxiServiceImpl extends ServiceImpl<ChoukuanxinxiDao, ChoukuanxinxiEntity> implements ChoukuanxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChoukuanxinxiEntity> page = this.selectPage(
                new Query<ChoukuanxinxiEntity>(params).getPage(),
                new EntityWrapper<ChoukuanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChoukuanxinxiEntity> wrapper) {
		  Page<ChoukuanxinxiView> page =new Query<ChoukuanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChoukuanxinxiView> selectListView(Wrapper<ChoukuanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChoukuanxinxiView selectView(Wrapper<ChoukuanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
