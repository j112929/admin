package com.bluemobi.controller.coupon;
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
import com.bluemobi.po.coupon.CouponTypeCategory;
import com.bluemobi.service.coupon.CouponTypeCategoryService;
import com.bluemobi.to.ResultTO;



/**
 * 【优惠券类别选择表】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:09
 * 
 */
@Controller
@RequestMapping("couponTypeCategory")
public class CouponTypeCategoryController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CouponTypeCategoryController.class);
    
    @Autowired
    private CouponTypeCategoryService couponTypeCategoryService;
    

    
    /**
     * 进入【优惠券类别选择表】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "coupon/typeCategory.index";
    }
    
    /**
     * 分页查询【优惠券类别选择表】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", key);
        Page<Map<String, Object>> page = couponTypeCategoryService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【优惠券类别选择表】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", id); 
        model.addAttribute("couponTypeCategory", couponTypeCategoryService.selectObject(map));
        return "coupon/typeCategory.detail";
    }
    
    /**
     * 进入新增【优惠券类别选择表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "coupon/typeCategory.edit";
    }
    
    /**
     * 新增【优惠券类别选择表】数据
     * @param couponTypeCategory
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addCouponTypeCategory(@ModelAttribute CouponTypeCategory couponTypeCategory, BindingResult result) {
        try {
            couponTypeCategoryService.insert(couponTypeCategory);
            LOGGER.info("用户【{}】添加优惠券类别选择表数据【{}】成功", new Object[] { this.getUserId(), couponTypeCategory } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加优惠券类别选择表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), couponTypeCategory, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【优惠券类别选择表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        model.addAttribute("couponTypeCategory", couponTypeCategoryService.selectObject(map));
        return "coupon/typeCategory.edit";
    }
    
    /**
     * 修改【优惠券类别选择表】数据
     * @param couponTypeCategory
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editCouponTypeCategory(@ModelAttribute CouponTypeCategory couponTypeCategory, BindingResult result) {
        try {
            couponTypeCategoryService.update(couponTypeCategory);
            LOGGER.info("用户【{}】修改优惠券类别选择表数据【{}】成功", new Object[] { this.getUserId(), couponTypeCategory } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改优惠券类别选择表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), couponTypeCategory, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【优惠券类别选择表】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteCouponTypeCategory(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            couponTypeCategoryService.delete(map);
            LOGGER.info("用户【{}】删除优惠券类别选择表数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除优惠券类别选择表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
