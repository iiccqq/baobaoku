package com.taotao.baobaoku.util;

import java.util.List;

public class PageInfo <T>{

	List<T> list;
	int total;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
