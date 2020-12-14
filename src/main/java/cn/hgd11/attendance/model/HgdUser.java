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
@Table(name = "hgd_user")
@Data
public class HgdUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    // $column.columnComment
    @Id
    private Integer id;
	
	    // 用户名(帐号)
    @Column(name = "username")
    private String username;
	
	    // 用户姓名
    @Column(name = "display_name")
    private String displayName;
	
	    // 创建时间
    @Column(name = "crt_time")
    private Date crtTime;
	
	    // 更新时间
    @Column(name = "upd_time")
    private Date updTime;
	
	    // 是否删除(0:否|1:是)
    @Column(name = "delete_flag")
    private String deleteFlag;

	    // 性别(0:男|1:女)
    @Column(name = "sex")
    private String sex;

}
