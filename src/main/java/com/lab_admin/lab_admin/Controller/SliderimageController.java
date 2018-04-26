package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Sliderimage;
import com.lab_admin.lab_admin.respository.SliderimageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SliderimageController {
    @Autowired
    private SliderimageRespository sliderimageRespository;

    /**
     * 获取所有SliderImage的方法
     * @param model
     * @return
     */
    @GetMapping(value = "/sliderimages")
    public String sliderimagesList(Model model){
        List<Sliderimage> sliderimageList = sliderimageRespository.findAll();
        return "";
    }
}
