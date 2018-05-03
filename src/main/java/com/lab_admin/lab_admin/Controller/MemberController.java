package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Member;
import com.lab_admin.lab_admin.Service.MemberService;
import com.lab_admin.lab_admin.respository.MemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
//@RestController//此处用RestController测试用，实际到跳转界面的时候需要改为Controlller
public class MemberController {

    @Autowired
    private MemberRespository memberRespository;
    @Autowired
    private MemberService memberService;

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
     * 添加成员函数，
     * @param member 传入的成员信息
     * @param file 传入的成员图片信息
     * @return 添加成功之后，应该重定向到列表界面
     */
    @PostMapping(value = "/member")
    public String addMember(Member member,
                            MultipartFile file){
        //此处的result是为了测试的时候检查memberService.insertMember函数中的结果，也便于以后添加各种图片验证使用
        String result = memberService.insertMember(member,file);
        return "redirect:/members";
    }

    /**
     * 删除成员的方法 将成员删除之后，页面重定向到成员列表界面
     * 测试成功
     * @param id 传入的需要删除的成员的id
     * @return 删除后将页面重定向到member_table中
     */
//    提交请求的form表格为
//<form th:action="@{|/member/${member.getId()}|}" method="delete" th:method="delete">
//    <button type="submit" class="btn btn-primary">删除成员</button>
//</form>
    @DeleteMapping(value = "/member/{id}")
    public String deleteMember(@PathVariable("id") Integer id){
        memberRespository.delete(id);
        return "redirect:/members";
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
