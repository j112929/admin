package com.bluemobi.controller.goods;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appcore.page.Page;
import com.bluemobi.controller.AbstractBackController;
import com.bluemobi.po.goods.GoodsSku;
import com.bluemobi.service.goods.GoodsSkuService;
import com.bluemobi.to.ResultTO;



/**
 * 【商品sku】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Controller
@RequestMapping("goodsSku")
public class GoodsSkuController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsSkuController.class);
    
    @Autowired
    private GoodsSkuService goodsSkuService;
    

    /**
     * 将请求参数中的字符串转换成日期格式
     * @param request
     * @param binder
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//请求参数中的日期字符串格式
        CustomDateEditor editor = new CustomDateEditor(df, false);
        binder.registerCustomEditor(Date.class, editor);
    }
    
    /**
     * 进入【商品sku】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/sku.index";
    }
    
    /**
     * 分页查询【商品sku】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", key);
        Page<Map<String, Object>> page = goodsSkuService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【商品sku】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, Integer skuId) {
        // 加载公共数据
        initIndex(model);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("skuId", skuId); 
        model.addAttribute("goodsSku", goodsSkuService.selectObject(map));
        return "goods/sku.detail";
    }
    
    /**
     * 进入新增【商品sku】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/sku.edit";
    }
    
    /**
     * 新增【商品sku】数据
     * @param goodsSku
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addGoodsSku(@ModelAttribute GoodsSku goodsSku, BindingResult result) {
        try {
            goodsSkuService.insert(goodsSku);
            LOGGER.info("用户【{}】添加商品sku数据【{}】成功", new Object[] { this.getUserId(), goodsSku } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加商品sku数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsSku, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【商品sku】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, Integer skuId) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("skuId", skuId); 
        model.addAttribute("goodsSku", goodsSkuService.selectObject(map));
        return "goods/sku.edit";
    }
    
    /**
     * 修改【商品sku】数据
     * @param goodsSku
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editGoodsSku(@ModelAttribute GoodsSku goodsSku, BindingResult result) {
        try {
            goodsSkuService.update(goodsSku);
            LOGGER.info("用户【{}】修改商品sku数据【{}】成功", new Object[] { this.getUserId(), goodsSku } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改商品sku数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsSku, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【商品sku】数据
     * @param skuId
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteGoodsSku(Integer skuId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("skuId", skuId); 
            goodsSkuService.delete(map);
            LOGGER.info("用户【{}】删除商品sku数据【{}】成功", new Object[] { this.getUserId(), skuId });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除商品sku数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), skuId, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
