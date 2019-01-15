package cn.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate
{
    public static void main(String[] args) throws ParseException
    {
        t1();
    }

    public static void t1() throws ParseException
    {
        // 日期转时间戳
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse("2012-01-01 12:50:43");
        System.out.println(date.getTime()); // 打印时间戳

        // 时间戳转日期
        System.out.println(dateFormat.format(date));

        // 加一天
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date date1 = calendar.getTime();
        System.out.println(dateFormat.format(date1));

        // 减一天
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date date2 = calendar.getTime();
        System.out.println(dateFormat.format(date2));

        // 加10分钟
        calendar.add(Calendar.MINUTE, 10);
        Date date3 = calendar.getTime();
        System.out.println(dateFormat.format(date3));
    }
}
