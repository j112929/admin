package com.bluemobi.controller.coupon;
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
import com.bluemobi.controller.AbstractBackController;
import com.bluemobi.po.coupon.CouponMerchant;
import com.bluemobi.service.coupon.CouponMerchantService;
import com.bluemobi.to.ResultTO;



/**
 * 【优惠券商户表】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:09
 * 
 */
@Controller
@RequestMapping("couponMerchant")
public class CouponMerchantController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CouponMerchantController.class);
    
    @Autowired
    private CouponMerchantService couponMerchantService;
    

    
    /**
     * 进入【优惠券商户表】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "coupon/merchant.index";
    }
    
    /**
     * 分页查询【优惠券商户表】
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
        Page<Map<String, Object>> page = couponMerchantService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【优惠券商户表】详情
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
        model.addAttribute("couponMerchant", couponMerchantService.selectObject(map));
        return "coupon/merchant.detail";
    }
    
    /**
     * 进入新增【优惠券商户表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "coupon/merchant.edit";
    }
    
    /**
     * 新增【优惠券商户表】数据
     * @param couponMerchant
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addCouponMerchant(@ModelAttribute CouponMerchant couponMerchant, BindingResult result) {
        try {
            couponMerchantService.insert(couponMerchant);
            LOGGER.info("用户【{}】添加优惠券商户表数据【{}】成功", new Object[] { this.getUserId(), couponMerchant } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加优惠券商户表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), couponMerchant, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【优惠券商户表】页面
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
        //获得相关属性关联
        List<Map<String,Object>> merchants = couponMerchantService.selectMapList(map);
        model.addAttribute("couponMerchant", couponMerchantService.selectObject(map));
        model.addAttribute("merchants",merchants);
       
        
        
        return "coupon/merchant.edit";
    }
    
    /**
     * 修改【优惠券商户表】数据
     * @param couponMerchant
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editCouponMerchant(@ModelAttribute CouponMerchant couponMerchant, BindingResult result) {
        try {
            couponMerchantService.update(couponMerchant);
            LOGGER.info("用户【{}】修改优惠券商户表数据【{}】成功", new Object[] { this.getUserId(), couponMerchant } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改优惠券商户表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), couponMerchant, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【优惠券商户表】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:09
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteCouponMerchant(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            couponMerchantService.delete(map);
            LOGGER.info("用户【{}】删除优惠券商户表数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除优惠券商户表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
