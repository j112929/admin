package com.bluemobi.to.white;

import com.appcore.model.AbstractObject;

public class ContentTO extends AbstractObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4560549184769765133L;
	private Integer id;
	private String sname;
	private String spu;
	private String name;
	private Integer viewType;
	private Integer goodsType;
	private Integer categoryId1;
	private Integer categoryId2;
	private Integer categoryId3;
	private Integer isShow;
	private String categoryNames;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpu() {
		return spu;
	}
	public void setSpu(String spu) {
		this.spu = spu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getViewType() {
		return viewType;
	}
	public void setViewType(Integer viewType) {
		this.viewType = viewType;
	}
	public Integer getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}
	public Integer getCategoryId1() {
		return categoryId1;
	}
	public void setCategoryId1(Integer categoryId1) {
		this.categoryId1 = categoryId1;
	}
	public Integer getCategoryId2() {
		return categoryId2;
	}
	public void setCategoryId2(Integer categoryId2) {
		this.categoryId2 = categoryId2;
	}
	public Integer getCategoryId3() {
		return categoryId3;
	}
	public void setCategoryId3(Integer categoryId3) {
		this.categoryId3 = categoryId3;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public String getCategoryNames() {
		return categoryNames;
	}
	public void setCategoryNames(String categoryNames) {
		this.categoryNames = categoryNames;
	}
	
}
