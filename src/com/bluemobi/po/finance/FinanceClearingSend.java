package com.bluemobi.po.finance;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【二清发送收银台记录表】持久化对象 数据库表：finance_clearing_send
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class FinanceClearingSend extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 批次号
    private String batchNo;
    // 商户名（打给会计的自定义名）
    private String buinessName;
    // 商户号（打给会计的自定义号）
    private Integer buinessNo;
    // 发送报文
    private String message;
    // 发送结果（成功失败  1：成功  0：失败）
    private Integer result;
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

    /** 获取 发送报文 */
    public String getMessage() {
        return message;
    }

    /** 设置 发送报文 */
    public void setMessage(String message) {
        this.message = message;
    }

    /** 获取 发送结果（成功失败  1：成功  0：失败） */
    public Integer getResult() {
        return result;
    }

    /** 设置 发送结果（成功失败  1：成功  0：失败） */
    public void setResult(Integer result) {
        this.result = result;
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
        sb.append("FinanceClearingSend");
        sb.append("{id=").append(id);
        sb.append(", batchNo=").append(batchNo);
        sb.append(", buinessName=").append(buinessName);
        sb.append(", buinessNo=").append(buinessNo);
        sb.append(", message=").append(message);
        sb.append(", result=").append(result);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FinanceClearingSend) {
            FinanceClearingSend financeClearingSend = (FinanceClearingSend) obj;
            if (this.getId().equals(financeClearingSend.getId())) {
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