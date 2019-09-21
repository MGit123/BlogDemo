package blogdemo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author admin
 * @date 2019/9/19 10:58
 */

@Controller
public class BaseController {

    @GetMapping("/")
    public String first(){
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }

    @GetMapping("/type")
    public String type(){
        return "type";
    }

    @GetMapping("/tag")
    public String tag(){
        return "tag";
    }

    @GetMapping("/archive")
    public String archive(){
        return "archive";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
