package com.bluemobi.serviceimpl.bts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.bts.BtsOrderItemsDao;
import com.bluemobi.service.bts.BtsOrderItemsService;

/**
 * 【商品订单明细表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "btsOrderItemsService")
public class BtsOrderItemsServiceImpl extends MybatisBaseServiceImpl implements BtsOrderItemsService {

    @Autowired
    private BtsOrderItemsDao btsOrderItemsDao;

    @Override
    public MyBatisBaseDao getDao() {
        return btsOrderItemsDao;
    }

}
