package com.bluemobi.po.activity;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【抽奖活动：积分抽奖，平台发起】持久化对象 数据库表：activity_lottery
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class ActivityLottery extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 名称
    private String name;
    // 活动规则
    private String description;
    // 每人每天最大抽奖次数
    private Integer maxLotteryCount;
    // 总转动次数
    private Integer count;
    // 结算价格(分)
    private Integer settlementPrice;
    // 每次抽奖价格(积分)
    private Integer price;
    // 开始时间
    private Date beginTime;
    // 结束时间
    private Date endTime;
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

    /** 获取 活动规则 */
    public String getDescription() {
        return description;
    }

    /** 设置 活动规则 */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 获取 每人每天最大抽奖次数 */
    public Integer getMaxLotteryCount() {
        return maxLotteryCount;
    }

    /** 设置 每人每天最大抽奖次数 */
    public void setMaxLotteryCount(Integer maxLotteryCount) {
        this.maxLotteryCount = maxLotteryCount;
    }

    /** 获取 总转动次数 */
    public Integer getCount() {
        return count;
    }

    /** 设置 总转动次数 */
    public void setCount(Integer count) {
        this.count = count;
    }

    /** 获取 结算价格(分) */
    public Integer getSettlementPrice() {
        return settlementPrice;
    }

    /** 设置 结算价格(分) */
    public void setSettlementPrice(Integer settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    /** 获取 每次抽奖价格(积分) */
    public Integer getPrice() {
        return price;
    }

    /** 设置 每次抽奖价格(积分) */
    public void setPrice(Integer price) {
        this.price = price;
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
        sb.append("ActivityLottery");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", maxLotteryCount=").append(maxLotteryCount);
        sb.append(", count=").append(count);
        sb.append(", settlementPrice=").append(settlementPrice);
        sb.append(", price=").append(price);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
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
        if (obj instanceof ActivityLottery) {
            ActivityLottery activityLottery = (ActivityLottery) obj;
            if (this.getId().equals(activityLottery.getId())) {
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