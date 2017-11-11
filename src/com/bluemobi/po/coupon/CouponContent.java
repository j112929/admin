package com.bluemobi.po.coupon;

import java.math.BigDecimal;
import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【优惠券表】持久化对象 数据库表：coupon_content
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:08
 * 
 */
public class CouponContent extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // promotion
    private Integer couponId;
    // 优惠券类型：0、全场类型 1、专场类型
    private Integer couponType;
    // 分类 ID
    private Integer categoryId;
    // 优惠券编码
    private String code;
    // 优惠券名称
    private String couponName;
    // 优惠券金额
    private Integer amount;
    // 商户承担额
    private Integer undertakeAmount;
    // 银行补贴金额
    private Integer bankSubsidy;
    // 数量
    private Integer count;
    // 有效期开始
    private Date validityStart;
    // 有效期结束
    private Date validityEnd;
    // 优惠券使用金额下限
    private BigDecimal minLimitAmount;
    // 每单使用最大次数
    private Integer maxUseCount;
    // 使用详情
    private String useDetail;
    // 使用须知
    private String useNotice;
    // 发布时间开始
    private Date publishDateStart;
    // 发布时间结束
    private Date publishDateEnd;
    // 发布方式：0、自动发布 1、用户自行领取
    private Integer publishType;
    // 发布人群：0、所有用户 1、白名单
    private Integer publishPopulation;
    // 优惠券图片
    private String pic;
    // 审核状态
    private Integer auditStatus;
    // 审核人
    private Integer auditUserId;
    // 创建时间
    private Date ctime;
    // 最后一次更新时间
    private Date mtime;
    // 创建人
    private Integer createUserId;

    /** 获取 promotion 属性 */
    public Integer getCouponId() {
            if(this.couponId==null){
                this.couponId=0;
            }
        return couponId;
    }

    /** 设置 promotion 属性 */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /** 获取 优惠券类型：0、全场类型 1、专场类型 属性 */
    public Integer getCouponType() {
            if(this.couponType==null){
                this.couponType=0;
            }
        return couponType;
    }

    /** 设置 优惠券类型：0、全场类型 1、专场类型 属性 */
    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    /** 获取 分类 ID 属性 */
    public Integer getCategoryId() {
            if(this.categoryId==null){
                this.categoryId=0;
            }
        return categoryId;
    }

    /** 设置 分类 ID 属性 */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /** 获取 优惠券编码 属性 */
    public String getCode() {
            if(this.code==null){
                this.code="";
            }
        return code;
    }

    /** 设置 优惠券编码 属性 */
    public void setCode(String code) {
        this.code = code;
    }

    /** 获取 优惠券名称 属性 */
    public String getCouponName() {
            if(this.couponName==null){
                this.couponName="";
            }
        return couponName;
    }

    /** 设置 优惠券名称 属性 */
    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    /** 获取 优惠券金额 属性 */
    public Integer getAmount() {
            if(this.amount==null){
                this.amount=0;
            }
        return amount;
    }

    /** 设置 优惠券金额 属性 */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /** 获取 商户承担额 属性 */
    public Integer getUndertakeAmount() {
            if(this.undertakeAmount==null){
                this.undertakeAmount=0;
            }
        return undertakeAmount;
    }

    /** 设置 商户承担额 属性 */
    public void setUndertakeAmount(Integer undertakeAmount) {
        this.undertakeAmount = undertakeAmount;
    }

    /** 获取 银行补贴金额 属性 */
    public Integer getBankSubsidy() {
            if(this.bankSubsidy==null){
                this.bankSubsidy=0;
            }
        return bankSubsidy;
    }

    /** 设置 银行补贴金额 属性 */
    public void setBankSubsidy(Integer bankSubsidy) {
        this.bankSubsidy = bankSubsidy;
    }

    /** 获取 数量 属性 */
    public Integer getCount() {
            if(this.count==null){
                this.count=0;
            }
        return count;
    }

    /** 设置 数量 属性 */
    public void setCount(Integer count) {
        this.count = count;
    }

    /** 获取 有效期开始 属性 */
    public Date getValidityStart() {
        return validityStart;
    }

    /** 设置 有效期开始 属性 */
    public void setValidityStart(Date validityStart) {
        this.validityStart = validityStart;
    }

    /** 获取 有效期结束 属性 */
    public Date getValidityEnd() {
        return validityEnd;
    }

    /** 设置 有效期结束 属性 */
    public void setValidityEnd(Date validityEnd) {
        this.validityEnd = validityEnd;
    }

    /** 获取 优惠券使用金额下限 属性 */
    public BigDecimal getMinLimitAmount() {
        return minLimitAmount;
    }

    /** 设置 优惠券使用金额下限 属性 */
    public void setMinLimitAmount(BigDecimal minLimitAmount) {
        this.minLimitAmount = minLimitAmount;
    }

    /** 获取 每单使用最大次数 属性 */
    public Integer getMaxUseCount() {
            if(this.maxUseCount==null){
                this.maxUseCount=0;
            }
        return maxUseCount;
    }

    /** 设置 每单使用最大次数 属性 */
    public void setMaxUseCount(Integer maxUseCount) {
        this.maxUseCount = maxUseCount;
    }

    /** 获取 使用详情 属性 */
    public String getUseDetail() {
            if(this.useDetail==null){
                this.useDetail="";
            }
        return useDetail;
    }

    /** 设置 使用详情 属性 */
    public void setUseDetail(String useDetail) {
        this.useDetail = useDetail;
    }

    /** 获取 使用须知 属性 */
    public String getUseNotice() {
            if(this.useNotice==null){
                this.useNotice="";
            }
        return useNotice;
    }

    /** 设置 使用须知 属性 */
    public void setUseNotice(String useNotice) {
        this.useNotice = useNotice;
    }

    /** 获取 发布时间开始 属性 */
    public Date getPublishDateStart() {
        return publishDateStart;
    }

    /** 设置 发布时间开始 属性 */
    public void setPublishDateStart(Date publishDateStart) {
        this.publishDateStart = publishDateStart;
    }

    /** 获取 发布时间结束 属性 */
    public Date getPublishDateEnd() {
        return publishDateEnd;
    }

    /** 设置 发布时间结束 属性 */
    public void setPublishDateEnd(Date publishDateEnd) {
        this.publishDateEnd = publishDateEnd;
    }

    /** 获取 发布方式：0、自动发布 1、用户自行领取 属性 */
    public Integer getPublishType() {
            if(this.publishType==null){
                this.publishType=0;
            }
        return publishType;
    }

    /** 设置 发布方式：0、自动发布 1、用户自行领取 属性 */
    public void setPublishType(Integer publishType) {
        this.publishType = publishType;
    }

    /** 获取 发布人群：0、所有用户 1、白名单 属性 */
    public Integer getPublishPopulation() {
            if(this.publishPopulation==null){
                this.publishPopulation=0;
            }
        return publishPopulation;
    }

    /** 设置 发布人群：0、所有用户 1、白名单 属性 */
    public void setPublishPopulation(Integer publishPopulation) {
        this.publishPopulation = publishPopulation;
    }

    /** 获取 优惠券图片 属性 */
    public String getPic() {
    	if(this.pic==null){
            this.pic="";
        }
		return pic;
	}

    /** 设置 优惠券图片 属性 */
    public void setPic(String pic) {
		this.pic = pic;
	}

    /** 获取 审核状态 属性 */
    public Integer getAuditStatus() {
            if(this.auditStatus==null){
                this.auditStatus=0;
            }
        return auditStatus;
    }


	/** 设置 审核状态 属性 */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /** 获取 审核人 属性 */
    public Integer getAuditUserId() {
            if(this.auditUserId==null){
                this.auditUserId=0;
            }
        return auditUserId;
    }

    /** 设置 审核人 属性 */
    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }

    /** 获取 创建时间 属性 */
    public Date getCtime() {
        return ctime;
    }

    /** 设置 创建时间 属性 */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /** 获取 最后一次更新时间 属性 */
    public Date getMtime() {
        return mtime;
    }

    /** 设置 最后一次更新时间 属性 */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /** 获取 创建人 属性 */
    public Integer getCreateUserId() {
            if(this.createUserId==null){
                this.createUserId=0;
            }
        return createUserId;
    }

    /** 设置 创建人 属性 */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CouponContent");
        sb.append("{couponId=").append(couponId);
        sb.append(", couponType=").append(couponType);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", code=").append(code);
        sb.append(", couponName=").append(couponName);
        sb.append(", amount=").append(amount);
        sb.append(", undertakeAmount=").append(undertakeAmount);
        sb.append(", bankSubsidy=").append(bankSubsidy);
        sb.append(", count=").append(count);
        sb.append(", validityStart=").append(validityStart);
        sb.append(", validityEnd=").append(validityEnd);
        sb.append(", minLimitAmount=").append(minLimitAmount);
        sb.append(", maxUseCount=").append(maxUseCount);
        sb.append(", useDetail=").append(useDetail);
        sb.append(", useNotice=").append(useNotice);
        sb.append(", publishDateStart=").append(publishDateStart);
        sb.append(", publishDateEnd=").append(publishDateEnd);
        sb.append(", publishType=").append(publishType);
        sb.append(", publishPopulation=").append(publishPopulation);
        sb.append(", pic=").append(pic);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", auditUserId=").append(auditUserId);
        sb.append(", ctime=").append(ctime);
        sb.append(", mtime=").append(mtime);
        sb.append(", createUserId=").append(createUserId);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CouponContent) {
            CouponContent couponContent = (CouponContent) obj;
            if (this.getCouponId().equals(couponContent.getCouponId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getCouponId();
        return pkStr.hashCode();
    }

}