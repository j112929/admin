package com.bluemobi.po.goods;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【商品品牌表】持久化对象 数据库表：goods_brand
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public class GoodsBrand extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 品牌id
    private Integer id;
    // 品牌名称
    private String name;
    // 品牌英文名称
    private String enName;
    // 品牌描述
    private String description;
    // 图片
    private String pic;
    // 序号
    private Integer sortOrder;
    // 状态：0、不可用 1、可用
    private Integer status;
    // 创建人
    private Integer creator;
    // 创建时间
    private Date ctime;
    // 修改人
    private Integer modifier;
    // 修改时间
    private Date mtime;

    /** 获取 品牌id */
    public Integer getId() {
        return id;
    }

    /** 设置 品牌id */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 品牌名称 */
    public String getName() {
        return name;
    }

    /** 设置 品牌名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 品牌英文名称 */
    public String getEnName() {
        return enName;
    }

    /** 设置 品牌英文名称 */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /** 获取 品牌描述 */
    public String getDescription() {
        return description;
    }

    /** 设置 品牌描述 */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 获取 图片 */
    public String getPic() {
        return pic;
    }

    /** 设置 图片 */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /** 获取 序号 */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /** 设置 序号 */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /** 获取 状态：0、不可用 1、可用 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 状态：0、不可用 1、可用 */
    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append("GoodsBrand");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", enName=").append(enName);
        sb.append(", description=").append(description);
        sb.append(", pic=").append(pic);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", status=").append(status);
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
        if (obj instanceof GoodsBrand) {
            GoodsBrand goodsBrand = (GoodsBrand) obj;
            if (this.getId().equals(goodsBrand.getId())) {
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