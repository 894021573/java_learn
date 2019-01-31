package cn.javaweb.servlet;

import cn.javaweb.service.GoodsService;
import cn.javaweb.service.bean.CartItem;
import cn.javaweb.service.impl.GoodsServiceImpl;
import cn.javaweb.utils.ParameterWrapUtil;
import cn.javaweb.utils.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class GoodsServlet extends BaseServlet
{
    // 商品列表
    public void listGoods(HttpServletRequest req, HttpServletResponse resp)
    {
        // 获取参数
        int userId = Integer.valueOf(req.getParameter("user_id"));

        String token = req.getParameter("token");
        GoodsService goodsService = new GoodsServiceImpl();
        Map<String, Object> map = goodsService.listGoods();
        ResponseUtil.responseJson(resp, map);
    }

    // 添加到购物车
    public void addToCart(HttpServletRequest req, HttpServletResponse resp)
    {
        // 获取参数
        int userId = Integer.parseInt(req.getParameter("user_id"));
        int goodsId = Integer.parseInt(req.getParameter("goods_id"));

        // 加入购物车
        GoodsService goodsService = new GoodsServiceImpl();
        Map<String, Object> map = goodsService.addToCat(userId, goodsId);

        ResponseUtil.responseJson(resp, map);
    }

    // 获取购物车
    public void listCartItems(HttpServletRequest req, HttpServletResponse resp)
    {
        // 获取参数
        int userId = Integer.parseInt(req.getParameter("user_id"));

        // 获取购物车
        GoodsService goodsService = new GoodsServiceImpl();
        Map<String, Object> map = goodsService.listCartItems(userId);

        ResponseUtil.responseJson(resp, map);
    }

    public void getGoodsDetail(HttpServletRequest req, HttpServletResponse resp)
    {
        // 获取参数
        int goodsId = Integer.parseInt(req.getParameter("goods_id"));

        // 获取商品详情
        GoodsService goodsService = new GoodsServiceImpl();
        Map<String, Object> map = goodsService.getGoodsDetail(goodsId);

        ResponseUtil.responseJson(resp, map);
    }
}
