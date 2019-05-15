package com.langsin.JavaBean;

import java.util.List;

public class PageBean<T> {
	private int pagecode;// 当前页码 page code
	private int totalpage;// 总页数 total page
	private int totalrecord;// 总记录数 total record
	private int pagesize;// 每页记录数page size
	private List<T> beanList;// 当前页的记录
	public int getPagecode() {
		return pagecode;
	}
	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage() {
		int total = this.totalrecord/this.pagesize;
		this.totalpage = totalrecord%pagesize==0?total:total+1;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
	
}
