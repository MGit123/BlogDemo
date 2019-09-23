package blogdemo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @date 2019/9/22 23:52
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/blogs")
    public String blogs(){
        return "admin/blogs";
    }

    @GetMapping("/blogInput")
    public String blogInput(){
        return "admin/blogInput";
    }
}
