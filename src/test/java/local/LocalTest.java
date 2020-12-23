package local;

import cn.hgd11.attendance.model.HgdRecord;
import cn.hgd11.attendance.util.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.commons.lang3.time.FastDateParser;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

public class LocalTest {

    @Test
    public void dateTest()
            throws ParseException, IOException {
        Date date = DateUtils.Lang3DateUtils.parseDate("2020-11-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        System.out.println(DateUtils.DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));

        ClassLoader classLoader = HgdRecord.class.getClassLoader();
        Enumeration<URL> resourceUrls = classLoader.getResources("cn/hgd11/attendance");
        System.out.println();
        Set<Resource> result = new LinkedHashSet<>(16);
        while (resourceUrls.hasMoreElements()) {
            URL url = resourceUrls.nextElement();
            result.add(convertClassLoaderURL(url));
        }
    }

    protected Resource convertClassLoaderURL(URL url) {
        return new UrlResource(url);
    }
}
