package blog.controller;

import blog.bean.Pet;
import blog.bean.User;
import blog.dao.UserDao;
import blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        User user = userDao.getUserById(1);
        System.out.println("name is" + user.getUsername());
        return "index";
    }

    // 登录（不同的方法的path值不能一样）
    @RequestMapping(method = RequestMethod.POST, path = "/login",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User login(User userForm)
    {
        String username = userForm.getUsername();
        String password = userForm.getPassword();

        System.out.println("username is " + username);
        System.out.println("password is " + password);

        User user = userService.getUser(username);

        if(user == null){
            return null;
        }

        return user;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/loginWithPet",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User loginWithPet(User user, Pet pet)
    {
        String username = user.getUsername();
        String name = pet.getName();

        System.out.println("master name is " + username);
        System.out.println("pet name is " + name);

        return user;
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