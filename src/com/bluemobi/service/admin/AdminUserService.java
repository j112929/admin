package com.bluemobi.service.admin;


import java.util.List;

import com.appcore.service.MybatisBaseService;
import com.bluemobi.po.admin.AdminUser;
import com.bluemobi.to.admin.AdminMenuTO;

/**
 * 【后台用户】 服务类 接口
 * @author AutoCode 309444359@qq.com
 * @date 2015-07-28 15:14:39
 *
 */
public interface AdminUserService extends MybatisBaseService{    
    
    
    void insertUser(AdminUser adminUser);

    void updateUser(AdminUser user);
    
    void deleteUser(int userid);
    
    /**
     * 根据tokenId查询用户, 用于自动登录
     * 
     * @author haojian
     * @date 2016-6-24 下午2:16:26
     * @param userName
     * @return
     * @return AdminUser
     */
    AdminUser selectUserByTokenId(String tokenId);
    
	/**
	 * 获取用户菜单列表
	 * @author haoj 309444359@qq.com
	 * @date 2016-9-11 下午9:59:29
	 * @param userId
	 * @param merchantId 平台商户id传 0 
	 * @return
	 */
	List<AdminMenuTO> selectAdminMenuTOList(int userId, int merchantId);
    
}

