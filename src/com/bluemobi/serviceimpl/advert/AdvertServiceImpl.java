package com.bluemobi.serviceimpl.advert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.advert.AdvertDao;
import com.bluemobi.service.advert.AdvertService;

/**
 * 【广告表，存放广告位信息、banner信息等】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "advertService")
public class AdvertServiceImpl extends MybatisBaseServiceImpl implements AdvertService {

    @Autowired
    private AdvertDao advertDao;

    @Override
    public MyBatisBaseDao getDao() {
        return advertDao;
    }

}
