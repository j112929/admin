package com.bluemobi.to.coupon;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 
 * @author gaozj 
 * @date 2016-09-07 
 *
 */
public class CouponQueryTO extends AbstractObject{
	
	private static final long serialVersionUID = 4648572840050033563L;

	/**
	 * 优惠券类型: 0.全场类型 1.专场类型
	 */
	private Integer couponType;
	
	/**
	 * 审核状态:0.审核中 1.审核通过 2.审核不通过
	 */
	private Integer auditStatus;
	
	/**
	 * 查询起始时间
	 */
	private Date startDate;
	
	/**
	 * 查询结束时间
	 */
	private Date endDate;
	
	/**
	 * 优惠券编码
	 */
	private String code;
	/**
	 * 每页显示数量
	 */
	private Integer pageSize;

	/**
	 * 页码
	 */
	private Integer pageIndex;

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
