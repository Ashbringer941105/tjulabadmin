package com.lab_admin.lab_admin.utils;

import com.lab_admin.lab_admin.Service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadFile {

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    /**
     * 文件上传的函数
     * @param file 需要上传的文件
     * @param filePath 想要将文件上传的位置
     * @return 返回是否上传成功的信息
     */
    public static String upload(MultipartFile file,
                          String filePath){

        //首先判断文件是否为空
        if (file.isEmpty()) {
            return "文件为空";
        }
        //判断是否存在重名情况
        //TODO

        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
