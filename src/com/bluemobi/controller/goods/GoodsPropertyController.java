package com.bluemobi.controller.goods;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appcore.page.Page;
import com.appcore.service.MybatisBaseService;
import com.bluemobi.controller.AbstractBackController;
import com.bluemobi.po.goods.GoodsProperty;
import com.bluemobi.po.goods.GoodsPropertyValue;
import com.bluemobi.service.goods.GoodsPropertyService;
import com.bluemobi.service.goods.GoodsPropertyValueService;
import com.bluemobi.to.ResultTO;
import com.bluemobi.to.goods.PropertyAndPropertyValueTO;



/**
 * 【商品属性基础数据表】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Controller
@RequestMapping("goodsProperty")
public class GoodsPropertyController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsPropertyController.class);
    
    @Autowired
    private GoodsPropertyService goodsPropertyService;
    @Autowired
	private GoodsPropertyValueService goodsPropertyValueService;

    /**
     * 进入【商品属性基础数据表】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/property.index";
    }
    
    /**
     * 分页查询【商品属性基础数据表】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("propertyName", key);
        int count = goodsPropertyService.pageCountPropAndVal(map);
		int offset = (pageIndex - 1) * pageSize;
		map.put("offset", Integer.valueOf(offset));
		map.put("rows", Integer.valueOf(pageSize));
        List<Map<String, Object>> propAndVallist = goodsPropertyService.selectPropertyAndPropertyValue(map);
        Page<Map<String, Object>> page = new Page<Map<String, Object>>(pageIndex, pageSize, (long) count, propAndVallist);
        return page;
    }
    
    /**   
     * 此方法描述的是：   绑定属性的页面查询
     * @author: jizhuolin  
     * @version: 2016-9-9 下午4:57:50 
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return  
     */
    @RequestMapping(value = "pageSelect", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> pageSelect(String propertyId,String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("propertyName", key);
        int count = goodsPropertyService.pageCountPropAndVal(map);
		int offset = (pageIndex - 1) * pageSize;
		map.put("offset", Integer.valueOf(offset));
		map.put("rows", Integer.valueOf(pageSize));
		
		map.put("propertyId",propertyId);
        List<Map<String, Object>> propAndPropValList = goodsPropertyService.selectPropertyAndPropertyValue(map);
        
        Page<Map<String, Object>> page = new Page<Map<String, Object>>(pageIndex, pageSize, count, propAndPropValList);
        return page;
    }
    
    /**
     * 分类绑定属性页面，修改sku属性
     * 
     * @auther zhangzheng
     * @date 2016-2-22 下午4:54:19
     * @param propertyId
     * @param status
     * @return
     */
    @RequestMapping(value = "changePropertySku", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO changePropertySku(Integer propertyId, Integer status, Integer categoryId) {
        try {
            goodsPropertyService.changePropertySku(propertyId, status, categoryId);
            LOGGER.info("用户【{}】修改sku属性【{}】修改成功", new Object[] { this.getUserId(), propertyId });
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改sku属性【{}】修改失败。Exception:【{}】", new Object[] { this.getUserId(), propertyId, e });
            return ResultTO.newFailResultTO("修改sku属性失败", null);
        }
        return ResultTO.newSuccessResultTO("修改sku属性成功", null);
    }
    /**   
     * 此方法描述的是：   修改图片属性
     * @author: jizhuolin  
     * @version: 2016-9-12 下午1:22:04 
     * @param propertyId
     * @param status
     * @param categoryId
     * @return  
     */
    @RequestMapping(value = "changePropertyPic", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO changePropertyPic(Integer propertyId, Integer status, Integer categoryId) {
        int i = 0;
        try {
            i = goodsPropertyService.changePropertyPic(propertyId, status, categoryId);
            if (i == 1) {
                return ResultTO.newFailResultTO("修改图片属性失败，只允许设置一个图片属性。", null);
            }
            LOGGER.info("用户【{}】修改图片属性【{}】修改成功", new Object[] { this.getUserId(), propertyId });
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改图片属性【{}】修改失败。Exception:【{}】", new Object[] { this.getUserId(), propertyId, e });
            return ResultTO.newFailResultTO("修改图片属性失败", null);
        }
        return ResultTO.newSuccessResultTO("修改图片属性成功", null);
    }
    /**
     * 查询【商品属性基础数据表】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", id); 
        model.addAttribute("goodsProperty", goodsPropertyService.selectObject(map));
        return "goods/property.detail";
    }
    
    /**
     * 进入新增【商品属性基础数据表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/property.edit";
    }
    
    /**
     * 新增【商品属性基础数据表】数据
     * @param goodsProperty
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addGoodsProperty(@ModelAttribute GoodsProperty goodsProperty, BindingResult result) {
        try {
        	goodsProperty.setIsSku(0);
        	goodsProperty.setIsPic(0);
            goodsPropertyService.insert(goodsProperty);
            LOGGER.info("用户【{}】添加商品属性基础数据表数据【{}】成功", new Object[] { this.getUserId(), goodsProperty } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加商品属性基础数据表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsProperty, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【商品属性基础数据表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        GoodsProperty goodsProperty = goodsPropertyService.selectObject(map);
        Map<String, Object> mapTmp = new HashMap<String, Object>();
        mapTmp.put("propertyId", id);
        List<GoodsPropertyValue> list = goodsPropertyValueService.selectObjectList(mapTmp);
        goodsProperty.setList(list);
        model.addAttribute("goodsProperty", goodsProperty);
        return "goods/property.edit";
    }
    
    /**
     * 修改【商品属性基础数据表】数据
     * @param goodsProperty
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editGoodsProperty(@ModelAttribute GoodsProperty goodsProperty, BindingResult result) {
        try {
            goodsPropertyService.update(goodsProperty);
            for (GoodsPropertyValue goodsPropertyValue : goodsProperty.getList()) {
            	goodsPropertyValue.setPropertyId(goodsProperty.getId());
            	goodsPropertyValueService.update(goodsPropertyValue);
			}
            LOGGER.info("用户【{}】修改商品属性基础数据表数据【{}】成功", new Object[] { this.getUserId(), goodsProperty } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改商品属性基础数据表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsProperty, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【商品属性基础数据表】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteGoodsProperty(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            goodsPropertyService.delete(map);
            LOGGER.info("用户【{}】删除商品属性基础数据表数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除商品属性基础数据表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
