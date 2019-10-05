package blogdemo.demo.controller;

import blogdemo.demo.entity.Blog;
import blogdemo.demo.entity.User;
import blogdemo.demo.service.BlogSerivce;
import blogdemo.demo.service.TagService;
import blogdemo.demo.service.TypeService;
import blogdemo.demo.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author admin
 * @date 2019/9/28 23:56
 */

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogSerivce blogSerivce;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    //博客管理
    @GetMapping("/blogManage")
    public String blogManage(@PageableDefault(size=2,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                             BlogQuery blog, Model model ){
        model.addAttribute("header","blogManage");
        model.addAttribute("types",typeService.ListType());
        model.addAttribute("blogList",blogSerivce.blogList(pageable,blog));
        return "admin/blogManage";
    }

    //博客管理
    @PostMapping("/blogManage/search")
    public String blogSearch(@PageableDefault(size=2,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                             BlogQuery blog, Model model ){
        model.addAttribute("blogList",blogSerivce.blogList(pageable,blog));
        return "admin/blogManage::blogs";
    }

    @GetMapping("/blogAdd")
    public String blogAdd(Model model){
        model.addAttribute("header","blogAdd");
        model.addAttribute("types",typeService.ListType());
        model.addAttribute("tags",tagService.ListTag());
        return "admin/blogAdd";
    }

    @PostMapping("/blogAdd")
    public String blogInput(RedirectAttributes attribute, Blog blog, HttpSession session){
        blog.setUser((User)session.getAttribute("user"));
        System.err.println("typeId:"+blog.getType().getId());
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.ListTag(blog.getTagIds()));

        Blog b= blogSerivce.saveBlog(blog);
        if(b!=null){
            attribute.addFlashAttribute("message","博客添加成功");
        }else{
            attribute.addFlashAttribute("message","博客添加失败");
        }

        return "redirect:/admin/blogManage";
    }
}
