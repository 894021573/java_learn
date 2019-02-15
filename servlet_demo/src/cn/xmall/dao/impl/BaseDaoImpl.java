package cn.xmall.dao.impl;

import cn.xmall.dao.BaseDao;
import common.utils.JDBCUtil;
import common.utils.StringUtil;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T> implements BaseDao<T>
{
    private String sql;

    public T findOne(String where, Object... params)
    {
        return this.findOne(new String[]{"*"}, where, params);
    }

    public T findOne(String[] fields, String where, Object... params)
    {
        return JDBCUtil.queryOne(this.generateSelectSql(fields, where + " LIMIT 1"), getTClass(), params);
    }

    public List<T> findAll()
    {
        return this.findAll("1=1");
    }

    public List<T> findAll(String where, Object... params)
    {
        return this.findAll(new String[]{"*"}, where, params);
    }

    public List<T> findAll(String[] fields, String where, Object... params)
    {
        return (List<T>) JDBCUtil.queryList(this.generateSelectSql(fields, where), getTClass(), params);
    }

    public int add(Map<String, Object> map)
    {
        return JDBCUtil.update(this.generateInsertSql(map), map.values().toArray());
    }

    public int update(String update, String where, Object... params)
    {
        return JDBCUtil.update(this.generateUpdateSql(update, where), params);
    }

    public int delete(String where, Object... params)
    {
        return JDBCUtil.update(this.generateDeleteSql(where), params);
    }

    private String generateSelectSql(String[] fields, String where)
    {
        where = where.trim();
        if (where.startsWith("INNER") || where.startsWith("LEFT") || where.startsWith("RIGHT") || where.startsWith("GROUP") || where.startsWith("HAVING") || where.startsWith("ORDER") || where.startsWith("LIMIT")) {

        } else {
            where = " WHERE " + where;
        }

        this.sql = "SELECT " + this.handlerField(fields) + " FROM `" + this.getTableName() + "` " + where;
        return this.sql;
    }

    private String generateInsertSql(Map<String, Object> map)
    {
        String[] fields = map.keySet().toArray(new String[0]);

        StringBuilder placeHolder = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            if (i < fields.length - 1) {
                placeHolder.append("?,");
            } else {
                placeHolder.append("?");
            }
        }

        this.sql = "INSERT INTO `" + this.getTableName() + "` (" + this.handlerField(fields) + ") VALUES (" + placeHolder + ")";
        return this.sql;
    }

    private String generateUpdateSql(String update, String where)
    {
        this.sql = "UPDATE `" + this.getTableName() + "` SET " + update + " WHERE " + where;
        return this.sql;
    }

    private String generateDeleteSql(String where)
    {
        this.sql = "DELETE FROM  `" + this.getTableName() + "` WHERE " + where;
        return this.sql;
    }

    private String getTableName()
    {
        String tableName = getTClass().getSimpleName();
        return (this.underlineName(tableName)).toLowerCase();
    }

    private String handlerField(String[] fields)
    {
        StringBuilder field = new StringBuilder();
        if (fields.length == 1 && fields[0].equals("*")) {
            field.append("*");
        } else {
            for (int i = 0; i < fields.length; i++) {
                field.append(fields[i]);

                if (i < fields.length - 1) {
                    field.append(",");
                }
            }
        }
        return field.toString();
    }

    private Class<T> getTClass()
    {
        return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private String underlineName(String string)
    {
        return StringUtil.underlineName(string);
    }

    public String getSql()
    {
        return sql;
    }

    public String handlerIn(int length)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append("? ,");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
