package com.bluemobi.serviceimpl.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.activity.ActivityGrouponDao;
import com.bluemobi.service.activity.ActivityGrouponService;

/**
 * 【团购活动：本金购买，平台发起】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "activityGrouponService")
public class ActivityGrouponServiceImpl extends MybatisBaseServiceImpl implements ActivityGrouponService {

    @Autowired
    private ActivityGrouponDao activityGrouponDao;

    @Override
    public MyBatisBaseDao getDao() {
        return activityGrouponDao;
    }

}
