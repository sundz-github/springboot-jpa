package com.jpa;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2020/11/3 20:34
 */
@Log4j2
public class RabbitMqTest extends BaseTest{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    /*@Test
    public void sendJob(){
        User user = new User();
        user.setCicCity("上海");
        Date now = new Date();
        *//*DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = now.format(fomatter);*//*
        user.setDate(now);
        user.setCicMail("123456@163.com");
        Job job = new Job(1,"战士","超级赛尔亚人",user);
        rabbitTemplate.convertAndSend("amq1.direct","/queues1",job);
        log.info("消息发送成功!");
    }
*/
    @Test
    public void sendString() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", 10);
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("text/plain");
        messageProperties.setHeader("head","nihao");
        Message message = new Message("ni".getBytes(), messageProperties);
        rabbitTemplate.send("amq1.direct", "/queues1",message);
        log.info("消息发送成功!");
    }

    @Test
    public void receive(){
        /*Object message = rabbitTemplate.receiveAndConvert("queues1");*/
        Message receive = rabbitTemplate.receive("queues1");
        System.out.println("从队列中获取的数据为:"+receive.getMessageProperties().getUserId());
    }

    @Test
    public void rabbitAdminTest(){
        System.out.println();
    }


}
