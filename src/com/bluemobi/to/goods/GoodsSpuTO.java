package com.bluemobi.to.goods;

import java.math.BigDecimal;

import com.appcore.model.AbstractObject;

public class GoodsSpuTO extends AbstractObject {

    private static final long serialVersionUID = 1L;
    
    // skuID
    private Integer[] skuId;
    // 库存
    private Integer[] stock;
    // 警戒库存
    private Integer[] stockWarn;
    // 原价
    private Integer[] originalPrice;
    // 本金出售价
    private Integer[] price;
    // 本金手续费率 
    private BigDecimal[] chargeRate;
    // 积分出售价
    private Integer[] pointPrice;
    // 积分结算价
    private Integer[] settlementPrice;
    

    /*sku属性，最多可绑定三个 */
    // sku属性，Property
    private Integer[] skuPropertyId;
    // 第一个sku属性值的PropertyValue
    private Integer[] gpv0;
    // 第二个sku属性值的PropertyValue
    private Integer[] gpv1;
    // 第三个sku属性值的PropertyValue
    private Integer[] gpv2;

    // 扩展属性Property
    private Integer[] spuPropertyId;
    // 扩展属性PropertyValue
    private Integer[] spuPropertyValueId;
	public Integer[] getSkuId() {
		return skuId;
	}
	public void setSkuId(Integer[] skuId) {
		this.skuId = skuId;
	}
	public Integer[] getStock() {
		return stock;
	}
	public void setStock(Integer[] stock) {
		this.stock = stock;
	}
	public Integer[] getStockWarn() {
		return stockWarn;
	}
	public void setStockWarn(Integer[] stockWarn) {
		this.stockWarn = stockWarn;
	}
	public Integer[] getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(Integer[] originalPrice) {
		this.originalPrice = originalPrice;
	}
	public Integer[] getPrice() {
		return price;
	}
	public void setPrice(Integer[] price) {
		this.price = price;
	}
	public BigDecimal[] getChargeRate() {
		return chargeRate;
	}
	public void setChargeRate(BigDecimal[] chargeRate) {
		this.chargeRate = chargeRate;
	}
	public Integer[] getPointPrice() {
		return pointPrice;
	}
	public void setPointPrice(Integer[] pointPrice) {
		this.pointPrice = pointPrice;
	}
	public Integer[] getGpv0() {
		return gpv0;
	}
	public void setGpv0(Integer[] gpv0) {
		this.gpv0 = gpv0;
	}
	public Integer[] getGpv1() {
		return gpv1;
	}
	public void setGpv1(Integer[] gpv1) {
		this.gpv1 = gpv1;
	}
	public Integer[] getGpv2() {
		return gpv2;
	}
	public void setGpv2(Integer[] gpv2) {
		this.gpv2 = gpv2;
	}
	public Integer[] getSpuPropertyId() {
		return spuPropertyId;
	}
	public void setSpuPropertyId(Integer[] spuPropertyId) {
		this.spuPropertyId = spuPropertyId;
	}
	public Integer[] getSpuPropertyValueId() {
		return spuPropertyValueId;
	}
	public void setSpuPropertyValueId(Integer[] spuPropertyValueId) {
		this.spuPropertyValueId = spuPropertyValueId;
	}
	public Integer[] getSkuPropertyId() {
		return skuPropertyId;
	}
	public void setSkuPropertyId(Integer[] skuPropertyId) {
		this.skuPropertyId = skuPropertyId;
	}
	public Integer[] getSettlementPrice() {
		return settlementPrice;
	}
	public void setSettlementPrice(Integer[] settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

}
