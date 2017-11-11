package com.bluemobi.po.white;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【白名单主表】持久化对象 数据库表：white_list
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class WhiteList extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 白名单id（批次号）
    private Integer id;
    // 名称
    private String name;
    // 描述
    private String description;
    // 创建人
    private Integer creator;
    // 创建时间
    private Date ctime;
    // 修改人
    private Integer modifier;
    // 修改时间
    private Date mtime;

    /** 获取 白名单id（批次号） */
    public Integer getId() {
        return id;
    }

    /** 设置 白名单id（批次号） */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 名称 */
    public String getName() {
        return name;
    }

    /** 设置 名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 描述 */
    public String getDescription() {
        return description;
    }

    /** 设置 描述 */
    public void setDescription(String description) {
        this.description = description;
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
        sb.append("WhiteList");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
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
        if (obj instanceof WhiteList) {
            WhiteList whiteList = (WhiteList) obj;
            if (this.getId().equals(whiteList.getId())) {
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