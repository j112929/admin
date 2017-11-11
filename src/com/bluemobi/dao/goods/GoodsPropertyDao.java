package com.bluemobi.dao.goods;

import java.util.List;
import java.util.Map;

import com.appcore.dao.MyBatisBaseDao;

/**
 * 【商品属性基础数据表】 数据访问对象 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public interface GoodsPropertyDao extends MyBatisBaseDao {
	/**   
	 * 此方法描述的是：   查询属性、属性值
	 * @author: jizhuolin  
	 * @version: 2016-8-30 下午5:05:47 
	 * @param paramMap
	 * @return  
	 */
	public List<Map<String, Object>> selectPropertyAndPropertyValue(Map<String, Object> paramMap);
	
	/**   
     * 此方法描述的是：   查询属性和属性值的总条数
     * @author: jizhuolin  
     * @version: 2016-9-9 下午5:05:01 
     * @param paramMap
     * @return  
     */
    Integer pageCountPropAndVal(Map<String, Object> paramMap);

	/**   
	 * 此方法描述的是：   通过分类Id查是sku属性的数量
	 * @author: jizhuolin  
	 * @version: 2016-9-9 下午5:24:37 
	 * @param categoryId
	 * @return  
	 */
	public int selectPropertyIsSkuCountByCategoryId(Integer categoryId);

	/**   
	 * 此方法描述的是：   通过分类Id查是Pic属性的数量
	 * @author: jizhuolin  
	 * @version: 2016-9-12 上午11:44:33 
	 * @param categoryId
	 * @return  
	 */
	public int selectPropertyIsPicCountByCategoryId(Integer categoryId);
	
}
