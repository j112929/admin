package com.bluemobi.serviceimpl.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.coupon.CouponListingDao;
import com.bluemobi.service.coupon.CouponListingService;

/**
 * 【优惠券使用情况表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:08
 * 
 */
@Service(value = "couponListingService")
public class CouponListingServiceImpl extends MybatisBaseServiceImpl implements CouponListingService {

    @Autowired
    private CouponListingDao couponListingDao;

    @Override
    public MyBatisBaseDao getDao() {
        return couponListingDao;
    }

}
