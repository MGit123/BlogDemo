package blogdemo.demo.controller;

import blogdemo.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Pageable;

/**
 * @author admin
 * @date 2019/9/28 23:56
 */

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    //标签管理
    @GetMapping("/tagManage")
    public String tagManage(Model model){
        model.addAttribute("header","tagManage");
        return "admin/tagManage";
    }

    @GetMapping("/tagAdd")
    public String tagAdd(Model model){
        model.addAttribute("header","tagAdd");
        return "admin/tagAdd";
    }
}
