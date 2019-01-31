package cn.javaweb.service.impl;

import cn.javaweb.bean.Goods;
import cn.javaweb.bean.GoodsAttribute;
import cn.javaweb.bean.User;
import cn.javaweb.dao.UserDao;
import cn.javaweb.dao.impl.GoodsAttributeDaoImpl;
import cn.javaweb.dao.impl.GoodsDaoImpl;
import cn.javaweb.dao.impl.UserDaoImpl;
import cn.javaweb.service.CommonService;
import cn.javaweb.utils.ReturnMapUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonServiceImpl implements CommonService
{
    public boolean isValidUser(int userId, String token)
    {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserByToken(userId, token);
        return user != null;
    }

    @Override
    public Object getGoodsDetail(int goodsId)
    {
        Goods goods = (new GoodsDaoImpl()).getGoodsById(goodsId);
        if (goods != null) {
            List<GoodsAttribute> listGoodsAttribute = (new GoodsAttributeDaoImpl()).listGoodsAttribute(goodsId);
            goods.setListGoodsAttribute(listGoodsAttribute);
        }

        return goods;
    }
}
