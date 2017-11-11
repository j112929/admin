package com.bluemobi.serviceimpl.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.finance.FinanceBatchDao;
import com.bluemobi.service.finance.FinanceBatchService;

/**
 * 【批次总表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "financeBatchService")
public class FinanceBatchServiceImpl extends MybatisBaseServiceImpl implements FinanceBatchService {

    @Autowired
    private FinanceBatchDao financeBatchDao;

    @Override
    public MyBatisBaseDao getDao() {
        return financeBatchDao;
    }

}
