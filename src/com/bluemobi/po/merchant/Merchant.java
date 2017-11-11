package com.bluemobi.po.merchant;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【商户表】持久化对象 数据库表：merchant
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class Merchant extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 商户id
    private Integer merchantId;
    // 商户编号
    private String merchantNo;
    // 商户简称
    private String name;
    // 商户全称
    private String fullName;
    // 法人代表
    private String legalPerson;
    // 公司注册资金
    private Integer registeredCapital;
    // 证件类型：1、身份证 2、驾驶证 3、护照
    private Integer cardType;
    // 证件号码
    private String cardNo;
    // 公司类型：1、私营 2、国企 3、合资 4、外企
    private Integer companyType;
    // 营业执照号码
    private String businessLicenseNo;
    // 营业执照开始时间
    private Date businessLicenseBeginTime;
    // 营业执照结束时间
    private Date businessLicenseEndTime;
    // 组织机构代码
    private String organizationCode;
    // 组织机构开始时间
    private Date organizationBeginTime;
    // 组织机构结束时间
    private Date organizationEndTime;
    // 省份代码
    private Integer province;
    // 城市代码
    private Integer city;
    // 区县代码
    private Integer county;
    // 办公详细地址
    private String address;
    // 联系人姓名
    private String linkmanName;
    // 联系人电话
    private String linkmanPhone;
    // 联系人邮箱
    private String linkmanEmail;
    // 合同开始时间
    private Date contractBeginTime;
    // 合同结束时间
    private Date contractEndTime;
    // 清算账户户名
    private String bankAccountName;
    // 清算账号
    private String bankAccount;
    // 开户行名称
    private String bankName;
    // 开户行编号
    private String bankNo;
    // 开户行所在城市编码
    private Integer bankCity;
    // 账户类型：1、储蓄卡 2、信用卡 3、企业账户
    private Integer bankAccountType;
    // 财务联系人姓名
    private String financeLinkmanName;
    // 财务联系人电话
    private String financeLinkmanPhone;
    // 财务联系人邮箱
    private String financeLinkmanEmail;
    // 附件
    private String extraFile;
    // 合同
    private String contractFile;
    // 简介
    private String description;
    // 审核状态：0、未审核 1、审核通过 2、审核不通过
    private Integer verifyStatus;
    // 是否终止：0、未终止 1、终止
    private Integer isStop;
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

    /** 获取 商户id */
    public Integer getMerchantId() {
        return merchantId;
    }

    /** 设置 商户id */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /** 获取 商户编号 */
    public String getMerchantNo() {
        return merchantNo;
    }

    /** 设置 商户编号 */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    /** 获取 商户简称 */
    public String getName() {
        return name;
    }

    /** 设置 商户简称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 商户全称 */
    public String getFullName() {
        return fullName;
    }

    /** 设置 商户全称 */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /** 获取 法人代表 */
    public String getLegalPerson() {
        return legalPerson;
    }

    /** 设置 法人代表 */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /** 获取 公司注册资金 */
    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    /** 设置 公司注册资金 */
    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    /** 获取 证件类型：1、身份证 2、驾驶证 3、护照 */
    public Integer getCardType() {
        return cardType;
    }

    /** 设置 证件类型：1、身份证 2、驾驶证 3、护照 */
    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    /** 获取 证件号码 */
    public String getCardNo() {
        return cardNo;
    }

    /** 设置 证件号码 */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /** 获取 公司类型：1、私营 2、国企 3、合资 4、外企 */
    public Integer getCompanyType() {
        return companyType;
    }

    /** 设置 公司类型：1、私营 2、国企 3、合资 4、外企 */
    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    /** 获取 营业执照号码 */
    public String getBusinessLicenseNo() {
        return businessLicenseNo;
    }

    /** 设置 营业执照号码 */
    public void setBusinessLicenseNo(String businessLicenseNo) {
        this.businessLicenseNo = businessLicenseNo;
    }

    /** 获取 营业执照开始时间 */
    public Date getBusinessLicenseBeginTime() {
        return businessLicenseBeginTime;
    }

    /** 设置 营业执照开始时间 */
    public void setBusinessLicenseBeginTime(Date businessLicenseBeginTime) {
        this.businessLicenseBeginTime = businessLicenseBeginTime;
    }

    /** 获取 营业执照结束时间 */
    public Date getBusinessLicenseEndTime() {
        return businessLicenseEndTime;
    }

    /** 设置 营业执照结束时间 */
    public void setBusinessLicenseEndTime(Date businessLicenseEndTime) {
        this.businessLicenseEndTime = businessLicenseEndTime;
    }

    /** 获取 组织机构代码 */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /** 设置 组织机构代码 */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    /** 获取 组织机构开始时间 */
    public Date getOrganizationBeginTime() {
        return organizationBeginTime;
    }

    /** 设置 组织机构开始时间 */
    public void setOrganizationBeginTime(Date organizationBeginTime) {
        this.organizationBeginTime = organizationBeginTime;
    }

    /** 获取 组织机构结束时间 */
    public Date getOrganizationEndTime() {
        return organizationEndTime;
    }

    /** 设置 组织机构结束时间 */
    public void setOrganizationEndTime(Date organizationEndTime) {
        this.organizationEndTime = organizationEndTime;
    }

    /** 获取 省份代码 */
    public Integer getProvince() {
        return province;
    }

    /** 设置 省份代码 */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /** 获取 城市代码 */
    public Integer getCity() {
        return city;
    }

    /** 设置 城市代码 */
    public void setCity(Integer city) {
        this.city = city;
    }

    /** 获取 区县代码 */
    public Integer getCounty() {
        return county;
    }

    /** 设置 区县代码 */
    public void setCounty(Integer county) {
        this.county = county;
    }

    /** 获取 办公详细地址 */
    public String getAddress() {
        return address;
    }

    /** 设置 办公详细地址 */
    public void setAddress(String address) {
        this.address = address;
    }

    /** 获取 联系人姓名 */
    public String getLinkmanName() {
        return linkmanName;
    }

    /** 设置 联系人姓名 */
    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    /** 获取 联系人电话 */
    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    /** 设置 联系人电话 */
    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    /** 获取 联系人邮箱 */
    public String getLinkmanEmail() {
        return linkmanEmail;
    }

    /** 设置 联系人邮箱 */
    public void setLinkmanEmail(String linkmanEmail) {
        this.linkmanEmail = linkmanEmail;
    }

    /** 获取 合同开始时间 */
    public Date getContractBeginTime() {
        return contractBeginTime;
    }

    /** 设置 合同开始时间 */
    public void setContractBeginTime(Date contractBeginTime) {
        this.contractBeginTime = contractBeginTime;
    }

    /** 获取 合同结束时间 */
    public Date getContractEndTime() {
        return contractEndTime;
    }

    /** 设置 合同结束时间 */
    public void setContractEndTime(Date contractEndTime) {
        this.contractEndTime = contractEndTime;
    }

    /** 获取 清算账户户名 */
    public String getBankAccountName() {
        return bankAccountName;
    }

    /** 设置 清算账户户名 */
    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    /** 获取 清算账号 */
    public String getBankAccount() {
        return bankAccount;
    }

    /** 设置 清算账号 */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    /** 获取 开户行名称 */
    public String getBankName() {
        return bankName;
    }

    /** 设置 开户行名称 */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /** 获取 开户行编号 */
    public String getBankNo() {
        return bankNo;
    }

    /** 设置 开户行编号 */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    /** 获取 开户行所在城市编码 */
    public Integer getBankCity() {
        return bankCity;
    }

    /** 设置 开户行所在城市编码 */
    public void setBankCity(Integer bankCity) {
        this.bankCity = bankCity;
    }

    /** 获取 账户类型：1、储蓄卡 2、信用卡 3、企业账户 */
    public Integer getBankAccountType() {
        return bankAccountType;
    }

    /** 设置 账户类型：1、储蓄卡 2、信用卡 3、企业账户 */
    public void setBankAccountType(Integer bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    /** 获取 财务联系人姓名 */
    public String getFinanceLinkmanName() {
        return financeLinkmanName;
    }

    /** 设置 财务联系人姓名 */
    public void setFinanceLinkmanName(String financeLinkmanName) {
        this.financeLinkmanName = financeLinkmanName;
    }

    /** 获取 财务联系人电话 */
    public String getFinanceLinkmanPhone() {
        return financeLinkmanPhone;
    }

    /** 设置 财务联系人电话 */
    public void setFinanceLinkmanPhone(String financeLinkmanPhone) {
        this.financeLinkmanPhone = financeLinkmanPhone;
    }

    /** 获取 财务联系人邮箱 */
    public String getFinanceLinkmanEmail() {
        return financeLinkmanEmail;
    }

    /** 设置 财务联系人邮箱 */
    public void setFinanceLinkmanEmail(String financeLinkmanEmail) {
        this.financeLinkmanEmail = financeLinkmanEmail;
    }

    /** 获取 附件 */
    public String getExtraFile() {
        return extraFile;
    }

    /** 设置 附件 */
    public void setExtraFile(String extraFile) {
        this.extraFile = extraFile;
    }

    /** 获取 合同 */
    public String getContractFile() {
        return contractFile;
    }

    /** 设置 合同 */
    public void setContractFile(String contractFile) {
        this.contractFile = contractFile;
    }

    /** 获取 简介 */
    public String getDescription() {
        return description;
    }

    /** 设置 简介 */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 获取 审核状态：0、未审核 1、审核通过 2、审核不通过 */
    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    /** 设置 审核状态：0、未审核 1、审核通过 2、审核不通过 */
    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    /** 获取 是否终止：0、未终止 1、终止 */
    public Integer getIsStop() {
        return isStop;
    }

    /** 设置 是否终止：0、未终止 1、终止 */
    public void setIsStop(Integer isStop) {
        this.isStop = isStop;
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
        sb.append("Merchant");
        sb.append("{merchantId=").append(merchantId);
        sb.append(", merchantNo=").append(merchantNo);
        sb.append(", name=").append(name);
        sb.append(", fullName=").append(fullName);
        sb.append(", legalPerson=").append(legalPerson);
        sb.append(", registeredCapital=").append(registeredCapital);
        sb.append(", cardType=").append(cardType);
        sb.append(", cardNo=").append(cardNo);
        sb.append(", companyType=").append(companyType);
        sb.append(", businessLicenseNo=").append(businessLicenseNo);
        sb.append(", businessLicenseBeginTime=").append(businessLicenseBeginTime);
        sb.append(", businessLicenseEndTime=").append(businessLicenseEndTime);
        sb.append(", organizationCode=").append(organizationCode);
        sb.append(", organizationBeginTime=").append(organizationBeginTime);
        sb.append(", organizationEndTime=").append(organizationEndTime);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", address=").append(address);
        sb.append(", linkmanName=").append(linkmanName);
        sb.append(", linkmanPhone=").append(linkmanPhone);
        sb.append(", linkmanEmail=").append(linkmanEmail);
        sb.append(", contractBeginTime=").append(contractBeginTime);
        sb.append(", contractEndTime=").append(contractEndTime);
        sb.append(", bankAccountName=").append(bankAccountName);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankNo=").append(bankNo);
        sb.append(", bankCity=").append(bankCity);
        sb.append(", bankAccountType=").append(bankAccountType);
        sb.append(", financeLinkmanName=").append(financeLinkmanName);
        sb.append(", financeLinkmanPhone=").append(financeLinkmanPhone);
        sb.append(", financeLinkmanEmail=").append(financeLinkmanEmail);
        sb.append(", extraFile=").append(extraFile);
        sb.append(", contractFile=").append(contractFile);
        sb.append(", description=").append(description);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", isStop=").append(isStop);
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
        if (obj instanceof Merchant) {
            Merchant merchant = (Merchant) obj;
            if (this.getMerchantId().equals(merchant.getMerchantId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String pkStr = "" + this.getMerchantId();
        return pkStr.hashCode();
    }

}