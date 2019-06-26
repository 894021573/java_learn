package blog.service;

import blog.bean.User;
import blog.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserDao userDao;

    public User getUser(String username)
    {
        return userDao.getUserByUsername(username);
    }
}
