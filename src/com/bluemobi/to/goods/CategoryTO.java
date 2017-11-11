/**   
 * 文件名：CategoryTO.java   
 *   
 * 版本信息：   
 * 日期：2016-8-31   
 * Copyright 科匠 Corporation 2016    
 * 版权所有   
 *   
 */
package com.bluemobi.to.goods;

import com.appcore.model.AbstractObject;

/**   
 * 此类描述的是：   
 * @author: jizhuolin   
 * @version: 2016-8-31 下午4:43:07    
 */
public class CategoryTO extends AbstractObject {

	/**   
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）   
	 * 
	 */
	private static final long serialVersionUID = -4707186687034059723L;
	
	/**   
	 * cateGoryFirstId:一级分类Id
	 * 
	 */
	private Integer firstCateGoryId;
	/**   
	 * cateGorySecondId:二级分类Id   
	 * 
	 */
	private Integer secondCateGoryId;
	/**   
	 * cateGoryId:三级分类Id   
	 * 
	 */
	private Integer thirdCateGoryId;
	
	/**   
	 * firstCategoryName:一级分类名   
	 * 
	 */
	private String firstCategoryName;
	
	/**   
	 * secondCategoryName:二级分类名   
	 * 
	 */
	private String secondCategoryName;
	
	/**   
	 * thirdCategoryName:三级分类名   
	 * 
	 */
	private String thirdCategoryName;

	
	
	public Integer getFirstCateGoryId() {
		return firstCateGoryId;
	}

	public void setFirstCateGoryId(Integer firstCateGoryId) {
		this.firstCateGoryId = firstCateGoryId;
	}

	public Integer getSecondCateGoryId() {
		return secondCateGoryId;
	}

	public void setSecondCateGoryId(Integer secondCateGoryId) {
		this.secondCateGoryId = secondCateGoryId;
	}

	public Integer getThirdCateGoryId() {
		return thirdCateGoryId;
	}

	public void setThirdCateGoryId(Integer thirdCateGoryId) {
		this.thirdCateGoryId = thirdCateGoryId;
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
	 * thirdCategoryName   
	 *   
	 * @return  the thirdCategoryName    
	 */
	public String getThirdCategoryName() {
		return thirdCategoryName;
	}

	/**   
	 * @param thirdCategoryName the thirdCategoryName to set   
	 */
	public void setThirdCategoryName(String thirdCategoryName) {
		this.thirdCategoryName = thirdCategoryName;
	}
	
	
	
}
