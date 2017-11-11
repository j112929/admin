package com.bluemobi.po.bts;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【商品订单明细表】持久化对象 数据库表：bts_order_items
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class BtsOrderItems extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 订单明细id
    private Integer id;
    // 子订单号
    private String orderChildNo;
    // 用户id
    private Integer userId;
    // 订单明细备注
    private String remark;
    // 商户id
    private Integer merchantId;
    // 商品spu id
    private Integer spuId;
    // 商品sku id
    private Integer skuId;
    // 商品名称
    private String goodsName;
    // 商品图片
    private String goodsPic;
    // 属性，格式：[{"id":"3","name":"颜色","value":"1","valueName":"白色"},{"id":"4","name":"尺码","value":"1","valueName":"X码"}]
    private String propertys;
    // 商品数量
    private Integer quantity;
    // 已退数量
    private Integer refundQuantity;
    // 原价(分)
    private Integer goodsOriginalPrice;
    // 现价(分)
    private Integer goodsPrice;
    // 商品总价
    private Integer goodsAmount;
    // 优惠金额(分)
    private Integer couponAmount;
    // 积分总价
    private Integer pointAmount;
    // 金币抵扣金额
    private Integer discountAmount;
    // 运费
    private Integer freightAmount;
    // 应付金额(订单总价)
    private Integer payableAmount;
    // 实付金额
    private Integer payAmount;
    // 是否评价：0、未评价 1、已评价
    private Integer isComment;
    // 创建时间
    private Date ctime;
    // 修改时间
    private Date mtime;

    /** 获取 订单明细id */
    public Integer getId() {
        return id;
    }

    /** 设置 订单明细id */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 子订单号 */
    public String getOrderChildNo() {
        return orderChildNo;
    }

    /** 设置 子订单号 */
    public void setOrderChildNo(String orderChildNo) {
        this.orderChildNo = orderChildNo;
    }

    /** 获取 用户id */
    public Integer getUserId() {
        return userId;
    }

    /** 设置 用户id */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /** 获取 订单明细备注 */
    public String getRemark() {
        return remark;
    }

    /** 设置 订单明细备注 */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 获取 商户id */
    public Integer getMerchantId() {
        return merchantId;
    }

    /** 设置 商户id */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /** 获取 商品spu id */
    public Integer getSpuId() {
        return spuId;
    }

    /** 设置 商品spu id */
    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    /** 获取 商品sku id */
    public Integer getSkuId() {
        return skuId;
    }

    /** 设置 商品sku id */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /** 获取 商品名称 */
    public String getGoodsName() {
        return goodsName;
    }

    /** 设置 商品名称 */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /** 获取 商品图片 */
    public String getGoodsPic() {
        return goodsPic;
    }

    /** 设置 商品图片 */
    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    /** 获取 属性，格式：[{"id":"3","name":"颜色","value":"1","valueName":"白色"},{"id":"4","name":"尺码","value":"1","valueName":"X码"}] */
    public String getPropertys() {
        return propertys;
    }

    /** 设置 属性，格式：[{"id":"3","name":"颜色","value":"1","valueName":"白色"},{"id":"4","name":"尺码","value":"1","valueName":"X码"}] */
    public void setPropertys(String propertys) {
        this.propertys = propertys;
    }

    /** 获取 商品数量 */
    public Integer getQuantity() {
        return quantity;
    }

    /** 设置 商品数量 */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /** 获取 已退数量 */
    public Integer getRefundQuantity() {
        return refundQuantity;
    }

    /** 设置 已退数量 */
    public void setRefundQuantity(Integer refundQuantity) {
        this.refundQuantity = refundQuantity;
    }

    /** 获取 原价(分) */
    public Integer getGoodsOriginalPrice() {
        return goodsOriginalPrice;
    }

    /** 设置 原价(分) */
    public void setGoodsOriginalPrice(Integer goodsOriginalPrice) {
        this.goodsOriginalPrice = goodsOriginalPrice;
    }

    /** 获取 现价(分) */
    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    /** 设置 现价(分) */
    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /** 获取 商品总价 */
    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    /** 设置 商品总价 */
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
        sb.append("BtsOrderItems");
        sb.append("{id=").append(id);
        sb.append(", orderChildNo=").append(orderChildNo);
        sb.append(", userId=").append(userId);
        sb.append(", remark=").append(remark);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", spuId=").append(spuId);
        sb.append(", skuId=").append(skuId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsPic=").append(goodsPic);
        sb.append(", propertys=").append(propertys);
        sb.append(", quantity=").append(quantity);
        sb.append(", refundQuantity=").append(refundQuantity);
        sb.append(", goodsOriginalPrice=").append(goodsOriginalPrice);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsAmount=").append(goodsAmount);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", pointAmount=").append(pointAmount);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", freightAmount=").append(freightAmount);
        sb.append(", payableAmount=").append(payableAmount);
        sb.append(", payAmount=").append(payAmount);
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
        if (obj instanceof BtsOrderItems) {
            BtsOrderItems btsOrderItems = (BtsOrderItems) obj;
            if (this.getId().equals(btsOrderItems.getId())) {
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