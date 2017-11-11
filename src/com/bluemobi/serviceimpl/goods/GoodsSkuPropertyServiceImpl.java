package com.bluemobi.serviceimpl.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsSkuPropertyDao;
import com.bluemobi.service.goods.GoodsSkuPropertyService;

/**
 * 【商品sku属性表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Service(value = "goodsSkuPropertyService")
public class GoodsSkuPropertyServiceImpl extends MybatisBaseServiceImpl implements GoodsSkuPropertyService {

    @Autowired
    private GoodsSkuPropertyDao goodsSkuPropertyDao;

    @Override
    public MyBatisBaseDao getDao() {
        return goodsSkuPropertyDao;
    }

}
