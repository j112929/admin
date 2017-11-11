package com.bluemobi.serviceimpl.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsCategoryDao;
import com.bluemobi.po.goods.GoodsCategory;
import com.bluemobi.po.goods.GoodsCategoryProperty;
import com.bluemobi.po.goods.GoodsProperty;
import com.bluemobi.service.goods.GoodsCategoryPropertyService;
import com.bluemobi.service.goods.GoodsCategoryService;
import com.bluemobi.service.goods.GoodsPropertyService;
import com.bluemobi.to.goods.CategoryTO;
import com.bluemobi.to.goods.FirstCategoryTO;
import com.bluemobi.to.goods.SecondCategoryTO;
import com.bluemobi.to.goods.ThirdCategoryTO;

/**
 * 【商品分类】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Service(value = "goodsCategoryService")
public class GoodsCategoryServiceImpl extends MybatisBaseServiceImpl implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryDao goodsCategoryDao;
    @Autowired
	private GoodsPropertyService goodsPropertyService;
    @Autowired
	private GoodsCategoryPropertyService goodsCategoryPropertyService;
    
    @Override
    public MyBatisBaseDao getDao() {
        return goodsCategoryDao;
    }

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsCategoryService#selectCategoryName(java.util.Map)   
	 */
	@Override
	public List<CategoryTO> selectCategoryName(Map<String, Object> paramMap) {
		return goodsCategoryDao.selectThreeCategoryName(paramMap);
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsCategoryService#selectThreeCategoryName(java.util.Map)   
	 */
	@Override
	public List<CategoryTO> selectThreeCategoryName(Map<String, Object> paramMap) {
		return goodsCategoryDao.selectThreeCategoryName(paramMap);
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsCategoryService#selectFirstCategory(java.util.Map)   
	 */
	@Override
	public List<FirstCategoryTO> selectFirstCategory(
			Map<String, Object> paramMap) {
		return goodsCategoryDao.selectFirstCategory(paramMap);
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsCategoryService#selectSecondCategory(java.util.Map)   
	 */
	@Override
	public List<SecondCategoryTO> selectSecondCategory(
			Map<String, Object> paramMap) {
		return goodsCategoryDao.selectSecondCategory(paramMap);
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsCategoryService#selectThirdCategory(java.util.Map)   
	 */
	@Override
	public List<ThirdCategoryTO> selectThirdCategory(
			Map<String, Object> paramMap) {
		return goodsCategoryDao.selectThirdCategory(paramMap);
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsCategoryService#pageCountFirst()   
	 */
	@Override
	public Integer pageCountFirst(Map<String, Object> paramMap) {
		return goodsCategoryDao.pageCountFirst(paramMap);
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsCategoryService#pageCountSecond()   
	 */
	@Override
	public Integer pageCountSecond(Map<String, Object> paramMap) {
		return goodsCategoryDao.pageCountSecond(paramMap);
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsCategoryService#pageCountThird()   
	 */
	@Override
	public Integer pageCountThird(Map<String, Object> paramMap) {
		return goodsCategoryDao.pageCountThird(paramMap);
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsCategoryService#bindProp(java.util.Map, java.util.List)   
	 */
	@Override
	public void bindProp(Map<String, Object> map, List<Map<String, Object>> properties) {
		//查询三级分类已经绑定的属性，用于右侧展示
        //1.通过categoryId查出中间表关联的propertyId 列表
        List<GoodsCategoryProperty> list = goodsCategoryPropertyService.selectObjectList(map);
        //2.循环列表查出所有已绑定的属性列表
        for (GoodsCategoryProperty obj : list) {
        	Map<String, Object> mapPropTmp = new HashMap<String, Object>();
        	mapPropTmp.put("id", obj.getPropertyId());
        	GoodsProperty goodsProperty = goodsPropertyService.selectObject(mapPropTmp);
        	Map<String, Object> mapTmp = new HashMap<String, Object>();
        	mapTmp.put("id", goodsProperty.getId());
        	mapTmp.put("name",goodsProperty.getName());
        	properties.add(mapTmp);
        }
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsCategoryService#addAllOneGradeCategory(java.util.List)   
	 */
	@Override
	public void addAllOneGradeCategory(List<SecondCategoryTO> list) {
		Map<String, Object> mapTmp = new HashMap<String, Object>();
        mapTmp.put("grade", 1);
        List<GoodsCategory> goodsCategoryList = this.selectObjectList(mapTmp);
        List<String> listTmp  = new ArrayList<String>();
        for (SecondCategoryTO secondCategoryTO : list) {
        	for (GoodsCategory goodsCategory : goodsCategoryList) {
        		listTmp.add(goodsCategory.getId().toString());
        		listTmp.add(goodsCategory.getName());
			}
        	secondCategoryTO.setAllOneGradeCategory(listTmp);
		}
	}

	
}
