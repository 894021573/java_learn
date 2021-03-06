package common.utils;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomUtil
{
    public static void main(String[] args)
    {
        System.out.println(getOrderNumber());
    }

    public static String getToken()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static BigInteger getOrderNumber()
    {
        //格式化当前时间
        SimpleDateFormat sfDate = new SimpleDateFormat("yyMMddHHmmssSSS");
        String strDate = sfDate.format(new Date());
//        //得到17位时间如：20170411094039080
//        System.out.println("时间17位：" + strDate);
        //为了防止高并发重复,再获取3个随机数
        String random = getRandom620(4);

        //最后得到19位订单编号。
        BigInteger orderNumber = new BigInteger(strDate + random);
        return orderNumber;
    }

    /**
     * 获取6-10 的随机位数数字
     *
     * @param length 想要生成的长度
     * @return result
     */
    public static String getRandom620(Integer length)
    {
        String result = "";
        Random rand = new Random();
        int n = 20;
        if (null != length && length > 0) {
            n = length;
        }
        int randInt = 0;
        for (int i = 0; i < n; i++) {
            randInt = rand.nextInt(10);
            result += randInt;
        }
        return result;
    }
}
