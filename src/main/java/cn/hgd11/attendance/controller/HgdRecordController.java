package cn.hgd11.attendance.controller;

import cn.hgd11.attendance.vo.HgdRecordVo;
import cn.hgd11.common.entity.ObjectResultResponse;
import cn.hgd11.common.entity.TableResultResponse;
import cn.hgd11.tk.mybatis.controller.BaseController;
import cn.hgd11.attendance.service.HgdRecordService;
import cn.hgd11.attendance.model.HgdRecord;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.Date;

/**
 * @author 尚村山夫
 * @version 2020-12-14 21:14:31
 * @email
 */
@RestController
@RequestMapping("hgdRecord")
@Slf4j
@Api(tags = "打卡管理")
public class HgdRecordController extends BaseController<HgdRecordService, HgdRecord, Integer> {

    @PostMapping("random/record")
    @ApiOperation("随机添加打卡记录")
    public ObjectResultResponse<Void> addRandomRecord()
            throws ParseException {
        log.info("随机添加打卡记录");
        return this.baseBiz.addRandomRecord();
    }

    @PostMapping("record")
    @ApiOperation("进行打卡")
    public ObjectResultResponse<Void> addRecord(
            @RequestParam(value = "recordType") @ApiParam(value = "打卡类型(0:上班打卡|1:外出打卡|2:补卡)") String recordType,
            @RequestParam(value = "userId") @ApiParam(value = "用户ID", example = "1") Integer userId)
            throws ParseException {
        log.info("进行打卡,当前用户ID:{}", userId);
        return this.baseBiz.addRecord(recordType, userId);
    }

    @GetMapping("record")
    @ApiOperation("查询打卡记录,当前库中只有11月份的打卡记录")
    public @NotNull TableResultResponse<HgdRecordVo> getRecord(
            @RequestParam(value = "recordType", defaultValue = "") @ApiParam(value = "打卡类型(0:上班打卡|1:外出打卡|2:补卡)") String recordType,
            @RequestParam(value = "userId", required = false) @ApiParam(value = "用户ID", example = "1") Integer userId,
            @RequestParam(value = "endTime") @ApiParam("查询结束时间,格式为yyyy/MM/dd") Date endTime,
            @RequestParam("startTime") @ApiParam("查询开始时间,格式为yyyy/MM/dd") Date startTime,
            @RequestParam(value = "pageNum", defaultValue = "1") @ApiParam(value = "当前页,默认为1", example = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") @ApiParam(value = "页容量，默认为10", example = "10") int pageSize)
            throws ParseException {
        log.info("查询打卡记录");
        return this.baseBiz.getRecord(recordType, userId, endTime, startTime, pageNum, pageSize);
    }
}