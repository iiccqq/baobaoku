package com.taotao.baobaoku.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class StaticDao {
	@Resource
	JdbcTemplate jdbcTemplate;
	public List getStatusStatic() {
		String sql = "SELECT  babyid,status ,COUNT(1) as count FROM health_lababa WHERE babyid=? GROUP BY babyid,status";
		List list = jdbcTemplate.queryForList(sql ,1);
		return list;
	}

}
