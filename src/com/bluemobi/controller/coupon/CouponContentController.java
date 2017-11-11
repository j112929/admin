package com.bluemobi.controller.coupon;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.appcore.page.Page;
import com.bluemobi.constant.CouponConstant;
import com.bluemobi.controller.AbstractBackController;
import com.bluemobi.po.coupon.CouponContent;
import com.bluemobi.po.goods.GoodsCategory;
import com.bluemobi.service.coupon.CouponContentService;
import com.bluemobi.service.goods.GoodsCategoryService;
import com.bluemobi.to.ResultTO;
import com.bluemobi.to.coupon.CouponQueryTO;



/**
 * 【优惠券表】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-06 17:29:08
 * 
 */
@Controller
@RequestMapping("couponContent")
public class CouponContentController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CouponContentController.class);
    
    @Autowired
    private CouponContentService couponContentService;
    @Autowired
    private GoodsCategoryService goodsCategoryService;
    
    /* 常用字符串*/
    
    
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
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//请求参数中的日期字符串格式
        CustomDateEditor editor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, editor);
    }
    
    /**
     * 进入【优惠券表】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "coupon/content.index";
    }
    
    /**
     * 分页查询【优惠券表】
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
    public Page<Map<String, Object>> page(CouponQueryTO queryTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        Page<Map<String, Object>> page = null;
        try {
        	if(queryTO.getAuditStatus() != null){        		
        		map.put("auditStatus", queryTO.getAuditStatus().byteValue());
        	}
        	if(queryTO.getCouponType() != null){
        		map.put("couponType", queryTO.getCouponType().byteValue());
        	}
        	if(queryTO.getStartDate() != null){
        		map.put("startDate", queryTO.getStartDate());
        	}
        	if(queryTO.getEndDate() != null){
        		map.put("endDate",queryTO.getEndDate()) ;
        	}
			if(queryTO !=null && !"".equals(queryTO.getCode())){
				map.put("code", queryTO.getCode());
			}
			page = couponContentService.page(map,queryTO.getPageIndex(), queryTO.getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
 //       map.put("couponType", queryTO.getCouponType()==null?null : queryTO.getCouponType().byteValue());
//        map.put("auditStatus", queryTO.getAuditStatus()==null?null : queryTO.getAuditStatus().byteValue());
//        map.put("startDate", queryTO.getStartDate());
//        map.put("endDate",queryTO.getEndDate()) ;
//        map.put("code", queryTO.getCode()); 
        return page;
    }
    
    /**
     * 查询【优惠券表】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, Integer couponId) {
        // 加载公共数据
        initIndex(model);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("couponId", couponId); 
        model.addAttribute("couponContent", couponContentService.selectObject(map));
        return "coupon/content.detail";
    }
    
    /**
     * 进入新增【优惠券表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pId", 0); 
        List<GoodsCategory> goodsCategoryList = goodsCategoryService.selectObjectList(map);
        model.addAttribute("categories", goodsCategoryList);
        return "coupon/content.edit";
    }
    
    /**
     * 新增【优惠券表】数据
     * @param couponContent
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addCouponContent(@RequestParam(value="picLogo",required=false) MultipartFile[] picLogo, @ModelAttribute CouponContent couponContent, BindingResult result) {
        Date date = new Date();
        Map<String, Object> uploadResultMap = null;
    	try {
 		if(picLogo != null && picLogo.length > 0){
    			uploadResultMap = uploadImage(picLogo,CouponConstant.COUPON_IMAGE);
    			if(uploadResultMap != null &&(Boolean)uploadResultMap.get("flag")){
    				couponContent.setPic(uploadResultMap.get("imageUrl").toString()); 
    			}
    		}
    		couponContent.setCtime(date);
    		couponContent.setMtime(date);
            couponContentService.insert(couponContent);
            LOGGER.info("用户【{}】添加优惠券表数据【{}】成功", new Object[] { this.getUserId(), couponContent } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加优惠券表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), couponContent, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【优惠券表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, Integer couponId) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("couponId", couponId); 
        model.addAttribute("couponContent", couponContentService.selectObject(map));
        return "coupon/content.edit";
    }
    
    /**
     * 修改【优惠券表】数据
     * @param couponContent
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editCouponContent(@RequestParam(value="picLogo", required=false)MultipartFile[] picLogo, @ModelAttribute CouponContent couponContent ,  BindingResult result) {
    	Date date = new Date();
    	Map<String,Object> uploadResultMap = null;
    	try {   		
    		if (picLogo != null && picLogo.length > 0) {
                uploadResultMap = uploadImage(picLogo, CouponConstant.COUPON_IMAGE);
                if (uploadResultMap != null && (Boolean) uploadResultMap.get("flag")) {
                    couponContent.setPic(uploadResultMap.get("imageUrl").toString());
                }
            }
    		couponContent.setMtime(date);
            couponContentService.update(couponContent);
            LOGGER.info("用户【{}】修改优惠券表数据【{}】成功", new Object[] { this.getUserId(), couponContent } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改优惠券表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), couponContent, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【优惠券表】数据
     * @param couponId
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-06 17:29:08
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteCouponContent(Integer couponId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("couponId", couponId); 
            couponContentService.delete(map);
            LOGGER.info("用户【{}】删除优惠券表数据【{}】成功", new Object[] { this.getUserId(), couponId });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除优惠券表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), couponId, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    /**
     * 上传图片
     * @param files
     * @param type
     * @return
     */
