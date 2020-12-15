package cn.hgd11.attendance.service;

import cn.hgd11.attendance.util.DateUtils;
import cn.hgd11.common.entity.ObjectResultResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import cn.hgd11.attendance.model.HgdRecord;
import cn.hgd11.attendance.mapper.HgdRecordMapper;
import cn.hgd11.tk.mybatis.biz.BusinessBiz;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.*;

/**
 * @author 尚村山夫
 * @version 2020-12-14 21:14:31
 * @email
 */
@Service
public class HgdRecordService extends BusinessBiz<HgdRecordMapper, HgdRecord> {
    /**
     * 随机添加打卡,在数据库中模拟出一批打卡记录<br/>
     *
     * @return
     */
    public ObjectResultResponse<Void> addRandomRecord()
            throws ParseException {
        List<HgdRecord> recordList = new ArrayList<>();
        Date amd = DateUtils.Lang3DateUtils.parseDate("2020-11-01 08:00:00");
        for (int i = 0; i < 30; i++) {
            for (int k = 1; k <= 3; k++) {
                // 这层循环表示用户ID
                Date[] dates = validateRecord(amd);
                HgdRecord am = new HgdRecord();
                am.setRecordTime(dates[0]);
                am.setUserId(k);
                am.setRecordType("0");
                recordList.add(am);

                HgdRecord pm = new HgdRecord();
                pm.setRecordTime(dates[1]);
                pm.setUserId(k);
                pm.setRecordType("0");
                recordList.add(pm);
            }

            amd = DateUtils.Lang3DateUtils.addDays(amd, 1);
        }
        this.mapper.insertList(recordList);

        return null;
    }

    /**
     * 有效的打卡时间为上午8:00--9:30  下午17:00--18:30
     *
     * @return
     */
    @NotNull
    private Date[] validateRecord(@NotNull Date am)
            throws ParseException {

        Random random = new Random();
        // 开始打卡时间
        Date amEnd = DateUtils.date(am.getTime() + random.nextInt(
                (int) (DateUtils.MILLISECONDS_PER_MINUTE + DateUtils.MILLISECONDS_PER_HOUR)) + 1);
        // 结束打卡时间 = 开始打卡时间 + 9 + 2小时随机数
        Date pmEnd = DateUtils.date(amEnd.getTime() + DateUtils.MILLISECONDS_PER_HOUR * 9 + random.nextInt(
                (int) DateUtils.MILLISECONDS_PER_HOUR * 2));

        return new Date[]{amEnd, pmEnd};
    }

    /**
     * 添加打卡记录，打卡时使用系统当前时间
     *
     * @param recordType
     * @param userId
     * @return
     */
    @NotNull
    public ObjectResultResponse<Void> addRecord(@NotNull String recordType, @NotNull Integer userId) {
        HgdRecord record = new HgdRecord();
        record.setRecordTime(new Date());
        record.setUserId(userId);
        record.setRecordType(recordType);
        this.mapper.insertSelective(record);
        return new ObjectResultResponse<>(0, "添加成功");
    }

    /**
     * 查询打卡记录
     * @param recordType
     * @param userId
     * @param endTime
     * @param startTime
     * @return
     */
    @NotNull
    public ObjectResultResponse<Void> getRecord(
        @Nullable String recordType,
        @Nullable Integer userId,
        @NotNull Date endTime,
        @NotNull Date startTime
    ) {
        String parttern = "yyyy-MM-dd";
        // 将日期格式化到日期
        startTime = DateUtils.Lang3DateUtils.parseDate(DateUtils.DateFormatUtils.format(startTime, parttern),
                                                       parttern)
        this.mapper.recordList(startTime, endTime, userId, recordType);
    }
}