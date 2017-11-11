package com.bluemobi.serviceimpl.white;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.white.WhiteListTargetDao;
import com.bluemobi.service.white.WhiteListTargetService;

/**
 * 【白名单关联表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "whiteListTargetService")
public class WhiteListTargetServiceImpl extends MybatisBaseServiceImpl implements WhiteListTargetService {

    @Autowired
    private WhiteListTargetDao whiteListTargetDao;

    @Override
    public MyBatisBaseDao getDao() {
        return whiteListTargetDao;
    }
    @Override
    public <T> int deleteRelated(T parameter) {
		return whiteListTargetDao.deleteRelated(parameter);
	}

}
