package com.bluemobi.po.white;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【白名单关联表】持久化对象 数据库表：white_list_target
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class WhiteListTarget extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 白名单id
    private Integer whiteListId;
    // 目标类型:1、商品 2、活动
    private String type;
    // 目标id，白名单关联的商品或活动id
    private Integer targetId;
    // 创建人
    private Integer creator;
    // 创建时间
    private Date ctime;
    // 修改人
    private Integer modifier;
    // 修改时间
    private Date mtime;

    /** 获取 主键 */
    public Integer getId() {
        return id;
    }

    /** 设置 主键 */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 白名单id */
    public Integer getWhiteListId() {
        return whiteListId;
    }

    /** 设置 白名单id */
    public void setWhiteListId(Integer whiteListId) {
        this.whiteListId = whiteListId;
    }

    /** 获取 目标类型:1、商品 2、活动 */
    public String getType() {
        return type;
    }

    /** 设置 目标类型:1、商品 2、活动 */
    public void setType(String type) {
        this.type = type;
    }

    /** 获取 目标id，白名单关联的商品或活动id */
    public Integer getTargetId() {
        return targetId;
    }

    /** 设置 目标id，白名单关联的商品或活动id */
    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
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
        sb.append("WhiteListTarget");
        sb.append("{id=").append(id);
        sb.append(", whiteListId=").append(whiteListId);
        sb.append(", type=").append(type);
        sb.append(", targetId=").append(targetId);
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
        if (obj instanceof WhiteListTarget) {
            WhiteListTarget whiteListTarget = (WhiteListTarget) obj;
            if (this.getId().equals(whiteListTarget.getId())) {
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