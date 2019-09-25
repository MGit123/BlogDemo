package blogdemo.demo.interceptor;

import blogdemo.demo.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @date 2019/9/25 22:51
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        User user=(User)request.getSession().getAttribute("user");

        if(user==null){
            response.sendRedirect("/admin/login");
            return false;
        }

        return true;
    }
}
