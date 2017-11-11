package com.bluemobi.serviceimpl.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsSkuDao;
import com.bluemobi.service.goods.GoodsSkuService;

/**
 * 【商品sku】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "goodsSkuService")
public class GoodsSkuServiceImpl extends MybatisBaseServiceImpl implements GoodsSkuService {

    @Autowired
    private GoodsSkuDao goodsSkuDao;

    @Override
    public MyBatisBaseDao getDao() {
        return goodsSkuDao;
    }

}
