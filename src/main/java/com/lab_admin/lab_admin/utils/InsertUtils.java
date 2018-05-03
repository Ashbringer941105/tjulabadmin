package com.lab_admin.lab_admin.utils;

import com.lab_admin.lab_admin.Bean.*;
import com.lab_admin.lab_admin.Service.MemberService;
import com.lab_admin.lab_admin.respository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class InsertUtils {

    @Autowired
    private ActivityRespository activityRespository;
    @Autowired
    private MemberRespository memberRespository;
    @Autowired
    private PaperRespository paperRespository;
    @Autowired
    private ProjectRespository projectRespository;
    @Autowired
    private SliderimageRespository sliderimageRespository;

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);


    public  String insertObject(Object object,
                               MultipartFile file,
                               String filePath){
         /*
        此处定义文件路径
         */
//        filePath = "E://test//";

        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        //更改图片信息中的存储路径

        //根据传入的object的类，执行不同的修改信息以及
        switch (object.getClass().getName()){
            case "Activity" :
                Activity activity = (Activity)object;
                activity.setActivity_imagepath(filePath+fileName);
                activityRespository.save(activity);
                break;
            case "Member":
                Member member = (Member)object;
                member.setImagepath(filePath+fileName);
                memberRespository.save(member);
                break;
            case "Paper":
                Paper paper = (Paper)object;
                paper.setPaper_imagepath(filePath+fileName);
                paperRespository.save(paper);
                break;
            case "Project":
                Project project = (Project)object;
                project.setProject_imagepath(filePath+fileName);
                projectRespository.save(project);
                break;
            case "Sliderimage":
                Sliderimage sliderimage = (Sliderimage)object;
                sliderimage.setSliderimage_imagepath(filePath+fileName);
                sliderimageRespository.save(sliderimage);
                break;
            default:
                return "输入的object错误";

        }
        /*
        对文件上传的操作
         */
//        String result = upload(file,filePath);
//        return result;
        fileName = UUID.randomUUID() + suffixName;
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

//    /**
//     * 文件上传的函数
//     * @param file 需要上传的文件
//     * @param filePath 想要将文件上传的位置
//     * @return 返回是否上传成功的信息
//     */
//    public static String upload(MultipartFile file,
//                          String filePath){
//
//        //首先判断文件是否为空
//        if (file.isEmpty()) {
//            return "文件为空";
//        }
//
////        // 获取文件名
//        String fileName = file.getOriginalFilename();
////        logger.info("上传的文件名为：" + fileName);
////        // 获取文件的后缀名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
////        logger.info("上传的后缀名为：" + suffixName);
//        // 解决中文问题，liunx下中文路径，图片显示问题
//         fileName = UUID.randomUUID() + suffixName;
//        File dest = new File(filePath + fileName);
//        // 检测是否存在目录
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(dest);
//            return "上传成功";
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "上传失败";
//    }
}
