package com.bluemobi.serviceimpl.white;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.white.WhiteListDetailDao;
import com.bluemobi.service.white.WhiteListDetailService;

/**
 * 【白名单明细表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "whiteListDetailService")
public class WhiteListDetailServiceImpl extends MybatisBaseServiceImpl implements WhiteListDetailService {

    @Autowired
    private WhiteListDetailDao whiteListDetailDao;

    @Override
    public MyBatisBaseDao getDao() {
        return whiteListDetailDao;
    }

	@Override
	public <T> int deleteRelated(T parameter) {
		return whiteListDetailDao.deleteRelated(parameter);
	}

}
