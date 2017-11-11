/**   
 * 文件名：ThirdCategoryTO.java   
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
 * @version: 2016-9-1 下午5:12:45    
 */
public class ThirdCategoryTO extends AbstractObject {

	/**   
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）   
	 * 
	 */
	private static final long serialVersionUID = 8786355297752292308L;
	
	/**   
	 * thirdCategoryId:三级分类Id
	 * 
	 */
	private Integer thirdCategoryId;
	
	/**   
	 * secondCategoryId:二级分类Id
	 * 
	 */
	private Integer secondCategoryId;
	/**   
	 * firstCategoryId:一级分类Id 
	 * 
	 */
	private Integer firstCategoryId;
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
	 * thirdCategoryName:三级分类名称   
	 * 
	 */
	private String thirdCategoryName;
	/**   
	 * pic:三级分类图片
	 * 
	 */
	private String pic;
	
	/**   
	 * thirdSortOrder:三级分类排序   
	 * 
	 */
	private Integer thirdSortOrder;

	/**   
	 * thirdCategoryId   
	 *   
	 * @return  the thirdCategoryId    
	 */
	public Integer getThirdCategoryId() {
		return thirdCategoryId;
	}

	/**   
	 * @param thirdCategoryId the thirdCategoryId to set   
	 */
	public void setThirdCategoryId(Integer thirdCategoryId) {
		this.thirdCategoryId = thirdCategoryId;
	}
	
	/**   
	 * firstCategoryId   
	 *   
	 * @return  the firstCategoryId    
	 */
	public Integer getFirstCategoryId() {
		return firstCategoryId;
	}

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

	/**   
	 * pic   
	 *   
	 * @return  the pic    
	 */
	public String getPic() {
		return pic;
	}

	/**   
	 * @param pic the pic to set   
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

	/**   
	 * thirdSortOrder   
	 *   
	 * @return  the thirdSortOrder    
	 */
	public Integer getThirdSortOrder() {
		return thirdSortOrder;
	}

	/**   
	 * @param thirdSortOrder the thirdSortOrder to set   
	 */
	public void setThirdSortOrder(Integer thirdSortOrder) {
		this.thirdSortOrder = thirdSortOrder;
	} 
	
}
