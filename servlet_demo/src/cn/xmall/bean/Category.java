package cn.xmall.bean;

import com.google.gson.annotations.Expose;

public class Category
{
    @Expose
    private int id;
    @Expose
    private String name;
    private int parentId;

    private int createdAt;
    private int updatedAt;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getParentId()
    {
        return parentId;
    }

    public void setParentId(int parentId)
    {
        this.parentId = parentId;
    }

    public int getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(int createdAt)
    {
        this.createdAt = createdAt;
    }

    public int getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(int updatedAt)
    {
        this.updatedAt = updatedAt;
    }
}
