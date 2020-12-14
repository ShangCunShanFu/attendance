package local;

import cn.hgd11.attendance.util.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.commons.lang3.time.FastDateParser;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

public class LocalTest {

    @Test
    public void dateTest()
            throws ParseException {
        Date date = DateUtils.Lang3DateUtils.parseDate("2020-11-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        System.out.println(DateUtils.DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
    }
}
