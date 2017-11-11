package com.bluemobi.po.log;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【审核日志表】持久化对象 数据库表：log_audit
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class LogAudit extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 审核类型:1、供应商入驻 2、商品上架 3、供应商可售商品类型 4、优惠券 5、秒杀 6、抽奖 7、团购
    private Integer type;
    // 审核目标id
    private Integer targetId;
    // 备注：由审核人员填写
    private String remark;
    // 描述：系统自动写入
    private String description;
    // 审核级别：1、一级审核 2、二级审核
    private Integer grade;
    // 审核状态：0、不通过 1、通过
    private Integer status;
    // 审核人
    private Integer auditer;
    // 审核时间
    private Date auditTime;

    /** 获取 主键 */
    public Integer getId() {
        return id;
    }

    /** 设置 主键 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 审核类型:1、供应商入驻 2、商品上架 3、供应商可售商品类型 4、优惠券 5、秒杀 6、抽奖 7、团购 */
    public Integer getType() {
        return type;
    }

    /** 设置 审核类型:1、供应商入驻 2、商品上架 3、供应商可售商品类型 4、优惠券 5、秒杀 6、抽奖 7、团购 */
    public void setType(Integer type) {
        this.type = type;
    }

    /** 获取 审核目标id */
    public Integer getTargetId() {
        return targetId;
    }

    /** 设置 审核目标id */
    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    /** 获取 备注：由审核人员填写 */
    public String getRemark() {
        return remark;
    }

    /** 设置 备注：由审核人员填写 */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 获取 描述：系统自动写入 */
    public String getDescription() {
        return description;
    }

    /** 设置 描述：系统自动写入 */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 获取 审核级别：1、一级审核 2、二级审核 */
    public Integer getGrade() {
        return grade;
    }

    /** 设置 审核级别：1、一级审核 2、二级审核 */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /** 获取 审核状态：0、不通过 1、通过 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 审核状态：0、不通过 1、通过 */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 获取 审核人 */
    public Integer getAuditer() {
        return auditer;
    }

    /** 设置 审核人 */
    public void setAuditer(Integer auditer) {
        this.auditer = auditer;
    }

    /** 获取 审核时间 */
    public Date getAuditTime() {
        return auditTime;
    }

    /** 设置 审核时间 */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LogAudit");
        sb.append("{id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", targetId=").append(targetId);
        sb.append(", remark=").append(remark);
        sb.append(", description=").append(description);
        sb.append(", grade=").append(grade);
        sb.append(", status=").append(status);
        sb.append(", auditer=").append(auditer);
        sb.append(", auditTime=").append(auditTime);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LogAudit) {
            LogAudit logAudit = (LogAudit) obj;
            if (this.getId().equals(logAudit.getId())) {
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