package com.doliao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * author： xueyuan
 * date  ： 2017-07-10 下午8:58
 */

@SpringBootApplication
@MapperScan(basePackages = "com.doliao.mapper")
@ServletComponentScan
public class ApplicationConfig extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.run(ApplicationConfig.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的AppConfig启动类
        return builder.sources(ApplicationConfig.class);
    }
}
