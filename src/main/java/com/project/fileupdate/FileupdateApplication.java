package com.project.fileupdate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.project.dao")
@ComponentScan("com.project.*")
public class FileupdateApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileupdateApplication.class, args);
    }

}
