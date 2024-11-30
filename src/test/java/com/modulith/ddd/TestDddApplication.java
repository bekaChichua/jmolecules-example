package com.modulith.ddd;

import org.springframework.boot.SpringApplication;

public class TestDddApplication {

    public static void main(String[] args) {
        SpringApplication.from(DddApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
