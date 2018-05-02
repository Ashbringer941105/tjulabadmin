package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Paper;
import com.lab_admin.lab_admin.respository.PaperRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController//此处用RestController测试用，实际到跳转界面的时候需要改为Controlller
public class PaperController {
    @Autowired
    private PaperRespository paperRespository;

    /**
     * 获得所有的paper的list的方法，
     * @param model
     * @return
     */
    @GetMapping(value = "/papers")
    public  String paperList(Model model){
        List<Paper> paperList = paperRespository.findAll();
        model.addAttribute("paperList",paperList);
        return  "paper_table";
    }

    /**
     * 查询一个paper的方法
     * 测试通过
     * @param paper_id
     * @param model
     * @return
     */
    @GetMapping(value = "/paper/{paper_id}")
    public String getPaper(@PathVariable("paper_id") Integer paper_id,
                          Model model){
        Paper paper = paperRespository.findOne(paper_id);
        model.addAttribute("paper",paper);
        return "";
    }

    /**
     * 添加Paper的方法，
     * 测试成功，
     * @param paper
     * @return
     */
    @PostMapping(value = "/paper")
    public Paper addPaper(Paper paper){
        return paperRespository.save(paper);
    }

    /**
     * 根据id更新paper信息的函数
     * 测试成功
     * @param paper_id
     * @param paper
     * @return
     */
    @PutMapping(value = "/paper/update/{paper_id}")
    public String updatePaper(@PathVariable("paper_id") Integer paper_id,
                              Paper paper){
        paper.setPaper_id(paper_id);
        paperRespository.save(paper);
        return "";
    }

    /**
     * 根据id删除一个paper的方法，
     * 测试成功
     * @param paper_id
     * @return
     */
    @DeleteMapping(value = "/paper/{paper_id}")
    public String deletePaper(@PathVariable("paper_id") Integer paper_id){
        paperRespository.delete(paper_id);
        return "redirect:/papers";
    }
}
