package com.bluemobi.serviceimpl.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.coupon.CouponTypeCategoryDao;
import com.bluemobi.service.coupon.CouponTypeCategoryService;

/**
 * 【优惠券类别选择表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:09
 * 
 */
@Service(value = "couponTypeCategoryService")
public class CouponTypeCategoryServiceImpl extends MybatisBaseServiceImpl implements CouponTypeCategoryService {

    @Autowired
    private CouponTypeCategoryDao couponTypeCategoryDao;

    @Override
    public MyBatisBaseDao getDao() {
        return couponTypeCategoryDao;
    }

}
