package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Member;
import com.lab_admin.lab_admin.respository.MemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/")
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

    @RequestMapping("/add_sliderimage")
    public String add_sliderimage(){
        return "add_sliderimage";
    }

//
//    @RequestMapping("/member_table")
//    public String member_table(Model model){
//        System.out.println("进入member_table函数");
//        List<Member> memberList = memberRespository.findAll();
//        model.addAttribute("memberList",memberList);
//        return "member_table";
//    }
//
//    @RequestMapping("/edit")
//    public String edit_member(@RequestParam("id") Integer id,
//                               Model model){
//        System.out.println("/edit/{id} 接收到的消息为"+id.toString());
////        Member member = memberRespository.findOne(id);
////        model.addAttribute("member",member);
//        return "form-advanced";
//    }


}
