package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Paper;
import com.lab_admin.lab_admin.respository.PaperRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PaperController {
    @Autowired
    private PaperRespository paperRespository;

    /**
     * 获得所有的paper的list的方法，
     * @param model
     * @return
     */
    @GetMapping(value = "/papers")
    public String paperList(Model model){
        List<Paper> paperList = paperRespository.findAll();
        return  "";
    }
}
