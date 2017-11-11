package com.bluemobi.po.coupon;


import com.appcore.model.AbstractObject;

/**
 * 【优惠券类别选择表】持久化对象 数据库表：coupon_type_category
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:09
 * 
 */
public class CouponTypeCategory extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 
    private Integer id;
    // 优惠券ID
    private Integer couponId;
    // 父级分类ID
    private Integer categoryId;

    /** 获取  属性 */
    public Integer getId() {
            if(this.id==null){
                this.id=0;
            }
        return id;
    }

    /** 设置  属性 */
    public void setId(Integer id) {
        this.id = id;
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

    /** 获取 父级分类ID 属性 */
    public Integer getCategoryId() {
            if(this.categoryId==null){
                this.categoryId=0;
            }
        return categoryId;
    }

    /** 设置 父级分类ID 属性 */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CouponTypeCategory");
        sb.append("{id=").append(id);
        sb.append(", couponId=").append(couponId);
        sb.append(", categoryId=").append(categoryId);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CouponTypeCategory) {
            CouponTypeCategory couponTypeCategory = (CouponTypeCategory) obj;
            if (this.getId().equals(couponTypeCategory.getId())) {
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