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
import com.bluemobi.po.goods.GoodsCategoryProperty;
import com.bluemobi.service.goods.GoodsCategoryPropertyService;
import com.bluemobi.to.ResultTO;



/**
 * 【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Controller
@RequestMapping("goodsCategoryProperty")
public class GoodsCategoryPropertyController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsCategoryPropertyController.class);
    
    @Autowired
    private GoodsCategoryPropertyService goodsCategoryPropertyService;
    

    
    /**
     * 进入【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/categoryProperty.index";
    }
    
    /**
     * 分页查询【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】
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
        Page<Map<String, Object>> page = goodsCategoryPropertyService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】详情
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
        model.addAttribute("goodsCategoryProperty", goodsCategoryPropertyService.selectObject(map));
        return "goods/categoryProperty.detail";
    }
    
    /**
     * 进入新增【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/categoryProperty.edit";
    }
    
    /**
     * 新增【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】数据
     * @param goodsCategoryProperty
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addGoodsCategoryProperty(@ModelAttribute GoodsCategoryProperty goodsCategoryProperty, BindingResult result) {
        try {
            goodsCategoryPropertyService.insert(goodsCategoryProperty);
            LOGGER.info("用户【{}】添加商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性数据【{}】成功", new Object[] { this.getUserId(), goodsCategoryProperty } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsCategoryProperty, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】页面
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
        model.addAttribute("goodsCategoryProperty", goodsCategoryPropertyService.selectObject(map));
        return "goods/categoryProperty.edit";
    }
    
    /**
     * 修改【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】数据
     * @param goodsCategoryProperty
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editGoodsCategoryProperty(@ModelAttribute GoodsCategoryProperty goodsCategoryProperty, BindingResult result) {
        try {
            goodsCategoryPropertyService.update(goodsCategoryProperty);
            LOGGER.info("用户【{}】修改商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性数据【{}】成功", new Object[] { this.getUserId(), goodsCategoryProperty } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsCategoryProperty, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteGoodsCategoryProperty(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            goodsCategoryPropertyService.delete(map);
            LOGGER.info("用户【{}】删除商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除商品分类绑定属性表，后台管理员在新增商品的时候，选好分类后，系统会自动带出当前商品的属性数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
