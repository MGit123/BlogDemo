package blogdemo.demo.service.serviceImpl;

import blogdemo.demo.dao.UserDao;
import blogdemo.demo.entity.User;
import blogdemo.demo.service.UserService;
import blogdemo.demo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @date 2019/9/25 10:12
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {

        return userDao.findByUsernameAndPassword(username, MD5Util.code(password));
    }
}
