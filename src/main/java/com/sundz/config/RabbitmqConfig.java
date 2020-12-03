package com.sundz.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2020/11/4 12:42
 */
@Configuration
public class RabbitmqConfig {

    /**
     *  配置数据转化器
     * @param
     * @return {@link MessageConverter}
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
