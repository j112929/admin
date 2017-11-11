/**   
 * 文件名：Test.java   
 *   
 * 版本信息：   
 * 日期：2016-8-30   
 * Copyright 科匠 Corporation 2016    
 * 版权所有   
 *   
 */
package test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.appcore.util.FileUtil;
import com.appcore.util.SftpUtil;
import com.appcore.util.StringUtil;
import com.appcore.util.UUIDUtil;
import com.bluemobi.conf.ImageServerConfig;
import com.bluemobi.constant.BaseConstant;
import com.bluemobi.controller.AbstractController;

/**   
 * 此类描述的是：   
 * @author: jizhuolin   
 * @version: 2016-8-30 上午10:31:24    
 */
public class Test {
	private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
		/*String salt = UUIDUtil.getUUID().subSequence(0, 6).toString();
		System.out.println(salt);
		String str = StringUtil.md5(StringUtil.md5("111111")+salt);
		System.out.println(str);*/
		uploadImage(null, null, false);
		
	}
	public static Map<String, Object> uploadImage(MultipartFile[] files, String imageUrl, boolean isUploadToImageServer) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        for (int i = 0; i < files.length; i++) {
            LOGGER.info("fileName = " + files[i].getOriginalFilename());
            if (!files[i].isEmpty()) {
                int pre = (int) System.currentTimeMillis();
                try {
                    // 检验文件夹是否存在，不存在 就创建
                    FileUtil.makeDir(BaseConstant.BASE_IMAGE_ADDRESS + imageUrl);
                    // 文件后缀名
                    String suffix = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf(".") + 1, files[i].getOriginalFilename().length());
                    // 拿到输出流，同时重命名上传的文件
//                    String imageName = new Date().getTime() + files[i].getOriginalFilename();
                    String imageName = UUID.randomUUID().toString() + "." + suffix;
                    FileOutputStream os = new FileOutputStream(BaseConstant.BASE_IMAGE_ADDRESS + imageUrl + imageName);

                    // 拿到上传文件的输入流
                    InputStream in = files[i].getInputStream();
                    // 以写字节的方式写文件
                    int len = 0;
                    byte[] bb = new byte[4096];
                    while ((len = in.read(bb)) != -1) {
                        os.write(bb, 0, len);
                    }
                    os.flush();
                    os.close();
                    in.close();

                    // 上传图片到图片服务器
                    if (isUploadToImageServer) {
                        
                        String localFilePathName = BaseConstant.BASE_IMAGE_ADDRESS + imageUrl + imageName;
                        
                        String HOST = ImageServerConfig.HOST;
                        short PORT = ImageServerConfig.PORT;
                        String USER_NAME = ImageServerConfig.USER_NAME;
                        String PASSWORD = ImageServerConfig.PASSWORD;
                        String BASE_IMAGE_PATH = ImageServerConfig.BASE_IMAGE_PATH;
                        SftpUtil.upload(HOST, PORT, USER_NAME, PASSWORD, localFilePathName, BASE_IMAGE_PATH + imageUrl, imageName);
                    }
                    
//                    File file = new File(BaseConstant.BASE_IMAGE_ADDRESS + imageUrl + imageName);
//                    String fileMD5 = FileUtil.md5(file);
                    resultMap.put("hashcode", imageName.substring(0, imageName.indexOf(".")));
//                    imageName = fileMD5 + "." + suffix;
//                    File renameFile = new File(BaseConstant.BASE_IMAGE_ADDRESS + imageUrl + imageName);
//                    file.renameTo(renameFile);
                    resultMap.put("imageUrl", imageUrl + imageName);
                    
                    int finaltime = (int) System.currentTimeMillis();
                    LOGGER.info("消耗时间：", finaltime - pre);
                    resultMap.put("flag", true);
                } catch (Exception e) {
                    LOGGER.error("上传出错,错误信息：【{}】", e);
                    resultMap.put("flag", false);
                }
            }
        }
        return resultMap;
    }
}
