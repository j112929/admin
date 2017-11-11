package com.bluemobi.serviceimpl.common;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.bluemobi.dao.common.CommonCommentDao;
import com.bluemobi.po.common.CommonComment;
import com.bluemobi.service.common.CommonCommentService;

/**
 * 【评论表】 服务类 实现类
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-09
 * 
 */
@Service(value = "commonCommentService")
public class CommonCommentServiceImpl extends MybatisBaseServiceImpl implements CommonCommentService {

    @Autowired
    private CommonCommentDao commonCommentDao;

    @Override
    public MyBatisBaseDao getDao() {
        return commonCommentDao;
    }

    @Override
    public void deleteLogic(Map<String, Object> map) {
    		CommonComment commentContent = commonCommentDao.selectObject(map);
            commentContent.setStatus(2);
            commonCommentDao.update(commentContent);
    }
    
}
