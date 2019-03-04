package cn.demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class TestC3P0
{
    //通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource= new  ComboPooledDataSource("mysql");
    //从连接池中取用一个连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            System.out.println("数据库连接出错");
        }
        return null;
    }

    public static void close(Connection conn, PreparedStatement pst, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("数据库连接关闭出错1");
            }
        }
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println("数据库连接关闭出错2");
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("数据库连接关闭出错3");
            }
        }
    }

    // https://www.cnblogs.com/ygj0930/p/6405861.html
    public void usePool()
    {
        try {
            for (int i = 0; i < 500; i++) {
                Connection connection = getConnection();
                String sql = "INSERT INTO `bona`.`t_user` (`id`, `user_name`, `password`, `account`) VALUES (null, '', '0', '0')";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
