package org.example.homework_1_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.homework_1_back.dao")
public class Homework1BackApplication {

    public static void main(String[] args) {
        SpringApplication.run(Homework1BackApplication.class, args);
    }

}
