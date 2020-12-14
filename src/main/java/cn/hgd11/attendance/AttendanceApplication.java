package cn.hgd11.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 尚村山夫
 * @version 2020-12-14 21:14:31
 * @email
 */
@SpringBootApplication
@ComponentScan({"cn.hgd11.attendance"})
@MapperScan("cn.hgd11.attendance.mapper")
public class AttendanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AttendanceApplication.class, args);
    }
}
