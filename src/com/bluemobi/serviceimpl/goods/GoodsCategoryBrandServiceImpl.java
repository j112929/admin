package com.bluemobi.serviceimpl.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsCategoryBrandDao;
import com.bluemobi.service.goods.GoodsCategoryBrandService;

/**
 * 【商品分类绑定品牌表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的品牌列表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Service(value = "goodsCategoryBrandService")
public class GoodsCategoryBrandServiceImpl extends MybatisBaseServiceImpl implements GoodsCategoryBrandService {

    @Autowired
    private GoodsCategoryBrandDao goodsCategoryBrandDao;

    @Override
    public MyBatisBaseDao getDao() {
        return goodsCategoryBrandDao;
    }

}
