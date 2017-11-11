package com.bluemobi.po.bts;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【退货单表】持久化对象 数据库表：bts_order_refund
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class BtsOrderRefund extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 退货单id
    private Integer id;
    // 用户id
    private Integer userId;
    // 店铺id
    private Integer shopId;
    // 退货单号
    private String refundNo;
    // 订单明细id
    private Integer orderItemsId;
    // 退货商品数量
    private Integer quantity;
    // 退货原因
    private String reason;
    // 图片地址,格式如：["/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg","/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg"]
    private String pics;
    // 退货单状态：0、取消申请 1、申请退货 2、审批通过  3、审批拒绝 4、退款完成
    private Integer status;
    // 退款金额
    private Integer refundAmount;
    // 是否评价：0、未评价 1、已评价
    private Integer isComment;
    // 创建时间
    private Date ctime;
    // 修改时间
    private Date mtime;

    /** 获取 退货单id */
    public Integer getId() {
        return id;
    }

    /** 设置 退货单id */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 用户id */
    public Integer getUserId() {
        return userId;
    }

    /** 设置 用户id */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /** 获取 店铺id */
    public Integer getShopId() {
        return shopId;
    }

    /** 设置 店铺id */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /** 获取 退货单号 */
    public String getRefundNo() {
        return refundNo;
    }

    /** 设置 退货单号 */
    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    /** 获取 订单明细id */
    public Integer getOrderItemsId() {
        return orderItemsId;
    }

    /** 设置 订单明细id */
    public void setOrderItemsId(Integer orderItemsId) {
        this.orderItemsId = orderItemsId;
    }

    /** 获取 退货商品数量 */
    public Integer getQuantity() {
        return quantity;
    }

    /** 设置 退货商品数量 */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /** 获取 退货原因 */
    public String getReason() {
        return reason;
    }

    /** 设置 退货原因 */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /** 获取 图片地址,格式如：["/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg","/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg"] */
    public String getPics() {
        return pics;
    }

    /** 设置 图片地址,格式如：["/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg","/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg"] */
    public void setPics(String pics) {
        this.pics = pics;
    }

    /** 获取 退货单状态：0、取消申请 1、申请退货 2、审批通过  3、审批拒绝 4、退款完成 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 退货单状态：0、取消申请 1、申请退货 2、审批通过  3、审批拒绝 4、退款完成 */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 获取 退款金额 */
    public Integer getRefundAmount() {
        return refundAmount;
    }

    /** 设置 退款金额 */
    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }

    /** 获取 是否评价：0、未评价 1、已评价 */
    public Integer getIsComment() {
        return isComment;
    }

    /** 设置 是否评价：0、未评价 1、已评价 */
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    /** 获取 创建时间 */
    public Date getCtime() {
        return ctime;
    }

    /** 设置 创建时间 */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /** 获取 修改时间 */
    public Date getMtime() {
        return mtime;
    }

    /** 设置 修改时间 */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BtsOrderRefund");
        sb.append("{id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", shopId=").append(shopId);
        sb.append(", refundNo=").append(refundNo);
        sb.append(", orderItemsId=").append(orderItemsId);
        sb.append(", quantity=").append(quantity);
        sb.append(", reason=").append(reason);
        sb.append(", pics=").append(pics);
        sb.append(", status=").append(status);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", isComment=").append(isComment);
        sb.append(", ctime=").append(ctime);
        sb.append(", mtime=").append(mtime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BtsOrderRefund) {
            BtsOrderRefund btsOrderRefund = (BtsOrderRefund) obj;
            if (this.getId().equals(btsOrderRefund.getId())) {
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