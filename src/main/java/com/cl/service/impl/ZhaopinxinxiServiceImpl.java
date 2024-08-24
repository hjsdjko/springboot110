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


import com.cl.dao.ZhaopinxinxiDao;
import com.cl.entity.ZhaopinxinxiEntity;
import com.cl.service.ZhaopinxinxiService;
import com.cl.entity.view.ZhaopinxinxiView;

@Service("zhaopinxinxiService")
public class ZhaopinxinxiServiceImpl extends ServiceImpl<ZhaopinxinxiDao, ZhaopinxinxiEntity> implements ZhaopinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaopinxinxiEntity> page = this.selectPage(
                new Query<ZhaopinxinxiEntity>(params).getPage(),
                new EntityWrapper<ZhaopinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaopinxinxiEntity> wrapper) {
		  Page<ZhaopinxinxiView> page =new Query<ZhaopinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhaopinxinxiView> selectListView(Wrapper<ZhaopinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhaopinxinxiView selectView(Wrapper<ZhaopinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
