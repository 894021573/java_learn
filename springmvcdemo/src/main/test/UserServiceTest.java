import blog.bean.User;
import blog.controller.IndexController;
import blog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserServiceTest
{
    @Autowired
    private UserService userService;


    @Test
    public void testGetUser()
    {
        User user = userService.getUser("A2");
        System.out.println(user);
    }
}
