package com.bluemobi.po.coupon;


import com.appcore.model.AbstractObject;

/**
 * 【优惠券白名单表】持久化对象 数据库表：coupon_white_list
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:09
 * 
 */
public class CouponWhiteList extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // white_id
    private Integer id;
    // 优惠券ID
    private Integer couponId;
    // 证件号码(18位身份证)
    private String codeId;

    /** 获取 white_id 属性 */
    public Integer getId() {
            if(this.id==null){
                this.id=0;
            }
        return id;
    }

    /** 设置 white_id 属性 */
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

    /** 获取 证件号码(18位身份证) 属性 */
    public String getCodeId() {
            if(this.codeId==null){
                this.codeId="";
            }
        return codeId;
    }

    /** 设置 证件号码(18位身份证) 属性 */
    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CouponWhiteList");
        sb.append("{id=").append(id);
        sb.append(", couponId=").append(couponId);
        sb.append(", codeId=").append(codeId);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CouponWhiteList) {
            CouponWhiteList couponWhiteList = (CouponWhiteList) obj;
            if (this.getId().equals(couponWhiteList.getId())) {
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