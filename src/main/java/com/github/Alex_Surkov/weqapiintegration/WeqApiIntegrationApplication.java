package com.github.Alex_Surkov.weqapiintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "net.proselyte.catapiintegration.api")
@SpringBootApplication
public class WeqApiIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeqApiIntegrationApplication.class, args);
    }

}
