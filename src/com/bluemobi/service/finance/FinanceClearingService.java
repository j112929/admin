package com.bluemobi.service.finance;

import java.util.List;

import com.appcore.service.MybatisBaseService;
import com.bluemobi.po.finance.FinanceClearing;

/**
 * 【二清清算总表】 服务类 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public interface FinanceClearingService extends MybatisBaseService {

	/**
	 * insertBatch:批量插入
	 * @param list 
	 * @return :void 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-12 下午4:17:11
	 */
	public void insertBatch(List<FinanceClearing> list);
}
