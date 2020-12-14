package cn.hgd11.attendance.util;

import java.text.ParseException;
import java.util.Date;

public class DateUtils {
    public static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final long MILLISECONDS_PER_MILLISECOND = 1;
    public static final long MILLISECONDS_PER_SECOND = MILLISECONDS_PER_MILLISECOND * 1000;
    public static final long MILLISECONDS_PER_MINUTE = MILLISECONDS_PER_SECOND * 60;
    public static final long MILLISECONDS_PER_HOUR = MILLISECONDS_PER_MINUTE * 60;
    public static final long MILLISECONDS_PER_DAY = MILLISECONDS_PER_HOUR * 24;

    public static Date date(){
        return new Date();
    }

    public static Date date(long milliseconds){
        return new Date(milliseconds);
    }

    public static class DateFormatUtils extends org.apache.commons.lang3.time.DateFormatUtils {

    }

    public static class Lang3DateUtils extends org.apache.commons.lang3.time.DateUtils {
        public static Date parseDate(final String str)
                throws ParseException {
            return parseDate("2020-11-01 08:00:00", DateUtils.FORMAT);
        }
    }
}
