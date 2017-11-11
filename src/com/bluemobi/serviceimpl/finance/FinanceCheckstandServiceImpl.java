package com.bluemobi.serviceimpl.finance;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.finance.FinanceCheckstandDao;
import com.bluemobi.po.finance.FinanceCheckstand;
import com.bluemobi.service.finance.FinanceCheckstandService;
import com.bluemobi.to.finance.FinanceCheckstandTO;
/**
 * 【收银台文件数据】 服务类 实现类
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 */
@Service(value = "financeCheckstandService")
public class FinanceCheckstandServiceImpl extends MybatisBaseServiceImpl implements FinanceCheckstandService {

    @Autowired
    private FinanceCheckstandDao financeCheckstandDao;
    @Override
    public MyBatisBaseDao getDao() {
        return financeCheckstandDao;
    }

	/**
	 * insertBatch:批量插入(一清本金)全本金一清  
	 * 从收银台获取对账文件放到收银台文件数据表 ,然后在根据收银台文件数据表和订单表对比，生成对账表和批次总表 （批次总表只放一条数据，根据批次号放入）
	 * @param financeCheckstand 
	 * @return :void 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-8 下午3:50:35
	 */
	@Override
	public void insertBatch(List<FinanceCheckstand> list) {
	    	FileInputStream fis = null;
	    	InputStreamReader isr = null;
	    	BufferedReader br = null;     //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
	    	try {
				String str="";
				String file="C:\\20160808_AP0123456789012345678900_PC_ALIPAY_1\\20160808_AP0123456789012345678900_PC_ALIPAY_1.txt";
				int s=file.lastIndexOf("\\");
				String finename = file.substring(s+1, file.length());
				System.out.println(finename);
				fis =new FileInputStream(file);
				
				 // 从文件系统中的某个文件中获取字节
				isr= new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
				br=new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
				while((str = br.readLine()) != null){
					FinanceCheckstand financeCheckstand=new FinanceCheckstand();
					 String ss[]=str.split("\\|");
					 //向收银台文件数据表中添加数据
					 financeCheckstand.setAppid(ss[0]);//APPID
					 financeCheckstand.setChannelNo(ss[1]);//渠道号
					 financeCheckstand.setSno(ss[2]);//兴知付流水号
					 financeCheckstand.setMrchSno(ss[3]);//商户流水号
					 financeCheckstand.setReceiptType(Integer.parseInt(ss[4]));//账单类型
					 financeCheckstand.setImpeachType(Integer.parseInt(ss[5]));//存疑类型
					 financeCheckstand.setCur(ss[6]);//币种
					 financeCheckstand.setTransAmt(Long.parseLong(ss[7]));//交易金额
					 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					 SimpleDateFormat sdfs = new SimpleDateFormat("yyyyMMdd");
					 Date date = sdf.parse(ss[8]);
					 Date dates = sdf.parse(ss[9]);
					 Date datess = sdfs.parse(ss[10]);
					 financeCheckstand.setCreateTime(date);//创建时间
					 financeCheckstand.setPayTime(dates);//支付时间
					 financeCheckstand.setReceiptTime(datess);//账务日期
					 financeCheckstand.setBatchNo(ss[10]);//批次号（待定）
					 financeCheckstand.setFileName(finename);
					 list.add(financeCheckstand);
				}
				//获取收银台对账文件成功后添加到收银台文件数据表中
				financeCheckstandDao.insertBatch(list); 
			} catch (FileNotFoundException e) {
				 System.out.println("找不到指定文件");
			} catch(IOException e){
				 System.out.println("读取文件失败");
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("时间转换错误");
			} finally {
				try {
					  br.close();
					  isr.close();
					   fis.close();
					    // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
					} catch (IOException e) {
					    e.printStackTrace();
					   }
					  }
		
	};
	/**
	 * selectList:查询收银台表和订单表的sno'号相同的
	 * @return :void 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-8 下午5:46:35
	 */
	public List<FinanceCheckstandTO> selectList() {
		return null;
	}

	/**
	 * selectFinanceCheckstandSno:查询收银台表中有的sno号，而订单表中没有的sno号
	 * @return 
	 * @return :List<FinanceCheckstandTO> 
	 * @Creator:FENG ZHEN
	 * @Date:2016-9-13 下午3:57:57
	 */
	@Override
	public List<FinanceCheckstand> selectFinanceCheckstandSno() {
		return null;
	}

	
	
}
