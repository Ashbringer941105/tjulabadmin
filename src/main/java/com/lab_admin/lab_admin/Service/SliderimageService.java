package com.lab_admin.lab_admin.Service;

import com.lab_admin.lab_admin.Bean.Sliderimage;
import com.lab_admin.lab_admin.respository.SliderimageRespository;
import com.lab_admin.lab_admin.utils.UploadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SliderimageService {

    @Autowired
    private SliderimageRespository sliderimageRespository;

    private static final Logger logger = LoggerFactory.getLogger(SliderimageService.class);

    public String insertSliderimage(Sliderimage sliderimage,
                                    MultipartFile file){
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "E://test//";

        //更改图片信息中的存储路径
        sliderimage.setSliderimage_imagepath(filePath+fileName);
        sliderimageRespository.save(sliderimage);

        /*
        对文件上传的操作
         */
        String result = UploadFile.upload(file,filePath);
        return result;

    }
}
