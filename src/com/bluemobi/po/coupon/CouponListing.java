package com.bluemobi.po.coupon;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【优惠券使用情况表】持久化对象 数据库表：coupon_listing
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:08
 * 
 */
public class CouponListing extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // ID
    private Integer id;
    // 客户端用户id
    private Integer userId;
    // 商户ID
    private Integer merchantId;
    // 优惠券ID
    private Integer couponId;
    // 优惠券编码
    private String code;
    // 优惠券状态：0、未使用 1、已使用 2、已作废 
    private Integer status;
    // 订单号
    private String orderCode;
    // 是否删除：0、未删除 1、已删除
    private Integer isDel;
    // 是否失效：0、未失效 1、已失效
    private Integer isFailure;
    // 创建时间
    private Date ctime;
    // 最后一次更新时间
    private Date mtime;

    /** 获取 ID 属性 */
    public Integer getId() {
            if(this.id==null){
                this.id=0;
            }
        return id;
    }

    /** 设置 ID 属性 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 客户端用户id 属性 */
    public Integer getUserId() {
            if(this.userId==null){
                this.userId=0;
            }
        return userId;
    }

    /** 设置 客户端用户id 属性 */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /** 获取 商户ID 属性 */
    public Integer getMerchantId() {
            if(this.merchantId==null){
                this.merchantId=0;
            }
        return merchantId;
    }

    /** 设置 商户ID 属性 */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /** 获取 优惠券ID 属性 */
    public Integer getCouponId() {
            if(this.couponId==null){
                this.couponId=0;
            }
        return couponId;
    }

    /** 设置 优惠券ID 属性 */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /** 获取 优惠券编码 属性 */
    public String getCode() {
            if(this.code==null){
                this.code="";
            }
        return code;
    }

    /** 设置 优惠券编码 属性 */
    public void setCode(String code) {
        this.code = code;
    }

    /** 获取 优惠券状态：0、未使用 1、已使用 2、已作废  属性 */
    public Integer getStatus() {
            if(this.status==null){
                this.status=0;
            }
        return status;
    }

    /** 设置 优惠券状态：0、未使用 1、已使用 2、已作废  属性 */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 获取 订单号 属性 */
    public String getOrderCode() {
            if(this.orderCode==null){
                this.orderCode="";
            }
        return orderCode;
    }

    /** 设置 订单号 属性 */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /** 获取 是否删除：0、未删除 1、已删除 属性 */
    public Integer getIsDel() {
            if(this.isDel==null){
                this.isDel=0;
            }
        return isDel;
    }

    /** 设置 是否删除：0、未删除 1、已删除 属性 */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /** 获取 是否失效：0、未失效 1、已失效 属性 */
    public Integer getIsFailure() {
            if(this.isFailure==null){
                this.isFailure=0;
            }
        return isFailure;
    }

    /** 设置 是否失效：0、未失效 1、已失效 属性 */
    public void setIsFailure(Integer isFailure) {
        this.isFailure = isFailure;
    }

    /** 获取 创建时间 属性 */
    public Date getCtime() {
        return ctime;
    }

    /** 设置 创建时间 属性 */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /** 获取 最后一次更新时间 属性 */
    public Date getMtime() {
        return mtime;
    }

    /** 设置 最后一次更新时间 属性 */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CouponListing");
        sb.append("{id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", couponId=").append(couponId);
        sb.append(", code=").append(code);
        sb.append(", status=").append(status);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", isDel=").append(isDel);
        sb.append(", isFailure=").append(isFailure);
        sb.append(", ctime=").append(ctime);
        sb.append(", mtime=").append(mtime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CouponListing) {
            CouponListing couponListing = (CouponListing) obj;
            if (this.getId().equals(couponListing.getId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getId();
        return pkStr.hashCode();
    }

}