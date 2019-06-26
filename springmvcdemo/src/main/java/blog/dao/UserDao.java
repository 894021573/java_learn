package blog.dao;

import blog.bean.User;

public interface UserDao {

    // 根据 id 寻找对应的 User
    User getUserById(int id);

    User getUserByUsername(String username);
}
