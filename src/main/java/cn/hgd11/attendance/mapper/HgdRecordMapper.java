package cn.hgd11.attendance.mapper;

import cn.hgd11.attendance.model.HgdRecord;
import cn.hgd11.attendance.vo.HgdRecordVo;
import cn.hgd11.tk.mybatis.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author 尚村山夫
 * @version 2020-12-14 21:14:31
 * @email
 */
public interface HgdRecordMapper extends CommonMapper<HgdRecord> {

    /**
     * 批量添加打卡记录
     *
     * @param recordList
     * @return
     */
    int insertList(@Param("recordList") List<HgdRecord> recordList);

    /**
     * 查询打卡记录
     *
     * @param startTime 查询开始时间 精确到天
     * @param endTime   查询结束时间  精确到天
     * @param userId    用户ID
     * @param recordType
     * @return 查询打卡记录
     */
    @Nullable
    List<HgdRecordVo> recordList(
        @NotNull @Param("startTime") Date startTime,
        @NotNull @Param("endTime") Date endTime,
        @Nullable @Param("userId") Integer userId,
        @Nullable @Param("recordType") String recordType
    );
}
