package com.bluemobi.po.activity;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【秒杀活动：积分秒杀，平台发起】持久化对象 数据库表：activity_seckill
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class ActivitySeckill extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 名称
    private String name;
    // 商品sku id
    private Integer skuId;
    // 每人限购数量
    private Integer maxBuyQuantity;
    // 秒杀商品数量
    private Integer quantity;
    // 结算价格(分)
    private Integer settlementPrice;
    // 价格(积分)
    private Integer price;
    // 序号
    private Integer sortOrder;
    // 描述
    private String description;
    // 预发布时间
    private Date showTime;
    // 开始时间
    private Date beginTime;
    // 结束时间
    private Date endTime;
    // 是否是白名单活动：0、不是 1、是
    private Integer isWhiteListActivity;
    // 审核状态：0、未审核 1、审核通过 2、审核不通过
    private Integer verifyStatus;
    // 创建人
    private Integer creator;
    // 创建时间
    private Date ctime;
    // 修改人
    private Integer modifier;
    // 修改时间
    private Date mtime;

    /** 获取 主键 */
    public Integer getId() {
        return id;
    }

    /** 设置 主键 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 名称 */
    public String getName() {
        return name;
    }

    /** 设置 名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 商品sku id */
    public Integer getSkuId() {
        return skuId;
    }

    /** 设置 商品sku id */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /** 获取 每人限购数量 */
    public Integer getMaxBuyQuantity() {
        return maxBuyQuantity;
    }

    /** 设置 每人限购数量 */
    public void setMaxBuyQuantity(Integer maxBuyQuantity) {
        this.maxBuyQuantity = maxBuyQuantity;
    }

    /** 获取 秒杀商品数量 */
    public Integer getQuantity() {
        return quantity;
    }

    /** 设置 秒杀商品数量 */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /** 获取 结算价格(分) */
    public Integer getSettlementPrice() {
        return settlementPrice;
    }

    /** 设置 结算价格(分) */
    public void setSettlementPrice(Integer settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    /** 获取 价格(积分) */
    public Integer getPrice() {
        return price;
    }

    /** 设置 价格(积分) */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /** 获取 序号 */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /** 设置 序号 */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /** 获取 描述 */
    public String getDescription() {
        return description;
    }

    /** 设置 描述 */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 获取 预发布时间 */
    public Date getShowTime() {
        return showTime;
    }

    /** 设置 预发布时间 */
    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    /** 获取 开始时间 */
    public Date getBeginTime() {
        return beginTime;
    }

    /** 设置 开始时间 */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /** 获取 结束时间 */
    public Date getEndTime() {
        return endTime;
    }

    /** 设置 结束时间 */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /** 获取 是否是白名单活动：0、不是 1、是 */
    public Integer getIsWhiteListActivity() {
        return isWhiteListActivity;
    }

    /** 设置 是否是白名单活动：0、不是 1、是 */
    public void setIsWhiteListActivity(Integer isWhiteListActivity) {
        this.isWhiteListActivity = isWhiteListActivity;
    }

    /** 获取 审核状态：0、未审核 1、审核通过 2、审核不通过 */
    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    /** 设置 审核状态：0、未审核 1、审核通过 2、审核不通过 */
    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
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
        sb.append("ActivitySeckill");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", skuId=").append(skuId);
        sb.append(", maxBuyQuantity=").append(maxBuyQuantity);
        sb.append(", quantity=").append(quantity);
        sb.append(", settlementPrice=").append(settlementPrice);
        sb.append(", price=").append(price);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", description=").append(description);
        sb.append(", showTime=").append(showTime);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", isWhiteListActivity=").append(isWhiteListActivity);
        sb.append(", verifyStatus=").append(verifyStatus);
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
        if (obj instanceof ActivitySeckill) {
            ActivitySeckill activitySeckill = (ActivitySeckill) obj;
            if (this.getId().equals(activitySeckill.getId())) {
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