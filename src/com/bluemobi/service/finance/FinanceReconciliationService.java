package com.bluemobi.service.finance;

import java.util.List;

import com.appcore.service.MybatisBaseService;
import com.bluemobi.po.finance.FinanceReconciliation;

/**
 * 【对账表】 服务类 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public interface FinanceReconciliationService extends MybatisBaseService {

	/**
	 * insertBatch:批量向对账表中添加数据
	 * @param list 
	 * @return :void 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-9 下午4:42:05
	 */
	public void insertBatch(List<FinanceReconciliation> list);
	/**
	 * selectList:查询对账表(仅供结算使用)
	 * @return 
	 * @return :List<FinanceReconciliation> 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-12 下午3:35:00
	 */
	public List<FinanceReconciliation> selectList();
}
