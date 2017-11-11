package com.bluemobi.serviceimpl.bts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.bts.BtsCartDao;
import com.bluemobi.service.bts.BtsCartService;

/**
 * 【购物车表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "btsCartService")
public class BtsCartServiceImpl extends MybatisBaseServiceImpl implements BtsCartService {

    @Autowired
    private BtsCartDao btsCartDao;

    @Override
    public MyBatisBaseDao getDao() {
        return btsCartDao;
    }

}
