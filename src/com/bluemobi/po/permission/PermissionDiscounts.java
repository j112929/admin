package com.bluemobi.po.permission;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【优惠折扣抢购表】持久化对象 数据库表：permission_discounts
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-05 14:52:21
 * 
 */
public class PermissionDiscounts extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 优惠折扣Id
    private Integer discountId;
    // 折扣名称
    private String title;
    // 折扣活动开始时间
    private Date startTime;
    // 折扣活动结束时间
    private Date endTime;
    // 抢购价格
    private Float price;
    // 商品 sku
    private String sku;
    // 抢购数量：一个用户只能购买N件商品并且只能提交一次成功订单，取消订单可以再次抢购
    private Integer buynumber;
    // 创建时间
    private Date ctime;

    /** 获取 优惠折扣Id 属性 */
    public Integer getDiscountId() {
            if(this.discountId==null){
                this.discountId=0;
            }
        return discountId;
    }

    /** 设置 优惠折扣Id 属性 */
    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    /** 获取 折扣名称 属性 */
    public String getTitle() {
            if(this.title==null){
                this.title="";
            }
        return title;
    }

    /** 设置 折扣名称 属性 */
    public void setTitle(String title) {
        this.title = title;
    }

    /** 获取 折扣活动开始时间 属性 */
    public Date getStartTime() {
        return startTime;
    }

    /** 设置 折扣活动开始时间 属性 */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /** 获取 折扣活动结束时间 属性 */
    public Date getEndTime() {
        return endTime;
    }

    /** 设置 折扣活动结束时间 属性 */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /** 获取 抢购价格 属性 */
    public Float getPrice() {
        return price;
    }

    /** 设置 抢购价格 属性 */
    public void setPrice(Float price) {
        this.price = price;
    }

    /** 获取 商品 sku 属性 */
    public String getSku() {
            if(this.sku==null){
                this.sku="";
            }
        return sku;
    }

    /** 设置 商品 sku 属性 */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /** 获取 抢购数量：一个用户只能购买N件商品并且只能提交一次成功订单，取消订单可以再次抢购 属性 */
    public Integer getBuynumber() {
            if(this.buynumber==null){
                this.buynumber=0;
            }
        return buynumber;
    }

    /** 设置 抢购数量：一个用户只能购买N件商品并且只能提交一次成功订单，取消订单可以再次抢购 属性 */
    public void setBuynumber(Integer buynumber) {
        this.buynumber = buynumber;
    }

    /** 获取 创建时间 属性 */
    public Date getCtime() {
        return ctime;
    }

    /** 设置 创建时间 属性 */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PermissionDiscounts");
        sb.append("{discountId=").append(discountId);
        sb.append(", title=").append(title);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", price=").append(price);
        sb.append(", sku=").append(sku);
        sb.append(", buynumber=").append(buynumber);
        sb.append(", ctime=").append(ctime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PermissionDiscounts) {
            PermissionDiscounts permissionDiscounts = (PermissionDiscounts) obj;
            if (this.getDiscountId().equals(permissionDiscounts.getDiscountId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getDiscountId();
        return pkStr.hashCode();
    }

}