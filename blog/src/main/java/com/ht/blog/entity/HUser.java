package com.ht.blog.entity;

import com.ht.blog.common.help.valid.groups.CreateAction;
import com.ht.blog.common.help.valid.groups.auth.LoginAction;
import com.ht.blog.common.help.valid.message.HUserMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Component
public class HUser implements Serializable
{
    private Integer id;

    @NotEmpty(groups = {LoginAction.class, CreateAction.class}, message = HUserMessage.USERNAME_NOT_EMPTY)
    private String username;

    @NotEmpty(groups = {LoginAction.class, CreateAction.class}, message = HUserMessage.PASSWORD_NOT_EMPTY)
    private String password;

    @NotEmpty(groups = CreateAction.class, message = HUserMessage.NICKNAME_NOT_EMPTY)
    private String nickname;

    @NotEmpty(groups = CreateAction.class, message = HUserMessage.AVATAR_URL_NOT_EMPTY)
    private String avatarUrl;

    private String token;

    private Integer expiredAt;

    private Integer createdAt;

    private Integer updatedAt;

    private static final long serialVersionUID = 1L;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getAvatarUrl()
    {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl)
    {
        this.avatarUrl = avatarUrl;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token == null ? null : token.trim();
    }

    public Integer getExpiredAt()
    {
        return expiredAt;
    }

    public void setExpiredAt(Integer expiredAt)
    {
        this.expiredAt = expiredAt;
    }

    public Integer getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt)
    {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", token=").append(token);
        sb.append(", expiredAt=").append(expiredAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}