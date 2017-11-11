package com.bluemobi.controller.coupon;
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
import com.bluemobi.po.coupon.CouponListing;
import com.bluemobi.service.coupon.CouponListingService;
import com.bluemobi.to.ResultTO;



/**
 * 【优惠券使用情况表】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:08
 * 
 */
@Controller
@RequestMapping("couponListing")
public class CouponListingController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CouponListingController.class);
    
    @Autowired
    private CouponListingService couponListingService;
    

    /**
     * 将请求参数中的字符串转换成日期格式
     * @param request
     * @param binder
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//请求参数中的日期字符串格式
        CustomDateEditor editor = new CustomDateEditor(df, false);
        binder.registerCustomEditor(Date.class, editor);
    }
    
    /**
     * 进入【优惠券使用情况表】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "coupon/listing.index";
    }
    
    /**
     * 分页查询【优惠券使用情况表】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", key);
        Page<Map<String, Object>> page = couponListingService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【优惠券使用情况表】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", id); 
        model.addAttribute("couponListing", couponListingService.selectObject(map));
        return "coupon/listing.detail";
    }
    
    /**
     * 进入新增【优惠券使用情况表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "coupon/listing.edit";
    }
    
    /**
     * 新增【优惠券使用情况表】数据
     * @param couponListing
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addCouponListing(@ModelAttribute CouponListing couponListing, BindingResult result) {
        try {
            couponListingService.insert(couponListing);
            LOGGER.info("用户【{}】添加优惠券使用情况表数据【{}】成功", new Object[] { this.getUserId(), couponListing } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加优惠券使用情况表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), couponListing, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【优惠券使用情况表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        model.addAttribute("couponListing", couponListingService.selectObject(map));
        return "coupon/listing.edit";
    }
    
    /**
     * 修改【优惠券使用情况表】数据
     * @param couponListing
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editCouponListing(@ModelAttribute CouponListing couponListing, BindingResult result) {
        try {
            couponListingService.update(couponListing);
            LOGGER.info("用户【{}】修改优惠券使用情况表数据【{}】成功", new Object[] { this.getUserId(), couponListing } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改优惠券使用情况表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), couponListing, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【优惠券使用情况表】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteCouponListing(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            couponListingService.delete(map);
            LOGGER.info("用户【{}】删除优惠券使用情况表数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除优惠券使用情况表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
