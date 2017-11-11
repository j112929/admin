package com.bluemobi.po.goods;


import com.appcore.model.AbstractObject;

/**
 * 【商品spu自定义属性表】持久化对象 数据库表：goods_spu_property_custom
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public class GoodsSpuPropertyCustom extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 商品spu id
    private Integer spuId;
    // 属性名
    private Integer name;
    // 属性值名
    private Integer valueName;

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

    /** 获取 属性名 */
    public Integer getName() {
        return name;
    }

    /** 设置 属性名 */
    public void setName(Integer name) {
        this.name = name;
    }

    /** 获取 属性值名 */
    public Integer getValueName() {
        return valueName;
    }

    /** 设置 属性值名 */
    public void setValueName(Integer valueName) {
        this.valueName = valueName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GoodsSpuPropertyCustom");
        sb.append("{id=").append(id);
        sb.append(", spuId=").append(spuId);
        sb.append(", name=").append(name);
        sb.append(", valueName=").append(valueName);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GoodsSpuPropertyCustom) {
            GoodsSpuPropertyCustom goodsSpuPropertyCustom = (GoodsSpuPropertyCustom) obj;
            if (this.getId().equals(goodsSpuPropertyCustom.getId())) {
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