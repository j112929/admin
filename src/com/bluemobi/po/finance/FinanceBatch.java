package com.bluemobi.po.finance;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【批次总表】持久化对象 数据库表：finance_batch
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class FinanceBatch extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 批次号
    private String batchNo;
    // 账务日期
    private Date receiptTime;
    // 创建日期
    private Date createTime;
    // 渠道号
    private String channeNo;
    // 文件名1
    private String fileName1;
    // 文件名2
    private String fileName2;
    // 文件名3
    private String fileName3;
    // 文件名4
    private String fileName4;
    // 文件名5
    private String fileName5;
    // 文件名6
    private String fileName6;
    // 收银台支付金额
    private Double thirdbackAmount;
    // 获取对账文件是否成功 ： 1：是   0：否
    private Integer flag;
    // 状态：  1：权益  0：B2C
    private Integer status;
    // 成功笔数
    private Integer successTotal;
    // 失败笔数
    private Integer faileTotal;

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

    /** 获取 渠道号 */
    public String getChanneNo() {
        return channeNo;
    }

    /** 设置 渠道号 */
    public void setChanneNo(String channeNo) {
        this.channeNo = channeNo;
    }

    /** 获取 文件名1 */
    public String getFileName1() {
        return fileName1;
    }

    /** 设置 文件名1 */
    public void setFileName1(String fileName1) {
        this.fileName1 = fileName1;
    }

    /** 获取 文件名2 */
    public String getFileName2() {
        return fileName2;
    }

    /** 设置 文件名2 */
    public void setFileName2(String fileName2) {
        this.fileName2 = fileName2;
    }

    /** 获取 文件名3 */
    public String getFileName3() {
        return fileName3;
    }

    /** 设置 文件名3 */
    public void setFileName3(String fileName3) {
        this.fileName3 = fileName3;
    }

    /** 获取 文件名4 */
    public String getFileName4() {
        return fileName4;
    }

    /** 设置 文件名4 */
    public void setFileName4(String fileName4) {
        this.fileName4 = fileName4;
    }

    /** 获取 文件名5 */
    public String getFileName5() {
        return fileName5;
    }

    /** 设置 文件名5 */
    public void setFileName5(String fileName5) {
        this.fileName5 = fileName5;
    }

    /** 获取 文件名6 */
    public String getFileName6() {
        return fileName6;
    }

    /** 设置 文件名6 */
    public void setFileName6(String fileName6) {
        this.fileName6 = fileName6;
    }

    /** 获取 收银台支付金额 */
    public Double getThirdbackAmount() {
        return thirdbackAmount;
    }

    /** 设置 收银台支付金额 */
    public void setThirdbackAmount(Double thirdbackAmount) {
        this.thirdbackAmount = thirdbackAmount;
    }

    /** 获取 获取对账文件是否成功 ： 1：是   0：否 */
    public Integer getFlag() {
        return flag;
    }

    /** 设置 获取对账文件是否成功 ： 1：是   0：否 */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /** 获取 状态：  1：权益  0：B2C */
    public Integer getStatus() {
        return status;
    }

    /** 设置 状态：  1：权益  0：B2C */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 获取 成功笔数 */
    public Integer getSuccessTotal() {
        return successTotal;
    }

    /** 设置 成功笔数 */
    public void setSuccessTotal(Integer successTotal) {
        this.successTotal = successTotal;
    }

    /** 获取 失败笔数 */
    public Integer getFaileTotal() {
        return faileTotal;
    }

    /** 设置 失败笔数 */
    public void setFaileTotal(Integer faileTotal) {
        this.faileTotal = faileTotal;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FinanceBatch");
        sb.append("{id=").append(id);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", receiptTime=").append(receiptTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", channeNo=").append(channeNo);
        sb.append(", fileName1=").append(fileName1);
        sb.append(", fileName2=").append(fileName2);
        sb.append(", fileName3=").append(fileName3);
        sb.append(", fileName4=").append(fileName4);
        sb.append(", fileName5=").append(fileName5);
        sb.append(", fileName6=").append(fileName6);
        sb.append(", thirdbackAmount=").append(thirdbackAmount);
        sb.append(", flag=").append(flag);
        sb.append(", status=").append(status);
        sb.append(", successTotal=").append(successTotal);
        sb.append(", faileTotal=").append(faileTotal);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FinanceBatch) {
            FinanceBatch financeBatch = (FinanceBatch) obj;
            if (this.getId().equals(financeBatch.getId())) {
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