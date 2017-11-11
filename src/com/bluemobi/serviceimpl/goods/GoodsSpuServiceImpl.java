package com.bluemobi.serviceimpl.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.page.Page;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsCategoryDao;
import com.bluemobi.dao.goods.GoodsSkuDao;
import com.bluemobi.dao.goods.GoodsSkuPropertyDao;
import com.bluemobi.dao.goods.GoodsSpuDao;
import com.bluemobi.dao.goods.GoodsSpuPropertyDao;
import com.bluemobi.po.goods.GoodsCategory;
import com.bluemobi.po.goods.GoodsSku;
import com.bluemobi.po.goods.GoodsSkuProperty;
import com.bluemobi.po.goods.GoodsSpu;
import com.bluemobi.po.goods.GoodsSpuProperty;
import com.bluemobi.service.goods.GoodsSpuService;
import com.bluemobi.to.goods.GoodsSpuTO;
import com.bluemobi.to.white.ContentTO;

/**
 * 【商品spu】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "goodsSpuService")
public class GoodsSpuServiceImpl extends MybatisBaseServiceImpl implements GoodsSpuService {

    @Autowired
    private GoodsSpuDao goodsSpuDao;
    @Autowired
    private GoodsSkuDao goodsSkuDao;
    @Autowired
    private GoodsSpuPropertyDao goodsSpuPropertyDao;
    @Autowired
    private GoodsSkuPropertyDao goodsSkuPropertyDao;
    @Autowired
    private GoodsCategoryDao goodsCategoryDao;
    @Override
    public MyBatisBaseDao getDao() {
        return goodsSpuDao;
    }
    @Override
    public Page<ContentTO> pageRelatedSearch(Map<String, Object> map, int pageIndex, int pageSize) {
		int count = this.pageCount2(map);
		int offset = (pageIndex - 1) * pageSize;
		map.put("offset", offset);
		map.put("rows", pageSize);
		List<ContentTO> list = goodsSpuDao.pageRelatedSearch(map);
		for (ContentTO contentTO : list) {
			Map<String,Object> mapTmp = new HashMap<String,Object>();
			mapTmp.put("id", contentTO.getCategoryId1());
			GoodsCategory goodsCategoryOne = goodsCategoryDao.selectObject(mapTmp);
			mapTmp.put("id", contentTO.getCategoryId2());
			GoodsCategory goodsCategoryTwo = goodsCategoryDao.selectObject(mapTmp);
			mapTmp.put("id", contentTO.getCategoryId3());
			GoodsCategory goodsCategoryThree = goodsCategoryDao.selectObject(mapTmp);
			String categoryNames = goodsCategoryOne.getName()+goodsCategoryTwo.getName()+goodsCategoryThree.getName();
			contentTO.setCategoryNames(categoryNames);
		}
		return new Page<ContentTO>(pageIndex, pageSize, (long) count, list);
	}
	@Override
	public Integer pageCount2(Map<String, Object> paramMap) {
		return goodsSpuDao.pageCount2(paramMap);
	}

	@Override
	@Transactional
	public void insertSpu(GoodsSpu goodsSpu, GoodsSpuTO goodsSpuTO)throws Exception {
		goodsSpuDao.insert(goodsSpu);
		//商品spu属性表
		Integer[] spuPropertyId=goodsSpuTO.getSpuPropertyId();
		for (int i = 0; i < spuPropertyId.length; i++) {
			GoodsSpuProperty gspup=new GoodsSpuProperty();
			gspup.setPropertyId(spuPropertyId[i]);
			gspup.setPropertyValueId(goodsSpuTO.getSpuPropertyValueId()[i]);
			gspup.setSpuId(goodsSpu.getSpuId());
			goodsSpuPropertyDao.insert(gspup);
		}
		//商品sku属性表
		Integer[] stock=goodsSpuTO.getStock();
		for (int i = 0; i < stock.length; i++) {
			//商品sku表
			GoodsSku sku=new GoodsSku();
			sku.setStock(stock[i]);
		     /*警戒库存*/
			sku.setStockWarn(goodsSpuTO.getStockWarn()[i]);
		     /*原价*/
			sku.setOriginalPrice(goodsSpuTO.getOriginalPrice()[i]);
		     /*本金出售价*/
			sku.setPrice(goodsSpuTO.getPrice()[i]);
		     /*本金手续费率*/ 
			sku.setChargeRate(goodsSpuTO.getChargeRate()[i]);
		     /*积分出售价*/
			sku.setPointPrice(goodsSpuTO.getPointPrice()[i]);
		     /*积分结算价*/
			sku.setSettlementPrice(goodsSpuTO.getSettlementPrice()[i]);
			goodsSkuDao.insert(sku);
			
			//商品sku属性表
			Integer[] skuPropertyId=goodsSpuTO.getSkuPropertyId();
			for (int j = 0; j < skuPropertyId.length; j++) {
				GoodsSkuProperty gskup=new GoodsSkuProperty();
				gskup.setPropertyId(skuPropertyId[j]);
				if(j==0){
					gskup.setPropertyValueId(goodsSpuTO.getGpv0()[i]);
				}else if(j==1){
					gskup.setPropertyValueId(goodsSpuTO.getGpv1()[i]);
				}else if(j==2){
					gskup.setPropertyValueId(goodsSpuTO.getGpv2()[i]);
				}
				gskup.setSkuId(sku.getSkuId());
				goodsSkuPropertyDao.insert(gskup);
			}
		}
	}
}
