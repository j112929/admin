package com.bluemobi.po.coupon;


import com.appcore.model.AbstractObject;

/**
 * 【优惠券分类表】持久化对象 数据库表：coupon_category
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:08
 * 
 */
public class CouponCategory extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // category_id
    private Integer id;
    // 分类标题
    private String categoryItitle;
    // 父分类 ID
    private Integer categoryParentName;
    // 分类层级
    private Integer categoryGrade;

    /** 获取 category_id 属性 */
    public Integer getId() {
            if(this.id==null){
                this.id=0;
            }
        return id;
    }

    /** 设置 category_id 属性 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 分类标题 属性 */
    public String getCategoryItitle() {
            if(this.categoryItitle==null){
                this.categoryItitle="";
            }
        return categoryItitle;
    }

    /** 设置 分类标题 属性 */
    public void setCategoryItitle(String categoryItitle) {
        this.categoryItitle = categoryItitle;
    }

    /** 获取 父分类 ID 属性 */
    public Integer getCategoryParentName() {
            if(this.categoryParentName==null){
                this.categoryParentName=0;
            }
        return categoryParentName;
    }

    /** 设置 父分类 ID 属性 */
    public void setCategoryParentName(Integer categoryParentName) {
        this.categoryParentName = categoryParentName;
    }

    /** 获取 分类层级 属性 */
    public Integer getCategoryGrade() {
            if(this.categoryGrade==null){
                this.categoryGrade=0;
            }
        return categoryGrade;
    }

    /** 设置 分类层级 属性 */
    public void setCategoryGrade(Integer categoryGrade) {
        this.categoryGrade = categoryGrade;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CouponCategory");
        sb.append("{id=").append(id);
        sb.append(", categoryItitle=").append(categoryItitle);
        sb.append(", categoryParentName=").append(categoryParentName);
        sb.append(", categoryGrade=").append(categoryGrade);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CouponCategory) {
            CouponCategory couponCategory = (CouponCategory) obj;
            if (this.getId().equals(couponCategory.getId())) {
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