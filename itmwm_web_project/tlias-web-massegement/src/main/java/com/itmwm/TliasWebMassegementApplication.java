package com.itmwm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan  // 开启了对 servlet 组件的支持
@SpringBootApplication
public class TliasWebMassegementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebMassegementApplication.class, args);
    }

}
