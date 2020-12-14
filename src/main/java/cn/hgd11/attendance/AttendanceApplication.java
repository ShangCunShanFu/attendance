package cn.hgd11.attendance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wangkaige
 * @date 2020/12/14
 */
@SpringBootApplication
@ComponentScan({"cn.hgd11.attendance"})
@MapperScan("cn.hgd11.server.withdb.mapper")
public class AttendanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AttendanceApplication.class, args);
    }
}
