package cn.xmall.service;

public class RedisKeyService
{
    /**
     * 购物车key
     *
     * @param userId
     * @return
     */
    public static String getCartOfUserId(int userId)
    {
        return "cart_of_" + userId;
    }
}
