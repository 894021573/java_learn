package cn.xmall.service;

/**
 * 共用
 */
public interface CommonService
{
    /**
     * 是否为有效用户
     *
     * @param userId
     * @param token
     * @return
     */
    boolean isValidUser(int userId, String token);

    /**
     * 获取商品详情
     *
     * @param goodsId
     * @return
     */
    Object getGoodsDetail(int goodsId);
}
