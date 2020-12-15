package cn.hgd11.attendance.controller;

import cn.hgd11.attendance.model.HgdRecordConfig;
import cn.hgd11.attendance.service.HgdRecordConfigService;
import cn.hgd11.common.entity.ObjectResultResponse;
import cn.hgd11.tk.mybatis.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("hgdRecordConfig")
@Slf4j
@Api(tags = "有效打卡时间配置")
public class HgdRecordConfigController extends BaseController<HgdRecordConfigService,HgdRecordConfig,Integer> {
    @PutMapping
    @ApiOperation("随机添加打卡记录")
    public ObjectResultResponse<HgdRecordConfig> recordConfig(
            @RequestBody @Validated HgdRecordConfig hgdRecordConfig,
            BindingResult bindingResult) {
        log.info("随机添加打卡记录");
        return this.baseBiz.recordConfig(hgdRecordConfig);
    }
}