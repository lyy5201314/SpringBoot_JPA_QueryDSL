package com.zx.demo;

import com.zx.demo.base.api.cors.WebConfig;
import com.zx.demo.core.CoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@Import({CoreConfig.class, WebConfig.class})
@EnableJpaAuditing
public class DemobApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemobApplication.class, args);
    }

}
