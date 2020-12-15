package cn.hgd11.attendance.vo;

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
public class HgdRecordVo {

    private Integer id;

    private String username;

    private String displayName;

    private Date date;

    private Date recordIn;

    private Date recordOut;

    private Integer invalidateAm;

    private Integer invalidatePm;
}
