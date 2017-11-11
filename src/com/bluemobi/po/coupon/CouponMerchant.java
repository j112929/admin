package com.bluemobi.po.coupon;


import com.appcore.model.AbstractObject;

/**
 * 【优惠券商户表】持久化对象 数据库表：coupon_merchant
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:09
 * 
 */
public class CouponMerchant extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // p_store_id
    private Integer id;
    // 商户ID
    private Long merchantId;
    // 优惠券ID
    private Integer couponId;

    /** 获取 p_store_id 属性 */
    public Integer getId() {
            if(this.id==null){
                this.id=0;
            }
        return id;
    }

    /** 设置 p_store_id 属性 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 商户ID 属性 */
    public Long getMerchantId() {
        return merchantId;
    }

    /** 设置 商户ID 属性 */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /** 获取 优惠券ID 属性 */
    public Integer getCouponId() {
            if(this.couponId==null){
                this.couponId=0;
            }
        return couponId;
    }

    /** 设置 优惠券ID 属性 */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CouponMerchant");
        sb.append("{id=").append(id);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", couponId=").append(couponId);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CouponMerchant) {
            CouponMerchant couponMerchant = (CouponMerchant) obj;
            if (this.getId().equals(couponMerchant.getId())) {
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