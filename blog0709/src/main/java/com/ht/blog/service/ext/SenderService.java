package com.ht.blog.service.ext;

import com.ht.blog.configurer.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderService
{
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send() {
        System.out.println("梁桂钊 发送消息...");
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, "你好， 梁桂钊!");
    }
}
