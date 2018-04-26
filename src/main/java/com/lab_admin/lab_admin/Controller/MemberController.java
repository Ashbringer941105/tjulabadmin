package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Member;
import com.lab_admin.lab_admin.respository.MemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberRespository memberRespository;

    /**
     * 获取所有member列表的方法
     * @param model
     * @return
     */
    @GetMapping(value = "/members")
    public String memberList(Model model){
        List<Member> memberList = memberRespository.findAll();
        return "";
    }
}
