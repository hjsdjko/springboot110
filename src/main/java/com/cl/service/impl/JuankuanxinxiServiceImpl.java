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


import com.cl.dao.JuankuanxinxiDao;
import com.cl.entity.JuankuanxinxiEntity;
import com.cl.service.JuankuanxinxiService;
import com.cl.entity.view.JuankuanxinxiView;

@Service("juankuanxinxiService")
public class JuankuanxinxiServiceImpl extends ServiceImpl<JuankuanxinxiDao, JuankuanxinxiEntity> implements JuankuanxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JuankuanxinxiEntity> page = this.selectPage(
                new Query<JuankuanxinxiEntity>(params).getPage(),
                new EntityWrapper<JuankuanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JuankuanxinxiEntity> wrapper) {
		  Page<JuankuanxinxiView> page =new Query<JuankuanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JuankuanxinxiView> selectListView(Wrapper<JuankuanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JuankuanxinxiView selectView(Wrapper<JuankuanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
