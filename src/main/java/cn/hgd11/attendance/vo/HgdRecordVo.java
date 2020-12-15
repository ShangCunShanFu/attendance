package cn.hgd11.attendance.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @author: 尚村山夫
 * @date: Created in 2020/12/15 19:18
 * @description:
 **************************************/
@Data
@ApiModel(description = "打卡记录响应体")
public class HgdRecordVo {

    @ApiModelProperty(value = "记录ID", example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户名(帐号)", example = "wangkaige")
    private String username;

    @ApiModelProperty(value = "用户名(姓名)", example = "王凯歌")
    private String displayName;

    @ApiModelProperty(value = "打卡日期")
    private Date date;

    @ApiModelProperty(value = "上班打卡时间")
    private Date recordIn;

    @ApiModelProperty(value = "下班打卡时间")
    private Date recordOut;

    @ApiModelProperty(value = "上午打卡记录是否有效(0:有效|1:异常)", example = "0")
    private Integer invalidateAm;

    @ApiModelProperty(value = "下午打卡记录是否有效(0:有效|1:异常)", example = "0")
    private Integer invalidatePm;
}
