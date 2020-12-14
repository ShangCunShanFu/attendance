package cn.hgd11.attendance.controller;

import cn.hgd11.common.entity.ObjectResultResponse;
import cn.hgd11.tk.mybatis.controller.BaseController;
import cn.hgd11.attendance.service.HgdRecordService;
import cn.hgd11.attendance.model.HgdRecord;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

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
    @ApiOperation("随机添加打卡记录")
    public ObjectResultResponse<Void> addRecord(
            @RequestParam(value = "recordType") @ApiParam(value = "打卡类型(0:上班打卡|1:外出打卡|2:补卡)") String recordType,
            @RequestParam(value = "userId") @ApiParam("用户ID") Integer userId)
            throws ParseException {
        log.info("随机添加打卡记录");
        return this.baseBiz.addRecord(recordType, userId);
    }

    @GetMapping("record")
    @ApiOperation("随机添加打卡记录")
    public ObjectResultResponse<Void> getRecord(
            @RequestParam(value = "recordType", defaultValue = "") @ApiParam(value = "打卡类型(0:上班打卡|1:外出打卡|2:补卡)") String recordType,
            @RequestParam(value = "userId", required = false) @ApiParam("用户ID") Integer userId)
            throws ParseException {
        log.info("随机添加打卡记录");
        return this.baseBiz.getRecord(recordType, userId);
    }
}