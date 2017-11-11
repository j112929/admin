package com.bluemobi.po.activity;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【抽奖明细】持久化对象 数据库表：activity_lottery_item
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class ActivityLotteryItem extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 抽奖活动id
    private Integer lotteryId;
    // 商品sku id
    private Integer skuId;
    // 位置
    private Integer position;
    // 图片
    private String pic;
    // 商品数量
    private Integer quantity;
    // 商品剩余数量
    private Integer remainQuantity;
    // 结算价格(分)
    private Integer settlementPrice;
    // 开始时间
    private Date beginTime;
    // 结束时间
    private Date endTime;

    /** 获取 主键 */
    public Integer getId() {
        return id;
    }

    /** 设置 主键 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 抽奖活动id */
    public Integer getLotteryId() {
        return lotteryId;
    }

    /** 设置 抽奖活动id */
    public void setLotteryId(Integer lotteryId) {
        this.lotteryId = lotteryId;
    }

    /** 获取 商品sku id */
    public Integer getSkuId() {
        return skuId;
    }

    /** 设置 商品sku id */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /** 获取 位置 */
    public Integer getPosition() {
        return position;
    }

    /** 设置 位置 */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /** 获取 图片 */
    public String getPic() {
        return pic;
    }

    /** 设置 图片 */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /** 获取 商品数量 */
    public Integer getQuantity() {
        return quantity;
    }

    /** 设置 商品数量 */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /** 获取 商品剩余数量 */
    public Integer getRemainQuantity() {
        return remainQuantity;
    }

    /** 设置 商品剩余数量 */
    public void setRemainQuantity(Integer remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    /** 获取 结算价格(分) */
    public Integer getSettlementPrice() {
        return settlementPrice;
    }

    /** 设置 结算价格(分) */
    public void setSettlementPrice(Integer settlementPrice) {
        this.settlementPrice = settlementPrice;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ActivityLotteryItem");
        sb.append("{id=").append(id);
        sb.append(", lotteryId=").append(lotteryId);
        sb.append(", skuId=").append(skuId);
        sb.append(", position=").append(position);
        sb.append(", pic=").append(pic);
        sb.append(", quantity=").append(quantity);
        sb.append(", remainQuantity=").append(remainQuantity);
        sb.append(", settlementPrice=").append(settlementPrice);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActivityLotteryItem) {
            ActivityLotteryItem activityLotteryItem = (ActivityLotteryItem) obj;
            if (this.getId().equals(activityLotteryItem.getId())) {
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