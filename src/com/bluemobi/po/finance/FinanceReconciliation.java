package com.bluemobi.po.finance;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【对账表】持久化对象 数据库表：finance_reconciliation
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class FinanceReconciliation extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 批次号
    private String batchNo;
    // 交易流水号
    private String sno;
    // 支付方式
    private Integer payType;
    // 订单号
    private String orderNo;
    // 币种
    private String cur;
    // 我方交易金额（单位：分）
    private Long mtransAmt;
    // 收银台方交易金额（单位：分）
    private Long transAmt;
    // 我方交易积分
    private Integer mintegral;
    // 收银台方交易积分
    private Integer tintegral;
    // 交易类型（购买，退款） 1：购买  0：退款
    private Integer businessDea;
    // 状态：1:平 2： 长款 3:短款  4：金融不一致  5:积分不一致 6：积分金额都不一致
    private Integer status;
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date updateTime;
    // 账务日期
    private Date receiptTime;
    // 订单类型： 1、普通  2、折扣 3、团购 4、秒杀 5、抽奖
    private Integer type;
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

    /** 获取 交易流水号 */
    public String getSno() {
        return sno;
    }

    /** 设置 交易流水号 */
    public void setSno(String sno) {
        this.sno = sno;
    }

    /** 获取 支付方式 */
    public Integer getPayType() {
        return payType;
    }

    /** 设置 支付方式 */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    
    /** 获取 订单号 */
    public String getOrderNo() {
        return orderNo;
    }

    /** 设置 订单号 */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /** 获取 币种 */
    public String getCur() {
        return cur;
    }

    /** 设置 币种 */
    public void setCur(String cur) {
        this.cur = cur;
    }

    /** 获取 我方交易金额（单位：分） */
    public Long getMtransAmt() {
        return mtransAmt;
    }

    /** 设置 我方交易金额（单位：分） */
    public void setMtransAmt(Long mtransAmt) {
        this.mtransAmt = mtransAmt;
    }

    /** 获取 收银台方交易金额（单位：分） */
    public Long getTransAmt() {
        return transAmt;
    }

    /** 设置 收银台方交易金额（单位：分） */
    public void setTransAmt(Long transAmt) {
        this.transAmt = transAmt;
    }

    /** 获取 我方交易积分 */
    public Integer getMintegral() {
        return mintegral;
    }

    /** 设置 我方交易积分 */
    public void setMintegral(Integer mintegral) {
        this.mintegral = mintegral;
    }

    /** 获取 收银台方交易积分 */
    public Integer getTintegral() {
        return tintegral;
    }

    /** 设置 收银台方交易积分 */
    public void setTintegral(Integer tintegral) {
        this.tintegral = tintegral;
    }

    /** 获取 交易类型（购买，退款） 1：购买  0：退款 */
    public Integer getBusinessDea() {
        return businessDea;
    }

    /** 设置 交易类型（购买，退款） 1：购买  0：退款 */
    public void setBusinessDea(Integer businessDea) {
        this.businessDea = businessDea;
    }

    /** 获取 状态：1:平 2： 长款 3:短款  4：金融不一致  5:积分不一致 6：积分金额都不一致 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 状态：1:平 2： 长款 3:短款  4：金融不一致  5:积分不一致 6：积分金额都不一致 */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 获取 创建时间 */
    public Date getCreateTime() {
        return createTime;
    }

    /** 设置 创建时间 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 获取 修改时间 */
    public Date getUpdateTime() {
        return updateTime;
    }

    /** 设置 修改时间 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FinanceReconciliation");
        sb.append("{id=").append(id);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", sno=").append(sno);
        sb.append(", payType=").append(payType);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", cur=").append(cur);
        sb.append(", mtransAmt=").append(mtransAmt);
        sb.append(", transAmt=").append(transAmt);
        sb.append(", mintegral=").append(mintegral);
        sb.append(", tintegral=").append(tintegral);
        sb.append(", businessDea=").append(businessDea);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FinanceReconciliation) {
            FinanceReconciliation financeReconciliation = (FinanceReconciliation) obj;
            if (this.getId().equals(financeReconciliation.getId())) {
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