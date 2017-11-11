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
import com.bluemobi.po.bts.BtsOrderRefund;
import com.bluemobi.service.bts.BtsOrderRefundService;
import com.bluemobi.to.ResultTO;



/**
 * 【退货单表】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Controller
@RequestMapping("btsOrderRefund")
public class BtsOrderRefundController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BtsOrderRefundController.class);
    
    @Autowired
    private BtsOrderRefundService btsOrderRefundService;
    

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
     * 进入【退货单表】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "bts/orderRefund.index";
    }
    
    /**
     * 分页查询【退货单表】
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
        Page<Map<String, Object>> page = btsOrderRefundService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【退货单表】详情
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
        model.addAttribute("btsOrderRefund", btsOrderRefundService.selectObject(map));
        return "bts/orderRefund.detail";
    }
    
    /**
     * 进入新增【退货单表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "bts/orderRefund.edit";
    }
    
    /**
     * 新增【退货单表】数据
     * @param btsOrderRefund
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addBtsOrderRefund(@ModelAttribute BtsOrderRefund btsOrderRefund, BindingResult result) {
        try {
            btsOrderRefundService.insert(btsOrderRefund);
            LOGGER.info("用户【{}】添加退货单表数据【{}】成功", new Object[] { this.getUserId(), btsOrderRefund } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加退货单表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), btsOrderRefund, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【退货单表】页面
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
        model.addAttribute("btsOrderRefund", btsOrderRefundService.selectObject(map));
        return "bts/orderRefund.edit";
    }
    
    /**
     * 修改【退货单表】数据
     * @param btsOrderRefund
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editBtsOrderRefund(@ModelAttribute BtsOrderRefund btsOrderRefund, BindingResult result) {
        try {
            btsOrderRefundService.update(btsOrderRefund);
            LOGGER.info("用户【{}】修改退货单表数据【{}】成功", new Object[] { this.getUserId(), btsOrderRefund } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改退货单表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), btsOrderRefund, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【退货单表】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteBtsOrderRefund(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            btsOrderRefundService.delete(map);
            LOGGER.info("用户【{}】删除退货单表数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除退货单表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
