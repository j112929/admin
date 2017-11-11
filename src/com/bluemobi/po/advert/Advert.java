package com.bluemobi.po.advert;

import java.util.Date;

import com.appcore.model.AbstractObject;

/**
 * 【广告表，存放广告位信息、banner信息等】持久化对象 数据库表：advert
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class Advert extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 广告id
    private Integer id;
    // 名称
    private String name;
    // 图片
    private String pic;
    // 位置：1、商城banner 2、积分专区banner 3、分期专区banner
    private Integer position;
    // 链接类型：1、H5页面  2、商品详情
    private Integer linkType;
    // 链接，存放链接地址或目标id
    private String link;
    // 序号
    private Integer sortOrder;
    // 描述
    private String description;
    // 开始时间
    private Date beginTime;
    // 结束时间
    private Date endTime;
    // 状态：0、不显示 1、显示
    private Integer status;
    // 创建人
    private Integer creator;
    // 创建时间
    private Date ctime;
    // 修改人
    private Integer modifier;
    // 修改时间
    private Date mtime;

    /** 获取 广告id */
    public Integer getId() {
        return id;
    }

    /** 设置 广告id */
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

    /** 获取 图片 */
    public String getPic() {
        return pic;
    }

    /** 设置 图片 */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /** 获取 位置：1、商城banner 2、积分专区banner 3、分期专区banner */
    public Integer getPosition() {
        return position;
    }

    /** 设置 位置：1、商城banner 2、积分专区banner 3、分期专区banner */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /** 获取 链接类型：1、H5页面  2、商品详情 */
    public Integer getLinkType() {
        return linkType;
    }

    /** 设置 链接类型：1、H5页面  2、商品详情 */
    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    /** 获取 链接，存放链接地址或目标id */
    public String getLink() {
        return link;
    }

    /** 设置 链接，存放链接地址或目标id */
    public void setLink(String link) {
        this.link = link;
    }

    /** 获取 序号 */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /** 设置 序号 */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /** 获取 描述 */
    public String getDescription() {
        return description;
    }

    /** 设置 描述 */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 获取 开始时间 */
    public Date getBeginTime() {
        return beginTime;
    }

    /** 设置 开始时间 */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /** 获取 结束时间 */
    public Date getEndTime() {
        return endTime;
    }

    /** 设置 结束时间 */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /** 获取 状态：0、不显示 1、显示 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 状态：0、不显示 1、显示 */
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
        sb.append("Advert");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pic=").append(pic);
        sb.append(", position=").append(position);
        sb.append(", linkType=").append(linkType);
        sb.append(", link=").append(link);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", description=").append(description);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
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
        if (obj instanceof Advert) {
            Advert advert = (Advert) obj;
            if (this.getId().equals(advert.getId())) {
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