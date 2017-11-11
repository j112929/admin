/**   
 * 文件名：PropertyAndPropertyValueTO.java   
 *   
 * 版本信息：   
 * 日期：2016-8-30   
 * Copyright 科匠 Corporation 2016    
 * 版权所有   
 *   
 */
package com.bluemobi.to.goods;

import com.appcore.model.AbstractObject;

/**   
 * 此类描述的是：   用于CRUD属性、属性值
 * @author: jizhuolin   
 * @version: 2016-8-30 上午11:37:45    
 */
public class PropertyAndPropertyValueTO extends AbstractObject {

	/**   
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）   
	 * 
	 */
	private static final long serialVersionUID = -1180613847335862593L;
	// 属性 ID
    private Integer propertyId;
    // 属性值ID
    private Integer propertyValueId;
    // 属性序号
    private Integer sortOrder;
    // 属性名
    private String propertyName;
    // 属性值：有多个值
    private String propertyValue;
    //备注
    private String description;
    // 是否开启规格（开启后将和价格、库存等相关联）。1：是；0：否；
    private Integer isSku;
    //属否图片属性
    private Integer isPic;
    // 属性值序号
    private Integer valueSortOrder;
	/**   
	 * propertyId   
	 *   
	 * @return  the propertyId    
	 */
	public Integer getPropertyId() {
		return propertyId;
	}
	/**   
	 * @param propertyId the propertyId to set   
	 */
	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}
	
	/**   
	 * propertyValueId   
	 *   
	 * @return  the propertyValueId    
	 */
	public Integer getPropertyValueId() {
		return propertyValueId;
	}
	/**   
	 * @param propertyValueId the propertyValueId to set   
	 */
	public void setPropertyValueId(Integer propertyValueId) {
		this.propertyValueId = propertyValueId;
	}
	/**   
	 * sortOrder   
	 *   
	 * @return  the sortOrder    
	 */
	public Integer getSortOrder() {
		return sortOrder;
	}
	/**   
	 * @param sortOrder the sortOrder to set   
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	/**   
	 * propertyName   
	 *   
	 * @return  the propertyName    
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**   
	 * @param propertyName the propertyName to set   
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/**   
	 * propertyValue   
	 *   
	 * @return  the propertyValue    
	 */
	public String getPropertyValue() {
		return propertyValue;
	}
	/**   
	 * @param propertyValue the propertyValue to set   
	 */
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	/**   
	 * description   
	 *   
	 * @return  the description    
	 */
	public String getDescription() {
		return description;
	}
	/**   
	 * @param description the description to set   
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**   
	 * isSku   
	 *   
	 * @return  the isSku    
	 */
	public Integer getIsSku() {
		return isSku;
	}
	/**   
	 * @param isSku the isSku to set   
	 */
	public void setIsSku(Integer isSku) {
		this.isSku = isSku;
	}
	
	/**   
	 * isPic   
	 *   
	 * @return  the isPic    
	 */
	public Integer getIsPic() {
		return isPic;
	}
	/**   
	 * @param isPic the isPic to set   
	 */
	public void setIsPic(Integer isPic) {
		this.isPic = isPic;
	}
	/**   
	 * valueSortOrder   
	 *   
	 * @return  the valueSortOrder    
	 */
	public Integer getValueSortOrder() {
		return valueSortOrder;
	}
	/**   
	 * @param valueSortOrder the valueSortOrder to set   
	 */
	public void setValueSortOrder(Integer valueSortOrder) {
		this.valueSortOrder = valueSortOrder;
	}
    
    
}
