package com.bluemobi.po.goods;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【商品关联文件表，如sku图片、商品简介图片、视频、h5等。】持久化对象 数据库表：goods_file
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public class GoodsFile extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 商品图片id
    private Integer id;
    // 图片类型：1、商品主图 2、sku图片3、商品视频 4、h5
    private Integer type;
    // 目标id（商品id或skuid）
    private Integer targetId;
    // 图片地址
    private String pic;
    // 序号
    private Integer sortOrder;
    // 状态：0、不可用 1、可用
    private Integer status;
    // 是否删除：0、未删除 1、删除
    private Integer isDel;
    // 创建人
    private Integer creator;
    // 创建时间
    private Date ctime;
    // 修改人
    private Integer modifier;
    // 修改时间
    private Date mtime;

    /** 获取 商品图片id */
    public Integer getId() {
        return id;
    }

    /** 设置 商品图片id */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 图片类型：1、商品主图 2、sku图片3、商品视频 4、h5 */
    public Integer getType() {
        return type;
    }

    /** 设置 图片类型：1、商品主图 2、sku图片3、商品视频 4、h5 */
    public void setType(Integer type) {
        this.type = type;
    }

    /** 获取 目标id（商品id或skuid） */
    public Integer getTargetId() {
        return targetId;
    }

    /** 设置 目标id（商品id或skuid） */
    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    /** 获取 图片地址 */
    public String getPic() {
        return pic;
    }

    /** 设置 图片地址 */
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

    /** 获取 是否删除：0、未删除 1、删除 */
    public Integer getIsDel() {
        return isDel;
    }

    /** 设置 是否删除：0、未删除 1、删除 */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
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
        sb.append("GoodsFile");
        sb.append("{id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", targetId=").append(targetId);
        sb.append(", pic=").append(pic);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", status=").append(status);
        sb.append(", isDel=").append(isDel);
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
        if (obj instanceof GoodsFile) {
            GoodsFile goodsFile = (GoodsFile) obj;
            if (this.getId().equals(goodsFile.getId())) {
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