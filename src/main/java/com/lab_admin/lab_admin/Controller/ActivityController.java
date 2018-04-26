package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Activity;
import com.lab_admin.lab_admin.respository.ActivityRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 处理Activity相关的RESTFUL请求的Controller类
 */
@RestController//此处用RestController测试用，实际到跳转界面的时候需要改为Controlller
public class ActivityController {

    @Autowired
    private ActivityRespository activityRespository;

    /**
     * 响应连接为/activities的GET请求的函数
     * 负责从数据库中获取所有的Activity，然后将数据放到Modle中
     *
     * 测试通过
     * @return
     */
    @GetMapping("/activities")
    public String   activitiesList(Model model){
        List<Activity> activityList = activityRespository.findAll();
        model.addAttribute("activityList",activityList);

        return "";//此处应加入需要转向的页面的HTML文件
    }

    /**
     * 通过id查询一个实验室活动，并将其添加到Attribute中，然后转向activity编辑界面
     *
     * 测试通过
     * @param model
     * @param activity_id
     * @return
     */
    @GetMapping("/activity/{id}")
    public String  getActivity(Model model,
                              @PathVariable("id") Integer activity_id){
        Activity activity = activityRespository.findOne(activity_id);
        model.addAttribute("activity",activity);
        return "";
    }



    /**
     * 添加一个实验室活动的方法,添加完成之后，将页面重定向到activities，也就是转到实验室活动列表中
     * 测试通过
     * @param activity
     * @return
     */
    @PostMapping(value = "/activity")
    public String  addActivity(Activity activity){
        activityRespository.save(activity);
        return "redirect:/activities";
//        return activityRespository.save(activity);
    }

    /**
     * 通过一个activity_id删除一个实验室活动，然后重定向至/activities，也就是转到实验室活动列表中
     *
     * 测试通过
     * @param activity_id
     * @return
     */
    @DeleteMapping(value = "/activity/{id}")
    public String deleteActivity(@PathVariable("id") Integer activity_id){
        activityRespository.delete(activity_id);
        return "redirect:/activities";
    }
}
