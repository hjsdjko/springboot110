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

import com.cl.entity.XiaoyouhuiEntity;
import com.cl.entity.view.XiaoyouhuiView;

import com.cl.service.XiaoyouhuiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 校友会
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
@RestController
@RequestMapping("/xiaoyouhui")
public class XiaoyouhuiController {
    @Autowired
    private XiaoyouhuiService xiaoyouhuiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoyouhuiEntity xiaoyouhui,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xiaoyouhui.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiaoyouhuiEntity> ew = new EntityWrapper<XiaoyouhuiEntity>();

		PageUtils page = xiaoyouhuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoyouhui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoyouhuiEntity xiaoyouhui, 
		HttpServletRequest request){
        EntityWrapper<XiaoyouhuiEntity> ew = new EntityWrapper<XiaoyouhuiEntity>();

		PageUtils page = xiaoyouhuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoyouhui), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoyouhuiEntity xiaoyouhui){
       	EntityWrapper<XiaoyouhuiEntity> ew = new EntityWrapper<XiaoyouhuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoyouhui, "xiaoyouhui")); 
        return R.ok().put("data", xiaoyouhuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoyouhuiEntity xiaoyouhui){
        EntityWrapper< XiaoyouhuiEntity> ew = new EntityWrapper< XiaoyouhuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoyouhui, "xiaoyouhui")); 
		XiaoyouhuiView xiaoyouhuiView =  xiaoyouhuiService.selectView(ew);
		return R.ok("查询校友会成功").put("data", xiaoyouhuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoyouhuiEntity xiaoyouhui = xiaoyouhuiService.selectById(id);
		xiaoyouhui = xiaoyouhuiService.selectView(new EntityWrapper<XiaoyouhuiEntity>().eq("id", id));
        return R.ok().put("data", xiaoyouhui);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoyouhuiEntity xiaoyouhui = xiaoyouhuiService.selectById(id);
		xiaoyouhui = xiaoyouhuiService.selectView(new EntityWrapper<XiaoyouhuiEntity>().eq("id", id));
        return R.ok().put("data", xiaoyouhui);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoyouhuiEntity xiaoyouhui, HttpServletRequest request){
    	xiaoyouhui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoyouhui);
        xiaoyouhuiService.insert(xiaoyouhui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoyouhuiEntity xiaoyouhui, HttpServletRequest request){
    	xiaoyouhui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoyouhui);
        xiaoyouhuiService.insert(xiaoyouhui);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiaoyouhuiEntity xiaoyouhui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoyouhui);
        xiaoyouhuiService.updateById(xiaoyouhui);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XiaoyouhuiEntity> list = new ArrayList<XiaoyouhuiEntity>();
        for(Long id : ids) {
            XiaoyouhuiEntity xiaoyouhui = xiaoyouhuiService.selectById(id);
            xiaoyouhui.setSfsh(sfsh);
            xiaoyouhui.setShhf(shhf);
            list.add(xiaoyouhui);
        }
        xiaoyouhuiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaoyouhuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
