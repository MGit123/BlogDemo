package blogdemo.demo.controller;

import blogdemo.demo.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author admin
 * @date 2019/9/19 10:58
 */

@Controller
public class BaseController {

    @GetMapping("/")
    public String first(Model model){
        model.addAttribute("header","index");
        return "index";
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("header","index");
        return "index";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        model.addAttribute("header","blog");
        return "blog";
    }

    @GetMapping("/type")
    public String type(Model model){
        model.addAttribute("header","type");
        return "type";
    }

    @GetMapping("/tag")
    public String tag(Model model){
        model.addAttribute("header","tag");
        return "tag";
    }

    @GetMapping("/archive")
    public String archive(Model model){
        model.addAttribute("header","archive");
        return "archive";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("header","about");
        return "about";
    }
}
