package com.bluemobi.service.goods;

import java.util.Map;

import com.appcore.page.Page;
import com.appcore.service.MybatisBaseService;

import com.bluemobi.po.goods.GoodsSpu;
import com.bluemobi.to.goods.GoodsSpuTO;
import com.bluemobi.to.white.ContentTO;


/**
 * 【商品spu】 服务类 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public interface GoodsSpuService extends MybatisBaseService {
	/**
	 * 查询对应白名单的商品信息
	 * @param paramMap
	 * @return
	 */
	public Page<ContentTO> pageRelatedSearch(Map<String,Object> paramMap,int pageIndex, int pageSize);
	/**
	 * 查询对应白名单的商品信息条数
	 * @param paramMap
	 * @return
	 */
	public Integer pageCount2(Map<String,Object> paramMap);


	void insertSpu(GoodsSpu goodsSpu, GoodsSpuTO goodsSpuTO) throws Exception;

}
