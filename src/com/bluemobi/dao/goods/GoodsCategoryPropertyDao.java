package com.bluemobi.dao.goods;

import java.util.List;

import com.appcore.dao.MyBatisBaseDao;
import com.bluemobi.po.goods.GoodsCategoryProperty;

/**
 * 【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】 数据访问对象 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
public interface GoodsCategoryPropertyDao extends MyBatisBaseDao {
	 /**
     * 根据分类ID删除属性与分类关联
     * 
     * @auther zhangzheng
     * @date 2015-10-26 上午11:13:57
     * @param list
     */
    void deleteByCategoryId(List<GoodsCategoryProperty> list);

    /**
     * 批量新增属性与分类关联
     * 
     * @auther zhangzheng
     * @date 2015-10-26 上午11:14:25
     * @param list
     */
    void insertGoodsPropertyCategories(List<GoodsCategoryProperty> list);

}
