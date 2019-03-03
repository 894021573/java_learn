package common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{
    public static String getTime()
    {
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(today);
    }

    public static int getSecondTimestamp()
    {
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        return Integer.valueOf(timestamp);
    }
}
