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

import com.cl.entity.JiaruxiaoyouhuiEntity;
import com.cl.entity.view.JiaruxiaoyouhuiView;

import com.cl.service.JiaruxiaoyouhuiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 加入校友会
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
@RestController
@RequestMapping("/jiaruxiaoyouhui")
public class JiaruxiaoyouhuiController {
    @Autowired
    private JiaruxiaoyouhuiService jiaruxiaoyouhuiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaruxiaoyouhuiEntity jiaruxiaoyouhui,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiaruxiaoyouhui.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaruxiaoyouhuiEntity> ew = new EntityWrapper<JiaruxiaoyouhuiEntity>();

		PageUtils page = jiaruxiaoyouhuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaruxiaoyouhui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaruxiaoyouhuiEntity jiaruxiaoyouhui, 
		HttpServletRequest request){
        EntityWrapper<JiaruxiaoyouhuiEntity> ew = new EntityWrapper<JiaruxiaoyouhuiEntity>();

		PageUtils page = jiaruxiaoyouhuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaruxiaoyouhui), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaruxiaoyouhuiEntity jiaruxiaoyouhui){
       	EntityWrapper<JiaruxiaoyouhuiEntity> ew = new EntityWrapper<JiaruxiaoyouhuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaruxiaoyouhui, "jiaruxiaoyouhui")); 
        return R.ok().put("data", jiaruxiaoyouhuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaruxiaoyouhuiEntity jiaruxiaoyouhui){
        EntityWrapper< JiaruxiaoyouhuiEntity> ew = new EntityWrapper< JiaruxiaoyouhuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaruxiaoyouhui, "jiaruxiaoyouhui")); 
		JiaruxiaoyouhuiView jiaruxiaoyouhuiView =  jiaruxiaoyouhuiService.selectView(ew);
		return R.ok("查询加入校友会成功").put("data", jiaruxiaoyouhuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaruxiaoyouhuiEntity jiaruxiaoyouhui = jiaruxiaoyouhuiService.selectById(id);
		jiaruxiaoyouhui = jiaruxiaoyouhuiService.selectView(new EntityWrapper<JiaruxiaoyouhuiEntity>().eq("id", id));
        return R.ok().put("data", jiaruxiaoyouhui);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaruxiaoyouhuiEntity jiaruxiaoyouhui = jiaruxiaoyouhuiService.selectById(id);
		jiaruxiaoyouhui = jiaruxiaoyouhuiService.selectView(new EntityWrapper<JiaruxiaoyouhuiEntity>().eq("id", id));
        return R.ok().put("data", jiaruxiaoyouhui);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaruxiaoyouhuiEntity jiaruxiaoyouhui, HttpServletRequest request){
    	jiaruxiaoyouhui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaruxiaoyouhui);
        jiaruxiaoyouhuiService.insert(jiaruxiaoyouhui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaruxiaoyouhuiEntity jiaruxiaoyouhui, HttpServletRequest request){
    	jiaruxiaoyouhui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaruxiaoyouhui);
        jiaruxiaoyouhuiService.insert(jiaruxiaoyouhui);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaruxiaoyouhuiEntity jiaruxiaoyouhui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaruxiaoyouhui);
        jiaruxiaoyouhuiService.updateById(jiaruxiaoyouhui);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaruxiaoyouhuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
