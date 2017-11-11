package com.bluemobi.po.permission;


import com.appcore.model.AbstractObject;

/**
 * 【优惠折扣关联商品表】持久化对象 数据库表：permission_discounts_goods
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-05 14:52:22
 * 
 */
public class PermissionDiscountsGoods extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // Id
    private Integer id;
    // 优惠折扣ID
    private Integer discountId;
    // 折扣出售价格
    private Float price;
    // 商品 skuId
    private Integer skuId;
    // 商品名称
    private String goodsName;

    /** 获取 Id 属性 */
    public Integer getId() {
            if(this.id==null){
                this.id=0;
            }
        return id;
    }

    /** 设置 Id 属性 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 优惠折扣ID 属性 */
    public Integer getDiscountId() {
            if(this.discountId==null){
                this.discountId=0;
            }
        return discountId;
    }

    /** 设置 优惠折扣ID 属性 */
    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    /** 获取 折扣出售价格 属性 */
    public Float getPrice() {
        return price;
    }

    /** 设置 折扣出售价格 属性 */
    public void setPrice(Float price) {
        this.price = price;
    }

    /** 获取 商品 skuId 属性 */
    public Integer getSkuId() {
            if(this.skuId==null){
                this.skuId=0;
            }
        return skuId;
    }

    /** 设置 商品 skuId 属性 */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /** 获取 商品名称 属性 */
    public String getGoodsName() {
            if(this.goodsName==null){
                this.goodsName="";
            }
        return goodsName;
    }

    /** 设置 商品名称 属性 */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PermissionDiscountsGoods");
        sb.append("{id=").append(id);
        sb.append(", discountId=").append(discountId);
        sb.append(", price=").append(price);
        sb.append(", skuId=").append(skuId);
        sb.append(", goodsName=").append(goodsName);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PermissionDiscountsGoods) {
            PermissionDiscountsGoods permissionDiscountsGoods = (PermissionDiscountsGoods) obj;
            if (this.getId().equals(permissionDiscountsGoods.getId())) {
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