package com.viettel.websocket.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.viettel.websocket.test")
public class SpringWebSocketMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringWebSocketMain.class);
    }
}
