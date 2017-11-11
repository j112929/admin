package com.bluemobi.controller.goods;
import java.util.HashMap;
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
import com.bluemobi.controller.AbstractBackController;
import com.bluemobi.po.goods.GoodsPropertyValue;
import com.bluemobi.service.goods.GoodsPropertyValueService;
import com.bluemobi.to.ResultTO;



/**
 * 【商品属性值】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Controller
@RequestMapping("goodsPropertyValue")
public class GoodsPropertyValueController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsPropertyValueController.class);
    
    @Autowired
    private GoodsPropertyValueService goodsPropertyValueService;
    

    
    /**
     * 进入【商品属性值】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/propertyValue.index";
    }
    
    /**
     * 分页查询【商品属性值】
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
        map.put("key", key);
        Page<Map<String, Object>> page = goodsPropertyValueService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【商品属性值】详情
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
        model.addAttribute("goodsPropertyValue", goodsPropertyValueService.selectObject(map));
        return "goods/propertyValue.detail";
    }
    
    /**
     * 进入新增【商品属性值】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/propertyValue.edit";
    }
    
    /**
     * 新增【商品属性值】数据
     * @param goodsPropertyValue
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addGoodsPropertyValue(@ModelAttribute GoodsPropertyValue goodsPropertyValue, BindingResult result) {
        try {
            goodsPropertyValueService.insert(goodsPropertyValue);
            LOGGER.info("用户【{}】添加商品属性值数据【{}】成功", new Object[] { this.getUserId(), goodsPropertyValue } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加商品属性值数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsPropertyValue, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【商品属性值】页面
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
        model.addAttribute("goodsPropertyValue", goodsPropertyValueService.selectObject(map));
        return "goods/propertyValue.edit";
    }
    
    /**
     * 修改【商品属性值】数据
     * @param goodsPropertyValue
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editGoodsPropertyValue(@ModelAttribute GoodsPropertyValue goodsPropertyValue, BindingResult result) {
        try {
            goodsPropertyValueService.update(goodsPropertyValue);
            LOGGER.info("用户【{}】修改商品属性值数据【{}】成功", new Object[] { this.getUserId(), goodsPropertyValue } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改商品属性值数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsPropertyValue, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【商品属性值】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteGoodsPropertyValue(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            goodsPropertyValueService.delete(map);
            LOGGER.info("用户【{}】删除商品属性值数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除商品属性值数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
