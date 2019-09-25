package blogdemo.demo.service;

import blogdemo.demo.entity.User;

/**
 * @author admin
 * @date 2019/9/25 10:12
 */
public interface UserService {

    User checkUser(String username, String password);
}
