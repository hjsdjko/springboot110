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


import com.cl.dao.JiaruxiaoyouhuiDao;
import com.cl.entity.JiaruxiaoyouhuiEntity;
import com.cl.service.JiaruxiaoyouhuiService;
import com.cl.entity.view.JiaruxiaoyouhuiView;

@Service("jiaruxiaoyouhuiService")
public class JiaruxiaoyouhuiServiceImpl extends ServiceImpl<JiaruxiaoyouhuiDao, JiaruxiaoyouhuiEntity> implements JiaruxiaoyouhuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaruxiaoyouhuiEntity> page = this.selectPage(
                new Query<JiaruxiaoyouhuiEntity>(params).getPage(),
                new EntityWrapper<JiaruxiaoyouhuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaruxiaoyouhuiEntity> wrapper) {
		  Page<JiaruxiaoyouhuiView> page =new Query<JiaruxiaoyouhuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiaruxiaoyouhuiView> selectListView(Wrapper<JiaruxiaoyouhuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaruxiaoyouhuiView selectView(Wrapper<JiaruxiaoyouhuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
