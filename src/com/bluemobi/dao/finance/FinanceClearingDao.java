package com.bluemobi.dao.finance;

import java.util.List;

import com.appcore.dao.MyBatisBaseDao;
import com.bluemobi.po.finance.FinanceClearing;

/**
 * 【二清清算总表】 数据访问对象 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public interface FinanceClearingDao extends MyBatisBaseDao {

	/**
	 * insertBatch:批量插入
	 * @param list 
	 * @return :void 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-12 下午4:17:11
	 */
	public void insertBatch(List<FinanceClearing> list);
}
