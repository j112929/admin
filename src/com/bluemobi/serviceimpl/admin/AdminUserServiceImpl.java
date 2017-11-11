package com.bluemobi.serviceimpl.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appcore.dao.MyBatisBaseDao;
import com.appcore.service.impl.MybatisBaseServiceImpl;
import com.appcore.util.StringUtil;
import com.appcore.util.UUIDUtil;
import com.bluemobi.dao.admin.AdminUserDao;
import com.bluemobi.po.admin.AdminUser;
import com.bluemobi.service.admin.AdminUserService;
import com.bluemobi.to.admin.AdminMenuPermissionTO;
import com.bluemobi.to.admin.AdminMenuTO;

/**
 * 【后台用户】 服务类 实现类
 * @author AutoCode 309444359@qq.com
 * @date 2015-07-17 11:22:43
 *
 */
@Service(value="adminUserService")
public class AdminUserServiceImpl extends MybatisBaseServiceImpl implements AdminUserService{
    
    @Autowired
    private AdminUserDao adminUserDao;
    
    @Override
    public MyBatisBaseDao getDao() {
        return adminUserDao;
    }

    public void insertUser(AdminUser adminUser) {
        //混淆吗
        String salt = UUIDUtil.getUUID().subSequence(0, 6).toString();
        //密码进行MD5加密
        String passwordMd5Md5 = StringUtil.md5(StringUtil.md5(adminUser.getPassword()) + salt);
                
        adminUser.setCtime(new Date());
        adminUser.setMtime(new Date());
        adminUser.setPassword(passwordMd5Md5);
        adminUser.setIsOnline(0);
        adminUser.setSalt(salt);
        
        adminUserDao.insert(adminUser);
        
    }

    public void updateUser(AdminUser user) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userid", user.getUserId());
        AdminUser adminUser = this.selectObject(map);
        String pwd = "";
        if (!"".equals(adminUser.getPassword())) {
            pwd = StringUtil.md5(user.getPassword())+adminUser.getSalt();
        }
        
        adminUser.setMtime(new Date());
        adminUser.setEmail(user.getEmail());
        adminUser.setFullname(user.getFullname());
        adminUser.setSex(user.getSex());
        adminUser.setNickname(user.getNickname());
        if (!"".equals(user.getPassword())) {
            adminUser.setPassword(StringUtil.md5(pwd));
        }
        adminUser.setStatus(user.getStatus());
        adminUser.setUserName(user.getUserName());
        
        adminUserDao.update(adminUser);
        
    }

    public void deleteUser(int userid) {
        //获得用户信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", userid);
        AdminUser user = this.selectObject(map);
        if (user!=null) {
            //删除用户对应的权限关系 
        	
        }
        //删除用户
        adminUserDao.delete(map);
        
    }
    
    
    /**
     * 根据tokenId查询用户, 用于自动登录
     * 
     * @author haojian
     * @date 2016-6-24 下午2:16:26
     * @param userName
     * @return
     * @return AdminUser
     */
    @Override
    public AdminUser selectUserByTokenId(String tokenId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tokenId", tokenId);
        AdminUser casUser = adminUserDao.selectUserByTokenId(map);
        return casUser;
    }
    
	/**
	 * 获取用户菜单列表
	 * @author haoj 309444359@qq.com
	 * @date 2016-9-11 下午9:59:29
	 * @param userId
	 * @param merchantId 平台商户id传 0 
	 * @return
	 */
	@Override
	public List<AdminMenuTO> selectAdminMenuTOList(int userId, int merchantId) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		if(merchantId!=0){
			map.put("merchantId", merchantId);
		}
		List<AdminMenuTO> list = adminUserDao.selectAdminMenuTOList(map);
		return list;
	}
    
}


