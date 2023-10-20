package com.manavs.wf86test;

import com.manavs.wf86test.service.QueryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Wf86TestApplication {

//    @Bean
//    public QueryService getQueryService() {
//        return new QueryService();
//    }

    public static void main(String[] args) {
        SpringApplication.run(Wf86TestApplication.class, args);
    }

}
