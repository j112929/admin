package com.bluemobi.serviceimpl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.admin.AdminRoleDao;
import com.bluemobi.service.admin.AdminRoleService;

/**
 * 【角色表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Service(value = "adminRoleService")
public class AdminRoleServiceImpl extends MybatisBaseServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleDao adminRoleDao;

    @Override
    public MyBatisBaseDao getDao() {
        return adminRoleDao;
    }

}
