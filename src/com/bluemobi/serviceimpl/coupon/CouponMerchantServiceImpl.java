package com.bluemobi.serviceimpl.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.coupon.CouponMerchantDao;
import com.bluemobi.service.coupon.CouponMerchantService;

/**
 * 【优惠券商户表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:09
 * 
 */
@Service(value = "couponMerchantService")
public class CouponMerchantServiceImpl extends MybatisBaseServiceImpl implements CouponMerchantService {

    @Autowired
    private CouponMerchantDao couponMerchantDao;

    @Override
    public MyBatisBaseDao getDao() {
        return couponMerchantDao;
    }

}
