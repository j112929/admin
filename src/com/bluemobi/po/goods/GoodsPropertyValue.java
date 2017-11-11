package com.bluemobi.po.goods;


import com.appcore.model.AbstractObject;

/**
 * 【商品属性值】持久化对象 数据库表：goods_property_value
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public class GoodsPropertyValue extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 属性值id
    private Integer id;
    // 属性id
    private Integer propertyId;
    // 属性值名称
    private String name;
    // 序号
    private Integer sortOrder;

    /** 获取 属性值id */
    public Integer getId() {
        return id;
    }

    /** 设置 属性值id */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 属性id */
    public Integer getPropertyId() {
        return propertyId;
    }

    /** 设置 属性id */
    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    /** 获取 属性值名称 */
    public String getName() {
        return name;
    }

    /** 设置 属性值名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 序号 */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /** 设置 序号 */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GoodsPropertyValue");
        sb.append("{id=").append(id);
        sb.append(", propertyId=").append(propertyId);
        sb.append(", name=").append(name);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GoodsPropertyValue) {
            GoodsPropertyValue goodsPropertyValue = (GoodsPropertyValue) obj;
            if (this.getId().equals(goodsPropertyValue.getId())) {
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