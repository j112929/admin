package com.bluemobi.serviceimpl.white;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.page.Page;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.white.WhiteListDao;
import com.bluemobi.service.white.WhiteListService;

/**
 * 【白名单主表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "whiteListService")
public class WhiteListServiceImpl extends MybatisBaseServiceImpl implements WhiteListService {

    @Autowired
    private WhiteListDao whiteListDao;

    @Override
    public MyBatisBaseDao getDao() {
        return whiteListDao;
    }
}
