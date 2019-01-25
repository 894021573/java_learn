package cn.demo;

import cn.demo.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TestDbUtils
{
    /**
     * https://blog.csdn.net/a911711054/article/details/77719685
     * https://blog.csdn.net/damogu_arthur/article/details/40585999
     *
     * ArrayHandler：把结果集中的第一行数据转成对象数组。
     * ArrayListHandler：把结果集中的每一行数据都转成一个对象数组，再存放到List中。
     * BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
     * BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
     * ColumnListHandler：将结果集中某一列的数据存放到List中。
     * KeyedHandler：将结果集中的每一行数据都封装到一个Map里，然后再根据指定的key把每个Map再存放到一个Map里。
     * MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
     * MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List。
     * ScalarHandler：将结果集中某一条记录的其中某一列的数据存成Object。
     */
    public void selectArray()
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bona?serverTimezone=UTC&useAffectedRows=true";
        String username = "root";
        String password = "root";
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);

            QueryRunner queryRunner = new QueryRunner();
            String sql = "select * from t_user";
            Object[] objects = queryRunner.query(connection, sql, new ArrayHandler());
            for (Object object : objects) {
                System.out.println(object);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectArrayList()
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bona?serverTimezone=UTC&useAffectedRows=true";
        String username = "root";
        String password = "root";
        Connection connection;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            QueryRunner queryRunner = new QueryRunner();

            String sql = "select * from t_user";
            List<Object[]> objects = queryRunner.query(connection, sql, new ArrayListHandler());

            for (Object[] o : objects) {
                for (Object oo : o) {
                    System.out.println(oo);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectBean()
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bona?serverTimezone=UTC&useAffectedRows=true";
        String username = "root";
        String password = "root";
        Connection connection;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            QueryRunner queryRunner = new QueryRunner();

            String sql = "select * from t_user";
            User user = queryRunner.query(connection, sql, new BeanHandler<>(User.class));
            System.out.println(user.getId());
            System.out.println(user.getUserName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectBeanList()
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bona?serverTimezone=UTC&useAffectedRows=true";
        String username = "root";
        String password = "root";
        Connection connection;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            QueryRunner queryRunner = new QueryRunner();

            String sql = "select * from t_user where user_name = ?";
            List<User> userList = queryRunner.query(connection, sql, new BeanListHandler<>(User.class), "ht");
            for (User user : userList) {
                System.out.println(user.getId());
                System.out.println(user.getUserName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectColumnList()
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bona?serverTimezone=UTC&useAffectedRows=true";
        String username = "root";
        String password = "root";
        Connection connection;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            QueryRunner queryRunner = new QueryRunner();

            String sql = "select * from t_user where id = ?";
            List list = (List) queryRunner.query(connection, sql, new ColumnListHandler("id"), 1);
            for (Object o : list) {
                System.out.println(o);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectScalarHandler()
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bona?serverTimezone=UTC&useAffectedRows=true";
        String username = "root";
        String password = "root";
        Connection connection;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            QueryRunner queryRunner = new QueryRunner();

//            String sql = "select count(*) as c from t_user";
            String sql = "select id from t_user";
            long c = (long) queryRunner.query(connection, sql, new ScalarHandler("id"));
            System.out.println(c);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
