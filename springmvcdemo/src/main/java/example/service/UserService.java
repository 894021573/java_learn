package example.service;

import example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserDao userDao;

    public void getUser()
    {
        userDao.getUser();
        System.out.println("service get user");
    }
}
