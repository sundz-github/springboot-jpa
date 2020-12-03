package com.sundz.service.message;

import com.rabbitmq.client.impl.AMQImpl;
import com.sundz.jpa.entity.Job;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p> 同一队列不同消息类型，应该采用@RabbitListener和@RabbitHandler搭配使用 </p>
 *
 * @author Sundz
 * @date 2020/11/3 20:09
 */
@Service
@RabbitListener(queues = {"queues1"}/*, ackMode = "AUTO"*/)
public class RabbitMqServer {

    /**
     * @field 当带有@Header时，且需要在生产者进行指定，否则将报错（或者指出非必须）
     */
    @RabbitHandler
    public void listenerStr(@Payload Map<String, Object> payLoad, @Header(value = "name",required = false) String heads, AMQImpl.Channel channel) {
        System.out.println("listenerStr获取的消息:" + payLoad + ", 头:" + heads);
    }

    /**
     * @field 处理Job类
     */
    @RabbitHandler
    public void listenerJob(@Payload Job payLoad) {
        System.out.println("listenerJob获取的消息:" + payLoad);
    }

}
