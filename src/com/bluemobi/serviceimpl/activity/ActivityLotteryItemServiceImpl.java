package com.bluemobi.serviceimpl.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.activity.ActivityLotteryItemDao;
import com.bluemobi.service.activity.ActivityLotteryItemService;

/**
 * 【抽奖明细】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "activityLotteryItemService")
public class ActivityLotteryItemServiceImpl extends MybatisBaseServiceImpl implements ActivityLotteryItemService {

    @Autowired
    private ActivityLotteryItemDao activityLotteryItemDao;

    @Override
    public MyBatisBaseDao getDao() {
        return activityLotteryItemDao;
    }

}
