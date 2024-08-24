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

import com.cl.entity.JuankuanxinxiEntity;
import com.cl.entity.view.JuankuanxinxiView;

import com.cl.service.JuankuanxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 捐款信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
@RestController
@RequestMapping("/juankuanxinxi")
public class JuankuanxinxiController {
    @Autowired
    private JuankuanxinxiService juankuanxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JuankuanxinxiEntity juankuanxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			juankuanxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JuankuanxinxiEntity> ew = new EntityWrapper<JuankuanxinxiEntity>();

		PageUtils page = juankuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, juankuanxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JuankuanxinxiEntity juankuanxinxi, 
		HttpServletRequest request){
        EntityWrapper<JuankuanxinxiEntity> ew = new EntityWrapper<JuankuanxinxiEntity>();

		PageUtils page = juankuanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, juankuanxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JuankuanxinxiEntity juankuanxinxi){
       	EntityWrapper<JuankuanxinxiEntity> ew = new EntityWrapper<JuankuanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( juankuanxinxi, "juankuanxinxi")); 
        return R.ok().put("data", juankuanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JuankuanxinxiEntity juankuanxinxi){
        EntityWrapper< JuankuanxinxiEntity> ew = new EntityWrapper< JuankuanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( juankuanxinxi, "juankuanxinxi")); 
		JuankuanxinxiView juankuanxinxiView =  juankuanxinxiService.selectView(ew);
		return R.ok("查询捐款信息成功").put("data", juankuanxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JuankuanxinxiEntity juankuanxinxi = juankuanxinxiService.selectById(id);
		juankuanxinxi = juankuanxinxiService.selectView(new EntityWrapper<JuankuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", juankuanxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JuankuanxinxiEntity juankuanxinxi = juankuanxinxiService.selectById(id);
		juankuanxinxi = juankuanxinxiService.selectView(new EntityWrapper<JuankuanxinxiEntity>().eq("id", id));
        return R.ok().put("data", juankuanxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JuankuanxinxiEntity juankuanxinxi, HttpServletRequest request){
    	juankuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(juankuanxinxi);
        juankuanxinxiService.insert(juankuanxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JuankuanxinxiEntity juankuanxinxi, HttpServletRequest request){
    	juankuanxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(juankuanxinxi);
        juankuanxinxiService.insert(juankuanxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JuankuanxinxiEntity juankuanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(juankuanxinxi);
        juankuanxinxiService.updateById(juankuanxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        juankuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
