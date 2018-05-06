package com.lab_admin.lab_admin.utils;

import com.lab_admin.lab_admin.Bean.*;
import com.lab_admin.lab_admin.Service.MemberService;
import com.lab_admin.lab_admin.respository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/*
此处有几处注意的
1、使用 @Autowired注入Respository需要经过一下四步（）
    1）public static InsertUtils insertUtils;
    2）对这个类加上@Component注解
    3）加入public void init()函数
    4）将需要调用的函数设为static
2、可以通过object.getClass().getName()获得类的名字，
 但是需要注意，获得的类的名字是带有包名的，也就是com.lab_admin.lab_admin.Bean.Activity
 */


@Component
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

    public static InsertUtils insertUtils;
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @PostConstruct
    public void init(){
        insertUtils = this;
        insertUtils.projectRespository = this.projectRespository;
        insertUtils.activityRespository = this .activityRespository;
        insertUtils.memberRespository = this .memberRespository;
        insertUtils.paperRespository = this.paperRespository;
        insertUtils.sliderimageRespository = this.sliderimageRespository;
    }

    @Transactional
    public  String insertObject(Object object,
                               MultipartFile file,
                               String filePath){

        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        //更改图片信息中的存储路径

        fileName = UUID.randomUUID() + suffixName;
        String cc = object.getClass().getName();
        //根据传入的object的类，执行不同的修改信息以及
        switch (cc){
            case "com.lab_admin.lab_admin.Bean.Activity" :
                Activity activity = (Activity)object;
                activity.setActivity_imagepath(filePath+fileName);
                insertUtils.activityRespository.save(activity);
                break;
            case "com.lab_admin.lab_admin.Bean.Member":
                Member member = (Member)object;
                member.setImagepath(filePath+fileName);
                insertUtils.memberRespository.save(member);
                break;
            case "com.lab_admin.lab_admin.Bean.Paper":
                Paper paper = (Paper)object;
                paper.setPaper_imagepath(filePath+fileName);
                insertUtils.paperRespository.save(paper);
                break;
            case "com.lab_admin.lab_admin.Bean.Project":
                Project project = (Project)object;
                project.setProject_imagepath(filePath+fileName);
                insertUtils.projectRespository.save(project);
                break;
            case "com.lab_admin.lab_admin.Bean.Sliderimage":
                Sliderimage sliderimage = (Sliderimage)object;
                sliderimage.setSliderimage_imagepath(filePath+fileName);
                insertUtils.sliderimageRespository.save(sliderimage);
                break;
            default:
                return "输入的object错误";

        }
        /*
        对文件上传的操作
         */

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
