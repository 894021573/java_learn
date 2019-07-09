package com.ht.blog.common.help.result;

import common.util.result.CodeMsg;

public class CategoryCodeMsg extends CodeMsg
{
    public static CodeMsg CATEGOTY_IS_EXISTS = new CodeMsg(1001, "分类已存在");
    public static CodeMsg CATEGOTY_NOT_EXISTS = new CodeMsg(1002, "分类不存在");
}