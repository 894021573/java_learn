package example.controller;

import example.bean.User;
import example.dao.UserDao;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class IndexController
{
    @Autowired
    private UserService userService;

    @Autowired
   private UserDao userDao;

    @RequestMapping("/index")
    public String index()
    {
        User user = userDao.findUserById(1);
        System.out.println("name is" + user.getUsername());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public String login(User user)
    {
        String username = user.getUsername();
        String password = user.getPassword();

        System.out.println("username is " + username);
        System.out.println("password is " + password);

        userService.getUser();

        // 跳转
        return "redirect:main";
        // 重定向
//        return "forward:main";
    }

    @RequestMapping("/main")
    public String main(User user)
    {
        String username = user.getUsername();
        String password = user.getPassword();

        System.out.println("main username is " + username);
        System.out.println("main password is " + password);
        return "main";
    }
}