package com.bluemobi.service.goods;

import java.util.List;
import java.util.Map;

import com.appcore.service.MybatisBaseService;
import com.bluemobi.to.goods.PropertyAndPropertyValueTO;

/**
 * 【商品属性基础数据表】 服务类 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public interface GoodsPropertyService extends MybatisBaseService {
	/**
     * 查询属性和属性值
     * 
     * @auther jizhuolin
     * @date 2016-1-21 下午2:37:43
     * @param paramMap
     * @return
     */
    List<Map<String, Object>> selectPropertyAndPropertyValue(Map<String, Object> paramMap);
    
    /**   
     * 此方法描述的是：   查询属性和属性值的总条数
     * @author: jizhuolin  
     * @version: 2016-9-9 下午5:05:01 
     * @param paramMap
     * @return  
     */
    Integer pageCountPropAndVal(Map<String, Object> paramMap);
    
    /**   
     * 此方法描述的是：   修改属性、属性值
     * @author: jizhuolin  
     * @version: 2016-8-30 下午4:02:36 
     * @param paramMap
     * @return  
     */
    int updatePropertyAndPropertyValue(Map<String, Object> paramMap);
    
    /**   
     * 此方法描述的是：   删除属性、属性值
     * @author: jizhuolin  
     * @version: 2016-8-30 下午4:03:11 
     * @param paramMap
     * @return  
     */
    int deletePropertyAndPropertyValue(Map<String, Object> paramMap);

	/**   
	 * 此方法描述的是：   修改sku属性
	 * @author: jizhuolin  
	 * @version: 2016-9-9 下午5:19:34 
	 * @param propertyId
	 * @param status
	 * @param categoryId
	 * @return  
	 */
	int changePropertySku(Integer propertyId, Integer status, Integer categoryId);
	
	/**
     * 商品分类管理，修改绑定属性
     * 
     * @auther zhangzheng
     * @date 2015-10-12 下午6:15:53
     * @param propertyIds
     * @param categoryId
     */
    void updateBindProperty(String propertyIds, Integer categoryId);

	/**   
	 * 此方法描述的是：   修改图片属性
	 * @author: jizhuolin  
	 * @version: 2016-9-12 上午11:43:37 
	 * @param propertyId
	 * @param status
	 * @param categoryId
	 * @return  
	 */
	int changePropertyPic(Integer propertyId, Integer status, Integer categoryId);

	List<Map<String, Object>> selectPropertyByCategoryId(Map<String, Object> map);
    
}
