package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Activity;
import com.lab_admin.lab_admin.respository.ActivityRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 处理Activity相关的RESTFUL请求的Controller类
 */
@RestController
public class ActivityController {
    @Autowired
    private ActivityRespository activityRespository;

    /**
     * 响应连接为/activities的GET请求的函数
     * 负责从数据库中获取所有的Activity，然后将数据放到Modle中
     * @return
     */
    @GetMapping("/activities")
    public String activitiesList(Model model){
        List<Activity> activityList = activityRespository.findAll();
        model.addAttribute("activityList",activityList);

        return "";//此处应加入需要转向的页面的HTML文件
    }

}
