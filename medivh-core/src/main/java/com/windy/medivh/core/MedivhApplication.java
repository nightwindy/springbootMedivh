package com.windy.medivh.core;

//import com.camaro.starter.mq.annotation.EnableMQConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author windy
 * @Date 2017-11-03
 */
@SpringBootApplication
@ComponentScan("com.windy.medivh.core")
@EntityScan("com.windy.medivh.dao.entity")
@EnableJpaRepositories("com.windy.medivh.dao.repository")
@RestController
@EnableScheduling
/*@EnableMQConfiguration*/
@EnableDiscoveryClient
public class MedivhApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedivhApplication.class, args);
    }




}
