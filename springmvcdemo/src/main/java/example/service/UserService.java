package example.service;

import org.springframework.stereotype.Service;

@Service
public class UserService
{
    public void getUser()
    {
        System.out.println("service get user");
    }
}
