package cn.xmall.service.impl;

import cn.xmall.bean.Goods;
import cn.xmall.bean.GoodsAttribute;
import cn.xmall.bean.User;
import cn.xmall.dao.UserDao;
import cn.xmall.dao.impl.GoodsAttributeDaoImpl;
import cn.xmall.dao.impl.GoodsDaoImpl;
import cn.xmall.dao.impl.UserDaoImpl;
import cn.xmall.service.CommonService;

import java.util.List;

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
