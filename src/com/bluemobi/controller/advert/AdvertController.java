package com.bluemobi.controller.advert;

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
import com.bluemobi.constant.AdvertConstant;
import com.bluemobi.controller.AbstractBackController;
import com.bluemobi.po.advert.Advert;
import com.bluemobi.service.advert.AdvertService;
import com.bluemobi.to.ResultTO;
import com.bluemobi.to.advert.AdvertQueryTO;

/**
 * 【广告表，存放广告位信息、banner信息等】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Controller
@RequestMapping("advert")
public class AdvertController extends AbstractBackController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdvertController.class);

	@Autowired
	private AdvertService advertService;

	/**
	 * 将请求参数中的字符串转换成日期格式
	 * 
	 * @param request
	 * @param binder
	 * @return string
	 * @author AutoCode
	 * @date 2016-09
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	/**
	 * 进入【广告表，存放广告位信息、banner信息等】主页
	 * 
	 * @param model
	 * @return string
	 * @author AutoCode
	 * @date 2016-09
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model) {
		// 加载公共数据
		initIndex(model);
		return "advert/advert.index";
	}

	/**
	 * 分页查询【广告表，存放广告位信息、banner信息等】
	 * 
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
	public Page<AdvertQueryTO> page(AdvertQueryTO queryTO) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", queryTO.getKey());
		map.put("position", queryTO.getPosition());
		map.put("startDate", queryTO.getStartDate());
		map.put("endDate", queryTO.getEndDate());
		Page<AdvertQueryTO> page = advertService.page(map,
				queryTO.getPageIndex(), queryTO.getPageSize());
		return page;		
	}

	/**
	 * 查询【广告表，存放广告位信息、banner信息等】详情
	 * 
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
		model.addAttribute("advert", advertService.selectObject(map));
		return "advert/advert.detail";
	}

	/**
	 * 进入新增【广告表，存放广告位信息、banner信息等】页面
	 * 
	 * @param model
	 * @return string
	 * @author AutoCode
	 * @date 2016-09
	 */
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		// 加载公共数据
		initIndex(model);
		return "advert/advert.edit";
	}

	/**
	 * 新增【广告表，存放广告位信息、banner信息等】数据
	 * 
	 * @param advert
	 * @return ResultTO
	 * @author AutoCode
	 * @date 2016-09
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public ResultTO addAdvert(Advert advert,String[] linkSkuId) {
		try {
			// 1,根据标题是否存在
			Map<String, Object> reqMap = new HashMap<String, Object>();
			reqMap.put("name", advert.getName());
			List<Advert> userList = advertService.selectObjectList(reqMap);
			if (userList.size() > 0) {
				return ResultTO.newFailResultTO("添加失败,标题重复", null);
			}
			advert.setCtime(new Date());
			advert.setMtime(new Date());
			advert.setCreator(getUserId());
			advert.setModifier(getUserId());

			advertService.insert(advert);
			LOGGER.info("用户【{}】添加广告位表数据【{}】成功", new Object[] {
					this.getUserId(), advert });
		} catch (Exception e) {
			LOGGER.error("用户【{}】添加广告位表数据【{}】失败 Exception:【{}】", new Object[] {
					this.getUserId(), advert, e });
			return ResultTO.newFailResultTO("添加失败", null);
		}
		return ResultTO.newSuccessResultTO("添加成功", null);
	}

	/**
	 * 进入修改【广告表，存放广告位信息、banner信息等】页面
	 * 
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
		Advert advert = advertService.selectObject(map);
		//商品SKU列表
		List<String> skuList = new ArrayList<String>();
		if (advert.getLinkType() == AdvertConstant.LINKTYPE_3) {
            String[] links = advert.getLink().split(",");
            for (int i = 0; i < links.length; i++) {
                skuList.add(links[i]);
            }
        }
		model.addAttribute("advert", advert);
		model.addAttribute("skuList", skuList);
		return "advert/advert.edit";
	}

	/**
	 * 修改【广告表，存放广告位信息、banner信息等】数据
	 * 
	 * @param advert
	 * @return ResultTO
	 * @author AutoCode
	 * @date 2016-09
	 */
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public ResultTO editAdvert(@ModelAttribute Advert advert,BindingResult result, Model model) {
		try {
			// 1,根据标题是否存在
			Map<String, Object> reqMap = new HashMap<String, Object>();
			reqMap.put("name", advert.getName());
			advert.setMtime(new Date());
			advertService.update(advert);
			LOGGER.info("用户【{}】修改广告表，存放广告位信息、banner信息等数据【{}】成功", new Object[] {this.getUserId(), advert });
		} catch (Exception e) {
			LOGGER.error("用户【{}】修改广告表，存放广告位信息、banner信息等数据【{}】失败 Exception:【{}】",new Object[] { this.getUserId(), advert, e });
			return ResultTO.newFailResultTO("更新失败", null);
		}
		return ResultTO.newSuccessResultTO("更新成功", null);
	}

	/**
	 * 删除【广告表，存放广告位信息、banner信息等】数据
	 * 
	 * @param id
	 * @return ResultTO
	 * @author AutoCode
	 * @date 2016-09
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultTO deleteAdvert(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		    map.put("id", id);
			advertService.delete(map);
			LOGGER.info("用户【{}】删除广告表，存放广告位信息、banner信息等数据【{}】成功", new Object[] {
					this.getUserId(), id });
		} catch (Exception e) {
			LOGGER.error(
					"用户【{}】删除广告表，存放广告位信息、banner信息等数据【{}】失败 Exception:【{}】",
					new Object[] { this.getUserId(), id, e });
			return ResultTO.newFailResultTO("删除失败", null);
		}
		return ResultTO.newSuccessResultTO("删除成功", null);
	}

	@RequestMapping(value = "uploadImage", method = RequestMethod.POST)
	@ResponseBody
	public ResultTO uploadImage(
			@RequestParam(value = "files", required = false) MultipartFile[] files) {
		Map<String, Object> uploadResultMap = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String url = "/advert/content/";
		try {
			String fileName = files[0].getOriginalFilename();
			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1,
					fileName.length());
			Integer fileSize = Integer.valueOf(files[0].getSize() + "");
			
			if (!checkSuffix(suffix)) {
				return ResultTO.newFailResultTO("图片仅支持jpg、jpeg、png、gif格式！",
						null);
			}
			if (fileSize > 20 * 1024 * 1024) {
				return ResultTO.newFailResultTO("图片应小于20M！", null);
			}
			uploadResultMap = uploadImage(files, url);
			if (uploadResultMap != null	&& (Boolean) uploadResultMap.get("flag")) {
				resultMap.put("image", uploadResultMap.get("imageUrl") + "");
			}
			LOGGER.info("用户【{}】上传图片【{}】成功", new Object[] { this.getUserId(),
					uploadResultMap.get("imageUrl") + "" });
			return ResultTO.newSuccessResultTO("上传图片成功", resultMap);
		} catch (Exception e) {
			LOGGER.error("用户【{}】上传图片失败。Exception:【{}】",
					new Object[] { this.getUserId(), e });
			return ResultTO.newFailResultTO("上传图片失败", null);
		}
	}

	private boolean checkSuffix(String suffix) {
		boolean flag = false;
		if ("png".equalsIgnoreCase(suffix) || "jpg".equalsIgnoreCase(suffix)
				|| "jpeg".equalsIgnoreCase(suffix)
				|| "gif".equalsIgnoreCase(suffix)) {
			flag = true;
		}
		return flag;
	}
}
