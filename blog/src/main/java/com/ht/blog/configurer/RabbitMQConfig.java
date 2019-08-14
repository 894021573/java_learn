package com.ht.blog.configurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
    public static final String QUEUE_NAME = "spring-boot-simple";

    public static final String SEND_REGISTER_MAIL_QUEUE_NAME = "send_register_mail_queue_name";

    public static final String SEND_REGISTER_MAIL_QUEUE_NAME2 = "send_register_mail_queue_name2";

    public static final String SEND_REGISTER_MAIL_QUEUE_NAME3 = "send_register_mail_queue_name3";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Queue sendRegisterMailQueueName() {
        return new Queue(SEND_REGISTER_MAIL_QUEUE_NAME);
    }

    @Bean
    public Queue sendRegisterMailQueueName2() {
        return new Queue(SEND_REGISTER_MAIL_QUEUE_NAME2);
    }

    @Bean
    public Queue sendRegisterMailQueueName3() {
        return new Queue(SEND_REGISTER_MAIL_QUEUE_NAME3);
    }
}
