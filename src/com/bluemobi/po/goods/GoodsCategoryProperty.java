package com.bluemobi.po.goods;


import com.appcore.model.AbstractObject;

/**
 * 【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】持久化对象 数据库表：goods_category_property
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public class GoodsCategoryProperty extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 分类id
    private Integer categoryId;
    // 属性id
    private Integer propertyId;

    /** 获取 主键 */
    public Integer getId() {
        return id;
    }

    /** 设置 主键 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 分类id */
    public Integer getCategoryId() {
        return categoryId;
    }

    /** 设置 分类id */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /** 获取 属性id */
    public Integer getPropertyId() {
        return propertyId;
    }

    /** 设置 属性id */
    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GoodsCategoryProperty");
        sb.append("{id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", propertyId=").append(propertyId);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GoodsCategoryProperty) {
            GoodsCategoryProperty goodsCategoryProperty = (GoodsCategoryProperty) obj;
            if (this.getId().equals(goodsCategoryProperty.getId())) {
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