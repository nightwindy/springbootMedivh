package com.windy.medivh.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:dubbo/dubbo-all.xml")
public class DubboConfig {
}
