package com.bluemobi.controller.goods;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.appcore.page.Page;
import com.bluemobi.controller.AbstractBackController;
import com.bluemobi.po.goods.GoodsCategory;
import com.bluemobi.po.goods.GoodsSpu;
import com.bluemobi.service.goods.GoodsBrandService;
import com.bluemobi.service.goods.GoodsCategoryPropertyService;
import com.bluemobi.service.goods.GoodsCategoryService;
import com.bluemobi.service.goods.GoodsPropertyService;
import com.bluemobi.service.goods.GoodsSpuService;
import com.bluemobi.to.ResultTO;
import com.bluemobi.to.goods.GoodsSpuTO;



/**
 * 【商品spu】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Controller
@RequestMapping("goodsSpu")
public class GoodsSpuController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsSpuController.class);
    
    @Autowired
    private GoodsSpuService goodsSpuService;
    @Autowired
    private GoodsBrandService goodsBrandService;
    @Autowired
    private GoodsCategoryService goodsCategoryService;
    @Autowired
    private GoodsCategoryPropertyService categoryPropertyService;
    @Autowired
    private GoodsPropertyService goodsPropertyService;
    

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
     * 进入【商品spu】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/spu.index";
    }
    
    /**
     * 分页查询【商品spu】
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
        Page<Map<String, Object>> page = goodsSpuService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【商品spu】详情
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
        model.addAttribute("goodsSpu", goodsSpuService.selectObject(map));
        return "goods/spu.detail";
    }
    
    /**
     * 进入新增【商品spu】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/spu.edit";
    }
    
    /**
     * 新增【商品spu】数据
     * @param goodsSpu
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addGoodsSpu(@ModelAttribute GoodsSpu goodsSpu,GoodsSpuTO goodsSpuTO,BindingResult result) {
        try {
            goodsSpuService.insertSpu(goodsSpu,goodsSpuTO);
            LOGGER.info("用户【{}】添加商品spu数据【{}】成功", new Object[] { this.getUserId(), goodsSpu } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加商品spu数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsSpu, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【商品spu】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "edit")
    public String edit(Model model, Integer spuId,Integer categoryId3) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        GoodsSpu goodsSpu=new GoodsSpu();
        if(spuId!=null){
        	map.put("spuId", spuId); 
        	goodsSpu=goodsSpuService.selectObject(map);
        	model.addAttribute("goodsSpu",goodsSpu);
        	categoryId3=goodsSpu.getCategoryId3();
        }
        //根据3级分类 查询属性
        map.put("categoryId", categoryId3);
        List<Map<String, Object>> properties=goodsPropertyService.selectPropertyByCategoryId(map);
        model.addAttribute("properties", properties);
        //根据三级分类  查询一二级分类
        map.clear();
        map.put("thirdCategoryId", categoryId3);
        model.addAttribute("categoryTO", goodsCategoryService.selectThreeCategoryName(map).get(0));
        //根据3级分类  查询品牌
        map.clear();
        model.addAttribute("goodsBrand", goodsBrandService.selectObjectList(map));
        return "goods/spu.edit";
    }
    
    @RequestMapping(value = "editCategory", method = RequestMethod.GET)
    public String editCategory(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        model.addAttribute("goodsCategory", goodsCategoryService.selectObjectList(map));
        return "goods/spu.edit.category";
    }
    /**
     * 
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "categoryByPid", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO categoryByPid(Model model, Integer pId) {
    	Map<String, Object> map=new HashMap<String,Object>();
    	map.put("pId", pId);
    	List<GoodsCategory> goodsCategoryList=null;
    	try {
            goodsCategoryList=goodsCategoryService.selectObjectList(map);
            LOGGER.info("用户【{}】修改商品spu数据【{}】成功", new Object[] { this.getUserId(), pId } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改商品spu数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), pId, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", goodsCategoryList);
    }
    /**
     * 修改【商品spu】数据
     * @param goodsSpu
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editGoodsSpu(@ModelAttribute GoodsSpu goodsSpu, BindingResult result) {
        try {
            goodsSpuService.update(goodsSpu);
            LOGGER.info("用户【{}】修改商品spu数据【{}】成功", new Object[] { this.getUserId(), goodsSpu } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改商品spu数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsSpu, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【商品spu】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteGoodsSpu(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            goodsSpuService.delete(map);
            LOGGER.info("用户【{}】删除商品spu数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除商品spu数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
