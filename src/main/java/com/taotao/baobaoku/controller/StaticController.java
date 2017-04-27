package com.taotao.baobaoku.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.taotao.baobaoku.dao.StaticDao;
import com.taotao.baobaoku.model.Lababa;
import com.taotao.baobaoku.util.R;

@RestController
@RequestMapping("/health/static")
public class StaticController {

	@Resource
	StaticDao staticDao;

	@ResponseBody
	@RequestMapping(value = "/statusStatic")
	public R statusStatic() throws IOException {
		List<Map> list = staticDao.getStatusStatic();
		List rs = Lists.newArrayList();
		for (Map m : list) {
			int status = (int) m.get("status");
			String strStatus = Lababa.getStatusInfo(status);
			long count = m.get("count") == null ? 0 : (Long) m.get("count");
			Map<String, Object> v = Maps.newHashMap();
			v.put("name", strStatus);
			v.put("value", count);
			rs.add(v);
		}
		return new R().put("rs", rs);
	}

}
