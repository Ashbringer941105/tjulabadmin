package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Sliderimage;
import com.lab_admin.lab_admin.respository.SliderimageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController//此处用RestController测试用，实际到跳转界面的时候需要改为Controlller
public class SliderimageController {
    @Autowired
    private SliderimageRespository sliderimageRespository;

    /**
     * 获取所有SliderImage的方法
     * 测试成功
     * @param model
     * @return
     */
    @GetMapping(value = "/sliderimages")
    public String  sliderimagesList(Model model){
        List<Sliderimage> sliderimageList = sliderimageRespository.findAll();
        return "";
    }

    /**
     * 根据id获取单个sliderimage
     * 测试成功
     * @param sliderimage_id
     * @return
     */
    @GetMapping(value = "/sliderimage/{sliderimage_id}")
    public String getSliderimage(@PathVariable("sliderimage_id") Integer sliderimage_id){
        Sliderimage sliderimage = sliderimageRespository.findOne(sliderimage_id);
        return "";
    }

    /**
     * 添加Sliderimage图像
     * 测试成功
     * @param sliderimage
     * @return
     */
    @PostMapping(value = "/sliderimage")
    public String addSliderimage(Sliderimage sliderimage){
        sliderimageRespository.save(sliderimage);
        return "";
    }

    /**
     * 根据id更新一个轮播图片的信息
     * 测试成功
     * @param sliderimage_id
     * @param sliderimage
     * @return
     */
    @PutMapping(value = "/sliderimage/update/{sliderimage_id}")
    public String updateSliderimage(@PathVariable("sliderimage_id") Integer sliderimage_id,
                                    Sliderimage sliderimage){
        sliderimage.setSliderimage_id(sliderimage_id);
        sliderimageRespository.save(sliderimage);
        return "";
    }

    /**
     * 根据id删除一个Slideriamge图像的信息
     * 测试成功
     * @param sliderimage_id
     * @return
     */
    @DeleteMapping(value = "/sliderimage/{sliderimage_id}")
    public String deleteSliderimage(@PathVariable("sliderimage_id") Integer sliderimage_id){
        sliderimageRespository.delete(sliderimage_id);
        return "";
    }
}
