package com.bluemobi.serviceimpl.finance;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.finance.FinanceClearingDao;
import com.bluemobi.dao.finance.FinanceReconciliationDao;
import com.bluemobi.po.finance.FinanceClearing;
import com.bluemobi.po.finance.FinanceReconciliation;
import com.bluemobi.service.finance.FinanceClearingService;

/**
 * 【二清清算总表】 服务类 实现类
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "financeClearingService")
public class FinanceClearingServiceImpl extends MybatisBaseServiceImpl implements FinanceClearingService {

    @Autowired
    private FinanceClearingDao financeClearingDao;
    @Autowired
    private FinanceReconciliationDao financeReconciliationDao;
    @Override
    public MyBatisBaseDao getDao() {
        return financeClearingDao;
    }

	/**
	 * insertBatch:批量插入     平台(全本金)——————————平台端全本金购买T+10
	 * @param list 
	 * @return :void 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-12 下午4:17:11
	 */
	@Override
	public void insertBatch(List<FinanceClearing> list) {
		
		//查询对账表
    	List<FinanceReconciliation> FinanceReconciliationList = financeReconciliationDao.selectList();
    	
    	//二清成功后向二清总表中添加数据
    	for (FinanceReconciliation financeReconciliation : FinanceReconciliationList) {
    		FinanceClearing financeClearing=new FinanceClearing();
    		financeClearing.setBatchNo(financeReconciliation.getBatchNo());//批次号
    		financeClearing.setPayType(financeReconciliation.getPayType());//支付方式
    		financeClearing.setSno(financeReconciliation.getSno());//交易流水号
    		//financeClearing.setOrderNo(financeReconciliation.get);//订单号
    		//financeClearing.setBuinessName(buinessName);//商户名（打给会计的自定义名）
    		//financeClearing.setBuinessNo(buinessNo);//商户号（打给会计的自定义号）
    		financeClearing.setBusinessDeal(financeReconciliation.getBusinessDea());//交易类型（购买，退款)  1：购买 0：退款
    		financeClearing.setCur(financeReconciliation.getCur());//币种
    		System.out.println(financeReconciliation.getTransAmt()-(financeReconciliation.getTransAmt())*0.1);
    		//根据兴知流水号查出他的实付金额，在根据规则运算
    		//根据订单类型判断： 1、普通  2、折扣 3、团购 4、秒杀 5、抽奖'
    		if(financeReconciliation.getType()==1){
    			//实物商品——分期商品全本金(全本金又分为借记卡和贷记卡，现在手续费率按照一个来)
        		financeClearing.setTransAmt((Long.valueOf((long) (financeReconciliation.getTransAmt()-(financeReconciliation.getTransAmt())*0.1))));//收银台方交易金额 -清算金额(单位：分）要计算待定。。。。。。。。。。。。。
    		}else if (financeReconciliation.getType()==2){
    			//营销活动——折扣专区本金(又分为借记卡和贷记卡，现在手续费率按照一个来)
    			financeClearing.setTransAmt((Long.valueOf((long) (financeReconciliation.getTransAmt()-(financeReconciliation.getTransAmt())*0.3))));
    		}else if(financeReconciliation.getType()==3){
    			//营销活动——团购全本金(又分为借记卡和贷记卡，现在手续费率按照一个来)
    			financeClearing.setTransAmt((Long.valueOf((long) (financeReconciliation.getTransAmt()-(financeReconciliation.getTransAmt())*0.2))));
    		}
    		System.exit(0);
    		//financeClearing.setIntegral(financeReconciliation.getTintegral());//积分
    		//financeClearing.setChannel(channel);//来源渠道（活动，抽奖等积分手动清算.......待定)
    		financeClearing.setFlag(1);//手工清算，自动清算（0：手工清算  1：自动清算）
    		//financeClearing.setPaybkNo(paybkNo);//银行卡号
    		//financeClearing.setPaybkCode(paybkCode);//开户行
    		financeClearing.setReceiptTime(financeReconciliation.getReceiptTime());//账务日期
    		financeClearing.setCreateTime(financeReconciliation.getCreateTime());//创建时间
    		list.add(financeClearing);
		}
    	//二清成功后向二清总表中添加数据
    	financeClearingDao.insertBatch(list);
	}
	/**
	 * equityPrincipal:权益商城——本金清算
	 * @return :void 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-14 上午10:43:02
	 */
	public void equityPrincipal(){
		
		
	}
	
	
	
}
