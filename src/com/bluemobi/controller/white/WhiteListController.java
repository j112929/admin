package com.bluemobi.controller.white;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.appcore.page.Page;
import com.appcore.util.FileUtil;
import com.bluemobi.controller.AbstractBackController;
import com.bluemobi.po.white.WhiteList;
import com.bluemobi.po.white.WhiteListDetail;
import com.bluemobi.po.white.WhiteListTarget;
import com.bluemobi.service.goods.GoodsCategoryService;
import com.bluemobi.service.goods.GoodsSpuService;
import com.bluemobi.service.white.WhiteListDetailService;
import com.bluemobi.service.white.WhiteListService;
import com.bluemobi.service.white.WhiteListTargetService;
import com.bluemobi.to.ResultTO;
import com.bluemobi.to.white.ContentTO;



/**
 * 【白名单主表】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Controller
@RequestMapping("whiteList")
public class WhiteListController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(WhiteListController.class);
    
    @Autowired
    private WhiteListService whiteListService;
    @Autowired
    private WhiteListDetailService whiteListDetailService;
    @Autowired
    private WhiteListTargetService whiteListTargetService;
    @Autowired
    private GoodsSpuService goodsSpuService;
    @Autowired
    private GoodsCategoryService goodsCategoryService;

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
     * 进入【白名单主表】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "white/list.index";
    }
    
    /**
     * 分页查询【白名单主表】
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
//        System.out.println(key);
    	Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", key);
        Page<Map<String,Object>> page = whiteListService.page(map,pageIndex, pageSize);
//        List<Map<String,Object>> list=page.getData();
//        for(Map<String,Object> m:list){
//       	Set<Entry<String, Object>> set=m.entrySet();
//        	for(Entry<String, Object> e:set){
//        		System.out.println("key: "+e.getKey());
//        		System.out.println("value: "+e.getValue());	
//        	}
//       }
//        Map<String, Object> m1 = new HashMap<String, Object>();
//        //List list1=null;
//        //List listTmp = new ArrayList(); 
//        for(Map<String,Object> m: list){
//        	if(m.containsKey("id")){
//	        	Integer id = (Integer)m.get("id");
//	        	m1.put("whiteListId",id);
//	        	List<WhiteListTarget> l1=whiteListTargetService.selectObjectList(m1);
//	        	System.out.println(l1);
//	        	if(l1.size()!=0){
//        	        String str="";
//		        	for(WhiteListTarget w:l1){
//		        		str+=w.getTargetId()+",";
//		        	}
//		        	//Map<String, Object> m2 = new HashMap<String, Object>();
//		        	str=str.substring(0, str.length()-1);
//		        	m.put("ok", str);
//	        	}
//	        	
////	        	m1.clear();
//        	}
//        	//list.add(whiteList);
//        }
//        //page.setData(list);
        return page;
    }
    /**
     * 查询【白名单主表】详情
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
        model.addAttribute("whiteList", whiteListService.selectObject(map));
        return "white/list.detail";
    }
    
    /**
     * 进入新增【白名单主表】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "white/list.edit";
    }
    
    /**
     * 新增【白名单主表】数据
     * @param whiteList
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addWhiteList(@ModelAttribute WhiteList whiteList, BindingResult result, MultipartFile uploadFile) {
        try {
        	whiteListService.insert(whiteList);
        	Integer id=whiteList.getId();
//        	System.out.println(id);
        	InputStream in=uploadFile.getInputStream();
        	InputStreamReader isr=new InputStreamReader(in,"utf-8");
        	BufferedReader br=new BufferedReader(isr);
        	String str =null ;
        	while((str =br.readLine())!= null){
        		WhiteListDetail w=new WhiteListDetail();
        		w.setUuid(str);
        		w.setWhiteListId(id);
        		whiteListDetailService.insert(w);
//        		System.out.println(str);
        	} 
            LOGGER.info("用户【{}】添加白名单主表数据【{}】成功", new Object[] { this.getUserId(), whiteList } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加白名单主表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), whiteList, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【白名单主表】页面
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
        model.addAttribute("whiteList", whiteListService.selectObject(map));
        return "white/list.edit";
    }
    /**
     * 修改【白名单主表】数据
     * @param whiteList
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editWhiteList(@ModelAttribute WhiteList whiteList, BindingResult result) {
        try {
            whiteListService.update(whiteList);
            LOGGER.info("用户【{}】修改白名单主表数据【{}】成功", new Object[] { this.getUserId(), whiteList } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改白名单主表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), whiteList, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【白名单主表】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteWhiteList(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            whiteListService.delete(map);
            whiteListDetailService.deleteRelated(map);
            whiteListTargetService.deleteRelated(map);
//            System.out.println("就是这个东西");
            LOGGER.info("用户【{}】删除白名单主表数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除白名单主表数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    @RequestMapping(value="upload",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> upload(MultipartFile file){
    	Map<String,Object>resultMap=new HashMap<String,Object>();
    	resultMap.put("status", 0);
    	return resultMap;
    }
    /**   
     * 此方法描述的是：   进入选择商品页面
     * @author: jizhuolin  
     * @version: 2016-9-14 下午3:53:23 
     * @param model
     * @param id
     * @return  
     */
    @RequestMapping(value="choosegoods",method=RequestMethod.GET)
    public String choosegoods(Model model, Integer id){
    	 // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("id", id); 
        //model.addAttribute("whiteList", whiteListService.selectObject(map));
        map.put("grade", 1);
        model.addAttribute("allOneGradeCategory",goodsCategoryService.selectObjectList(map));
        Map<String, Object> mapTmp = new HashMap<String, Object>();
        mapTmp.put("grade", 2);
        model.addAttribute("allTwoGradeCategory",goodsCategoryService.selectObjectList(mapTmp));
        Map<String, Object> mapTmp1 = new HashMap<String, Object>();
        mapTmp1.put("grade", 3);
        model.addAttribute("allThreeGradeCategory",goodsCategoryService.selectObjectList(mapTmp1));
        return "white/listchoosegoods";
    }
    /**   
     * 此方法描述的是：  通过白名单Id 查询商品信息
     * @author: jizhuolin  
     * @version: 2016-9-14 下午3:53:50 
     * @param id
     * @param sname
     * @param name
     * @param pageSize
     * @param pageIndex
     * @return  
     */
    @RequestMapping(value="pageRelated",method=RequestMethod.POST)
    @ResponseBody
    public Page<ContentTO> pageRelatedSearch(String id,String sname,String name, int pageSize, int pageIndex){
    	Map<String, Object> map = new HashMap<String, Object>();
    	if(!"".equals(id)&&id!=null){
    		map.put("id", id);
    	}
    	if(!"".equals(sname)&&id!=null){
    		map.put("sname",sname);
    	}
        if(!"".equals(name)&&id!=null){
        	map.put("name", name);
        }
        Page<ContentTO> page=goodsSpuService.pageRelatedSearch(map,pageIndex, pageSize);
    	return page;
    }
}
