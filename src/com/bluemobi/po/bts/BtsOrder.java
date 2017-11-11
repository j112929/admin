package com.bluemobi.po.bts;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【商品订单表，存放主订单编号，收货人信息等】持久化对象 数据库表：bts_order
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class BtsOrder extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 订单id
    private Integer id;
    // 订单号
    private String orderNo;
    // 用户id
    private Integer userId;
    // 订单备注
    private String remark;
    // 收货地区id(最后一级)
    private Integer consigneeRegionId;
    // 收货地区名称全称
    private String consigneeRegionName;
    // 收货人详细地址
    private String consigneeAddress;
    // 收货人姓名
    private String consigneeName;
    // 收货人邮箱
    private String consigneeEmail;
    // 收货人邮编
    private String consigneeZipcode;
    // 收货人手机号
    private String consigneeMobileNo;
    // 订单状态：1、待付款 2、已付款
    private Integer status;
    // 是否取消：0、未取消 1、已取消
    private Integer isCancel;
    // 是否删除：0、未删除 1、删除
    private Integer isDel;
    // 商品总价
    private Integer goodsAmount;
    // 金币抵扣金额
    private Integer discountAmount;
    // 运费
    private Integer freightAmount;
    // 应付金额(订单总价)
    private Integer payableAmount;
    // 实付金额
    private Integer payAmount;
    // 支付方式：1、本金支付 2、积分支付
    private Integer payType;
    // 支付时间
    private Date payTime;
    // 创建时间
    private Date ctime;

    /** 获取 订单id */
    public Integer getId() {
        return id;
    }

    /** 设置 订单id */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 订单号 */
    public String getOrderNo() {
        return orderNo;
    }

    /** 设置 订单号 */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /** 获取 用户id */
    public Integer getUserId() {
        return userId;
    }

    /** 设置 用户id */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /** 获取 订单备注 */
    public String getRemark() {
        return remark;
    }

    /** 设置 订单备注 */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 获取 收货地区id(最后一级) */
    public Integer getConsigneeRegionId() {
        return consigneeRegionId;
    }

    /** 设置 收货地区id(最后一级) */
    public void setConsigneeRegionId(Integer consigneeRegionId) {
        this.consigneeRegionId = consigneeRegionId;
    }

    /** 获取 收货地区名称全称 */
    public String getConsigneeRegionName() {
        return consigneeRegionName;
    }

    /** 设置 收货地区名称全称 */
    public void setConsigneeRegionName(String consigneeRegionName) {
        this.consigneeRegionName = consigneeRegionName;
    }

    /** 获取 收货人详细地址 */
    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    /** 设置 收货人详细地址 */
    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    /** 获取 收货人姓名 */
    public String getConsigneeName() {
        return consigneeName;
    }

    /** 设置 收货人姓名 */
    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    /** 获取 收货人邮箱 */
    public String getConsigneeEmail() {
        return consigneeEmail;
    }

    /** 设置 收货人邮箱 */
    public void setConsigneeEmail(String consigneeEmail) {
        this.consigneeEmail = consigneeEmail;
    }

    /** 获取 收货人邮编 */
    public String getConsigneeZipcode() {
        return consigneeZipcode;
    }

    /** 设置 收货人邮编 */
    public void setConsigneeZipcode(String consigneeZipcode) {
        this.consigneeZipcode = consigneeZipcode;
    }

    /** 获取 收货人手机号 */
    public String getConsigneeMobileNo() {
        return consigneeMobileNo;
    }

    /** 设置 收货人手机号 */
    public void setConsigneeMobileNo(String consigneeMobileNo) {
        this.consigneeMobileNo = consigneeMobileNo;
    }

    /** 获取 订单状态：1、待付款 2、已付款 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 订单状态：1、待付款 2、已付款 */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 获取 是否取消：0、未取消 1、已取消 */
    public Integer getIsCancel() {
        return isCancel;
    }

    /** 设置 是否取消：0、未取消 1、已取消 */
    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    /** 获取 是否删除：0、未删除 1、删除 */
    public Integer getIsDel() {
        return isDel;
    }

    /** 设置 是否删除：0、未删除 1、删除 */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /** 获取 商品总价 */
    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    /** 设置 商品总价 */
    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    /** 获取 金币抵扣金额 */
    public Integer getDiscountAmount() {
        return discountAmount;
    }

    /** 设置 金币抵扣金额 */
    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    /** 获取 运费 */
    public Integer getFreightAmount() {
        return freightAmount;
    }

    /** 设置 运费 */
    public void setFreightAmount(Integer freightAmount) {
        this.freightAmount = freightAmount;
    }

    /** 获取 应付金额(订单总价) */
    public Integer getPayableAmount() {
        return payableAmount;
    }

    /** 设置 应付金额(订单总价) */
    public void setPayableAmount(Integer payableAmount) {
        this.payableAmount = payableAmount;
    }

    /** 获取 实付金额 */
    public Integer getPayAmount() {
        return payAmount;
    }

    /** 设置 实付金额 */
    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    /** 获取 支付方式：1、本金支付 2、积分支付 */
    public Integer getPayType() {
        return payType;
    }

    /** 设置 支付方式：1、本金支付 2、积分支付 */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /** 获取 支付时间 */
    public Date getPayTime() {
        return payTime;
    }

    /** 设置 支付时间 */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /** 获取 创建时间 */
    public Date getCtime() {
        return ctime;
    }

    /** 设置 创建时间 */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BtsOrder");
        sb.append("{id=").append(id);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", userId=").append(userId);
        sb.append(", remark=").append(remark);
        sb.append(", consigneeRegionId=").append(consigneeRegionId);
        sb.append(", consigneeRegionName=").append(consigneeRegionName);
        sb.append(", consigneeAddress=").append(consigneeAddress);
        sb.append(", consigneeName=").append(consigneeName);
        sb.append(", consigneeEmail=").append(consigneeEmail);
        sb.append(", consigneeZipcode=").append(consigneeZipcode);
        sb.append(", consigneeMobileNo=").append(consigneeMobileNo);
        sb.append(", status=").append(status);
        sb.append(", isCancel=").append(isCancel);
        sb.append(", isDel=").append(isDel);
        sb.append(", goodsAmount=").append(goodsAmount);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", freightAmount=").append(freightAmount);
        sb.append(", payableAmount=").append(payableAmount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", payType=").append(payType);
        sb.append(", payTime=").append(payTime);
        sb.append(", ctime=").append(ctime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BtsOrder) {
            BtsOrder btsOrder = (BtsOrder) obj;
            if (this.getId().equals(btsOrder.getId())) {
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