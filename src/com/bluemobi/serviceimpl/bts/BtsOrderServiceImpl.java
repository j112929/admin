package com.bluemobi.serviceimpl.bts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.bts.BtsOrderDao;
import com.bluemobi.service.bts.BtsOrderService;

/**
 * 【商品订单表，存放主订单编号，收货人信息等】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "btsOrderService")
public class BtsOrderServiceImpl extends MybatisBaseServiceImpl implements BtsOrderService {

    @Autowired
    private BtsOrderDao btsOrderDao;

    @Override
    public MyBatisBaseDao getDao() {
        return btsOrderDao;
    }

}
