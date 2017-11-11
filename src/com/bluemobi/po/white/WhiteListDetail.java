package com.bluemobi.po.white;


import com.appcore.model.AbstractObject;

/**
 * 【白名单明细表】持久化对象 数据库表：white_list_detail
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public class WhiteListDetail extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 白名单明细id
    private Integer id;
    // 白名单id
    private Integer whiteListId;
    // 用户唯一标识
    private String uuid;

    /** 获取 白名单明细id */
    public Integer getId() {
        return id;
    }

    /** 设置 白名单明细id */
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

    /** 获取 用户唯一标识 */
    public String getUuid() {
        return uuid;
    }

    /** 设置 用户唯一标识 */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WhiteListDetail");
        sb.append("{id=").append(id);
        sb.append(", whiteListId=").append(whiteListId);
        sb.append(", uuid=").append(uuid);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WhiteListDetail) {
            WhiteListDetail whiteListDetail = (WhiteListDetail) obj;
            if (this.getId().equals(whiteListDetail.getId())) {
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