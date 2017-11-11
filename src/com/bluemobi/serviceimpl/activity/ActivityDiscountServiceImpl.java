package com.bluemobi.serviceimpl.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.activity.ActivityDiscountDao;
import com.bluemobi.service.activity.ActivityDiscountService;

/**
 * 【限时折扣活动：本金购买，商户发起】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "activityDiscountService")
public class ActivityDiscountServiceImpl extends MybatisBaseServiceImpl implements ActivityDiscountService {

    @Autowired
    private ActivityDiscountDao activityDiscountDao;

    @Override
    public MyBatisBaseDao getDao() {
        return activityDiscountDao;
    }

}
