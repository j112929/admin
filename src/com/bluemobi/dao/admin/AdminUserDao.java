package com.bluemobi.dao.admin;

import java.util.List;
import java.util.Map;

import com.appcore.dao.MyBatisBaseDao;
import com.bluemobi.po.admin.AdminUser;
import com.bluemobi.to.admin.AdminMenuTO;

/**
 * 【后台用户】 数据访问对象 接口
 * @author AutoCode 309444359@qq.com
 * @date 2015-07-28 15:14:39
 *
 */
public interface AdminUserDao extends MyBatisBaseDao{    
    
    
    /**
     * 根据tokenId查询用户，用于自动登录
     * 
     * @author haojian
     * @date 2016-6-24 下午2:09:08
     * @param param
     * @return
     * @return CasUser
     */
    AdminUser selectUserByTokenId(Map<String, Object> map);
    
    
	/**
	 * 获取用户菜单列表
	 * @author haoj 309444359@qq.com
	 * @date 2016-9-11 下午9:55:44
	 * @param map
	 * @return
	 */
	List<AdminMenuTO> selectAdminMenuTOList(Map<String,Object> map);

}


