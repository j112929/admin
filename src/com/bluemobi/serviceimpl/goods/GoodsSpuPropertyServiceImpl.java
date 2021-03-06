package com.bluemobi.serviceimpl.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsSpuPropertyDao;
import com.bluemobi.service.goods.GoodsSpuPropertyService;

/**
 * 【商品spu属性表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Service(value = "goodsSpuPropertyService")
public class GoodsSpuPropertyServiceImpl extends MybatisBaseServiceImpl implements GoodsSpuPropertyService {

    @Autowired
    private GoodsSpuPropertyDao goodsSpuPropertyDao;

    @Override
    public MyBatisBaseDao getDao() {
        return goodsSpuPropertyDao;
    }

}
