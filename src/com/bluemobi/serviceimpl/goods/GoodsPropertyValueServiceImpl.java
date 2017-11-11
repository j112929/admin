package com.bluemobi.serviceimpl.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsPropertyValueDao;
import com.bluemobi.service.goods.GoodsPropertyValueService;

/**
 * 【商品属性值】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Service(value = "goodsPropertyValueService")
public class GoodsPropertyValueServiceImpl extends MybatisBaseServiceImpl implements GoodsPropertyValueService {

    @Autowired
    private GoodsPropertyValueDao goodsPropertyValueDao;

    @Override
    public MyBatisBaseDao getDao() {
        return goodsPropertyValueDao;
    }

}
