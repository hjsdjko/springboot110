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

import com.cl.entity.JuanzengwupinEntity;
import com.cl.entity.view.JuanzengwupinView;

import com.cl.service.JuanzengwupinService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 捐赠物品
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-04 09:09:16
 */
@RestController
@RequestMapping("/juanzengwupin")
public class JuanzengwupinController {
    @Autowired
    private JuanzengwupinService juanzengwupinService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JuanzengwupinEntity juanzengwupin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			juanzengwupin.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JuanzengwupinEntity> ew = new EntityWrapper<JuanzengwupinEntity>();

		PageUtils page = juanzengwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, juanzengwupin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JuanzengwupinEntity juanzengwupin, 
		HttpServletRequest request){
        EntityWrapper<JuanzengwupinEntity> ew = new EntityWrapper<JuanzengwupinEntity>();

		PageUtils page = juanzengwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, juanzengwupin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JuanzengwupinEntity juanzengwupin){
       	EntityWrapper<JuanzengwupinEntity> ew = new EntityWrapper<JuanzengwupinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( juanzengwupin, "juanzengwupin")); 
        return R.ok().put("data", juanzengwupinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JuanzengwupinEntity juanzengwupin){
        EntityWrapper< JuanzengwupinEntity> ew = new EntityWrapper< JuanzengwupinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( juanzengwupin, "juanzengwupin")); 
		JuanzengwupinView juanzengwupinView =  juanzengwupinService.selectView(ew);
		return R.ok("查询捐赠物品成功").put("data", juanzengwupinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JuanzengwupinEntity juanzengwupin = juanzengwupinService.selectById(id);
		juanzengwupin = juanzengwupinService.selectView(new EntityWrapper<JuanzengwupinEntity>().eq("id", id));
        return R.ok().put("data", juanzengwupin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JuanzengwupinEntity juanzengwupin = juanzengwupinService.selectById(id);
		juanzengwupin = juanzengwupinService.selectView(new EntityWrapper<JuanzengwupinEntity>().eq("id", id));
        return R.ok().put("data", juanzengwupin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JuanzengwupinEntity juanzengwupin, HttpServletRequest request){
    	juanzengwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(juanzengwupin);
        juanzengwupinService.insert(juanzengwupin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JuanzengwupinEntity juanzengwupin, HttpServletRequest request){
    	juanzengwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(juanzengwupin);
        juanzengwupinService.insert(juanzengwupin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JuanzengwupinEntity juanzengwupin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(juanzengwupin);
        juanzengwupinService.updateById(juanzengwupin);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JuanzengwupinEntity> list = new ArrayList<JuanzengwupinEntity>();
        for(Long id : ids) {
            JuanzengwupinEntity juanzengwupin = juanzengwupinService.selectById(id);
            juanzengwupin.setSfsh(sfsh);
            juanzengwupin.setShhf(shhf);
            list.add(juanzengwupin);
        }
        juanzengwupinService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        juanzengwupinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
