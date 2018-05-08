package com.lab_admin.lab_admin.Controller;

import com.lab_admin.lab_admin.Bean.Sliderimage;
import com.lab_admin.lab_admin.Service.SliderimageService;
import com.lab_admin.lab_admin.respository.SliderimageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
//@RestController//此处用RestController测试用，实际到跳转界面的时候需要改为Controlller
public class SliderimageController {
    @Autowired
    private SliderimageRespository sliderimageRespository;
    @Autowired
    private SliderimageService sliderimageService;

    /**
     * 获取所有SliderImage的方法，编写完成
     * 测试成功
     * @param model
     * @return
     */
    @GetMapping(value = "/sliderimages")
    public String  sliderimagesList(Model model){
        List<Sliderimage> sliderimageList = sliderimageRespository.findAll();
        model.addAttribute("sliderimageList",sliderimageList);
        return "sliderimage_table";
    }

    /**
     * 根据id 获取单个sliderimage,编写完成，TODO 关联显示单个paper信息的界面
     * 测试成功
     * @param sliderimage_id
     * @return
     */
    //对应的form表的样子是这样的
//     <form th:action="@{|/sliderimage/${sliderimage.getSliderimage_id()}|}" method="get" th:method="get">
//        <button type="submit" >修改信息</button>
//     </form>
    @GetMapping(value = "/sliderimage")
    public String getSliderimage(@RequestParam("sliderimage_id") Integer sliderimage_id,
                                 Model model){
        Sliderimage sliderimage = sliderimageRespository.findOne(sliderimage_id);
        model.addAttribute("sliderimage",sliderimage);
        return "show_sliderimage";
    }

    /**
     * 添加Sliderimage图像
     * 测试成功
     * @param sliderimage
     * @return
     */
    @PostMapping(value = "/sliderimage")
    public String addSliderimage(Sliderimage sliderimage,
                                 MultipartFile file){
        String result = sliderimageService.insertSliderimage(sliderimage,file);
        int a= 10;
        return "redirect:/sliderimages";
    }

    /**
     * 根据id更新一个轮播图片的信息
     * 测试成功
     * TODO 需要完善更新信息的界面和更新的服务
     * @param sliderimage_id
     * @param sliderimage
     * @return
     */
    @PutMapping(value = "/sliderimage/update/{sliderimage_id}")
    public String updateSliderimage(@PathVariable("sliderimage_id") Integer sliderimage_id,
                                    Sliderimage sliderimage,MultipartFile file){

        sliderimage.setSliderimage_id(sliderimage_id);
        String result = sliderimageService.insertSliderimage(sliderimage,file);

        return "redirect:/sliderimages";
    }

    /**
     * 根据id 删除一个Slideriamge图像的信息，编写完成，
     * 测试成功
     * @param sliderimage_id
     * @return
     */
//    提交请求的form表单为
//<form th:action="@{|/sliderimage/${sliderimage.getSliderimage_id()}|}" method="delete" th:method="delete">
//  <button type="submit" class="btn btn-danger">删除成员</button>
//</form>
    @DeleteMapping(value = "/sliderimage/{sliderimage_id}")
    public String deleteSliderimage(@PathVariable("sliderimage_id") Integer sliderimage_id){
        sliderimageRespository.delete(sliderimage_id);
        return "redirect:/sliderimages";
    }
}
