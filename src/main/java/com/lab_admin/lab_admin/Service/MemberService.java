package com.lab_admin.lab_admin.Service;

import com.lab_admin.lab_admin.Bean.Member;
import com.lab_admin.lab_admin.respository.MemberRespository;
import com.lab_admin.lab_admin.utils.UploadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 对于Controller中的一些复杂逻辑应该都写在Service中
 */
@Service
public class MemberService {
    @Autowired
    private MemberRespository memberRespository;

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
    /**
     * @param file
     */
    @Transactional//数据库的事物的操作，被这个注解标注的函数中有一项事物出错的时候，本函数中的所有事物都不生效。
    public String  insertMember(Member member,
                                MultipartFile file){

        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "E://test//";
        /*
        对用户信息存储的操作
         */
        //判断如果member.getHomepage()是空的话，将他设为#，这样在展示的时候就不会报错
        if(member.getHomepage().equals("")){
            member.setHomepage("#");
        }
        //然后根据存储的路径，将路径信息存入数据库中
        member.setImagepath(filePath+fileName);
        memberRespository.save(member);
        /*
        对文件上传的操作
         */
        String result = UploadFile.upload(file,filePath);
        return result;
    }

}
