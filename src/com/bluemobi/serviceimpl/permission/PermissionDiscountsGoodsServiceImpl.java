package com.bluemobi.serviceimpl.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.permission.PermissionDiscountsGoodsDao;
import com.bluemobi.service.permission.PermissionDiscountsGoodsService;

/**
 * 【优惠折扣关联商品表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-05 14:38:49
 * 
 */
@Service(value = "permissionDiscountsGoodsService")
public class PermissionDiscountsGoodsServiceImpl extends MybatisBaseServiceImpl implements PermissionDiscountsGoodsService {

    @Autowired
    private PermissionDiscountsGoodsDao permissionDiscountsGoodsDao;

    @Override
    public MyBatisBaseDao getDao() {
        return permissionDiscountsGoodsDao;
    }

}
