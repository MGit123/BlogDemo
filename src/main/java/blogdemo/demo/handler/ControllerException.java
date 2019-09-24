package blogdemo.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author admin
 * @date 2019/9/24 10:41
 */

@ControllerAdvice
public class ControllerException {

     private final Logger logger= LoggerFactory.getLogger(this.getClass());

     @ExceptionHandler(Exception.class)              //拦截全局异常
     public ModelAndView exceptionHander(HttpServletRequest request,Exception e)throws Exception{
          logger.error("Request URL : {}, Exception :{}",request.getRequestURI(),e);

          //如果异常有状态码，跳转到特定的页面
          if(AnnotationUtils.findAnnotation(e.getClass(),ResponseStatus.class)!=null){
               throw e;
          }

          //无状态码跳转到error页面
          ModelAndView mv=new ModelAndView();
          mv.addObject("url",request.getRequestURI());
          mv.addObject("exception",e);
          mv.setViewName("error/error");
          return mv;
     }
}
