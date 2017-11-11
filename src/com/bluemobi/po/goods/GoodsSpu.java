package com.bluemobi.po.goods;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【商品spu】持久化对象 数据库表：goods_spu
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class GoodsSpu extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 商品spu id
    private Integer spuId;
    // 商户id
    private Integer merchantId;
    // 标准化产品单元(Standard Product Unit)
    private String spu;
    // 商品名称
    private String name;
    // 商品品牌
    private Integer brandId;
    // 商品一级分类
    private Integer categoryId1;
    // 商品二级分类
    private Integer categoryId2;
    // 商品三级分类
    private Integer categoryId3;
    // 商品类型：1、实物商品 2、虚拟商品
    private Integer goodsType;
    // 商品显示端：1、手机端 2、web端 3、手机端和web端
    private Integer viewType;
    // 商品配送范围(省id),0代表全国配送
    private Integer regionId;
    // 是否支持本金支付：0、不支持 1、支持
    private Integer isMoneyPay;
    // 是否支持积分支付：0、不支持 1、支持
    private Integer isPointPay;
    // 是否支持混合支付（本金+积分）：0、不支持 1、支持
    private Integer isMixPay;
    // 是否支持分期支付：0、不支持 1、支持
    private Integer isInstallmentPay;
    // 是否支持退货：0、不支持 1、支持
    private Integer isRefundable;
    // 是否提供发票：0、不提供 1、提供
    private Integer isInvoice;
    // 每月限购件数，为0就不限购
    private Integer maxBuyCount;
    // 专享类型：1、生日专享 2、白金专享 3、白名单专享
    private Integer vipType;
    // 是否有多SKU：0、单SKU 1、多SKU
    private Integer isMultSku;
    // 属性，格式：[{"name":"版型","valueName":"修身"},{"name":"衣长","valueName":"中长款"},{"name":"颜色","valueName":"白色 红色 蓝色 紫色"},{"name":"尺码","value":"X L XL XXL XXXL"}]
    private String propertys;
    // 图文详情，格式如：["/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg","/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg"]
    private String pics;
    // 商品简介
    private String description;
    // 促销语
    private String promotion;
    // 促销语开始时间
    private Date promotionBeginTime;
    // 促销语结束时间
    private Date promotionEndTime;
    // 采购批次编号
    private String procurementBatchNo;
    // 长（单位：mm）
    private Integer length;
    // 宽（单位：mm）
    private Integer wide;
    // 高（单位：mm）
    private Integer high;
    // 重量（单位：g）
    private Integer weight;
    // 销售数量
    private Integer salesQuantity;
    // 销售金额
    private Long salesAmount;
    // 状态：0、下架 1、上架
    private Integer status;
    // 前台是否显示：0、不显示 1、显示
    private Integer isShow;
    // 审核状态：0、未审核 1、审核通过 2、审核不通过
    private Integer verifyStatus;
    // 是否删除：0、未删除 1、删除
    private Integer isDel;
    // 创建人
    private Integer creator;
    // 创建时间
    private Date ctime;
    // 修改人
    private Integer modifier;
    // 修改时间
    private Date mtime;

    /** 获取 商品spu id */
    public Integer getSpuId() {
        return spuId;
    }

    /** 设置 商品spu id */
    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    /** 获取 商户id */
    public Integer getMerchantId() {
        return merchantId;
    }

    /** 设置 商户id */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /** 获取 标准化产品单元(Standard Product Unit) */
    public String getSpu() {
        return spu;
    }

    /** 设置 标准化产品单元(Standard Product Unit) */
    public void setSpu(String spu) {
        this.spu = spu;
    }

    /** 获取 商品名称 */
    public String getName() {
        return name;
    }

    /** 设置 商品名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 商品品牌 */
    public Integer getBrandId() {
        return brandId;
    }

    /** 设置 商品品牌 */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /** 获取 商品一级分类 */
    public Integer getCategoryId1() {
        return categoryId1;
    }

    /** 设置 商品一级分类 */
    public void setCategoryId1(Integer categoryId1) {
        this.categoryId1 = categoryId1;
    }

    /** 获取 商品二级分类 */
    public Integer getCategoryId2() {
        return categoryId2;
    }

    /** 设置 商品二级分类 */
    public void setCategoryId2(Integer categoryId2) {
        this.categoryId2 = categoryId2;
    }

    /** 获取 商品三级分类 */
    public Integer getCategoryId3() {
        return categoryId3;
    }

    /** 设置 商品三级分类 */
    public void setCategoryId3(Integer categoryId3) {
        this.categoryId3 = categoryId3;
    }

    /** 获取 商品类型：1、实物商品 2、虚拟商品 */
    public Integer getGoodsType() {
        return goodsType;
    }

    /** 设置 商品类型：1、实物商品 2、虚拟商品 */
    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    /** 获取 商品显示端：1、手机端 2、web端 3、手机端和web端 */
    public Integer getViewType() {
        return viewType;
    }

    /** 设置 商品显示端：1、手机端 2、web端 3、手机端和web端 */
    public void setViewType(Integer viewType) {
        this.viewType = viewType;
    }

    /** 获取 商品配送范围(省id),0代表全国配送 */
    public Integer getRegionId() {
        return regionId;
    }

    /** 设置 商品配送范围(省id),0代表全国配送 */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /** 获取 是否支持本金支付：0、不支持 1、支持 */
    public Integer getIsMoneyPay() {
        return isMoneyPay;
    }

    /** 设置 是否支持本金支付：0、不支持 1、支持 */
    public void setIsMoneyPay(Integer isMoneyPay) {
        this.isMoneyPay = isMoneyPay;
    }

    /** 获取 是否支持积分支付：0、不支持 1、支持 */
    public Integer getIsPointPay() {
        return isPointPay;
    }

    /** 设置 是否支持积分支付：0、不支持 1、支持 */
    public void setIsPointPay(Integer isPointPay) {
        this.isPointPay = isPointPay;
    }

    /** 获取 是否支持混合支付（本金+积分）：0、不支持 1、支持 */
    public Integer getIsMixPay() {
        return isMixPay;
    }

    /** 设置 是否支持混合支付（本金+积分）：0、不支持 1、支持 */
    public void setIsMixPay(Integer isMixPay) {
        this.isMixPay = isMixPay;
    }

    /** 获取 是否支持分期支付：0、不支持 1、支持 */
    public Integer getIsInstallmentPay() {
        return isInstallmentPay;
    }

    /** 设置 是否支持分期支付：0、不支持 1、支持 */
    public void setIsInstallmentPay(Integer isInstallmentPay) {
        this.isInstallmentPay = isInstallmentPay;
    }

    /** 获取 是否支持退货：0、不支持 1、支持 */
    public Integer getIsRefundable() {
        return isRefundable;
    }

    /** 设置 是否支持退货：0、不支持 1、支持 */
    public void setIsRefundable(Integer isRefundable) {
        this.isRefundable = isRefundable;
    }

    /** 获取 是否提供发票：0、不提供 1、提供 */
    public Integer getIsInvoice() {
        return isInvoice;
    }

    /** 设置 是否提供发票：0、不提供 1、提供 */
    public void setIsInvoice(Integer isInvoice) {
        this.isInvoice = isInvoice;
    }

    /** 获取 每月限购件数，为0就不限购 */
    public Integer getMaxBuyCount() {
        return maxBuyCount;
    }

    /** 设置 每月限购件数，为0就不限购 */
    public void setMaxBuyCount(Integer maxBuyCount) {
        this.maxBuyCount = maxBuyCount;
    }

    /** 获取 专享类型：1、生日专享 2、白金专享 3、白名单专享 */
    public Integer getVipType() {
        return vipType;
    }

    /** 设置 专享类型：1、生日专享 2、白金专享 3、白名单专享 */
    public void setVipType(Integer vipType) {
        this.vipType = vipType;
    }

    /** 获取 是否有多SKU：0、单SKU 1、多SKU */
    public Integer getIsMultSku() {
        return isMultSku;
    }

    /** 设置 是否有多SKU：0、单SKU 1、多SKU */
    public void setIsMultSku(Integer isMultSku) {
        this.isMultSku = isMultSku;
    }

    /** 获取 属性，格式：[{"name":"版型","valueName":"修身"},{"name":"衣长","valueName":"中长款"},{"name":"颜色","valueName":"白色 红色 蓝色 紫色"},{"name":"尺码","value":"X L XL XXL XXXL"}] */
    public String getPropertys() {
        return propertys;
    }

    /** 设置 属性，格式：[{"name":"版型","valueName":"修身"},{"name":"衣长","valueName":"中长款"},{"name":"颜色","valueName":"白色 红色 蓝色 紫色"},{"name":"尺码","value":"X L XL XXL XXXL"}] */
    public void setPropertys(String propertys) {
        this.propertys = propertys;
    }

    /** 获取 图文详情，格式如：["/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg","/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg"] */
    public String getPics() {
        return pics;
    }

    /** 设置 图文详情，格式如：["/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg","/d9/b0/4c/50/3e/0c0e2427242ec6dcae90ca.jpeg"] */
    public void setPics(String pics) {
        this.pics = pics;
    }

    /** 获取 商品简介 */
    public String getDescription() {
        return description;
    }

    /** 设置 商品简介 */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 获取 促销语 */
    public String getPromotion() {
        return promotion;
    }

    /** 设置 促销语 */
    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    /** 获取 促销语开始时间 */
    public Date getPromotionBeginTime() {
        return promotionBeginTime;
    }

    /** 设置 促销语开始时间 */
    public void setPromotionBeginTime(Date promotionBeginTime) {
        this.promotionBeginTime = promotionBeginTime;
    }

    /** 获取 促销语结束时间 */
    public Date getPromotionEndTime() {
        return promotionEndTime;
    }

    /** 设置 促销语结束时间 */
    public void setPromotionEndTime(Date promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    /** 获取 采购批次编号 */
    public String getProcurementBatchNo() {
        return procurementBatchNo;
    }

    /** 设置 采购批次编号 */
    public void setProcurementBatchNo(String procurementBatchNo) {
        this.procurementBatchNo = procurementBatchNo;
    }

    /** 获取 长（单位：mm） */
    public Integer getLength() {
        return length;
    }

    /** 设置 长（单位：mm） */
    public void setLength(Integer length) {
        this.length = length;
    }

    /** 获取 宽（单位：mm） */
    public Integer getWide() {
        return wide;
    }

    /** 设置 宽（单位：mm） */
    public void setWide(Integer wide) {
        this.wide = wide;
    }

    /** 获取 高（单位：mm） */
    public Integer getHigh() {
        return high;
    }

    /** 设置 高（单位：mm） */
    public void setHigh(Integer high) {
        this.high = high;
    }

    /** 获取 重量（单位：g） */
    public Integer getWeight() {
        return weight;
    }

    /** 设置 重量（单位：g） */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /** 获取 销售数量 */
    public Integer getSalesQuantity() {
        return salesQuantity;
    }

    /** 设置 销售数量 */
    public void setSalesQuantity(Integer salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    /** 获取 销售金额 */
    public Long getSalesAmount() {
        return salesAmount;
    }

    /** 设置 销售金额 */
    public void setSalesAmount(Long salesAmount) {
        this.salesAmount = salesAmount;
    }

    /** 获取 状态：0、下架 1、上架 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 状态：0、下架 1、上架 */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 获取 前台是否显示：0、不显示 1、显示 */
    public Integer getIsShow() {
        return isShow;
    }

    /** 设置 前台是否显示：0、不显示 1、显示 */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /** 获取 审核状态：0、未审核 1、审核通过 2、审核不通过 */
    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    /** 设置 审核状态：0、未审核 1、审核通过 2、审核不通过 */
    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    /** 获取 是否删除：0、未删除 1、删除 */
    public Integer getIsDel() {
        return isDel;
    }

    /** 设置 是否删除：0、未删除 1、删除 */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /** 获取 创建人 */
    public Integer getCreator() {
        return creator;
    }

    /** 设置 创建人 */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /** 获取 创建时间 */
    public Date getCtime() {
        return ctime;
    }

    /** 设置 创建时间 */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /** 获取 修改人 */
    public Integer getModifier() {
        return modifier;
    }

    /** 设置 修改人 */
    public void setModifier(Integer modifier) {
        this.modifier = modifier;
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
        sb.append("GoodsSpu");
        sb.append("{spuId=").append(spuId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", spu=").append(spu);
        sb.append(", name=").append(name);
        sb.append(", brandId=").append(brandId);
        sb.append(", categoryId1=").append(categoryId1);
        sb.append(", categoryId2=").append(categoryId2);
        sb.append(", categoryId3=").append(categoryId3);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", viewType=").append(viewType);
        sb.append(", regionId=").append(regionId);
        sb.append(", isMoneyPay=").append(isMoneyPay);
        sb.append(", isPointPay=").append(isPointPay);
        sb.append(", isMixPay=").append(isMixPay);
        sb.append(", isInstallmentPay=").append(isInstallmentPay);
        sb.append(", isRefundable=").append(isRefundable);
        sb.append(", isInvoice=").append(isInvoice);
        sb.append(", maxBuyCount=").append(maxBuyCount);
        sb.append(", vipType=").append(vipType);
        sb.append(", isMultSku=").append(isMultSku);
        sb.append(", propertys=").append(propertys);
        sb.append(", pics=").append(pics);
        sb.append(", description=").append(description);
        sb.append(", promotion=").append(promotion);
        sb.append(", promotionBeginTime=").append(promotionBeginTime);
        sb.append(", promotionEndTime=").append(promotionEndTime);
        sb.append(", procurementBatchNo=").append(procurementBatchNo);
        sb.append(", length=").append(length);
        sb.append(", wide=").append(wide);
        sb.append(", high=").append(high);
        sb.append(", weight=").append(weight);
        sb.append(", salesQuantity=").append(salesQuantity);
        sb.append(", salesAmount=").append(salesAmount);
        sb.append(", status=").append(status);
        sb.append(", isShow=").append(isShow);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", isDel=").append(isDel);
        sb.append(", creator=").append(creator);
        sb.append(", ctime=").append(ctime);
        sb.append(", modifier=").append(modifier);
        sb.append(", mtime=").append(mtime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GoodsSpu) {
            GoodsSpu goodsSpu = (GoodsSpu) obj;
            if (this.getSpuId().equals(goodsSpu.getSpuId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getSpuId();
        return pkStr.hashCode();
    }

}