package com.bluemobi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import com.bluemobi.to.ResultTO;

@Controller
@RequestMapping("")
public class CommonWebController extends AbstractBackController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonWebController.class);
	
	/**
	 * 404错误页面
	 * @author kevin
	 * @date 2015年12月14日下午1:40:43
	 * @version
	 * @param model
	 * @return
	 */
	@RequestMapping("404")
    public String pageNotFound(Model model) {
    	initIndex(model);
    	return "404";
    }

	/**
	 * 异常信息处理(目前只针对ajax的调用异常)
	 * @author kevin
	 * @date 2015年12月14日下午1:47:44
	 * @version
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("error")
    @ResponseBody
    public ResultTO parseErrorMessage(HttpServletRequest request, HttpServletResponse response) {
    	Exception ex = (Exception) request.getAttribute(DispatcherServlet.EXCEPTION_ATTRIBUTE);
    	LOGGER.error(ex.getMessage());
		return ResultTO.newFailResultTO(ex.getMessage(), null);
    }
	
	/**
     * 登陆后的主页地址
     * 
     * @author HeWeiwen 2015-6-11
     * @param model
     * @return
     */
    @RequestMapping("")
    public String getContinue(Model model) {
    	
    	LOGGER.info("进入主页面...");
    	
        // 加载公共数据
        initIndex(model);
        
        /**
         * 会员数据统计
         */
        model.addAttribute("totalUser", 99999);
        model.addAttribute("oneDayRegister", 99999);
        model.addAttribute("oneWeekRegister", 99999);
        model.addAttribute("oneMonthRegister", 99999);
        model.addAttribute("todayLogin", 99999);
        
        /**
         * 订单数据统计
         */
        model.addAttribute("totalOrder", 99999);
        model.addAttribute("waitProcessOrder", 99999);
        model.addAttribute("waitPayOrder", 99999);
        model.addAttribute("waitDeliveryOrder", 99999);
        model.addAttribute("refundOrder", 99999);
        
        /**
         * 商品数据统计
         */
        model.addAttribute("totalGoods", 99999);
        model.addAttribute("todayOnSellGoods", 99999);
        model.addAttribute("onSellGoods", 99999);
        model.addAttribute("offSellGoods", 99999);;
        
        /**
         * 帮助信息
         */
        return "index.index";
    }
}
