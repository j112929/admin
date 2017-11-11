package com.bluemobi.serviceimpl.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.coupon.CouponContentDao;
import com.bluemobi.service.coupon.CouponContentService;

/**
 * 【优惠券表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:08
 * 
 */
@Service(value = "couponContentService")
public class CouponContentServiceImpl extends MybatisBaseServiceImpl implements CouponContentService {

    @Autowired
    private CouponContentDao couponContentDao;

    @Override
    public MyBatisBaseDao getDao() {
        return couponContentDao;
    }

}
