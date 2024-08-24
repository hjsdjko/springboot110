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


import com.cl.dao.ForumDao;
import com.cl.entity.ForumEntity;
import com.cl.service.ForumService;
import com.cl.entity.view.ForumView;

@Service("forumService")
public class ForumServiceImpl extends ServiceImpl<ForumDao, ForumEntity> implements ForumService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ForumEntity> page = this.selectPage(
                new Query<ForumEntity>(params).getPage(),
                new EntityWrapper<ForumEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ForumEntity> wrapper) {
		  Page<ForumView> page =new Query<ForumView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ForumView> selectListView(Wrapper<ForumEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ForumView selectView(Wrapper<ForumEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
