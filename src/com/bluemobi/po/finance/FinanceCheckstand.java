package com.bluemobi.po.finance;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【收银台文件数据】持久化对象 数据库表：finance_checkstand
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class FinanceCheckstand extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 批次号
    private String batchNo;
    // APPID
    private String appid;
    // 渠道号
    private String channelNo;
    // 兴知付流水号
    private String sno;
    // 商户流水号
    private String mrchSno;
    // 账单类型：1-出账入账合一；2-入账；3-出账；4-存疑
    private Integer receiptType;
    // 存疑类型：1-渠道方成功；2-渠道方失败；3-渠道方少；4-金额不匹配
    private Integer impeachType;
    // 积分
    private Integer integral;
    // 币种
    private String cur;
    // 交易金额（单位：分）
    private Long transAmt;
    // 支付时间
    private Date payTime;
    // 账务日期
    private Date receiptTime;
    // 创建日期
    private Date createTime;
    //文件名
    private String fileName;
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

    /** 获取 APPID */
    public String getAppid() {
        return appid;
    }

    /** 设置 APPID */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /** 获取 渠道号 */
    public String getChannelNo() {
        return channelNo;
    }

    /** 设置 渠道号 */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    /** 获取 兴知付流水号 */
    public String getSno() {
        return sno;
    }

    /** 设置 兴知付流水号 */
    public void setSno(String sno) {
        this.sno = sno;
    }

    /** 获取 商户流水号 */
    public String getMrchSno() {
        return mrchSno;
    }

    /** 设置 商户流水号 */
    public void setMrchSno(String mrchSno) {
        this.mrchSno = mrchSno;
    }

    /** 获取 账单类型：1-出账入账合一；2-入账；3-出账；4-存疑 */
    public Integer getReceiptType() {
        return receiptType;
    }

    /** 设置 账单类型：1-出账入账合一；2-入账；3-出账；4-存疑 */
    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    /** 获取 存疑类型：1-渠道方成功；2-渠道方失败；3-渠道方少；4-金额不匹配 */
    public Integer getImpeachType() {
        return impeachType;
    }

    /** 设置 存疑类型：1-渠道方成功；2-渠道方失败；3-渠道方少；4-金额不匹配 */
    public void setImpeachType(Integer impeachType) {
        this.impeachType = impeachType;
    }

    /** 获取 积分 */
    public Integer getIntegral() {
        return integral;
    }

    /** 设置 积分 */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /** 获取 币种 */
    public String getCur() {
        return cur;
    }

    /** 设置 币种 */
    public void setCur(String cur) {
        this.cur = cur;
    }

    /** 获取 交易金额（单位：分） */
    public Long getTransAmt() {
        return transAmt;
    }

    /** 设置 交易金额（单位：分） */
    public void setTransAmt(Long transAmt) {
        this.transAmt = transAmt;
    }

    /** 获取 支付时间 */
    public Date getPayTime() {
        return payTime;
    }

    /** 设置 支付时间 */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /** 获取 账务日期 */
    public Date getReceiptTime() {
        return receiptTime;
    }

    /** 设置 账务日期 */
    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    /** 获取 创建日期 */
    public Date getCreateTime() {
        return createTime;
    }

    /** 设置 创建日期 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FinanceCheckstand");
        sb.append("{id=").append(id);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", appid=").append(appid);
        sb.append(", channelNo=").append(channelNo);
        sb.append(", sno=").append(sno);
        sb.append(", mrchSno=").append(mrchSno);
        sb.append(", receiptType=").append(receiptType);
        sb.append(", impeachType=").append(impeachType);
        sb.append(", integral=").append(integral);
        sb.append(", cur=").append(cur);
        sb.append(", transAmt=").append(transAmt);
        sb.append(", payTime=").append(payTime);
        sb.append(", receiptTime=").append(receiptTime);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FinanceCheckstand) {
            FinanceCheckstand financeCheckstand = (FinanceCheckstand) obj;
            if (this.getId().equals(financeCheckstand.getId())) {
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