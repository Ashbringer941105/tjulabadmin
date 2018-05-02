package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Member;
import com.lab_admin.lab_admin.respository.MemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
//@RequestMapping("/")
public class AdminController {

    @Autowired
    private MemberRespository memberRespository;

    @RequestMapping("/index")
    public String index(Model model){
        return "index";
    }

    @RequestMapping("/add_member")
    public String add_member(Model model){
        return "add_member";
    }



}
