package com.lab_admin.lab_admin.Service;

import com.lab_admin.lab_admin.Bean.Activity;
import com.lab_admin.lab_admin.respository.ActivityRespository;
import com.lab_admin.lab_admin.utils.InsertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AcivityService {
    @Autowired
    private ActivityRespository activityRespository;

    private static final Logger logger = LoggerFactory.getLogger(AcivityService.class);

    public String insertActiviy(Activity activity,
                                MultipartFile file){
        /*
        此处定义文件路径
         */
        String filePath = "E:/test/";

//        // 获取文件名
//        String fileName = file.getOriginalFilename();
//        logger.info("上传的文件名为：" + fileName);
//        // 获取文件的后缀名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        logger.info("上传的后缀名为：" + suffixName);
//        //更改图片信息中的存储路径
//        activity.setActivity_imagepath(filePath+fileName);
//        activityRespository.save(activity);

        /*
        对文件上传的操作
         */
        InsertUtils insertUtils = new InsertUtils();
        String result =insertUtils.insertObject(activity,file,filePath);
        return result;

    }
}
