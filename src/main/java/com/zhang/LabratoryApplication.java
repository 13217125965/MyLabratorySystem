package com.zhang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = {"com.zhang.sys.mapper","com.zhang.message.mapper","com.zhang.bus.mapper","com.zhang.stat.mapper"})
public class LabratoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabratoryApplication.class, args);
    }

}
