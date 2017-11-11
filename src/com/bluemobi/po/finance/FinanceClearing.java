package com.bluemobi.po.finance;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【二清清算总表】持久化对象 数据库表：finance_clearing
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class FinanceClearing extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 批次号
    private String batchNo;
    // 支付方式
    private Integer payType;
    // 交易流水号
    private String sno;
    // 订单号
    private String orderNo;
    // 商户名（打给会计的自定义名）
    private String buinessName;
    // 商户号（打给会计的自定义号）
    private Integer buinessNo;
    // 交易类型（购买，退款)  1：购买 0：退款
    private Integer businessDeal;
    // 币种
    private String cur;
    // 清算金额(单位：分）
    private Long transAmt;
    // 积分
    private Integer integral;
    // 来源渠道（活动，抽奖等积分手动清算)
    private String channel;
    // 手工清算，自动清算（0：手工清算  1：自动清算）
    private Integer flag;
    // 银行卡号
    private Integer paybkNo;
    // 开户行
    private String paybkCode;
    // 账务日期
    private Date receiptTime;
    // 创建时间
    private Date createTime;

    /** 获取 主键 */
    public Integer getId() {
        return id;
    }

    /** 设置 主键 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 批次号 */
    public String getBatchNo() {
        return batchNo;
    }

    /** 设置 批次号 */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    /** 获取 支付方式 */
    public Integer getPayType() {
        return payType;
    }

    /** 设置 支付方式 */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /** 获取 交易流水号 */
    public String getSno() {
        return sno;
    }

    /** 设置 交易流水号 */
    public void setSno(String sno) {
        this.sno = sno;
    }

    /** 获取 订单号 */
    public String getOrderNo() {
        return orderNo;
    }

    /** 设置 订单号 */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /** 获取 商户名（打给会计的自定义名） */
    public String getBuinessName() {
        return buinessName;
    }

    /** 设置 商户名（打给会计的自定义名） */
    public void setBuinessName(String buinessName) {
        this.buinessName = buinessName;
    }

    /** 获取 商户号（打给会计的自定义号） */
    public Integer getBuinessNo() {
        return buinessNo;
    }

    /** 设置 商户号（打给会计的自定义号） */
    public void setBuinessNo(Integer buinessNo) {
        this.buinessNo = buinessNo;
    }

    /** 获取 交易类型（购买，退款)  1：购买 0：退款 */
    public Integer getBusinessDeal() {
        return businessDeal;
    }

    /** 设置 交易类型（购买，退款)  1：购买 0：退款 */
    public void setBusinessDeal(Integer businessDeal) {
        this.businessDeal = businessDeal;
    }

    /** 获取 币种 */
    public String getCur() {
        return cur;
    }

    /** 设置 币种 */
    public void setCur(String cur) {
        this.cur = cur;
    }

    /** 获取 清算金额(单位：分） */
    public Long getTransAmt() {
        return transAmt;
    }

    /** 设置 清算金额(单位：分） */
    public void setTransAmt(Long transAmt) {
        this.transAmt = transAmt;
    }

    /** 获取 积分 */
    public Integer getIntegral() {
        return integral;
    }

    /** 设置 积分 */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /** 获取 来源渠道（活动，抽奖等积分手动清算) */
    public String getChannel() {
        return channel;
    }

    /** 设置 来源渠道（活动，抽奖等积分手动清算) */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /** 获取 手工清算，自动清算（0：手工清算  1：自动清算） */
    public Integer getFlag() {
        return flag;
    }

    /** 设置 手工清算，自动清算（0：手工清算  1：自动清算） */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /** 获取 银行卡号 */
    public Integer getPaybkNo() {
        return paybkNo;
    }

    /** 设置 银行卡号 */
    public void setPaybkNo(Integer paybkNo) {
        this.paybkNo = paybkNo;
    }

    /** 获取 开户行 */
    public String getPaybkCode() {
        return paybkCode;
    }

    /** 设置 开户行 */
    public void setPaybkCode(String paybkCode) {
        this.paybkCode = paybkCode;
    }

    /** 获取 账务日期 */
    public Date getReceiptTime() {
        return receiptTime;
    }

    /** 设置 账务日期 */
    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    /** 获取 创建时间 */
    public Date getCreateTime() {
        return createTime;
    }

    /** 设置 创建时间 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FinanceClearing");
        sb.append("{id=").append(id);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", payType=").append(payType);
        sb.append(", sno=").append(sno);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", buinessName=").append(buinessName);
        sb.append(", buinessNo=").append(buinessNo);
        sb.append(", businessDeal=").append(businessDeal);
        sb.append(", cur=").append(cur);
        sb.append(", transAmt=").append(transAmt);
        sb.append(", integral=").append(integral);
        sb.append(", channel=").append(channel);
        sb.append(", flag=").append(flag);
        sb.append(", paybkNo=").append(paybkNo);
        sb.append(", paybkCode=").append(paybkCode);
        sb.append(", receiptTime=").append(receiptTime);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FinanceClearing) {
            FinanceClearing financeClearing = (FinanceClearing) obj;
            if (this.getId().equals(financeClearing.getId())) {
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