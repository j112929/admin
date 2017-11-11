package com.bluemobi.controller.bts;
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
import com.bluemobi.po.bts.BtsOrderItems;
import com.bluemobi.service.bts.BtsOrderItemsService;
import com.bluemobi.to.ResultTO;



/**
 * 【商品订单明细表】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Controller
@RequestMapping("btsOrderItems")
public class BtsOrderItemsController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BtsOrderItemsController.class);
    
    @Autowired
    private BtsOrderItemsService btsOrderItemsService;
    

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
     * 进入【商品订单明细表】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "bts/orderItems.index";
    }
    
    /**
     * 分页查询【商品订单明细表】
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
        Page<Map<String, Object>> page = btsOrderItemsService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【商品订单明细表】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", id); 
        model.addAttribute("btsOrderItems", btsOrderItemsService.selectObject(map));
        return "bts/orderItems.detail";
    }
    
    /**
     * 进入新增【商品订单明细表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "bts/orderItems.edit";
    }
    
    /**
     * 新增【商品订单明细表】数据
     * @param btsOrderItems
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addBtsOrderItems(@ModelAttribute BtsOrderItems btsOrderItems, BindingResult result) {
        try {
            btsOrderItemsService.insert(btsOrderItems);
            LOGGER.info("用户【{}】添加商品订单明细表数据【{}】成功", new Object[] { this.getUserId(), btsOrderItems } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加商品订单明细表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), btsOrderItems, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【商品订单明细表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        model.addAttribute("btsOrderItems", btsOrderItemsService.selectObject(map));
        return "bts/orderItems.edit";
    }
    
    /**
     * 修改【商品订单明细表】数据
     * @param btsOrderItems
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editBtsOrderItems(@ModelAttribute BtsOrderItems btsOrderItems, BindingResult result) {
        try {
            btsOrderItemsService.update(btsOrderItems);
            LOGGER.info("用户【{}】修改商品订单明细表数据【{}】成功", new Object[] { this.getUserId(), btsOrderItems } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改商品订单明细表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), btsOrderItems, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【商品订单明细表】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteBtsOrderItems(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            btsOrderItemsService.delete(map);
            LOGGER.info("用户【{}】删除商品订单明细表数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除商品订单明细表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
