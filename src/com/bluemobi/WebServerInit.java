package com.bluemobi;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bluemobi.conf.Config;

/**
 * 初始化缓存数据等
 * 
 * @Description
 * @author haojian 309444359@qq.com
 * @date 2015-12-15 下午3:42:16
 * 
 */
@Component(value = "webServerInit")
public class WebServerInit {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebServerInit.class);

    public boolean init(ServletContext context) {

        // beanutils 初始化设置
        ConvertUtils.register(new org.apache.commons.beanutils.converters.DateConverter(null), java.util.Date.class);
        ConvertUtils.register(new org.apache.commons.beanutils.converters.BigDecimalConverter(null), java.math.BigDecimal.class);

        //1、设置全局参数
        LOGGER.info("开始初始化【商品属性和属性值】...");
        long b = System.currentTimeMillis();
        context.setAttribute("BASE_URL",  Config.BASE_URL);
        context.setAttribute("STATIC_URL", Config.STATIC_URL);
        context.setAttribute("IMG_URL", Config.IMG_URL);
        context.setAttribute("SITE_NAME", Config.SITE_NAME);
        context.setAttribute("TEMP_IMG_URL", Config.TEMP_IMG_URL);
        long e = System.currentTimeMillis();
        LOGGER.info("初始化结束【商品属性和属性值】成功...耗时【{}】秒", new Object[] { (e - b) / 1000d });

        
        //2、设置权限基本数据
        Map<String,String> permissionMap = new LinkedHashMap<String,String>();
        permissionMap.put("index", "菜单权限");
        permissionMap.put("add", "添加");
        permissionMap.put("edit", "编辑");
        permissionMap.put("delete", "删除");
        permissionMap.put("page", "分页查询");
        permissionMap.put("detail", "查询明细");
        permissionMap.put("verify1", "一级审核");
        permissionMap.put("verify2", "二级审核");
        context.setAttribute("permissionMap", permissionMap);
        
        return true;
    }

}
