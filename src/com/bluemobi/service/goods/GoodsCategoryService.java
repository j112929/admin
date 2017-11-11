package com.bluemobi.service.goods;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.appcore.service.MybatisBaseService;
import com.bluemobi.to.goods.CategoryTO;
import com.bluemobi.to.goods.FirstCategoryTO;
import com.bluemobi.to.goods.SecondCategoryTO;
import com.bluemobi.to.goods.ThirdCategoryTO;

/**
 * 【商品分类】 服务类 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public interface GoodsCategoryService extends MybatisBaseService {
	/**   
	 * 此方法描述的是：   查询一二三级分类名，通过sql实现
	 * @author: jizhuolin  
	 * @version: 2016-8-31 下午5:56:02 
	 * @param paramMap
	 * @return  
	 */
	List<CategoryTO> selectCategoryName(Map<String, Object> paramMap);
	
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
	 * 此方法描述的是：    查询一级分类信息条数
	 * @author: jizhuolin  
	 * @version: 2016-9-2 下午3:46:39 
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
	 * @version: 2016-9-2 下午3:46:59 
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
	 * 此方法描述的是：   查询三级分类信息条数
	 * @author: jizhuolin  
	 * @version: 2016-9-2 下午3:47:18 
	 * @return  
	 */
	Integer pageCountThird(Map<String, Object> paramMap);
	
	/**   
	 * 此方法描述的是：   绑定属性
	 * @author: jizhuolin  
	 * @version: 2016-9-8 上午11:07:00 
	 * @param map
	 * @param properties  
	 */
	void bindProp(Map<String, Object> map, List<Map<String, Object>> properties);
	
	/**   
	 * 此方法描述的是：   添加所有一级分类
	 * @author: jizhuolin  
	 * @version: 2016-9-8 上午11:14:22 
	 * @param list  
	 */
	void addAllOneGradeCategory(List<SecondCategoryTO> list);
	
}
