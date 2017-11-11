package com.bluemobi.serviceimpl.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.coupon.CouponWhiteListDao;
import com.bluemobi.service.coupon.CouponWhiteListService;

/**
 * 【优惠券白名单表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:09
 * 
 */
@Service(value = "couponWhiteListService")
public class CouponWhiteListServiceImpl extends MybatisBaseServiceImpl implements CouponWhiteListService {

    @Autowired
    private CouponWhiteListDao couponWhiteListDao;

    @Override
    public MyBatisBaseDao getDao() {
        return couponWhiteListDao;
    }

}
