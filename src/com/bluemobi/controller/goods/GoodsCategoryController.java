package com.bluemobi.controller.goods;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.bluemobi.constant.GoodsConstant;
import com.bluemobi.controller.AbstractBackController;
import com.bluemobi.po.goods.GoodsCategory;
import com.bluemobi.po.goods.GoodsCategoryBrand;
import com.bluemobi.service.goods.GoodsBrandService;
import com.bluemobi.service.goods.GoodsCategoryBrandService;
import com.bluemobi.service.goods.GoodsCategoryService;
import com.bluemobi.service.goods.GoodsPropertyService;
import com.bluemobi.to.ResultTO;
import com.bluemobi.to.goods.FirstCategoryTO;
import com.bluemobi.to.goods.PropertyAndPropertyValueTO;
import com.bluemobi.to.goods.SecondCategoryTO;
import com.bluemobi.to.goods.ThirdCategoryTO;

/**
 * 【商品分类】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Controller
@RequestMapping("goodsCategory")
public class GoodsCategoryController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsCategoryController.class);
    
    @Autowired
    private GoodsCategoryService goodsCategoryService;
    @Autowired
	private GoodsPropertyService goodsPropertyService;
    @Autowired
	private GoodsBrandService goodsBrandService;
    @Autowired
	private GoodsCategoryBrandService goodsCategoryBrandService;
    

    /**
     * 将请求参数中的字符串转换成日期格式
     * @param request
     * @param binder
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//请求参数中的日期字符串格式
        CustomDateEditor editor = new CustomDateEditor(df, false);
        binder.registerCustomEditor(Date.class, editor);
    }
    
    /**
     * 进入【商品分类管理】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/category.index";
    }
    /**   
     * 此方法描述的是：   进入二级分类页面
     * @author: jizhuolin  
     * @version: 2016-9-1 上午11:51:25 
     * @param model
     * @return  
     */
    @RequestMapping(value = "second", method = RequestMethod.GET)
    public String secondGradeCategory(Model model){
    	// 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("grade", 1);
        model.addAttribute("allOneGradeCategory",goodsCategoryService.selectObjectList(map));
        return "goods/categorySecond.index";
    }
    /**   
     * 此方法描述的是：   进入三级分类页面
     * @author: jizhuolin  
     * @version: 2016-9-1 上午11:51:43 
     * @param model
     * @return  
     */
    @RequestMapping(value = "third", method = RequestMethod.GET)
    public String thirdGradeCategory(Model model){
    	// 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("grade", 1);
        model.addAttribute("allOneGradeCategory",goodsCategoryService.selectObjectList(map));
        Map<String, Object> mapTmp = new HashMap<String, Object>();
        mapTmp.put("grade", 2);
        model.addAttribute("allTwoGradeCategory",goodsCategoryService.selectObjectList(mapTmp));
        return "goods/categoryThird.index";
    }
    
    /**
     * 分页查询【商品一级分类】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<FirstCategoryTO> page(String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        int count = goodsCategoryService.pageCountFirst(map);
		int offset = (pageIndex - 1) * pageSize;
		map.put("offset", Integer.valueOf(offset));
		map.put("rows", Integer.valueOf(pageSize));
        List<FirstCategoryTO> list = goodsCategoryService.selectFirstCategory(map);
        Page<FirstCategoryTO> page = new Page<FirstCategoryTO>(pageIndex, pageSize, (long) count, list);
        return page;
    }
    /**   
     * 此方法描述的是：    分页查询【商品二级分类】
     * @author: jizhuolin  
     * @version: 2016-9-6 上午10:28:48 
     * @param firstCategoryName
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return  
     */
    @RequestMapping(value = "pageSecond", method = RequestMethod.POST)
    @ResponseBody
    public Page<SecondCategoryTO> secondPage(String pId,String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(!"0".equals(pId)){
        	map.put("pId",pId);
        }
        map.put("secondCategoryName", key);
        int count = goodsCategoryService.pageCountSecond(map);
		int offset = (pageIndex - 1) * pageSize;
		map.put("offset", Integer.valueOf(offset));
		map.put("rows", Integer.valueOf(pageSize));
        List<SecondCategoryTO> list = goodsCategoryService.selectSecondCategory(map);
        goodsCategoryService.addAllOneGradeCategory(list);
        Page<SecondCategoryTO> page = new Page<SecondCategoryTO>(pageIndex, pageSize, (long) count, list);
        return page;
    }

    /**   
     * 此方法描述的是：    分页查询【商品三级分类】
     * @author: jizhuolin  
     * @version: 2016-9-6 上午10:29:05 
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return  
     */
    @RequestMapping(value = "pageThird", method = RequestMethod.POST)
    @ResponseBody
    public Page<ThirdCategoryTO> thirdPage(String ppId,String pId,String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(!"0".equals(ppId)){
        	map.put("ppId", ppId);
        }
        if(!"0".equals(pId)){
        	map.put("pId", pId);
        }
        map.put("thirdCategoryName", key);
        int count = goodsCategoryService.pageCountThird(map);
		int offset = (pageIndex - 1) * pageSize;
		map.put("offset", Integer.valueOf(offset));
		map.put("rows", Integer.valueOf(pageSize));
        List<ThirdCategoryTO> list = goodsCategoryService.selectThirdCategory(map);
        Page<ThirdCategoryTO> page = new Page<ThirdCategoryTO>(pageIndex, pageSize, (long) count, list);
        return page;
    }
    
    /**
     * 查询【商品分类】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", id); 
        model.addAttribute("goodsCategory", goodsCategoryService.selectObject(map));
        return "goods/category.detail";
    }
    
    /**
     * 进入新增【商品分类】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "goods/category.edit";
    }
    @RequestMapping(value = "addSecond", method = RequestMethod.GET)
    public String addSecond(Model model) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("grade", 1); 
        model.addAttribute("allOneGradeCategory", goodsCategoryService.selectObjectList(map));
        return "goods/categorySecond.edit";
    }
    @RequestMapping(value = "addThird", method = RequestMethod.GET)
    public String addThird(Model model) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("grade", 1); 
        model.addAttribute("allOneGradeCategory", goodsCategoryService.selectObjectList(map));
        Map<String, Object> mapTmp = new HashMap<String, Object>();
        mapTmp.put("grade", 2); 
        model.addAttribute("allTwoGradeCategory", goodsCategoryService.selectObjectList(mapTmp));
        return "goods/categoryThird.edit";
    }
    /**
     * 新增【商品分类】数据
     * @param goodsCategory
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addGoodsCategory(@ModelAttribute GoodsCategory goodsCategory, BindingResult result) {
        try {
        	goodsCategory.setPId(0);
        	goodsCategory.setGrade(1);
        	goodsCategory.setStatus(1);
        	goodsCategory.setCreator(getUserId());
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	goodsCategory.setCtime(sdf.parse(sdf.format(new Date())));
        	goodsCategory.setModifier(getUserId());
        	goodsCategory.setMtime(sdf.parse(sdf.format(new Date())));
            goodsCategoryService.insert(goodsCategory);
            LOGGER.info("用户【{}】添加商品分类数据【{}】成功", new Object[] { this.getUserId(), goodsCategory } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加商品分类数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsCategory, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    @RequestMapping(value = "addSecond", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addGoodsCategorySecond(@ModelAttribute GoodsCategory goodsCategory, BindingResult result) {
        try {
        	goodsCategory.setGrade(2);
        	goodsCategory.setStatus(1);
        	goodsCategory.setCreator(getUserId());
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	goodsCategory.setCtime(sdf.parse(sdf.format(new Date())));
        	goodsCategory.setModifier(getUserId());
        	goodsCategory.setMtime(sdf.parse(sdf.format(new Date())));
            goodsCategoryService.insert(goodsCategory);
            LOGGER.info("用户【{}】添加商品分类数据【{}】成功", new Object[] { this.getUserId(), goodsCategory } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加商品分类数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsCategory, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    @RequestMapping(value = "addThird", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addGoodsCategoryThird(@RequestParam(value = "pic", required = false) MultipartFile[] pic,
    		@ModelAttribute GoodsCategory goodsCategory, BindingResult result) {
    	Map<String, Object> uploadResultMap = null;
        try {
        	goodsCategory.setGrade(3);
        	//先上传图片到服务器，再将路径增加到数据库
        	if (pic != null && pic.length > 0) {
                uploadResultMap = uploadImage(pic, GoodsConstant.BRAND_LOGO_IMAGE);
                if (uploadResultMap != null && (Boolean) uploadResultMap.get("flag")) {
                	goodsCategory.setPic(uploadResultMap.get("imageUrl").toString());
                }
            }
        	goodsCategory.setStatus(1);
        	goodsCategory.setCreator(getUserId());
        	goodsCategory.setCtime(new Date());
        	goodsCategory.setModifier(getUserId());
        	goodsCategory.setMtime(new Date());
            goodsCategoryService.insert(goodsCategory);
            LOGGER.info("用户【{}】添加商品分类数据【{}】成功", new Object[] { this.getUserId(), goodsCategory } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加商品分类数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsCategory, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【商品一级分类】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        model.addAttribute("goodsCategory", goodsCategoryService.selectObject(map));
        return "goods/category.edit";
    }
    @RequestMapping(value = "editSecond", method = RequestMethod.GET)
    public String editSecond(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        model.addAttribute("goodsCategory", goodsCategoryService.selectObject(map));
        Map<String, Object> mapTmp = new HashMap<String, Object>();
        mapTmp.put("grade", 1); 
        model.addAttribute("allOneGradeCategory", goodsCategoryService.selectObjectList(mapTmp));
        return "goods/categorySecond.edit";
    }
    @RequestMapping(value = "editThird", method = RequestMethod.GET)
    public String editThird(Model model, Integer id,String ppId) {
        // 加载公共数据
        initIndex(model);
        model.addAttribute("ppId",ppId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        model.addAttribute("goodsCategory", goodsCategoryService.selectObject(map));
        Map<String, Object> mapOne = new HashMap<String, Object>();
        mapOne.put("grade", 1); 
        model.addAttribute("allOneGradeCategory", goodsCategoryService.selectObjectList(mapOne));
        Map<String, Object> mapTwo = new HashMap<String, Object>();
        mapTwo.put("grade", 2); 
        model.addAttribute("allTwoGradeCategory", goodsCategoryService.selectObjectList(mapTwo));
        return "goods/categoryThird.edit";
    }
    /**   
     * 此方法描述的是：   选中一个一级分类，查出对应的所有二级分类(三级分类搜索框使用)
     * @author: jizhuolin  
     * @version: 2016-9-8 上午11:18:27 
     * @param model
     * @param pId
     * @return  
     */
    @RequestMapping(value = "selectTwoGrade", method = RequestMethod.POST)
    @ResponseBody
    public Model selectTwoGradeCategoryByPId(Model model,Integer pId){
    	Map<String, Object> map = new HashMap<String, Object>();
        map.put("pId", pId); 
        model.addAttribute("allTwoGradeCategory", goodsCategoryService.selectObjectList(map));
		return model;
    }
    /**   
     * 此方法描述的是：   查出对应的所有三级分类
     * @author: jizhuolin  
     * @version: 2016-9-12 下午8:36:48 
     * @param model
     * @param pId
     * @return  
     */
    @RequestMapping(value = "selectThreeGrade", method = RequestMethod.POST)
    @ResponseBody
    public Model selectThreeGradeCategoryByPId(Model model,Integer pId){
    	if(pId ==0)return null;
    	Map<String, Object> map = new HashMap<String, Object>();
        map.put("pId", pId); 
        model.addAttribute("allThreeGradeCategory", goodsCategoryService.selectObjectList(map));
		return model;
    }
    
    /**
     * 修改【商品分类】数据
     * @param goodsCategory
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editGoodsCategory(@ModelAttribute GoodsCategory goodsCategory, BindingResult result) {
        try {
            goodsCategoryService.update(goodsCategory);
            LOGGER.info("用户【{}】修改商品分类数据【{}】成功", new Object[] { this.getUserId(), goodsCategory } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改商品分类数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsCategory, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    @RequestMapping(value = "editSecond", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editGoodsCategorySecond(@ModelAttribute GoodsCategory goodsCategory, BindingResult result) {
        try {
            goodsCategoryService.update(goodsCategory);
            LOGGER.info("用户【{}】修改商品分类数据【{}】成功", new Object[] { this.getUserId(), goodsCategory } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改商品分类数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsCategory, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    @RequestMapping(value = "editThird", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editGoodsCategoryThird(@RequestParam(value = "pic", required = false) MultipartFile[] pic,
    		@ModelAttribute GoodsCategory goodsCategory, BindingResult result) {
    	Map<String, Object> uploadResultMap = null;
        try {
        	//先上传图片到服务器，再将路径增加到数据库
        	if (pic != null && pic.length > 0) {
                uploadResultMap = uploadImage(pic, GoodsConstant.BRAND_LOGO_IMAGE);
                if (uploadResultMap != null && (Boolean) uploadResultMap.get("flag")) {
                	goodsCategory.setPic(uploadResultMap.get("imageUrl").toString());
                }else{
                	goodsCategory.setPic("");
                }
            }
            goodsCategoryService.update(goodsCategory);
            LOGGER.info("用户【{}】修改商品分类数据【{}】成功", new Object[] { this.getUserId(), goodsCategory } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改商品分类数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), goodsCategory, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【商品分类】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-08
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteGoodsCategory(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            goodsCategoryService.delete(map);
            LOGGER.info("用户【{}】删除商品分类数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除商品分类数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    /**   
     * 此方法描述的是：   进入分类绑定属性页面
     * @author: jizhuolin  
     * @version: 2016-8-31 上午9:31:31 
     * @param model
     * @param id
     * @return  
     */
    @RequestMapping(value = "bindProperty", method = RequestMethod.GET)
    public String bindProperty(Model model,Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        GoodsCategory category = goodsCategoryService.selectObject(map);
        model.addAttribute("category",category);
        //查询所有属性、属性值用于列表展示
        List<Map<String, Object>> propAndVallist = goodsPropertyService.selectPropertyAndPropertyValue(null);
        model.addAttribute("goodsPropertyList", propAndVallist);
        
        List<Map<String, Object>> properties = new ArrayList<Map<String, Object>>();
        goodsCategoryService.bindProp(map, properties);
        
        //已绑定的属性
        model.addAttribute("propertiesBinded",properties);
        LOGGER.info("用户【{}】跳转分类【{}】绑定属性页面", new Object[] { getUserId(), id });
        return "goods/category.bindProperty";
    }

	
    /**   
     * 此方法描述的是：   分类绑定属性
     * @author: jizhuolin  
     * @version: 2016-8-31 上午9:31:54 
     * @param propertyIds
     * @param id 分类Id
     * @return  
     */
    @RequestMapping(value = "bindProperty", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO bindProperty(String propertyIds, Integer id) {
        try {
        	goodsPropertyService.updateBindProperty(propertyIds, id);
            LOGGER.info("用户【{}】绑定商品属性数据【{}】成功", new Object[] { this.getUserId(),id, propertyIds});
        } catch (Exception e) {
            LOGGER.error("用户【{}】绑定商品属性数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, propertyIds, e });
            return ResultTO.newFailResultTO("分类绑定属性失败", null);
        }
        return ResultTO.newSuccessResultTO("分类绑定属性成功", null);
    }
}
