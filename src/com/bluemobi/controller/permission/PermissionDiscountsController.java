package com.bluemobi.controller.permission;
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
import com.bluemobi.po.permission.PermissionDiscounts;
import com.bluemobi.service.permission.PermissionDiscountsService;
import com.bluemobi.to.ResultTO;



/**
 * 【优惠折扣抢购表】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-05 14:38:48
 * 
 */
@Controller
@RequestMapping("permissionDiscounts")
public class PermissionDiscountsController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionDiscountsController.class);
    
    @Autowired
    private PermissionDiscountsService permissionDiscountsService;
    

    /**
     * 将请求参数中的字符串转换成日期格式
     * @param request
     * @param binder
     * @return string
     * @author AutoCode
     * @date 2016-09-05 14:38:48
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//请求参数中的日期字符串格式
        CustomDateEditor editor = new CustomDateEditor(df, false);
        binder.registerCustomEditor(Date.class, editor);
    }
    
    /**
     * 进入【优惠折扣抢购表】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-05 14:38:48
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "permission/discounts.index";
    }
    
    /**
     * 分页查询【优惠折扣抢购表】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2016-09-05 14:38:48
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", key);
        Page<Map<String, Object>> page = permissionDiscountsService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【优惠折扣抢购表】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-05 14:38:48
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, Integer discountId) {
        // 加载公共数据
        initIndex(model);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("discountId", discountId); 
        model.addAttribute("permissionDiscounts", permissionDiscountsService.selectObject(map));
        return "permission/discounts.detail";
    }
    
    /**
     * 进入新增【优惠折扣抢购表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-05 14:38:48
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "permission/discounts.edit";
    }
    
    /**
     * 新增【优惠折扣抢购表】数据
     * @param permissionDiscounts
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-05 14:38:48
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addPermissionDiscounts(@ModelAttribute PermissionDiscounts permissionDiscounts, BindingResult result) {
        try {
            permissionDiscountsService.insert(permissionDiscounts);
            LOGGER.info("用户【{}】添加优惠折扣抢购表数据【{}】成功", new Object[] { this.getUserId(), permissionDiscounts } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加优惠折扣抢购表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), permissionDiscounts, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【优惠折扣抢购表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-05 14:38:48
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, Integer discountId) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("discountId", discountId); 
        model.addAttribute("permissionDiscounts", permissionDiscountsService.selectObject(map));
        return "permission/discounts.edit";
    }
    
    /**
     * 修改【优惠折扣抢购表】数据
     * @param permissionDiscounts
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-05 14:38:48
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editPermissionDiscounts(@ModelAttribute PermissionDiscounts permissionDiscounts, BindingResult result) {
        try {
            permissionDiscountsService.update(permissionDiscounts);
            LOGGER.info("用户【{}】修改优惠折扣抢购表数据【{}】成功", new Object[] { this.getUserId(), permissionDiscounts } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改优惠折扣抢购表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), permissionDiscounts, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【优惠折扣抢购表】数据
     * @param discountId
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-05 14:38:48
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deletePermissionDiscounts(Integer discountId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("discountId", discountId); 
            permissionDiscountsService.delete(map);
            LOGGER.info("用户【{}】删除优惠折扣抢购表数据【{}】成功", new Object[] { this.getUserId(), discountId });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除优惠折扣抢购表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), discountId, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
