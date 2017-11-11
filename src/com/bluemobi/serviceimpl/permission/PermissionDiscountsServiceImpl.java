package com.bluemobi.serviceimpl.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.permission.PermissionDiscountsDao;
import com.bluemobi.service.permission.PermissionDiscountsService;

/**
 * 【优惠折扣抢购表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-05 14:38:48
 * 
 */
@Service(value = "permissionDiscountsService")
public class PermissionDiscountsServiceImpl extends MybatisBaseServiceImpl implements PermissionDiscountsService {

    @Autowired
    private PermissionDiscountsDao permissionDiscountsDao;

    @Override
    public MyBatisBaseDao getDao() {
        return permissionDiscountsDao;
    }

}
