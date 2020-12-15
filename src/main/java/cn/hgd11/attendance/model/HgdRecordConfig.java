package cn.hgd11.attendance.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;


/**
 * @author 尚村山夫
 * @version 2020-12-15 23:50:07
 * @email
 */
@Table(name = "hgd_record_config")
@Data
@ApiModel(description = "进行有效打卡时间配置--入参实体类")
public class HgdRecordConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    // $column.columnComment
    @Id
    @ApiModelProperty(hidden = true)
    private Integer id;

    // 上午打卡时间范围--开始时间
    @ApiModelProperty(value = "上午打卡时间范围--开始时间", example = "hh:MM:ss", dataType = "java.lang.String")
    @Column(name = "am_start")
    private String amStart;

    // 上午打卡时间范围--结束时间
    @ApiModelProperty(value = "上午打卡时间范围--结束时间", example = "hh:MM:ss", dataType = "java.lang.String")
    @Column(name = "am_end")
    private String amEnd;

    // 下午打卡时间范围--开始时间
    @ApiModelProperty(value = "下午打卡时间范围--开始时间", example = "hh:MM:ss", dataType = "java.lang.String")
    @Column(name = "pm_start")
    private String pmStart;

    // 下午打卡时间范围--结束时间
    @ApiModelProperty(value = "下午打卡时间范围--结束时间", example = "hh:MM:ss", dataType = "java.lang.String")
    @Column(name = "pm_end")
    private String pmEnd;

    // 创建时间
    @ApiModelProperty(hidden = true)
    @Column(name = "crt_time")
    private Date crtTime;

    // 更新时间
    @ApiModelProperty(hidden = true)
    @Column(name = "upd_time")
    private Date updTime;

    // 是否删除(0:否|1:是)
    @ApiModelProperty(hidden = true)
    @Column(name = "delete_flag")
    private String deleteFlag;

}
