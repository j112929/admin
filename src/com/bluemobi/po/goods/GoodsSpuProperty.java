package com.bluemobi.po.goods;


import com.appcore.model.AbstractObject;

/**
 * 【商品spu属性表】持久化对象 数据库表：goods_spu_property
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public class GoodsSpuProperty extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 商品spu id
    private Integer spuId;
    // 属性id
    private Integer propertyId;
    // 属性值id
    private Integer propertyValueId;

    /** 获取 主键 */
    public Integer getId() {
        return id;
    }

    /** 设置 主键 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 商品spu id */
    public Integer getSpuId() {
        return spuId;
    }

    /** 设置 商品spu id */
    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    /** 获取 属性id */
    public Integer getPropertyId() {
        return propertyId;
    }

    /** 设置 属性id */
    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    /** 获取 属性值id */
    public Integer getPropertyValueId() {
        return propertyValueId;
    }

    /** 设置 属性值id */
    public void setPropertyValueId(Integer propertyValueId) {
        this.propertyValueId = propertyValueId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GoodsSpuProperty");
        sb.append("{id=").append(id);
        sb.append(", spuId=").append(spuId);
        sb.append(", propertyId=").append(propertyId);
        sb.append(", propertyValueId=").append(propertyValueId);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GoodsSpuProperty) {
            GoodsSpuProperty goodsSpuProperty = (GoodsSpuProperty) obj;
            if (this.getId().equals(goodsSpuProperty.getId())) {
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