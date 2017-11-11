package com.bluemobi.serviceimpl.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.activity.ActivityLotteryDao;
import com.bluemobi.service.activity.ActivityLotteryService;

/**
 * 【抽奖活动：积分抽奖，平台发起】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "activityLotteryService")
public class ActivityLotteryServiceImpl extends MybatisBaseServiceImpl implements ActivityLotteryService {

    @Autowired
    private ActivityLotteryDao activityLotteryDao;

    @Override
    public MyBatisBaseDao getDao() {
        return activityLotteryDao;
    }

}
