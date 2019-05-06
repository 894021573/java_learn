package example.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao
{
    public void getUser()
    {
        System.out.println("get user");
    }
}
