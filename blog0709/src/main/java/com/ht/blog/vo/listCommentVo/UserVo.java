package com.ht.blog.vo.listCommentVo;

public class UserVo
{
    private String nickname;

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname == null ? null : nickname.trim();
    }
}
