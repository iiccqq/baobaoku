package com.taotao.baobaoku.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.taotao.baobaoku.model.Lababa;
import com.taotao.baobaoku.util.PageInfo;

@Repository
public class LababaDao {

	@Resource
	JdbcTemplate jdbcTemplate;

	public PageInfo<Lababa> queryLababaList(int i, int j) {
		PageInfo<Lababa> pageInfo = new PageInfo<Lababa>();
		String sql = "select * from health_lababa order by record_time desc limit " + i + "," + j;
		List<Lababa> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Lababa>(Lababa.class));
		String countsql = "select count(1) from health_lababa limit " + i + "," + j;
		int total = jdbcTemplate.queryForObject(countsql, Integer.class);
		pageInfo.setList(list);
		pageInfo.setTotal(total);
		return pageInfo;
	}

	

	public void updateTodayStatus(Integer babyid, String baby_name, Integer status, Integer count, Date record_time)
	  {
	    String sql = "replace into health_lababa(babyid,baby_name,record_time,status,create_time,count) value(?,?,?,?,?,?)";
	    this.jdbcTemplate.update(sql, new Object[] { babyid, baby_name, record_time, status, new Date(), count });
	  }

}
