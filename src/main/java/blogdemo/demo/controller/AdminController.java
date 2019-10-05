package blogdemo.demo.controller;

import blogdemo.demo.entity.User;
import blogdemo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author admin
 * @date 2019/9/22 23:52
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    @GetMapping("/index")
    public String index(){
        return "admin/index";
    }


    @PostMapping("/loginCheck")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, Model model){

        User user=userService.checkUser(username,password);

        if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "redirect:/admin/index";
        }else{
            model.addAttribute("message","用户名或密码错误!");
            return "admin/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
         session.removeAttribute("user");
        return "redirect:admin/login";
    }
}
