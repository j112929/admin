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
import com.bluemobi.po.goods.GoodsBrand;
import com.bluemobi.service.goods.GoodsBrandService;
import com.bluemobi.service.goods.GoodsCategoryService;
import com.bluemobi.to.ResultTO;
import com.bluemobi.to.goods.CategoryTO;

/**
 * 【商品品牌表】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-08
 * 
 */
@Controller
@RequestMapping("goodsBrand")
public class GoodsBrandController extends AbstractBackController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(GoodsBrandController.class);

	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private GoodsCategoryService goodsCategoryService;

	/**
	 * 将请求参数中的字符串转换成日期格式
	 * 
	 * @param request
	 * @param binder
	 * @return string
	 * @author AutoCode
	 * @date 2016-08
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 请求参数中的日期字符串格式
		CustomDateEditor editor = new CustomDateEditor(df, false);
		binder.registerCustomEditor(Date.class, editor);
	}

	/**
	 * 进入【商品品牌表】主页
	 * 
	 * @param model
	 * @return string
	 * @author AutoCode
	 * @date 2016-08
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model) {
		// 加载公共数据
		initIndex(model);
		return "goods/brand.index";
	}

	/**
	 * 分页查询【商品品牌表】
	 * 
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
	public Page<Map<String, Object>> page(String key, int pageSize,
			int pageIndex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", key);
		Page<Map<String, Object>> page = goodsBrandService.page(map,pageIndex,pageSize);
		return page;
	}

	/**
	 * 查询【商品品牌表】详情
	 * 
	 * @param model
	 * @return string
	 * @author AutoCode
	 * @date 2016-08
	 */

	@RequestMapping(value = "bindCategory", method = RequestMethod.GET)
	public String bindCategory(Model model, Integer id) {
		// 加载公共数据
		initIndex(model);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		List list = new ArrayList();
		// 根据brandId查goods_category_brand,查到category_id(多个),根据category_id查出对应的分类，并展示在右侧
		// list.add();
		list.add(goodsCategoryService.selectThreeCategoryName(map));
		model.addAttribute("category", list);
		return "goods/brand.bindCategory";
	}

	@RequestMapping(value = "bindCategory", method = RequestMethod.POST)
	public String bind(Model model, Integer id) {
		// TODO 绑定三级分类

		return null;

	}

	/**
	 * 进入新增【商品品牌表】页面
	 * 
	 * @param model
	 * @return string
	 * @author AutoCode
	 * @date 2016-08
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		// 加载公共数据
		initIndex(model);
		return "goods/brand.edit";
	}

	/**
	 * 新增【商品品牌表】数据
	 * 
	 * @param goodsBrand
	 * @return ResultTO
	 * @author AutoCode
	 * @date 2016-08
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public ResultTO addGoodsBrand(@RequestParam(value = "pic", required = false) MultipartFile[] pic,@ModelAttribute GoodsBrand goodsBrand,
			BindingResult result) {
		Date date = new Date();
		Map<String, Object> uploadResultMap = null;
		try {
			
			if (pic != null && pic.length > 0) {
				
				//上传图片有问题
//                uploadResultMap = uploadImage(pic, GoodsConstant.BRAND_LOGO_IMAGE);
                if (uploadResultMap != null && (Boolean) uploadResultMap.get("flag")) {
                	goodsBrand.setPic(uploadResultMap.get("imageUrl").toString());
                }
            }
			goodsBrand.setCtime(date);
			goodsBrand.setMtime(date);
			goodsBrand.setSortOrder(0);
			goodsBrand.setStatus(1);
			goodsBrandService.insert(goodsBrand);
			LOGGER.info("用户【{}】添加广告位表数据【{}】成功", new Object[] {
					this.getUserId(), goodsBrand });
		} catch (Exception e) {
			LOGGER.error("用户【{}】添加广告位表数据【{}】失败 Exception:【{}】", new Object[] {
					this.getUserId(), goodsBrand, e });
			return ResultTO.newFailResultTO("添加失败", null);
		}
		return ResultTO.newSuccessResultTO("添加成功", null);
	}

	/**
	 * 进入修改【商品品牌表】页面
	 * 
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
		GoodsBrand goodsBrand = goodsBrandService.selectObject(map);
		model.addAttribute("goodsBrand", goodsBrand);
		return "goods/brand.edit";
	}

	/**
	 * 修改【商品品牌表】数据
	 * 
	 * @param goodsBrand
	 * @return ResultTO
	 * @author AutoCode
	 * @date 2016-08
	 */
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public ResultTO editGoodsBrand(
			@RequestParam(value = "pic", required = false) MultipartFile[] pic,
			@ModelAttribute GoodsBrand goodsBrand, BindingResult result) {

		Map<String, Object> uploadResultMap = null;
		try {

			if (pic != null && pic.length > 0) {
				uploadResultMap = uploadImage(pic,
						GoodsConstant.BRAND_LOGO_IMAGE);
				if (uploadResultMap != null
						&& (Boolean) uploadResultMap.get("flag")) {
					goodsBrand.setPic(uploadResultMap.get("imageUrl")
							.toString());
				}
			}
			goodsBrandService.update(goodsBrand);
			LOGGER.info("用户【{}】修改商品品牌表数据【{}】成功",
					new Object[] { this.getUserId(), goodsBrand });
		} catch (Exception e) {
			LOGGER.error("用户【{}】修改商品品牌表数据【{}】失败 Exception:【{}】", new Object[] {
					this.getUserId(), goodsBrand, e });
			return ResultTO.newFailResultTO("更新失败", null);
		}
		return ResultTO.newSuccessResultTO("更新成功", null);
	}

	/**
	 * 删除【商品品牌表】数据
	 * 
	 * @param id
	 * @return ResultTO
	 * @author AutoCode
	 * @date 2016-08
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultTO deleteGoodsBrand(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("id", id);
			goodsBrandService.delete(map);
			LOGGER.info("用户【{}】删除商品品牌表数据【{}】成功",
					new Object[] { this.getUserId(), id });
		} catch (Exception e) {
			LOGGER.error("用户【{}】删除商品品牌表数据【{}】失败 Exception:【{}】", new Object[] {
					this.getUserId(), id, e });
			return ResultTO.newFailResultTO("删除失败", null);
		}
		return ResultTO.newSuccessResultTO("删除成功", null);
	}

}
