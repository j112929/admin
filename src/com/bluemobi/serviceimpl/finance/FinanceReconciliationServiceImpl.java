package com.bluemobi.serviceimpl.finance;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.bts.BtsOrderChildDao;
import com.bluemobi.dao.finance.FinanceBatchDao;
import com.bluemobi.dao.finance.FinanceCheckstandDao;
import com.bluemobi.dao.finance.FinanceReconciliationDao;
import com.bluemobi.po.bts.BtsOrderChild;
import com.bluemobi.po.finance.FinanceBatch;
import com.bluemobi.po.finance.FinanceCheckstand;
import com.bluemobi.po.finance.FinanceReconciliation;
import com.bluemobi.service.finance.FinanceReconciliationService;
import com.bluemobi.to.finance.FinanceCheckstandTO;
/**
 * 【对账表】 服务类 实现类
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 */
@Service(value = "financeReconciliationService")
public class FinanceReconciliationServiceImpl extends MybatisBaseServiceImpl implements FinanceReconciliationService {

    @Autowired
    private FinanceReconciliationDao financeReconciliationDao;
    @Autowired
    private FinanceBatchDao financeBatchDao;
    @Autowired
    private FinanceCheckstandDao financeCheckstandDao;
    @Autowired
    private BtsOrderChildDao btsOrderChildDao;
    @Override
    public MyBatisBaseDao getDao() {
        return financeReconciliationDao;
    }

