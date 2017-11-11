package com.bluemobi.service.white;

import com.appcore.service.MybatisBaseService;

/**
 * 【白名单明细表】 服务类 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public interface WhiteListDetailService extends MybatisBaseService {
	public <P> int deleteRelated(P var1);
}
