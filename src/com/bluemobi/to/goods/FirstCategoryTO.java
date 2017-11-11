/**   
 * 文件名：FirstCategoryTO.java   
 *   
 * 版本信息：   
 * 日期：2016-9-1   
 * Copyright 科匠 Corporation 2016    
 * 版权所有   
 *   
 */
package com.bluemobi.to.goods;

import com.appcore.model.AbstractObject;

/**   
 * 此类描述的是：   
 * @author: jizhuolin   
 * @version: 2016-9-1 下午3:20:49    
 */
public class FirstCategoryTO extends AbstractObject {
	/**   
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）   
	 * 
	 */
	private static final long serialVersionUID = 7417250194728175501L;
	
	/**   
	 * firstCategoryId:一级分类id
	 * 
	 */
	private Integer firstCategoryId;

	/**   
	 * firstCategoryName:一级分类名称   
	 * 
	 */
	private String firstCategoryName;
	
	/**   
	 * sortOrder: 一级分类排序   
	 * 
	 */
	private String firstSortOrder;
	
	/**   
	 * secondCategoryAmount:相关的二级分类数量  
	 * 
	 */
	private Integer secondCategoryAmount;

	/**   
	 * firstCategoryId   
	 *   
	 * @return  the firstCategoryId    
	 */
	public Integer getFirstCategoryId() {
		return firstCategoryId;
	}

	/**   
	 * @param firstCategoryId the firstCategoryId to set   
	 */
	public void setFirstCategoryId(Integer firstCategoryId) {
		this.firstCategoryId = firstCategoryId;
	}

	/**   
	 * firstCategoryName   
	 *   
	 * @return  the firstCategoryName    
	 */
	public String getFirstCategoryName() {
		return firstCategoryName;
	}

	/**   
	 * @param firstCategoryName the firstCategoryName to set   
	 */
	public void setFirstCategoryName(String firstCategoryName) {
		this.firstCategoryName = firstCategoryName;
	}
	
	/**   
	 * firstSortOrder   
	 *   
	 * @return  the firstSortOrder    
	 */
	public String getFirstSortOrder() {
		return firstSortOrder;
	}

	/**   
	 * @param firstSortOrder the firstSortOrder to set   
	 */
	public void setFirstSortOrder(String firstSortOrder) {
		this.firstSortOrder = firstSortOrder;
	}

	/**   
	 * secondCategoryAmount   
	 *   
	 * @return  the secondCategoryAmount    
	 */
	public Integer getSecondCategoryAmount() {
		return secondCategoryAmount;
	}

	/**   
	 * @param secondCategoryAmount the secondCategoryAmount to set   
	 */
	public void setSecondCategoryAmount(Integer secondCategoryAmount) {
		this.secondCategoryAmount = secondCategoryAmount;
	}
	
	
}
