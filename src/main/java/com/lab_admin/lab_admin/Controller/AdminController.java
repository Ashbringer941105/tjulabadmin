package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Member;
import com.lab_admin.lab_admin.Bean.User;
import com.lab_admin.lab_admin.respository.MemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashSet;


@Controller
//@RequestMapping("/")
public class AdminController {


    @RequestMapping("/index")
    public String index(Model model){
        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model){

        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userId");
        return "redirect:/login";
    }

    @PutMapping("/loginVerify")
    public String loginVerify(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session){
        System.out.println("username is "+username+" password is "+ password);
        boolean bool = false;
        if((password.equals("123")) && (username.equals("admin"))){
            bool = true;
        }
        if (bool){
            session.setAttribute("userId",username);
            return "redirect:/index";
        } else {
            //TODO如果验证失败则向session或者model中加入相应的错误消息，帮助用户更好的解决错误。
            return "redirect:/login";
        }
    }




    @RequestMapping("/add_member")
    public String add_member(Model model){
        return "add_member";
    }

    @RequestMapping("/add_sliderimage")
    public String add_sliderimage(Model model){return  "add_sliderimage";}

    @RequestMapping("/add_activity")
    public String add_activity(Model model){return  "add_activity";}

    @RequestMapping("/add_paper")
    public String add_paper(Model model){return "add_paper";}

    @RequestMapping("/add_project")
    public String add_project(Model model){return "add_project";}



}
