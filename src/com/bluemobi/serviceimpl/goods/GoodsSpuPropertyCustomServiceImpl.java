package com.bluemobi.serviceimpl.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsSpuPropertyCustomDao;
import com.bluemobi.service.goods.GoodsSpuPropertyCustomService;

/**
 * 【商品spu自定义属性表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Service(value = "goodsSpuPropertyCustomService")
public class GoodsSpuPropertyCustomServiceImpl extends MybatisBaseServiceImpl implements GoodsSpuPropertyCustomService {

    @Autowired
    private GoodsSpuPropertyCustomDao goodsSpuPropertyCustomDao;

    @Override
    public MyBatisBaseDao getDao() {
        return goodsSpuPropertyCustomDao;
    }

}
