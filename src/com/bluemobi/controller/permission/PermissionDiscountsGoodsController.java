package com.bluemobi.controller.permission;
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
import com.bluemobi.po.permission.PermissionDiscountsGoods;
import com.bluemobi.service.permission.PermissionDiscountsGoodsService;
import com.bluemobi.to.ResultTO;



/**
 * 【优惠折扣关联商品表】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09-05 14:38:49
 * 
 */
@Controller
@RequestMapping("permissionDiscountsGoods")
public class PermissionDiscountsGoodsController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionDiscountsGoodsController.class);
    
    @Autowired
    private PermissionDiscountsGoodsService permissionDiscountsGoodsService;
    

    
    /**
     * 进入【优惠折扣关联商品表】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-05 14:38:49
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "permission/discountsGoods.index";
    }
    
    /**
     * 分页查询【优惠折扣关联商品表】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2016-09-05 14:38:49
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", key);
        Page<Map<String, Object>> page = permissionDiscountsGoodsService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【优惠折扣关联商品表】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-05 14:38:49
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", id); 
        model.addAttribute("permissionDiscountsGoods", permissionDiscountsGoodsService.selectObject(map));
        return "permission/discountsGoods.detail";
    }
    
    /**
     * 进入新增【优惠折扣关联商品表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-05 14:38:49
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "permission/discountsGoods.edit";
    }
    
    /**
     * 新增【优惠折扣关联商品表】数据
     * @param permissionDiscountsGoods
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-05 14:38:49
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addPermissionDiscountsGoods(@ModelAttribute PermissionDiscountsGoods permissionDiscountsGoods, BindingResult result) {
        try {
            permissionDiscountsGoodsService.insert(permissionDiscountsGoods);
            LOGGER.info("用户【{}】添加优惠折扣关联商品表数据【{}】成功", new Object[] { this.getUserId(), permissionDiscountsGoods } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加优惠折扣关联商品表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), permissionDiscountsGoods, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【优惠折扣关联商品表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09-05 14:38:49
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        model.addAttribute("permissionDiscountsGoods", permissionDiscountsGoodsService.selectObject(map));
        return "permission/discountsGoods.edit";
    }
    
    /**
     * 修改【优惠折扣关联商品表】数据
     * @param permissionDiscountsGoods
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-05 14:38:49
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editPermissionDiscountsGoods(@ModelAttribute PermissionDiscountsGoods permissionDiscountsGoods, BindingResult result) {
        try {
            permissionDiscountsGoodsService.update(permissionDiscountsGoods);
            LOGGER.info("用户【{}】修改优惠折扣关联商品表数据【{}】成功", new Object[] { this.getUserId(), permissionDiscountsGoods } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改优惠折扣关联商品表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), permissionDiscountsGoods, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【优惠折扣关联商品表】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09-05 14:38:49
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deletePermissionDiscountsGoods(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            permissionDiscountsGoodsService.delete(map);
            LOGGER.info("用户【{}】删除优惠折扣关联商品表数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除优惠折扣关联商品表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
