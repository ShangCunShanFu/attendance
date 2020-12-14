package cn.hgd11.attendance.mapper;

import cn.hgd11.attendance.model.HgdRecord;
import cn.hgd11.tk.mybatis.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author 尚村山夫
 * @email 
 * @version 2020-12-14 21:14:31
 */
public interface HgdRecordMapper extends CommonMapper<HgdRecord> {

    /**
     * 批量添加打卡记录
     * @param recordList
     * @return
     */
    int insertList(@Param("recordList") List<HgdRecord> recordList);
}
