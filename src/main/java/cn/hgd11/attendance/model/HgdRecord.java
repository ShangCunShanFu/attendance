package cn.hgd11.attendance.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;


/**
 * 
 * 
 * @author 尚村山夫
 * @email 
 * @version 2020-12-14 21:14:31
 */
@Table(name = "hgd_record")
@Data
public class HgdRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    private Integer id;
	
	    // 打卡时间
    @Column(name = "record_time")
    private Date recordTime;
	
	    // 打卡人
    @Column(name = "user_id")
    private Integer userId;
	
	    // 是否删除(0:否|1:是)
    @Column(name = "delete_flag")
    private String deleteFlag;

	    // 打卡类型(0:上班打卡|1:外出打卡|2:补卡)
    @Column(name = "record_type")
    private String recordType;

}
