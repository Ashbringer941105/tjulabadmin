package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Project;
import com.lab_admin.lab_admin.respository.ProjectRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectRespository projectRespository;

    /**
     * 获得所有的Project的方法
     * @param model
     * @return
     */
    @GetMapping(value = "/projects")
    public String projectList(Model model){
        List<Project> projectList = projectRespository.findAll();
        return "";
    }
}
