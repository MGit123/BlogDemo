package blogdemo.demo.controller;

import blogdemo.demo.entity.Type;
import blogdemo.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author admin
 * @date 2019/9/28 23:54
 */

@Controller
@Transactional
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    //分类管理
    @GetMapping("/typeManage")
    public String typeManage(@PageableDefault(size = 4,sort = ("id"), direction = Sort.Direction.DESC)
                                     Pageable pageable, Model model){
        model.addAttribute("typeList",typeService.ListType(pageable));
        model.addAttribute("header","typeManage");
        return "admin/typeManage";
    }

    @GetMapping("/typeAdd")
    public String typeAdd(Model model) {
        model.addAttribute("header","typeAdd");
        model.addAttribute("type",new Type());
        return "admin/typeAdd";
    }

    @GetMapping("/typeDelete/{typeId}")
    public String typeDelete( @PathVariable("typeId") Long typeId,RedirectAttributes attribute) {
        typeService.deleteType(typeId);
        attribute.addFlashAttribute("message","删除成功");
        return "redirect:/admin/typeManage";
    }


    @PostMapping("/typeAdd")
    public String post(RedirectAttributes attribute, @Valid Type type, BindingResult result){
          Type t=typeService.getTypeByName(type.getName());

          if(t!=null){
              result.rejectValue("name","nameError","该标签已存在");
          }

          if(result.hasErrors()){
              return "admin/typeAdd";
          }

          Type type1=typeService.saveType(type);
          if(type1==null){
               attribute.addFlashAttribute("message","添加失败");
          }else{
              attribute.addFlashAttribute("message","添加成功");
          }


          return "redirect:/admin/typeManage";
    }

    @GetMapping("/typeEdit/{typeId}")
    public String editPost(Model model,@PathVariable("typeId") Long typeId){
        Type t=typeService.getType(typeId);
        if(t!=null){
            model.addAttribute("type",t);
        }
        return "admin/typeAdd";
    }

    @PostMapping("/typeAdd/{typeId}")
    public String addPost(RedirectAttributes attribute, @Valid Type type, BindingResult result,@PathVariable("typeId") Long typeId){
        Type t=typeService.getTypeByName(type.getName());

        if(t!=null){
            result.rejectValue("name","nameError","该标签已存在");
        }

        if(result.hasErrors()){
            return "admin/typeAdd";
        }

        type.setId(typeId);
        Type type1=typeService.saveType(type);
        if(type1==null){
            attribute.addFlashAttribute("message","修改失败");
        }else{
            attribute.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/typeManage";
    }
}
