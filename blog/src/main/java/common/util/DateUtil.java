package common.util;

import java.util.Date;

public class DateUtil
{
    public static int getSecondTimestamp(Date date)
    {
        if (date == null) {
            return (int) (System.currentTimeMillis() / 1000);
        }

        return (int) (date.getTime() / 1000);
    }
}
