/**   
 * 文件名：SecondCategoryTO.java   
 *   
 * 版本信息：   
 * 日期：2016-9-1   
 * Copyright 科匠 Corporation 2016    
 * 版权所有   
 *   
 */
package com.bluemobi.to.goods;

import java.util.List;

import com.appcore.model.AbstractObject;
import com.bluemobi.po.goods.GoodsCategory;

/**   
 * 此类描述的是：   
 * @author: jizhuolin   
 * @version: 2016-9-1 下午3:50:56    
 */
public class SecondCategoryTO extends AbstractObject {

	/**   
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）   
	 * 
	 */
	private static final long serialVersionUID = 5499959185813549571L;
	/**   
	 * secondCategoryId:二级分类Id  
	 * 
	 */
	private Integer secondCategoryId;
	/**   
	 * firstCategoryName:一级分类名称  
	 * 
	 */
	private String firstCategoryName;
	/**   
	 * secondCategoryName:二级分类名称     
	 * 
	 */
	private String secondCategoryName;
	/**   
	 * secondSortOrder:二级分类排序
	 * 
	 */
	private Integer secondSortOrder;
	/**   
	 * thirdAmount:相关的三级分类数量
	 * 
	 */
	private Integer thirdCategoryAmount;
	
	/**   
	 * allOneGradeCategory:所有一级分类 
	 * 
	 */
	private List<?> allOneGradeCategory; 
	/**   
	 * secondCategoryId   
	 *   
	 * @return  the secondCategoryId    
	 */
	public Integer getSecondCategoryId() {
		return secondCategoryId;
	}
	/**   
	 * @param secondCategoryId the secondCategoryId to set   
	 */
	public void setSecondCategoryId(Integer secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
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
	 * secondCategoryName   
	 *   
	 * @return  the secondCategoryName    
	 */
	public String getSecondCategoryName() {
		return secondCategoryName;
	}
	/**   
	 * @param secondCategoryName the secondCategoryName to set   
	 */
	public void setSecondCategoryName(String secondCategoryName) {
		this.secondCategoryName = secondCategoryName;
	}
	/**   
	 * secondSortOrder   
	 *   
	 * @return  the secondSortOrder    
	 */
	public Integer getSecondSortOrder() {
		return secondSortOrder;
	}
	/**   
	 * @param secondSortOrder the secondSortOrder to set   
	 */
	public void setSecondSortOrder(Integer secondSortOrder) {
		this.secondSortOrder = secondSortOrder;
	}
	/**   
	 * thirdCategoryAmount   
	 *   
	 * @return  the thirdCategoryAmount    
	 */
	public Integer getThirdCategoryAmount() {
		return thirdCategoryAmount;
	}
	/**   
	 * @param thirdCategoryAmount the thirdCategoryAmount to set   
	 */
	public void setThirdCategoryAmount(Integer thirdCategoryAmount) {
		this.thirdCategoryAmount = thirdCategoryAmount;
	}
	/**   
	 * allOneGradeCategory   
	 *   
	 * @return  the allOneGradeCategory    
	 */
	public List<?> getAllOneGradeCategory() {
		return allOneGradeCategory;
	}
	/**   
	 * @param allOneGradeCategory the allOneGradeCategory to set   
	 */
	public void setAllOneGradeCategory(List<?> allOneGradeCategory) {
		this.allOneGradeCategory = allOneGradeCategory;
	}
	
	
}
