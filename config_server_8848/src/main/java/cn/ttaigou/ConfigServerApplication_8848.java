package cn.ttaigou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication//声明springboot应用启动main
@EnableEurekaClient//注册config服务到eureka
@EnableConfigServer//声明是configserver
public class ConfigServerApplication_8848 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication_8848.class);
    }
}

