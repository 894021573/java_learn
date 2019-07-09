package com.ht.blog.common.help.result;

import common.util.result.CodeMsg;

public class AuthCodeMsg extends CodeMsg
{
    public static CodeMsg LOGIN_FAIL = new CodeMsg(1001, "登录失败");
    public static CodeMsg REGISTER_FAIL = new CodeMsg(1002, "注册失败");
    public static CodeMsg USERNAME_EXISTS = new CodeMsg(1003, "用户名已存在");
    public static CodeMsg TOKEN_ERROR1 = new CodeMsg(1004, "TOKEN过期");
    public static CodeMsg TOKEN_ERROR2 = new CodeMsg(1005, "TOKEN不存在");
    public static CodeMsg TOKEN_ERROR3 = new CodeMsg(1006, "用户不匹配");
}