	/**
	 * insertBatch:批量向对账表中添加数据,收银台文件数据表和订单表对比操作
	 * @param list 
	 * @return :void 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-9 下午4:42:05
	 */
	@Override
	public void insertBatch(List<FinanceReconciliation> list) {
		//查询收银台表和订单表的sno'号相同的
		List<FinanceCheckstandTO> financeCheckstandlist = financeCheckstandDao.selectList();
		for (FinanceCheckstandTO financeCheckstandTO : financeCheckstandlist) {
			System.out.println(financeCheckstandTO.getSno());
		}
		//查询收银台表中有的sno号，而订单表中没有的sno号(长款)
		List<FinanceCheckstand> financeCheckstandlistSno=financeCheckstandDao.selectFinanceCheckstandSno();
		
		for (FinanceCheckstand financeCheckstandTO : financeCheckstandlistSno) {
			System.out.println(financeCheckstandTO.getSno());
		}
		//查询订单表表中有的sno号，而收银台中没有的sno号(短款)
		List<BtsOrderChild> btsOrderChildList =btsOrderChildDao.selectBtsOrderChildSno();
		for (BtsOrderChild btsOrderChild : btsOrderChildList) {
			System.out.println(btsOrderChild.getSno());
		}	
/*		//查询商品订单子表
		List<BtsOrderChild> btsOrderChildList = btsOrderChildDao.selectList();
		*/
		FinanceBatch financeBatch =new FinanceBatch(); 
		int count=0;//成功笔数
		int count1=0;//失败笔数
		count1=financeCheckstandlistSno.size()+btsOrderChildList.size();
		System.out.println(count1);
		//自动对账
		//收银台表和订单表的sno'号相同的
		for (FinanceCheckstandTO financeCheckstandTO : financeCheckstandlist){
			FinanceReconciliation financeReconciliation=new FinanceReconciliation();
				  //对比后向对账表中添加数据
				  financeReconciliation.setBatchNo(financeCheckstandTO.getBatchNo()); //批次号
				  financeReconciliation.setSno(financeCheckstandTO.getSno());//交易流水号
				  financeReconciliation.setPayType(1);//支付方式 :1:本金 2：积分
				  financeReconciliation.setOrderNo(financeCheckstandTO.getOrderNo());//订单号
				  financeReconciliation.setCur(financeCheckstandTO.getCur());//币种
				  //financeReconciliation.setMintegral(10000);//我方交易积分
				 // financeReconciliation.setTintegral(10000);//收银台交易积分
				  financeReconciliation.setCreateTime(financeCheckstandTO.getCreateTime());//创建时间
				  financeReconciliation.setUpdateTime(new Date());//修改时间
				  financeReconciliation.setType(financeCheckstandTO.getType());//订单类型： 1、普通  2、折扣 3、团购 4、秒杀 5、抽奖'
				  financeReconciliation.setTransAmt(financeCheckstandTO.getTransAmt());//收银台交易金额(收银台文件数据表中的数据)
				  //账单类型：1-出账入账合一；2-入账；3-出账；4-存疑
				  if(financeCheckstandTO.getReceiptType()==2){
					  financeReconciliation.setBusinessDea(1);//交易类型（购买，退款） 1：购买  0：退款'
				  }else if(financeCheckstandTO.getReceiptType()==3){
					  financeReconciliation.setBusinessDea(0);//交易类型（购买，退款） 1：购买  0：退款'
				  }
				  
				  System.exit(0);
				  if(financeCheckstandTO.getTransAmt()!=null && financeCheckstandTO.getPayAmount()!=null){
					  System.out.println("没有空值");
					  financeReconciliation.setMtransAmt(Long.valueOf(financeCheckstandTO.getPayAmount()));//我方交易金额（单位：分）(从订单表中取出的数据)
					  //判断金额是否相等  收银台交易金额和订单表的实付金额也要对比较
					  if(financeCheckstandTO.getTransAmt()==Long.valueOf(financeCheckstandTO.getPayAmount())){
						  financeReconciliation.setStatus(1);//状态：1:平 2： 长款 3:短款  4：金融不一致  5:积分不一致 6：积分金额都不一致'
						  count++;
					  }else{
						  financeReconciliation.setStatus(4);//状态：1:平 2： 长款 3:短款  4：金融不一致  5:积分不一致 6：积分金额都不一致' 
						  count++;
					  }
				  }else{
					  System.out.println("有一个空值");
					  if(financeCheckstandTO.getPayAmount()==null){
						  financeReconciliation.setStatus(4);//状态：1:平 2： 长款 3:短款  4：金融不一致  5:积分不一致 6：积分金额都不一致' 
						  financeReconciliation.setMtransAmt(Long.valueOf(0));//我方交易金额（单位：分）(从订单表中取出的数据)
						  count++;
					  }
				  }

				  list.add(financeReconciliation);
			}
		     //对比后向对账表中添加数据
		 	 financeReconciliationDao.insertBatch(list);
			 //向批次总表中添加数据每天只有一条  和我们订单表对之后的结果
			 financeBatch.setBatchNo(financeCheckstandlist.get(0).getBatchNo());//批次号
			 financeBatch.setReceiptTime(financeCheckstandlist.get(0).getReceiptTime());//账务日期
			 financeBatch.setCreateTime(financeCheckstandlist.get(0).getCreateTime());//创建日期
			 financeBatch.setChanneNo(financeCheckstandlist.get(0).getChannelNo());//渠道号(待定。。。。。。)
			 financeBatch.setFileName1(financeCheckstandlist.get(0).getFileName());//文件名
			 // financeBatch.setThirdbackAmount(thirdbackAmount);//收银台支付金额
			 financeBatch.setFlag(1);//获取对账文件是否成功 ： 1：是   0：否'
			 financeBatch.setStatus(0);//状态   1：权益  0：B2C'
			 financeBatch.setSuccessTotal(count);//成功笔数
			 financeBatch.setFaileTotal(count1);//失败笔数
			 financeBatchDao.insert(financeBatch);
			 
			 //手动对账---------异常订单处理
			if(financeCheckstandlistSno.size()>0 || btsOrderChildList.size()>0){
				System.out.println("注意了！！！我要开始处理异常订单了。。。。。。。。。。");
				
			}
		
		
		
		
	}

	
	@Override
	public List<FinanceReconciliation> selectList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

}
