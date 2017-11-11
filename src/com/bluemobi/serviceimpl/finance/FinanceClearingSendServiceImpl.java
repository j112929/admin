package com.bluemobi.serviceimpl.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.finance.FinanceClearingSendDao;
import com.bluemobi.service.finance.FinanceClearingSendService;

/**
 * 【二清发送收银台记录表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "financeClearingSendService")
public class FinanceClearingSendServiceImpl extends MybatisBaseServiceImpl implements FinanceClearingSendService {

    @Autowired
    private FinanceClearingSendDao financeClearingSendDao;

    @Override
    public MyBatisBaseDao getDao() {
        return financeClearingSendDao;
    }

}
