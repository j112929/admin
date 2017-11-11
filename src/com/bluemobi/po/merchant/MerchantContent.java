package com.bluemobi.po.merchant;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【】持久化对象 数据库表：merchant_content
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:07
 * 
 */
public class MerchantContent extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 供应商编号
    private Integer id;
    // 供应商名称
    private String name;
    // 供应商简称
    private String nameSp;
    // 备注
    private String smemo;
    // 法人代表姓名
    private String corporateName;
    // 注册资金
    private Integer registered;
    // 证件类型，0：身份证、1：护照
    private Integer cardType;
    // 证件号码
    private String cardNumber;
    // 公司类型，0：私营、1：国企、2：合资、3：外企
    private Integer type;
    // 营业执照
    private Integer licence;
    // 组织机构代码（加符号）
    private String organizationCard;
    // 营业执照开始时间
    private Date licenceBeginTime;
    // 营业执照结束时间
    private Date licenceEndTime;
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
    // 详细地址
    private String address;
    // 联系人邮箱
    private String email;
    // 联系人电话
    private Integer phone;
    // 合同开始时间
    private Date agreementBeginTime;
    // 合同结束时间
    private Date agreementEndTime;
    // 清算户名
    private String accountsName;
    // 清算账号
    private Integer accountsCard;
    // 开户行代码
    private Integer bank;
    // 行号
    private Integer bankCard;
    // 开户行所在地
    private String bankAddr;
    // 财务联系人
    private String financialPerson;
    // 财务邮箱
    private String financialEmail;
    // 财务联系电话
    private Integer financialPhone;
    // 创建时间
    private Date ctime;
    // 修改时间
    private Date mtime;
    // 操作人
    private Integer modifier;

    /** 获取 供应商编号 属性 */
    public Integer getId() {
            if(this.id==null){
                this.id=0;
            }
        return id;
    }

    /** 设置 供应商编号 属性 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 供应商名称 属性 */
    public String getName() {
            if(this.name==null){
                this.name="";
            }
        return name;
    }

    /** 设置 供应商名称 属性 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 供应商简称 属性 */
    public String getNameSp() {
            if(this.nameSp==null){
                this.nameSp="";
            }
        return nameSp;
    }

    /** 设置 供应商简称 属性 */
    public void setNameSp(String nameSp) {
        this.nameSp = nameSp;
    }

    /** 获取 备注 属性 */
    public String getSmemo() {
            if(this.smemo==null){
                this.smemo="";
            }
        return smemo;
    }

    /** 设置 备注 属性 */
    public void setSmemo(String smemo) {
        this.smemo = smemo;
    }

    /** 获取 法人代表姓名 属性 */
    public String getCorporateName() {
            if(this.corporateName==null){
                this.corporateName="";
            }
        return corporateName;
    }

    /** 设置 法人代表姓名 属性 */
    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    /** 获取 注册资金 属性 */
    public Integer getRegistered() {
            if(this.registered==null){
                this.registered=0;
            }
        return registered;
    }

    /** 设置 注册资金 属性 */
    public void setRegistered(Integer registered) {
        this.registered = registered;
    }

    /** 获取 证件类型，0：身份证、1：护照 属性 */
    public Integer getCardType() {
            if(this.cardType==null){
                this.cardType=0;
            }
        return cardType;
    }

    /** 设置 证件类型，0：身份证、1：护照 属性 */
    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    /** 获取 证件号码 属性 */
    public String getCardNumber() {
            if(this.cardNumber==null){
                this.cardNumber="";
            }
        return cardNumber;
    }

    /** 设置 证件号码 属性 */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /** 获取 公司类型，0：私营、1：国企、2：合资、3：外企 属性 */
    public Integer getType() {
            if(this.type==null){
                this.type=0;
            }
        return type;
    }

    /** 设置 公司类型，0：私营、1：国企、2：合资、3：外企 属性 */
    public void setType(Integer type) {
        this.type = type;
    }

    /** 获取 营业执照 属性 */
    public Integer getLicence() {
            if(this.licence==null){
                this.licence=0;
            }
        return licence;
    }

    /** 设置 营业执照 属性 */
    public void setLicence(Integer licence) {
        this.licence = licence;
    }

    /** 获取 组织机构代码（加符号） 属性 */
    public String getOrganizationCard() {
            if(this.organizationCard==null){
                this.organizationCard="";
            }
        return organizationCard;
    }

    /** 设置 组织机构代码（加符号） 属性 */
    public void setOrganizationCard(String organizationCard) {
        this.organizationCard = organizationCard;
    }

    /** 获取 营业执照开始时间 属性 */
    public Date getLicenceBeginTime() {
        return licenceBeginTime;
    }

    /** 设置 营业执照开始时间 属性 */
    public void setLicenceBeginTime(Date licenceBeginTime) {
        this.licenceBeginTime = licenceBeginTime;
    }

    /** 获取 营业执照结束时间 属性 */
    public Date getLicenceEndTime() {
        return licenceEndTime;
    }

    /** 设置 营业执照结束时间 属性 */
    public void setLicenceEndTime(Date licenceEndTime) {
        this.licenceEndTime = licenceEndTime;
    }

    /** 获取 组织机构开始时间 属性 */
    public Date getOrganizationBeginTime() {
        return organizationBeginTime;
    }

    /** 设置 组织机构开始时间 属性 */
    public void setOrganizationBeginTime(Date organizationBeginTime) {
        this.organizationBeginTime = organizationBeginTime;
    }

    /** 获取 组织机构结束时间 属性 */
    public Date getOrganizationEndTime() {
        return organizationEndTime;
    }

    /** 设置 组织机构结束时间 属性 */
    public void setOrganizationEndTime(Date organizationEndTime) {
        this.organizationEndTime = organizationEndTime;
    }

    /** 获取 省份代码 属性 */
    public Integer getProvince() {
            if(this.province==null){
                this.province=0;
            }
        return province;
    }

    /** 设置 省份代码 属性 */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /** 获取 城市代码 属性 */
    public Integer getCity() {
            if(this.city==null){
                this.city=0;
            }
        return city;
    }

    /** 设置 城市代码 属性 */
    public void setCity(Integer city) {
        this.city = city;
    }

    /** 获取 区县代码 属性 */
    public Integer getCounty() {
            if(this.county==null){
                this.county=0;
            }
        return county;
    }

    /** 设置 区县代码 属性 */
    public void setCounty(Integer county) {
        this.county = county;
    }

    /** 获取 详细地址 属性 */
    public String getAddress() {
            if(this.address==null){
                this.address="";
            }
        return address;
    }

    /** 设置 详细地址 属性 */
    public void setAddress(String address) {
        this.address = address;
    }

    /** 获取 联系人邮箱 属性 */
    public String getEmail() {
            if(this.email==null){
                this.email="";
            }
        return email;
    }

    /** 设置 联系人邮箱 属性 */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 获取 联系人电话 属性 */
    public Integer getPhone() {
            if(this.phone==null){
                this.phone=0;
            }
        return phone;
    }

    /** 设置 联系人电话 属性 */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /** 获取 合同开始时间 属性 */
    public Date getAgreementBeginTime() {
        return agreementBeginTime;
    }

    /** 设置 合同开始时间 属性 */
    public void setAgreementBeginTime(Date agreementBeginTime) {
        this.agreementBeginTime = agreementBeginTime;
    }

    /** 获取 合同结束时间 属性 */
    public Date getAgreementEndTime() {
        return agreementEndTime;
    }

    /** 设置 合同结束时间 属性 */
    public void setAgreementEndTime(Date agreementEndTime) {
        this.agreementEndTime = agreementEndTime;
    }

    /** 获取 清算户名 属性 */
    public String getAccountsName() {
            if(this.accountsName==null){
                this.accountsName="";
            }
        return accountsName;
    }

    /** 设置 清算户名 属性 */
    public void setAccountsName(String accountsName) {
        this.accountsName = accountsName;
    }

    /** 获取 清算账号 属性 */
    public Integer getAccountsCard() {
            if(this.accountsCard==null){
                this.accountsCard=0;
            }
        return accountsCard;
    }

    /** 设置 清算账号 属性 */
    public void setAccountsCard(Integer accountsCard) {
        this.accountsCard = accountsCard;
    }

    /** 获取 开户行代码 属性 */
    public Integer getBank() {
            if(this.bank==null){
                this.bank=0;
            }
        return bank;
    }

    /** 设置 开户行代码 属性 */
    public void setBank(Integer bank) {
        this.bank = bank;
    }

    /** 获取 行号 属性 */
    public Integer getBankCard() {
            if(this.bankCard==null){
                this.bankCard=0;
            }
        return bankCard;
    }

    /** 设置 行号 属性 */
    public void setBankCard(Integer bankCard) {
        this.bankCard = bankCard;
    }

    /** 获取 开户行所在地 属性 */
    public String getBankAddr() {
            if(this.bankAddr==null){
                this.bankAddr="";
            }
        return bankAddr;
    }

    /** 设置 开户行所在地 属性 */
    public void setBankAddr(String bankAddr) {
        this.bankAddr = bankAddr;
    }

    /** 获取 财务联系人 属性 */
    public String getFinancialPerson() {
            if(this.financialPerson==null){
                this.financialPerson="";
            }
        return financialPerson;
    }

    /** 设置 财务联系人 属性 */
    public void setFinancialPerson(String financialPerson) {
        this.financialPerson = financialPerson;
    }

    /** 获取 财务邮箱 属性 */
    public String getFinancialEmail() {
            if(this.financialEmail==null){
                this.financialEmail="";
            }
        return financialEmail;
    }

    /** 设置 财务邮箱 属性 */
    public void setFinancialEmail(String financialEmail) {
        this.financialEmail = financialEmail;
    }

    /** 获取 财务联系电话 属性 */
    public Integer getFinancialPhone() {
            if(this.financialPhone==null){
                this.financialPhone=0;
            }
        return financialPhone;
    }

    /** 设置 财务联系电话 属性 */
    public void setFinancialPhone(Integer financialPhone) {
        this.financialPhone = financialPhone;
    }

    /** 获取 创建时间 属性 */
    public Date getCtime() {
        return ctime;
    }

    /** 设置 创建时间 属性 */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /** 获取 修改时间 属性 */
    public Date getMtime() {
        return mtime;
    }

    /** 设置 修改时间 属性 */
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    /** 获取 操作人 属性 */
    public Integer getModifier() {
            if(this.modifier==null){
                this.modifier=0;
            }
        return modifier;
    }

    /** 设置 操作人 属性 */
    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MerchantContent");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", nameSp=").append(nameSp);
        sb.append(", smemo=").append(smemo);
        sb.append(", corporateName=").append(corporateName);
        sb.append(", registered=").append(registered);
        sb.append(", cardType=").append(cardType);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", type=").append(type);
        sb.append(", licence=").append(licence);
        sb.append(", organizationCard=").append(organizationCard);
        sb.append(", licenceBeginTime=").append(licenceBeginTime);
        sb.append(", licenceEndTime=").append(licenceEndTime);
        sb.append(", organizationBeginTime=").append(organizationBeginTime);
        sb.append(", organizationEndTime=").append(organizationEndTime);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", address=").append(address);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", agreementBeginTime=").append(agreementBeginTime);
        sb.append(", agreementEndTime=").append(agreementEndTime);
        sb.append(", accountsName=").append(accountsName);
        sb.append(", accountsCard=").append(accountsCard);
        sb.append(", bank=").append(bank);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", bankAddr=").append(bankAddr);
        sb.append(", financialPerson=").append(financialPerson);
        sb.append(", financialEmail=").append(financialEmail);
        sb.append(", financialPhone=").append(financialPhone);
        sb.append(", ctime=").append(ctime);
        sb.append(", mtime=").append(mtime);
        sb.append(", modifier=").append(modifier);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MerchantContent) {
            MerchantContent merchantContent = (MerchantContent) obj;
            if (this.getId().equals(merchantContent.getId())) {
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