package com.ht.blog.entity;

import com.ht.blog.common.help.valid.groups.CreateAction;
import com.ht.blog.common.help.valid.message.HArticleMessage;
import com.ht.blog.common.help.valid.message.HCategoryMessage;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class HCategory implements Serializable {
    private Integer id;

    @NotNull(groups = {CreateAction.class}, message = HCategoryMessage.USER_ID_NOT_EMPTY)
    private Integer userId;

    @NotEmpty(groups = {CreateAction.class}, message = HCategoryMessage.NAME_NOT_EMPTY)
    private String name;

    private Integer num;

    private Integer createdAt;

    private Integer updatedAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNum()
    {
        return num;
    }

    public void setNum(Integer num)
    {
        this.num = num;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", num=").append(num);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}