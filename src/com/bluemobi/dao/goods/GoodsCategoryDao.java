package com.bluemobi.dao.goods;

import java.util.List;
import java.util.Map;

import com.appcore.dao.MyBatisBaseDao;
import com.bluemobi.po.goods.GoodsCategory;
import com.bluemobi.to.goods.CategoryTO;
import com.bluemobi.to.goods.FirstCategoryTO;
import com.bluemobi.to.goods.SecondCategoryTO;
import com.bluemobi.to.goods.ThirdCategoryTO;

/**
 * 【商品分类】 数据访问对象 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public interface GoodsCategoryDao extends MyBatisBaseDao {
	/**   
	 * 此方法描述的是：   根据一级、二级、三级分类名称模糊查询,需传分类名<name>、等级<grade>
	 * @author: jizhuolin  
	 * @version: 2016-8-30 下午5:34:46 
	 * @return  
	 */
	List<GoodsCategory> selectByCategoryName(Map<String, Object> paramMap);
	
	/**   
	 * 此方法描述的是：   查询三级分类名称列表
	 * @author: jizhuolin  
	 * @version: 2016-8-31 下午4:48:38 
	 * @param paramMap
	 * @return  
	 */
	List<CategoryTO> selectThreeCategoryName(Map<String, Object> paramMap); 
	
	
	/**   
	 * 此方法描述的是： 查询一级分类信息
	 * @author: jizhuolin  
	 * @version: 2016-9-1 下午5:45:50 
	 * @param paramMap
	 * @return  
	 */
	List<FirstCategoryTO> selectFirstCategory(Map<String, Object> paramMap);
	/**   
	 * 此方法描述的是：   查询一级分类信息条数
	 * @author: jizhuolin  
	 * @version: 2016-9-2 下午3:42:05 
	 * @return  
	 */
	Integer pageCountFirst(Map<String, Object> paramMap);
	
	/**   
	 * 此方法描述的是：   查询二级分类信息
	 * @author: jizhuolin  
	 * @version: 2016-9-1 下午5:45:52 
	 * @param paramMap
	 * @return  
	 */
	List<SecondCategoryTO> selectSecondCategory(Map<String, Object> paramMap);
	/**   
	 * 此方法描述的是：   查询二级分类信息条数
	 * @author: jizhuolin  
	 * @version: 2016-9-2 下午3:43:14 
	 * @return  
	 */
	Integer pageCountSecond(Map<String, Object> paramMap);
	/**   
	 * 此方法描述的是：   查询三级分类信息
	 * @author: jizhuolin  
	 * @version: 2016-9-1 下午5:45:55 
	 * @param paramMap
	 * @return  
	 */
	List<ThirdCategoryTO> selectThirdCategory(Map<String, Object> paramMap);
	/**   
	 * 此方法描述的是：    查询三级分类信息条数
	 * @author: jizhuolin  
	 * @version: 2016-9-2 下午3:43:40 
	 * @return  
	 */
	Integer pageCountThird(Map<String, Object> paramMap);
	
}
