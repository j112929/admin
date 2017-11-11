package com.bluemobi.serviceimpl.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsCategoryPropertyDao;
import com.bluemobi.service.goods.GoodsCategoryPropertyService;

/**
 * 【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Service(value = "goodsCategoryPropertyService")
public class GoodsCategoryPropertyServiceImpl extends MybatisBaseServiceImpl implements GoodsCategoryPropertyService {

    @Autowired
    private GoodsCategoryPropertyDao goodsCategoryPropertyDao;

    @Override
    public MyBatisBaseDao getDao() {
        return goodsCategoryPropertyDao;
    }

}
