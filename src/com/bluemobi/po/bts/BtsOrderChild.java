package com.bluemobi.po.bts;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【商品订单子表】持久化对象 数据库表：bts_order_child
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class BtsOrderChild extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 子订单id
    private Integer id;
    // 订单号
    private String orderNo;
    // 子订单号
    private String orderChildNo;
    // 订单类型： 1、普通  2、折扣 3、团购 4、秒杀 5、抽奖
    private Integer type;
    // 用户id
    private Integer userId;
    // 商户id
    private Integer merchantId;
    // 子订单备注
    private String remark;
    // 给卖家留言
    private String leaveMessage;
    // 快递类型
    private Integer expressType;
    // 快递单号
    private String expressNo;
    // 发票抬头
    private String invoiceTitle;
    // 订单状态：1、待付款 2、待发货 3、待收货 4、待评价 5、退款
    private Integer status;
    // 是否取消：0、未取消 1、已取消
    private Integer isCancel;
    // 取消原因
    private String cancelReason;
    // 是否删除：0、未删除 1、删除
    private Integer isDel;
    // 商品总价(分)
    private Integer goodsAmount;
    // 优惠金额(分)
    private Integer couponAmount;
    // 积分总价
    private Integer pointAmount;
    // 运费
    private Integer freightAmount;
    // 应付金额(订单总价)
    private Integer payableAmount;
    // 实付金额
    private Integer payAmount;
    // 支付订单类型：1、主订单 2、子订单
    private Integer payOrderType;
    // 支付方式：1、本金支付 2、积分支付
    private Integer payType;
    // 支付状态：0、未支付 1、已支付
    private Integer payStatus;
    // 支付时间
    private Date payTime;
    // 兴支付流水号
    private String sno;
    // 创建时间
    private Date ctime;

    /** 获取 子订单id */
    public Integer getId() {
        return id;
    }

    /** 设置 子订单id */
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

    /** 获取 子订单号 */
    public String getOrderChildNo() {
        return orderChildNo;
    }

    /** 设置 子订单号 */
    public void setOrderChildNo(String orderChildNo) {
        this.orderChildNo = orderChildNo;
    }

    /** 获取 订单类型： 1、普通  2、折扣 3、团购 4、秒杀 5、抽奖 */
    public Integer getType() {
        return type;
    }

    /** 设置 订单类型： 1、普通  2、折扣 3、团购 4、秒杀 5、抽奖 */
    public void setType(Integer type) {
        this.type = type;
    }

    /** 获取 用户id */
    public Integer getUserId() {
        return userId;
    }

    /** 设置 用户id */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /** 获取 商户id */
    public Integer getMerchantId() {
        return merchantId;
    }

    /** 设置 商户id */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /** 获取 子订单备注 */
    public String getRemark() {
        return remark;
    }

    /** 设置 子订单备注 */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 获取 给卖家留言 */
    public String getLeaveMessage() {
        return leaveMessage;
    }

    /** 设置 给卖家留言 */
    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    /** 获取 快递类型 */
    public Integer getExpressType() {
        return expressType;
    }

    /** 设置 快递类型 */
    public void setExpressType(Integer expressType) {
        this.expressType = expressType;
    }

    /** 获取 快递单号 */
    public String getExpressNo() {
        return expressNo;
    }

    /** 设置 快递单号 */
    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    /** 获取 发票抬头 */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /** 设置 发票抬头 */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    /** 获取 订单状态：1、待付款 2、待发货 3、待收货 4、待评价 5、退款 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 订单状态：1、待付款 2、待发货 3、待收货 4、待评价 5、退款 */
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

    /** 获取 取消原因 */
    public String getCancelReason() {
        return cancelReason;
    }

    /** 设置 取消原因 */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    /** 获取 是否删除：0、未删除 1、删除 */
    public Integer getIsDel() {
        return isDel;
    }

    /** 设置 是否删除：0、未删除 1、删除 */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /** 获取 商品总价(分) */
    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    /** 设置 商品总价(分) */
    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    /** 获取 优惠金额(分) */
    public Integer getCouponAmount() {
        return couponAmount;
    }

    /** 设置 优惠金额(分) */
    public void setCouponAmount(Integer couponAmount) {
        this.couponAmount = couponAmount;
    }

    /** 获取 积分总价 */
    public Integer getPointAmount() {
        return pointAmount;
    }

    /** 设置 积分总价 */
    public void setPointAmount(Integer pointAmount) {
        this.pointAmount = pointAmount;
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

    /** 获取 支付订单类型：1、主订单 2、子订单 */
    public Integer getPayOrderType() {
        return payOrderType;
    }

    /** 设置 支付订单类型：1、主订单 2、子订单 */
    public void setPayOrderType(Integer payOrderType) {
        this.payOrderType = payOrderType;
    }

    /** 获取 支付方式：1、本金支付 2、积分支付 */
    public Integer getPayType() {
        return payType;
    }

    /** 设置 支付方式：1、本金支付 2、积分支付 */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /** 获取 支付状态：0、未支付 1、已支付 */
    public Integer getPayStatus() {
        return payStatus;
    }

    /** 设置 支付状态：0、未支付 1、已支付 */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /** 获取 支付时间 */
    public Date getPayTime() {
        return payTime;
    }

    /** 设置 支付时间 */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /** 获取 兴支付流水号 */
    public String getSno() {
        return sno;
    }

    /** 设置 兴支付流水号 */
    public void setSno(String sno) {
        this.sno = sno;
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
        sb.append("BtsOrderChild");
        sb.append("{id=").append(id);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", orderChildNo=").append(orderChildNo);
        sb.append(", type=").append(type);
        sb.append(", userId=").append(userId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", remark=").append(remark);
        sb.append(", leaveMessage=").append(leaveMessage);
        sb.append(", expressType=").append(expressType);
        sb.append(", expressNo=").append(expressNo);
        sb.append(", invoiceTitle=").append(invoiceTitle);
        sb.append(", status=").append(status);
        sb.append(", isCancel=").append(isCancel);
        sb.append(", cancelReason=").append(cancelReason);
        sb.append(", isDel=").append(isDel);
        sb.append(", goodsAmount=").append(goodsAmount);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", pointAmount=").append(pointAmount);
        sb.append(", freightAmount=").append(freightAmount);
        sb.append(", payableAmount=").append(payableAmount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", payOrderType=").append(payOrderType);
        sb.append(", payType=").append(payType);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payTime=").append(payTime);
        sb.append(", sno=").append(sno);
        sb.append(", ctime=").append(ctime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BtsOrderChild) {
            BtsOrderChild btsOrderChild = (BtsOrderChild) obj;
            if (this.getId().equals(btsOrderChild.getId())) {
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