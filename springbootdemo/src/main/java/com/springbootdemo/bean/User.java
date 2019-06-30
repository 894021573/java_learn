package com.springbootdemo.bean;

public class User
{
    Integer id;
    String uername;
    String password;
    Integer create_at;
    Integer update_at;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUername()
    {
        return uername;
    }

    public void setUername(String uername)
    {
        this.uername = uername;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getCreate_at()
    {
        return create_at;
    }

    public void setCreate_at(Integer create_at)
    {
        this.create_at = create_at;
    }

    public Integer getUpdate_at()
    {
        return update_at;
    }

    public void setUpdate_at(Integer update_at)
    {
        this.update_at = update_at;
    }
}
