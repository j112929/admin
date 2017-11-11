package com.bluemobi.po.activity;

import java.math.BigDecimal;
import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【团购活动：本金购买，平台发起】持久化对象 数据库表：activity_groupon
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class ActivityGroupon extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 名称
    private String name;
    // 商品sku id
    private Integer skuId;
    // 价格(分)
    private Integer price;
    // 库存
    private Integer stock;
    // 成团人数
    private Integer userCount;
    // 参团人数
    private Integer joinUserCount;
    // 本金支付手续费率
    private BigDecimal chargeRate;
    // 序号
    private Integer sortOrder;
    // 描述
    private String description;
    // 开始时间
    private Date beginTime;
    // 结束时间
    private Date endTime;
    // 是否成团：0、未成团 1、成团
    private Integer isGroupon;
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

    /** 获取 价格(分) */
    public Integer getPrice() {
        return price;
    }

    /** 设置 价格(分) */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /** 获取 库存 */
    public Integer getStock() {
        return stock;
    }

    /** 设置 库存 */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /** 获取 成团人数 */
    public Integer getUserCount() {
        return userCount;
    }

    /** 设置 成团人数 */
    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    /** 获取 参团人数 */
    public Integer getJoinUserCount() {
        return joinUserCount;
    }

    /** 设置 参团人数 */
    public void setJoinUserCount(Integer joinUserCount) {
        this.joinUserCount = joinUserCount;
    }

    /** 获取 本金支付手续费率 */
    public BigDecimal getChargeRate() {
        return chargeRate;
    }

    /** 设置 本金支付手续费率 */
    public void setChargeRate(BigDecimal chargeRate) {
        this.chargeRate = chargeRate;
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

    /** 获取 是否成团：0、未成团 1、成团 */
    public Integer getIsGroupon() {
        return isGroupon;
    }

    /** 设置 是否成团：0、未成团 1、成团 */
    public void setIsGroupon(Integer isGroupon) {
        this.isGroupon = isGroupon;
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
        sb.append("ActivityGroupon");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", skuId=").append(skuId);
        sb.append(", price=").append(price);
        sb.append(", stock=").append(stock);
        sb.append(", userCount=").append(userCount);
        sb.append(", joinUserCount=").append(joinUserCount);
        sb.append(", chargeRate=").append(chargeRate);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", description=").append(description);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", isGroupon=").append(isGroupon);
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
        if (obj instanceof ActivityGroupon) {
            ActivityGroupon activityGroupon = (ActivityGroupon) obj;
            if (this.getId().equals(activityGroupon.getId())) {
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