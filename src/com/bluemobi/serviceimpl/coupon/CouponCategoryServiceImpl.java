package com.bluemobi.serviceimpl.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.coupon.CouponCategoryDao;
import com.bluemobi.service.coupon.CouponCategoryService;

/**
 * 【优惠券分类表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:08
 * 
 */
@Service(value = "couponCategoryService")
public class CouponCategoryServiceImpl extends MybatisBaseServiceImpl implements CouponCategoryService {

    @Autowired
    private CouponCategoryDao couponCategoryDao;

    @Override
    public MyBatisBaseDao getDao() {
        return couponCategoryDao;
    }

}
