package cn.javaweb.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T>
{
    T findOne(String where, Object... params);

    T findOne(String[] fields, String where, Object... params);

    List<T> findAll(String where, Object... params);

    List<T> findAll(String[] fields, String where, Object... params);

    int save(Map<String, Object> map);

    int update(String update, String where, Object... params);

    int delete(String where, Object... params);
}
