package com.bluemobi.dao.goods;

import java.util.List;
import java.util.Map;

import com.appcore.dao.MyBatisBaseDao;
import com.bluemobi.to.white.ContentTO;

/**
 * 【商品spu】 数据访问对象 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public interface GoodsSpuDao extends MyBatisBaseDao {
	/**
	 * 查询对应白名单的商品信息
	 * @param paramMap
	 * @return
	 */
	public List<ContentTO> pageRelatedSearch(Map<String,Object> paramMap);
	/**
	 * 查询对应白名单的商品信息条数
	 * @param paramMap
	 * @return
	 */
	public Integer pageCount2(Map<String,Object> paramMap);
	
}
