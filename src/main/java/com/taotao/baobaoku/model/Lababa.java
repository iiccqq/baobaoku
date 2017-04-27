package com.taotao.baobaoku.model;

import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;

public class Lababa {

	int babyid;

	String baby_name;

	Date record_time;

	int status;
	
	Date create_time;
	
	int count;

	static int STATUS_YES_UNOPERATION = 1;
	static int STATUS_YES_OPERATION = 2;
	static int STATUS_NO_UNOPERATION = 3;
	static int STATUS_NO_OPERATION = 4;
	static Map<Integer, String> statusMap = Maps.newHashMap();
	static {
		statusMap.put(STATUS_YES_UNOPERATION, "拉了（没透）");
		statusMap.put(STATUS_YES_OPERATION, "拉了（透了）");
		statusMap.put(STATUS_NO_UNOPERATION, "没拉（没透）");
		statusMap.put(STATUS_NO_OPERATION, "没拉（透了）");
	}

	public static String getStatusInfo(int status) {
		return statusMap.get(status);
	}

	public int getBabyid() {
		return babyid;
	}

	public void setBabyid(int babyid) {
		this.babyid = babyid;
	}

	public String getBaby_name() {
		return baby_name;
	}

	public void setBaby_name(String baby_name) {
		this.baby_name = baby_name;
	}

	public Date getRecord_time() {
		return record_time;
	}

	public void setRecord_time(Date record_time) {
		this.record_time = record_time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
}
