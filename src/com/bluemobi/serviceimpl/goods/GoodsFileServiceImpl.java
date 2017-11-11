package com.bluemobi.serviceimpl.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.goods.GoodsFileDao;
import com.bluemobi.service.goods.GoodsFileService;

/**
 * 【商品关联文件表，如sku图片、商品简介图片、视频、h5等。】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Service(value = "goodsFileService")
public class GoodsFileServiceImpl extends MybatisBaseServiceImpl implements GoodsFileService {

    @Autowired
    private GoodsFileDao goodsFileDao;

    @Override
    public MyBatisBaseDao getDao() {
        return goodsFileDao;
    }

}
