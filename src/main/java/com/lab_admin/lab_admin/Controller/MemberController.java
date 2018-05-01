package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Member;
import com.lab_admin.lab_admin.respository.MemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController//此处用RestController测试用，实际到跳转界面的时候需要改为Controlller
public class MemberController {
    @Autowired
    private MemberRespository memberRespository;

    /**
     * 获取所有member列表的方法
     * 测试通过
     * @param model
     * @return
     */
    @GetMapping(value = "/members")
    public String  memberList(Model model){
        List<Member> memberList = memberRespository.findAll();
        model.addAttribute("memberList",memberList);
        return "member_table";
    }

    /**
     * 通过id 获取单个成员信息
     * 测试通过
     * @param model
     * @param id
     * @return
     */
//    传递参数的方式
//<form th:action="@{|/member/${member.getId()}|}" method="get" th:method="get">
//    <button type="submit" >修改信息</button>
//</form>
    @GetMapping(value = "/member/{id}")
    public String  getMember(@PathVariable("id") Integer id,
                            Model model){
        Member member = memberRespository.findOne(id);
        model.addAttribute("member",member);
        return "test";
    }

    /**
     * 添加成员方法
     * 测试通过
     * @param member
     * @return
     */
    @PostMapping(value = "/member")
    public String addMember(Member member){
        memberRespository.save(member);
        return "";
    }

    /**
     * 删除成员的方法
     * 测试成功
     * @param id
     * @return
     */
    @DeleteMapping(value = "/member/{id}")
    public String deleteMember(@PathVariable("id") Integer id){
        memberRespository.delete(id);
        return "";
    }

    /**
     * 更新成员信息的方法，测试成功
     * @param id
     * @param member
     * @return
     */
    @PutMapping(value = "/member/update/{id}")
    public String updateMember(@PathVariable("id") Integer id,
                               Member member){
        member.setId(id);
        memberRespository.save(member);
        return "";
    }

}
