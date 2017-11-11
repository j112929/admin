/**
 * Project Name:nodo 
 * File Name:OrderQueryTO.java 
 * Package Name:com.bluemobi.to.bts 
 * Date:2015年12月28日下午4:50:13 
 */
package com.bluemobi.to.advert;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * ClassName: OrderQueryTO Date: 2015年12月28日下午4:50:13
 * 
 * @author kevin
 * @version
 * @since JDK 7
 */
public class AdvertQueryTO extends AbstractObject {

	private static final long serialVersionUID = -2815924887338574575L;

	/**
	 * 开始日期
	 */
	private String startDate;

	/**
	 * 结束日期
	 */
	private String endDate;

	/**
	 * 推荐专区
	 */
	 private Integer position;

	/**
	 * 搜索关键字
	 */
	private String key;

	/**
	 * 搜索字段
	 */
	private Integer searchType;

	/**
	 * 每页显示数量
	 */
	private Integer pageSize;

	/**
	 * 页码
	 */
	private Integer pageIndex;
	
	
	

	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getSearchType() {
		return searchType;
	}

	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}


	
}
