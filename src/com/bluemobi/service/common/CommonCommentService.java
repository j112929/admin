package com.bluemobi.service.common;

import java.util.Map;
import com.appcore.service.MybatisBaseService;

/**
 * 【评论表】 服务类 接口
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
public interface CommonCommentService extends MybatisBaseService {

	  /**
     * 逻辑删除评论（修改status的状态）
     */
    void deleteLogic(Map<String, Object> map);
	
}
