package com.bluemobi.serviceimpl.bts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.bts.BtsOrderChildDao;
import com.bluemobi.po.bts.BtsOrderChild;
import com.bluemobi.service.bts.BtsOrderChildService;

/**
 * 【商品订单子表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "btsOrderChildService")
public class BtsOrderChildServiceImpl extends MybatisBaseServiceImpl implements BtsOrderChildService {

    @Autowired
    private BtsOrderChildDao btsOrderChildDao;

    @Override
    public MyBatisBaseDao getDao() {
        return btsOrderChildDao;
    }
	/**
	 * selectList:一清二清对账使用
	 * @return 
	 * @return :List<BtsOrderChild> 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-13 上午10:04:23
	 */
	@Override
	public List<BtsOrderChild> selectList() {
		return null;
	}
	/**
	 * selectFinance_checkstandSno:查询订单表表中有的sno号，而收银台中没有的sno号
	 * @return 
	 * @return :List<BtsOrderChild> 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-13 下午4:25:59
	 */
	@Override
	public List<BtsOrderChild> selectBtsOrderChildSno() {
		return null;
	}

}
