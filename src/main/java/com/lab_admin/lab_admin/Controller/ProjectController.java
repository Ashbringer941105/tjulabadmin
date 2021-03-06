package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Paper;
import com.lab_admin.lab_admin.Bean.Project;
import com.lab_admin.lab_admin.Service.ProjectService;
import com.lab_admin.lab_admin.respository.ProjectRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
//@RestController//此处用RestController测试用，实际到跳转界面的时候需要改为Controlller
public class ProjectController {
    @Autowired
    private ProjectRespository projectRespository;
    @Autowired
    private ProjectService projectService;


    /**
     * 获得所有的Project的方法
     * 测试通过
     * @param model
     * @return
     */
    @GetMapping(value = "/projects")
    public String projectList(Model model){
        List<Project> projectList = projectRespository.findAll();
        model.addAttribute("projectList",projectList);
        return "project_table";
    }

    /**
     * 通过id获取项目信息
     * 测试通过
     * TODO 关联显示单个paper信息的界面
     * @param project_id
     * @return
     */
    @GetMapping(value = "/project")
    public String getPaper(@RequestParam("project_id") Integer project_id,
                           Model model){
        Project project = projectRespository.findOne(project_id);
        model.addAttribute("project",project);
        return "show_project";
    }

    /**
     * 添加一个Project，
     * 测试成功
     * @param project
     * @return
     */
    @PostMapping(value = "/project")
    public String addProject(Project project,
                             MultipartFile file){
        String result = projectService.insertProject(project,file);
        return "redirect:/projects";
    }

    /**
     * 更新一个Project信息的方法
     * 测试成功
     *TODO 需要完善更新信息的界面和更新的服务
     * @param project_id
     * @param project
     * @return
     */
    @PutMapping(value = "/project/update/{project_id}")
    public String updateProject(@PathVariable("project_id") Integer project_id,
                                Project project,MultipartFile file){
        project.setProject_id(project_id);
        String result = projectService.insertProject(project,file);

        return "redirect:/projects";
    }

    /**
     * 根据id删除一个project的方法
     * 测试成功
     * @param project_id
     * @return
     */
    @DeleteMapping(value = "/project/{project_id}")
    public String deleteProject(@PathVariable("project_id") Integer project_id){
        projectRespository.delete(project_id);
        return "redirect:/projects";
    }

}
