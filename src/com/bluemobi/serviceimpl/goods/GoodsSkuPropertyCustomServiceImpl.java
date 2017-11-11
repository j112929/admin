package com.bluemobi.serviceimpl.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsSkuPropertyCustomDao;
import com.bluemobi.service.goods.GoodsSkuPropertyCustomService;

/**
 * 【商品sku自定义属性表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Service(value = "goodsSkuPropertyCustomService")
public class GoodsSkuPropertyCustomServiceImpl extends MybatisBaseServiceImpl implements GoodsSkuPropertyCustomService {

    @Autowired
    private GoodsSkuPropertyCustomDao goodsSkuPropertyCustomDao;

    @Override
    public MyBatisBaseDao getDao() {
        return goodsSkuPropertyCustomDao;
    }

}
