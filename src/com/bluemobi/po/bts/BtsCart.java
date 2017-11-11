package com.bluemobi.po.bts;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【购物车表】持久化对象 数据库表：bts_cart
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class BtsCart extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 购物车id
    private Integer id;
    // 用户id
    private Integer userId;
    // 商品sku id
    private Integer skuId;
    // 商品数量
    private Integer quantity;
    // 状态：0、未勾选 1、已勾选
    private Integer status;
    // 创建时间
    private Date ctime;
    // 修改时间
    private Date mtime;

    /** 获取 购物车id */
    public Integer getId() {
        return id;
    }

    /** 设置 购物车id */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 用户id */
    public Integer getUserId() {
        return userId;
    }

    /** 设置 用户id */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /** 获取 商品sku id */
    public Integer getSkuId() {
        return skuId;
    }

    /** 设置 商品sku id */
    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    /** 获取 商品数量 */
    public Integer getQuantity() {
        return quantity;
    }

    /** 设置 商品数量 */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /** 获取 状态：0、未勾选 1、已勾选 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 状态：0、未勾选 1、已勾选 */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 获取 创建时间 */
    public Date getCtime() {
        return ctime;
    }

    /** 设置 创建时间 */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /** 获取 修改时间 */
    public Date getMtime() {
        return mtime;
    }

    /** 设置 修改时间 */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BtsCart");
        sb.append("{id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", skuId=").append(skuId);
        sb.append(", quantity=").append(quantity);
        sb.append(", status=").append(status);
        sb.append(", ctime=").append(ctime);
        sb.append(", mtime=").append(mtime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BtsCart) {
            BtsCart btsCart = (BtsCart) obj;
            if (this.getId().equals(btsCart.getId())) {
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