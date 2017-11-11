package com.bluemobi.serviceimpl.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsCategoryPropertyDao;
import com.bluemobi.dao.goods.GoodsPropertyDao;
import com.bluemobi.dao.goods.GoodsPropertyValueDao;
import com.bluemobi.po.goods.GoodsCategoryProperty;
import com.bluemobi.po.goods.GoodsProperty;
import com.bluemobi.po.goods.GoodsPropertyValue;
import com.bluemobi.service.goods.GoodsPropertyService;
import com.bluemobi.to.goods.PropertyAndPropertyValueTO;

/**
 * 【商品属性基础数据表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Service(value = "goodsPropertyService")
public class GoodsPropertyServiceImpl extends MybatisBaseServiceImpl implements GoodsPropertyService {

    @Autowired
    private GoodsPropertyDao goodsPropertyDao;
    @Autowired
    private GoodsCategoryPropertyDao goodsCategoryPropertyDao;
    @Autowired
    private GoodsPropertyValueDao goodsPropertyValueDao;
    @Override
    public MyBatisBaseDao getDao() {
        return goodsPropertyDao;
    }

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsPropertyService#selectPropertyAndPropertyValue(java.util.Map)   
	 */
	@Override
	public List<Map<String, Object>> selectPropertyAndPropertyValue(
			Map<String, Object> paramMap) {
		List<Map<String, Object>> goodsPropertyList = goodsPropertyDao.selectPropertyAndPropertyValue(paramMap);
		return goodsPropertyList;
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsPropertyService#updatePropertyAndPropertyValue(java.util.Map)   
	 */
	@Override
	public int updatePropertyAndPropertyValue(Map<String, Object> paramMap) {
		int result = goodsPropertyDao.update(paramMap);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("propertyId", paramMap.get("propertyId"));
		List<GoodsPropertyValue> goodsPropertyValueList  = goodsPropertyValueDao.selectObjectList(param);
		for (GoodsPropertyValue goodsPropertyValue : goodsPropertyValueList) {
			Map<String, Object> paramTmp = new HashMap<String, Object>();
			paramTmp.put("id",goodsPropertyValue.getId());
			paramTmp.put("name", paramMap.get("propertyValue"));
			goodsPropertyValueDao.update(paramTmp);
		}
		return result;
	}
	/**
	 * 根据分类属性	 获取属性
	 * by lixue 
	 */
	@Override
	public List<Map<String, Object>> selectPropertyByCategoryId(
			Map<String, Object> map) {
		List<Map<String, Object>> propertys=new ArrayList<Map<String, Object>>();
		List<GoodsCategoryProperty> gcpList=goodsCategoryPropertyDao.selectObjectList(map);
		if(gcpList!=null && gcpList.size()>0){
			for (GoodsCategoryProperty gcp : gcpList) {
				Map<String, Object> property=new HashMap<String,Object>();
				GoodsProperty gp=goodsPropertyDao.selectObject(gcp.getPropertyId());
				property.put("goodsProperty", gp);
				map.clear();
				map.put("propertyId", gp.getId());
				List<GoodsPropertyValue> gpvList=goodsPropertyValueDao.selectObjectList(map);
				property.put("goodsPropertyValue", gpvList);
				propertys.add(property);
			}
		}
		return propertys;
	}
	
	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsPropertyService#deletePropertyAndPropertyValue(java.util.Map)   
	 */
	@Override
	public int deletePropertyAndPropertyValue(Map<String, Object> paramMap) {
		int result = goodsPropertyDao.delete(paramMap);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("propertyId", paramMap.get("propertyId"));
		List<GoodsPropertyValue> goodsPropertyValueList  = goodsPropertyValueDao.selectObjectList(param);
		for (GoodsPropertyValue goodsPropertyValue : goodsPropertyValueList) {
			Map<String, Object> paramTmp = new HashMap<String, Object>();
			paramTmp.put("id",goodsPropertyValue.getId());
			goodsPropertyValueDao.delete(paramTmp);
		}
		return result;
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsPropertyService#pageCountPropAndVal(java.util.Map)   
	 */
	@Override
	public Integer pageCountPropAndVal(Map<String, Object> paramMap) {
		return goodsPropertyDao.pageCountPropAndVal(paramMap);
	}

	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsPropertyService#changePropertySku(java.lang.Integer, java.lang.Integer, java.lang.Integer)   
	 */
	@Override
	public int changePropertySku(Integer propertyId, Integer status,
			Integer categoryId) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("id", propertyId);
        if (status == 1) {
            param.put("isSku", 0);
        } else {
            param.put("isSku", 1);
        }
        int r = goodsPropertyDao.update(param);
		return 0;
	}
	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsPropertyService#changePropertyPic(java.lang.Integer, java.lang.Integer, java.lang.Integer)   
	 */
	@Override
	public int changePropertyPic(Integer propertyId, Integer status,
			Integer categoryId) {
		if (status == 0) {
            int count = goodsPropertyDao.selectPropertyIsPicCountByCategoryId(categoryId);
            // 只允许设置一个图片属性
            if (count > 0) {
                return 1;
            }
        }
        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("id", propertyId);
        if (status == 1) {
            param.put("isPic", 0);
        } else {
            param.put("isPic", 1);
        }
        goodsPropertyDao.update(param);
		return 0;
	}
	/* (non-Javadoc)   
	 * @see com.bluemobi.service.goods.GoodsPropertyService#updateBindProperty(java.lang.String, java.lang.Integer)   
	 */
	@Override
	public void updateBindProperty(String propertyIds, Integer categoryId) {
		 Map<String, Object> map = new HashMap<String, Object>();
	        map.put("categoryId", categoryId);
	        List<GoodsCategoryProperty> goodsPropertyCategoriesList = goodsCategoryPropertyDao.selectObjectList(map);
	        if (goodsPropertyCategoriesList != null && !goodsPropertyCategoriesList.isEmpty()) {
	            goodsCategoryPropertyDao.deleteByCategoryId(goodsPropertyCategoriesList);
	        }

	        // 数据分割
	        String[] ids = propertyIds.split(",");
	        List<GoodsCategoryProperty> propertyCategories = new ArrayList<GoodsCategoryProperty>();
	        GoodsCategoryProperty GoodsCategoryProperty = null;
	        for (int i = 0; i < ids.length; i++) {
	            GoodsCategoryProperty = new GoodsCategoryProperty();
                GoodsCategoryProperty.setPropertyId(Integer.parseInt(ids[i].substring(1, ids[i].length())));
                GoodsCategoryProperty.setCategoryId(categoryId);
	            propertyCategories.add(GoodsCategoryProperty);
	        }
	        goodsCategoryPropertyDao.insertGoodsPropertyCategories(propertyCategories);
	}


}
