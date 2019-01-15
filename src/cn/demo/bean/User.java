package cn.demo.bean;

public class User
{
    private long id;
    private String userName;
    private String password;
    private int account;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getAccount()
    {
        return account;
    }

    public void setAccount(int account)
    {
        this.account = account;
    }
}
