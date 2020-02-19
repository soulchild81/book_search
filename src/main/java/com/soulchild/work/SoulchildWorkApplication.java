package com.soulchild.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class SoulchildWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoulchildWorkApplication.class, args);
    }

}
