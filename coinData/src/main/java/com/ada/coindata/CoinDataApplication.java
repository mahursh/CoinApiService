package com.ada.coindata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoinDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoinDataApplication.class, args);
    }

}
