package com.taotao.baobaoku.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.taotao.baobaoku.dao.LababaDao;
import com.taotao.baobaoku.model.Lababa;
import com.taotao.baobaoku.util.PageInfo;
import com.taotao.baobaoku.util.R;

@RestController
@RequestMapping("/health/lababa")
public class HealthController {

	@Resource
	LababaDao lababaDao;

	@ResponseBody
	@RequestMapping(value = "/list")
	public R list(Integer babyid,Integer start, Integer count) throws IOException {
		PageInfo<Lababa> pageInfo = lababaDao.queryLababaList(0, 100);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String, Object>> views = Lists.newArrayList();
		for (Lababa la : pageInfo.getList()) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("recordTime", df.format(la.getRecord_time()));
			map.put("status", Lababa.getStatusInfo(la.getStatus()));
			map.put("count", la.getCount());
			views.add(map);
		}
		R r = new R();
		r.put("list", views);
		r.put("total", pageInfo.getTotal());
		return r;
	}
	 
	  @ResponseBody
	  @RequestMapping({"/{babyid}"})
	  public R updateStatus(@PathVariable Integer babyid, Integer status, Integer count, String record_time)
	    throws IOException
	  {
	    String baby_name = "陶陶";
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    try
	    {
	      Date rt = StringUtils.isBlank(record_time) ? new Date() : sdf.parse(record_time);
	      
	      this.lababaDao.updateTodayStatus(babyid, baby_name, status, count, rt);
	    }
	    catch (ParseException e)
	    {
	      e.printStackTrace();
	      new R();return R.error();
	    }
	    Date rt;
	    return new R();
	  }

}
