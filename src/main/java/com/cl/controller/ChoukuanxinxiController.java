package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ChoukuanxinxiEntity;
import com.cl.entity.view.ChoukuanxinxiView;

import com.cl.service.ChoukuanxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 筹款信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
@RestController
@RequestMapping("/choukuanxinxi")
public class ChoukuanxinxiController {
    @Autowired
    private ChoukuanxinxiService choukuanxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChoukuanxinxiEntity choukuanxinxi,
		HttpServletRequest request){
        EntityWrapper<ChoukuanxinxiEntity> ew = new EntityWrapper<ChoukuanxinxiEntity>();

		PageUtils page = choukuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, choukuanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChoukuanxinxiEntity choukuanxinxi, 
		HttpServletRequest request){
        EntityWrapper<ChoukuanxinxiEntity> ew = new EntityWrapper<ChoukuanxinxiEntity>();

		PageUtils page = choukuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, choukuanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChoukuanxinxiEntity choukuanxinxi){
       	EntityWrapper<ChoukuanxinxiEntity> ew = new EntityWrapper<ChoukuanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( choukuanxinxi, "choukuanxinxi")); 
        return R.ok().put("data", choukuanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChoukuanxinxiEntity choukuanxinxi){
        EntityWrapper< ChoukuanxinxiEntity> ew = new EntityWrapper< ChoukuanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( choukuanxinxi, "choukuanxinxi")); 
		ChoukuanxinxiView choukuanxinxiView =  choukuanxinxiService.selectView(ew);
		return R.ok("查询筹款信息成功").put("data", choukuanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChoukuanxinxiEntity choukuanxinxi = choukuanxinxiService.selectById(id);
		choukuanxinxi = choukuanxinxiService.selectView(new EntityWrapper<ChoukuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", choukuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChoukuanxinxiEntity choukuanxinxi = choukuanxinxiService.selectById(id);
		choukuanxinxi = choukuanxinxiService.selectView(new EntityWrapper<ChoukuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", choukuanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChoukuanxinxiEntity choukuanxinxi, HttpServletRequest request){
    	choukuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(choukuanxinxi);
        choukuanxinxiService.insert(choukuanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChoukuanxinxiEntity choukuanxinxi, HttpServletRequest request){
    	choukuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(choukuanxinxi);
        choukuanxinxiService.insert(choukuanxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChoukuanxinxiEntity choukuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(choukuanxinxi);
        choukuanxinxiService.updateById(choukuanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        choukuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
