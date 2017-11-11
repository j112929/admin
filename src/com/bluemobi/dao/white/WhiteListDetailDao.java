package com.bluemobi.dao.white;

import com.appcore.dao.MyBatisBaseDao;

/**
 * 【白名单明细表】 数据访问对象 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public interface WhiteListDetailDao extends MyBatisBaseDao {
	public <P> int deleteRelated(P var1);
}
