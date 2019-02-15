package common.utils;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCUtil
{
    private JDBCUtil()
    {
    }

    public static Connection getConnection()
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bona?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8&useAffectedRows=true";
        String username = "root";
        String password = "root";
        Connection connection;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static <T> T queryOne(String sql, Class<T> type, Object... params)
    {
        Connection connection = JDBCUtil.getConnection();
        RowProcessor processor = new BasicRowProcessor(new GenerousBeanProcessor());
        QueryRunner queryRunner = new QueryRunner();

        Object object = null;
        try {
            object = queryRunner.query(connection, sql, new BeanHandler<>(type, processor), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
        return (T) object;
    }

    public static <T> T queryList(String sql, Class<T> type)
    {
        Connection connection = JDBCUtil.getConnection();
        RowProcessor processor = new BasicRowProcessor(new GenerousBeanProcessor());
        QueryRunner queryRunner = new QueryRunner();

        List<T> objects = null;
        try {
            objects = queryRunner.query(connection, sql, new BeanListHandler<>(type, processor));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
        return (T) objects;
    }

    public static <T> T queryList(String sql, Class<T> type, Object... params)
    {
        Connection connection = JDBCUtil.getConnection();
        RowProcessor processor = new BasicRowProcessor(new GenerousBeanProcessor());
        QueryRunner queryRunner = new QueryRunner();

        List<T> objects = null;
        try {
            objects = queryRunner.query(connection, sql, new BeanListHandler<>(type, processor), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
        return (T) objects;
    }

    @SuppressWarnings("deprecation")
    public static <T> T queryList(String sql, Object[] params, Class<T> type)
    {
        Connection connection = JDBCUtil.getConnection();
        RowProcessor processor = new BasicRowProcessor(new GenerousBeanProcessor());
        QueryRunner queryRunner = new QueryRunner();

        List<T> objects = null;
        try {
            objects = queryRunner.query(connection, sql, params, new BeanListHandler<>(type, processor));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
        return (T) objects;
    }

    public static <T> T queryMapList(String sql)
    {
        Connection connection = JDBCUtil.getConnection();
        RowProcessor processor = new BasicRowProcessor(new GenerousBeanProcessor());
        QueryRunner queryRunner = new QueryRunner();

        List<Map<String, Object>> objects = null;
        try {
            objects = queryRunner.query(connection, sql, new MapListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
        return (T) objects;
    }

    public static int update(String sql, Object... params)
    {
        Connection connection = JDBCUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        int affectNum = 0;
        try {
            affectNum = queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
        return affectNum;
    }

    public static int updateReturnGenerateId(String sql, Object... params)
    {
        Connection connection = JDBCUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        int affectNum = 0;
        int id = 0;
        try {
            affectNum = queryRunner.update(connection, sql, params);

            if (affectNum > 0) {
                id = ((BigInteger) queryRunner.query(connection, "SELECT LAST_INSERT_ID()", new ScalarHandler(1))).intValue();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
        return id;
    }

    public static void close(Connection connection)
    {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
