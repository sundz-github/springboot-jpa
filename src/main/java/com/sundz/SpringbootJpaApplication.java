package com.sundz;

import com.sundz.service.message.CommonServer;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author Sundz
 */
@SpringBootApplication
@Import(CommonServer.class)
@Log4j2
@EnableRabbit
public class SpringbootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
        log.info("<---------------SpringbootDemoApplication is staring--------------->");
    }


}
