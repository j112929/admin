package com.bluemobi.dao.finance;

import java.util.List;

import com.appcore.dao.MyBatisBaseDao;
import com.bluemobi.po.finance.FinanceCheckstand;
import com.bluemobi.to.finance.FinanceCheckstandTO;

/**
 * 【收银台文件数据】 数据访问对象 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public interface FinanceCheckstandDao extends MyBatisBaseDao {

	/**
	 * selectList:查询收银台表和订单表的sno'号相同的
	 * @return 
	 * @return :List<FinanceCheckstand> 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-9 下午4:25:27
	 */
	public List<FinanceCheckstandTO> selectList();
	
	/**
	 * insertBatch:批量插入(一清本金)
	 * @param financeCheckstand 
	 * @return :void 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-9 下午2:08:54
	 */
	public void insertBatch(List<FinanceCheckstand> list);
	/**
	 * selectFinanceCheckstandSno:查询收银台表中有的sno号，而订单表中没有的sno号
	 * @return 
	 * @return :List<FinanceCheckstandTO> 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-13 下午3:57:57
	 */
	public List<FinanceCheckstand> selectFinanceCheckstandSno();
	
}
