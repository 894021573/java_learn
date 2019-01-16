package cn.demo;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TestDbcp
{
    // DBCP 连接池
    // https://www.cnblogs.com/sunseine/p/5947448.html
    public void usePool()
    {
        // 数据库连接池
        InputStream inputStream = null;
        inputStream = TestDbcp.class.getClassLoader().getResourceAsStream("dbcp.properties");

        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties);
        try {
            DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();
            for (int i = 0; i < 500; i++) {
                String sql = "INSERT INTO `bona`.`t_user` (`id`, `user_name`, `password`, `account`) VALUES (null, '', '0', '0')";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void usePool2()
    {
        // 数据库连接池
        System.out.println(System.getProperty("user.dir"));
        InputStream inputStream = null;
        inputStream = TestDbcp.class.getClassLoader().getResourceAsStream("dbcp.properties");

        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties);
        try {
            DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);

            for (int i = 0; i < 2000; i++) {
                Connection connection = dataSource.getConnection();
                String sql = "INSERT INTO `bona`.`t_user` (`id`, `user_name`, `password`, `account`) VALUES (null, '', '0', '0')";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notUsePool()
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bona?serverTimezone=UTC&useAffectedRows=true";
        String username = "root";
        String password = "root";
        Connection connection;
        try {
            Class.forName(driver);

            for (int i = 0; i < 2000; i++) {
                connection = DriverManager.getConnection(url, username, password);

                QueryRunner queryRunner = new QueryRunner();
                String sql = "INSERT INTO `bona`.`t_user` (`id`, `user_name`, `password`, `account`) VALUES (null, '', '0', '0')";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
                connection.close();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
