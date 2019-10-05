package blogdemo.demo.controller;

import blogdemo.demo.entity.Blog;
import blogdemo.demo.service.BlogSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @date 2019/9/28 23:56
 */

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogSerivce blogSerivce;

    //博客管理
    @GetMapping("/blogManage")
    public String blogManage(@PageableDefault(size=2,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                             Blog blog,Model model ){
        model.addAttribute("header","blogManage");
        model.addAttribute("blogList",blogSerivce.blogList(pageable,blog));
        return "admin/blogManage";
    }

    @GetMapping("/blogAdd")
    public String blogAdd(Model model){
        model.addAttribute("header","blogAdd");
        return "admin/blogAdd";
    }
}
