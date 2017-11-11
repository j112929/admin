package com.bluemobi.po.goods;

import java.math.BigDecimal;
import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【商品sku】持久化对象 数据库表：goods_sku
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class GoodsSku extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 商品sku id
    private Integer skuId;
    // 商户id
    private Integer merchantId;
    // 商品spu id
    private Integer spuId;
    // 库存量单位 (Stock Keeping Unit)
    private String sku;
    // 属性，格式：[{"id":"3","name":"颜色","value":"1","valueName":"白色"},{"id":"4","name":"尺码","value":"1","valueName":"X码"}]
    private String propertys;
    // sku图片，格式如：["/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg","/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg"]
    private String pics;
    // 库存
    private Integer stock;
    // 库存警戒
    private Integer stockWarn;
    // 原价、市场价(分)
    private Integer originalPrice;
    // 本金价(分)
    private Integer price;
    // 积分价
    private Integer pointPrice;
    // 混合支付本金价格(分)
    private Integer mixPrice;
    // 混合支付积分价
    private Integer mixPointPrice;
    // 本金支付手续费率
    private BigDecimal chargeRate;
    // 积分结算价格(分)
    private Integer settlementPrice;
    // sku销售数量
    private Integer salesQuantity;
    // sku销售金额
    private Long salesAmount;
    // 收藏数
    private Integer collectCount;
    // 评论数
    private Integer commentCount;
    // 权重 权重大的商品排序靠前
    private Integer weight;
    // 序号 用于排序
    private Integer sortOrder;
    // 状态：0、下架 1、上架
    private Integer status;
    // 前台是否显示：0、不显示 1、显示
    private Integer isShow;
    // 是否删除：0、未删除 1、删除
    private Integer isDel;
    // 创建人
    private Integer creator;
    // 创建时间
    private Date ctime;
    // 修改人
    private Integer modifier;
    // 修改时间
    private Date mtime;

    /** 获取 商品sku id */
    public Integer getSkuId() {
        return skuId;
    }

    /** 设置 商品sku id */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
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

    /** 获取 库存量单位 (Stock Keeping Unit) */
    public String getSku() {
        return sku;
    }

    /** 设置 库存量单位 (Stock Keeping Unit) */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /** 获取 属性，格式：[{"id":"3","name":"颜色","value":"1","valueName":"白色"},{"id":"4","name":"尺码","value":"1","valueName":"X码"}] */
    public String getPropertys() {
        return propertys;
    }

    /** 设置 属性，格式：[{"id":"3","name":"颜色","value":"1","valueName":"白色"},{"id":"4","name":"尺码","value":"1","valueName":"X码"}] */
    public void setPropertys(String propertys) {
        this.propertys = propertys;
    }

    /** 获取 sku图片，格式如：["/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg","/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg"] */
    public String getPics() {
        return pics;
    }

    /** 设置 sku图片，格式如：["/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg","/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg"] */
    public void setPics(String pics) {
        this.pics = pics;
    }

    /** 获取 库存 */
    public Integer getStock() {
        return stock;
    }

    /** 设置 库存 */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /** 获取 库存警戒 */
    public Integer getStockWarn() {
        return stockWarn;
    }

    /** 设置 库存警戒 */
    public void setStockWarn(Integer stockWarn) {
        this.stockWarn = stockWarn;
    }

    /** 获取 原价、市场价(分) */
    public Integer getOriginalPrice() {
        return originalPrice;
    }

    /** 设置 原价、市场价(分) */
    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    /** 获取 本金价(分) */
    public Integer getPrice() {
        return price;
    }

    /** 设置 本金价(分) */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /** 获取 积分价 */
    public Integer getPointPrice() {
        return pointPrice;
    }

    /** 设置 积分价 */
    public void setPointPrice(Integer pointPrice) {
        this.pointPrice = pointPrice;
    }

    /** 获取 混合支付本金价格(分) */
    public Integer getMixPrice() {
        return mixPrice;
    }

    /** 设置 混合支付本金价格(分) */
    public void setMixPrice(Integer mixPrice) {
        this.mixPrice = mixPrice;
    }

    /** 获取 混合支付积分价 */
    public Integer getMixPointPrice() {
        return mixPointPrice;
    }

    /** 设置 混合支付积分价 */
    public void setMixPointPrice(Integer mixPointPrice) {
        this.mixPointPrice = mixPointPrice;
    }

    /** 获取 本金支付手续费率 */
    public BigDecimal getChargeRate() {
        return chargeRate;
    }

    /** 设置 本金支付手续费率 */
    public void setChargeRate(BigDecimal chargeRate) {
        this.chargeRate = chargeRate;
    }

    /** 获取 积分结算价格(分) */
    public Integer getSettlementPrice() {
        return settlementPrice;
    }

    /** 设置 积分结算价格(分) */
    public void setSettlementPrice(Integer settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    /** 获取 sku销售数量 */
    public Integer getSalesQuantity() {
        return salesQuantity;
    }

    /** 设置 sku销售数量 */
    public void setSalesQuantity(Integer salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    /** 获取 sku销售金额 */
    public Long getSalesAmount() {
        return salesAmount;
    }

    /** 设置 sku销售金额 */
    public void setSalesAmount(Long salesAmount) {
        this.salesAmount = salesAmount;
    }

    /** 获取 收藏数 */
    public Integer getCollectCount() {
        return collectCount;
    }

    /** 设置 收藏数 */
    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    /** 获取 评论数 */
    public Integer getCommentCount() {
        return commentCount;
    }

    /** 设置 评论数 */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /** 获取 权重 权重大的商品排序靠前 */
    public Integer getWeight() {
        return weight;
    }

    /** 设置 权重 权重大的商品排序靠前 */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /** 获取 序号 用于排序 */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /** 设置 序号 用于排序 */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /** 获取 状态：0、下架 1、上架 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 状态：0、下架 1、上架 */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 获取 前台是否显示：0、不显示 1、显示 */
    public Integer getIsShow() {
        return isShow;
    }

    /** 设置 前台是否显示：0、不显示 1、显示 */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /** 获取 是否删除：0、未删除 1、删除 */
    public Integer getIsDel() {
        return isDel;
    }

    /** 设置 是否删除：0、未删除 1、删除 */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /** 获取 创建人 */
    public Integer getCreator() {
        return creator;
    }

    /** 设置 创建人 */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /** 获取 创建时间 */
    public Date getCtime() {
        return ctime;
    }

    /** 设置 创建时间 */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /** 获取 修改人 */
    public Integer getModifier() {
        return modifier;
    }

    /** 设置 修改人 */
    public void setModifier(Integer modifier) {
        this.modifier = modifier;
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
        sb.append("GoodsSku");
        sb.append("{skuId=").append(skuId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", spuId=").append(spuId);
        sb.append(", sku=").append(sku);
        sb.append(", propertys=").append(propertys);
        sb.append(", pics=").append(pics);
        sb.append(", stock=").append(stock);
        sb.append(", stockWarn=").append(stockWarn);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", price=").append(price);
        sb.append(", pointPrice=").append(pointPrice);
        sb.append(", mixPrice=").append(mixPrice);
        sb.append(", mixPointPrice=").append(mixPointPrice);
        sb.append(", chargeRate=").append(chargeRate);
        sb.append(", settlementPrice=").append(settlementPrice);
        sb.append(", salesQuantity=").append(salesQuantity);
        sb.append(", salesAmount=").append(salesAmount);
        sb.append(", collectCount=").append(collectCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", weight=").append(weight);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", status=").append(status);
        sb.append(", isShow=").append(isShow);
        sb.append(", isDel=").append(isDel);
        sb.append(", creator=").append(creator);
        sb.append(", ctime=").append(ctime);
        sb.append(", modifier=").append(modifier);
        sb.append(", mtime=").append(mtime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GoodsSku) {
            GoodsSku goodsSku = (GoodsSku) obj;
            if (this.getSkuId().equals(goodsSku.getSkuId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getSkuId();
        return pkStr.hashCode();
    }

}