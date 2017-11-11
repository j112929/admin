package com.bluemobi.controller.finance;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.appcore.page.Page;
import com.bluemobi.controller.AbstractBackController;
import com.bluemobi.po.finance.FinanceCheckstand;
import com.bluemobi.po.finance.FinanceClearing;
import com.bluemobi.po.finance.FinanceReconciliation;
import com.bluemobi.service.finance.FinanceCheckstandService;
import com.bluemobi.service.finance.FinanceClearingService;
import com.bluemobi.service.finance.FinanceReconciliationService;
import com.bluemobi.to.ResultTO;



/**
 * 【收银台文件数据】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Controller
@RequestMapping("financeCheckstand")
public class FinanceCheckstandController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceCheckstandController.class);
    
    @Autowired
    private FinanceCheckstandService financeCheckstandService;
    @Autowired
    private FinanceReconciliationService financeReconciliationService;
    @Autowired
    private FinanceClearingService financeClearingService;
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void insertBatch(){
    	List<FinanceCheckstand> list=new ArrayList<FinanceCheckstand>();
    	financeCheckstandService.insertBatch(list);
    }
    
    
    
    @RequestMapping(value = "tests", method = RequestMethod.GET)
    public void selectList(){
    	List<FinanceReconciliation> list=new ArrayList<FinanceReconciliation>();
    	financeReconciliationService.insertBatch(list);
    }
    @RequestMapping(value = "testss", method = RequestMethod.GET)
    public void insertBatchs(){
    	List<FinanceClearing> list=new ArrayList<FinanceClearing>();
    	financeClearingService.insertBatch(list);
    }
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
     * 进入【收银台文件数据】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "finance/checkstand.index";
    }
    
    /**
     * 分页查询【收银台文件数据】
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
        Page<Map<String, Object>> page = financeCheckstandService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【收银台文件数据】详情
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
        model.addAttribute("financeCheckstand", financeCheckstandService.selectObject(map));
        return "finance/checkstand.detail";
    }
    
    /**
     * 进入新增【收银台文件数据】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "finance/checkstand.edit";
    }
    
    /**
     * 新增【收银台文件数据】数据
     * @param financeCheckstand
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addFinanceCheckstand(@ModelAttribute FinanceCheckstand financeCheckstand, BindingResult result) {
        try {
            financeCheckstandService.insert(financeCheckstand);
            LOGGER.info("用户【{}】添加收银台文件数据数据【{}】成功", new Object[] { this.getUserId(), financeCheckstand } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加收银台文件数据数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), financeCheckstand, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【收银台文件数据】页面
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
        model.addAttribute("financeCheckstand", financeCheckstandService.selectObject(map));
        return "finance/checkstand.edit";
    }
    
    /**
     * 修改【收银台文件数据】数据
     * @param financeCheckstand
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editFinanceCheckstand(@ModelAttribute FinanceCheckstand financeCheckstand, BindingResult result) {
        try {
            financeCheckstandService.update(financeCheckstand);
            LOGGER.info("用户【{}】修改收银台文件数据数据【{}】成功", new Object[] { this.getUserId(), financeCheckstand } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改收银台文件数据数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), financeCheckstand, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【收银台文件数据】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-09
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteFinanceCheckstand(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            financeCheckstandService.delete(map);
            LOGGER.info("用户【{}】删除收银台文件数据数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除收银台文件数据数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