//    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
//    @ResponseBody
//    public ResultTO uploadImage(@RequestParam(value = "files", required = false) MultipartFile[] files) {
//        Map<String, Object> uploadResultMap = null;
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//        String url = CouponConstant.COUPON_IMAGE;
//        String imagerUrl = "";
//        try {
//            String fileName = files[0].getOriginalFilename();
//            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
//            Integer fileSize = Integer.valueOf(files[0].getSize() + "");
//            if (!checkSuffix(suffix)) {
//                return ResultTO.newFailResultTO("图片仅支持jpg、jpeg、png、gif格式！", null);
//            }
//            if (fileSize > 2 * 1024 * 1024) {
//                return ResultTO.newFailResultTO("图片应小于2M！", null);
//            }
//            	resultMap.put("inputId", "pic");
////            if (type == 1) {
////                url = MaterialConstant.MATERIAL_ICONONIMG_IMAGE;
////                resultMap.put("sort", 1);
////                resultMap.put("inputId", "big");
////            } else if (type == 0 ) {
////                url = MaterialConstant.MATERIAL_ICONOFFIMG_IMAGE;
////                resultMap.put("sort", 0);
////                resultMap.put("inputId", "small");
////            } 
//
//            uploadResultM ap = uploadImage(files, url);
//            if (uploadResultMap != null && (Boolean) uploadResultMap.get("flag")) {
//                imagerUrl = uploadResultMap.get("imageUrl") + "";
//                resultMap.put("fileUrl", imagerUrl);
//            }
//            LOGGER.info("用户【{}】上传图片【{}】成功", new Object[] { this.getUserId()});
//        } catch (Exception e) {
//            LOGGER.error("用户【{}】上传图片失败。Exception:【{}】", new Object[] { this.getUserId(), e });
//            return ResultTO.newFailResultTO("上传图片失败", null);
//        }
//        return ResultTO.newSuccessResultTO("上传图片成功", resultMap);
//    }  
//    /**
//     * 判断图片格式是否合法
//     * @param suffix
//     * @return
//     */
//    private boolean checkSuffix(String suffix) {
//        boolean flag = false;
//        if ("png".equalsIgnoreCase(suffix) || "jpg".equalsIgnoreCase(suffix) || "jpeg".equalsIgnoreCase(suffix) || "gif".equalsIgnoreCase(suffix)) {
//            flag = true;
//        }
//        return flag;
//    }
//    
}

