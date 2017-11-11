package com.bluemobi.serviceimpl.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.activity.ActivitySeckillDao;
import com.bluemobi.service.activity.ActivitySeckillService;

/**
 * 【秒杀活动：积分秒杀，平台发起】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "activitySeckillService")
public class ActivitySeckillServiceImpl extends MybatisBaseServiceImpl implements ActivitySeckillService {

    @Autowired
    private ActivitySeckillDao activitySeckillDao;

    @Override
    public MyBatisBaseDao getDao() {
        return activitySeckillDao;
    }

}
