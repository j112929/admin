package com.bluemobi.po.goods;


import java.util.List;

import com.appcore.model.AbstractObject;

/**
 * 【商品属性基础数据表】持久化对象 数据库表：goods_property
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public class GoodsProperty extends AbstractObject {

    public static final long serialVersionUID = 1L;

    // 属性id
    private Integer id;
    // 属性名称
    private String name;
    // 备注
    private String description;
    // 序号
    private Integer sortOrder;
    // 是否是sku属性
    private Integer isSku;
    // 是否是图片属性
    private Integer isPic;
    
    private List<GoodsPropertyValue> list;

    /** 获取 属性id */
    public Integer getId() {
        return id;
    }

    /** 设置 属性id */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 获取 属性名称 */
    public String getName() {
        return name;
    }

    /** 设置 属性名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取 备注 */
    public String getDescription() {
        return description;
    }

    /** 设置 备注 */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 获取 序号 */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /** 设置 序号 */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /** 获取 是否是sku属性 */
    public Integer getIsSku() {
        return isSku;
    }

    /** 设置 是否是sku属性 */
    public void setIsSku(Integer isSku) {
        this.isSku = isSku;
    }

    /** 获取 是否是图片属性 */
    public Integer getIsPic() {
        return isPic;
    }

    /** 设置 是否是图片属性 */
    public void setIsPic(Integer isPic) {
        this.isPic = isPic;
    }
    
    /**   
	 * list   
	 *   
	 * @return  the list    
	 */
	public List<GoodsPropertyValue> getList() {
		return list;
	}

	/**   
	 * @param list the list to set   
	 */
	public void setList(List<GoodsPropertyValue> list) {
		this.list = list;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GoodsProperty");
        sb.append("{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", isSku=").append(isSku);
        sb.append(", isPic=").append(isPic);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GoodsProperty) {
            GoodsProperty goodsProperty = (GoodsProperty) obj;
            if (this.getId().equals(goodsProperty.getId())) {
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