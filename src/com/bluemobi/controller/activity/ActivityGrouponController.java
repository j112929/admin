package com.bluemobi.controller.activity;
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
import org.springframework.data.mongodb.repository.Near;
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
import com.bluemobi.po.activity.ActivityGroupon;
import com.bluemobi.service.activity.ActivityGrouponService;
import com.bluemobi.to.ResultTO;



/**
 * 【团购活动：本金购买，平台发起】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Controller
@RequestMapping("activityGroupon")
public class ActivityGrouponController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityGrouponController.class);
    
    @Autowired
    private ActivityGrouponService activityGrouponService;
    

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
     * 进入【团购活动：本金购买，平台发起】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "activity/groupon.index";
    }
    
    /**
     * 分页查询【团购活动：本金购买，平台发起】
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
        Page<Map<String, Object>> page = activityGrouponService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【团购活动：本金购买，平台发起】详情
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
        model.addAttribute("activityGroupon", activityGrouponService.selectObject(map));
        return "activity/groupon.detail";
    }
    
    /**
     * 进入新增【团购活动：本金购买，平台发起】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "activity/groupon.edit";
    }
    
    /**
     * 新增【团购活动：本金购买，平台发起】数据
     * @param activityGroupon
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addActivityGroupon(@ModelAttribute ActivityGroupon activityGroupon, BindingResult result) {
        int userid = getUserId();
        if (userid == 0) {
            return ResultTO.newFailResultTO("非法操作！请登陆！", null);
        }
        if (null == activityGroupon.getName()|| "".equals(activityGroupon.getName())) {
            return ResultTO.newFailResultTO("缺少团购名称参数", null);
        }
        if (null == activityGroupon.getBeginTime() || "".equals(activityGroupon.getBeginTime())) {
            return ResultTO.newFailResultTO("缺少开始时间参数", null);
        }
        if (null == activityGroupon.getEndTime() || "".equals(activityGroupon.getEndTime())) {
            return ResultTO.newFailResultTO("缺少结束时间参数", null);
        }
        if (null == activityGroupon.getSkuId() || " ".equals(activityGroupon.getSkuId())) {
            return ResultTO.newFailResultTO("缺少商品信息Id参数", null);
        }
        if (null == activityGroupon.getUserCount() || " ".equals(activityGroupon.getUserCount())) {
            return ResultTO.newFailResultTO("缺少成团人数参数", null);
        }
        if (null == activityGroupon.getPrice() || " ".equals(activityGroupon.getPrice())) {
            return ResultTO.newFailResultTO("缺少本金价格参数", null);
        }
        if (null == activityGroupon.getChargeRate() || " ".equals(activityGroupon.getChargeRate())) {
            return ResultTO.newFailResultTO("缺少本金支付手续费率参数", null);
        }
        
        try {
            activityGroupon.setCreator(getUserId());
            activityGroupon.setCtime(new Date());
            activityGroupon.setIsGroupon(0);//是否成团：0、未成团 1、成团
            activityGroupon.setMtime(new Date());
            activityGroupon.setVerifyStatus(0);//审核状态：0、未审核 1、审核通过 2、审核不通过
            activityGroupon.setModifier(getUserId());
            
            activityGrouponService.insert(activityGroupon);
            LOGGER.info("用户【{}】添加团购活动：本金购买，平台发起数据【{}】成功", new Object[] { this.getUserId(), activityGroupon } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加团购活动：本金购买，平台发起数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), activityGroupon, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【团购活动：本金购买，平台发起】页面
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
        model.addAttribute("activityGroupon", activityGrouponService.selectObject(map));
        return "activity/groupon.edit";
    }
    
    /**
     * 修改【团购活动：本金购买，平台发起】数据
     * @param activityGroupon
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editActivityGroupon(@ModelAttribute ActivityGroupon activityGroupon, BindingResult result) {
        try {
            Map<String, Object> reqMap = new HashMap<String, Object>();
            reqMap.put("id", activityGroupon.getId());
            ActivityGroupon groupon = activityGrouponService.selectObject(reqMap);
            if (groupon == null) {
                return ResultTO.newFailResultTO("没有该团购信息", null);
            }
            groupon.setBeginTime(activityGroupon.getBeginTime());
            groupon.setChargeRate(activityGroupon.getChargeRate());
            groupon.setEndTime(activityGroupon.getEndTime());
            groupon.setJoinUserCount(activityGroupon.getJoinUserCount());
            groupon.setModifier(getUserId());
            groupon.setMtime(new Date());
            groupon.setName(activityGroupon.getName());
            groupon.setSkuId(activityGroupon.getSkuId());
            groupon.setPrice(activityGroupon.getPrice());
            groupon.setUserCount(activityGroupon.getUserCount());
            
            activityGrouponService.update(groupon);
            LOGGER.info("用户【{}】修改团购活动：本金购买，平台发起数据【{}】成功", new Object[] { this.getUserId(), activityGroupon } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改团购活动：本金购买，平台发起数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), activityGroupon, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【团购活动：本金购买，平台发起】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteActivityGroupon(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            activityGrouponService.delete(map);
            LOGGER.info("用户【{}】删除团购活动：本金购买，平台发起数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除团购活动：本金购买，平台发起数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
