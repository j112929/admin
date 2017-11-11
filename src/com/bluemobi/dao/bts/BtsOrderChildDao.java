package com.bluemobi.dao.bts;

import java.util.List;

import com.appcore.dao.MyBatisBaseDao;
import com.bluemobi.po.bts.BtsOrderChild;

/**
 * 【商品订单子表】 数据访问对象 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public interface BtsOrderChildDao extends MyBatisBaseDao {

	/**
	 * selectList:一清二清对账使用
	 * @return 
	 * @return :List<BtsOrderChild> 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-13 上午10:04:23
	 */
	public List<BtsOrderChild> selectList();

	/**
	 * selectFinance_checkstandSno:查询订单表表中有的sno号，而收银台中没有的sno号
	 * @return 
	 * @return :List<BtsOrderChild> 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-13 下午4:25:59
	 */
	public List<BtsOrderChild> selectBtsOrderChildSno();
}
