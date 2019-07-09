package com.ht.blog.configurer;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
    public static final String QUEUE_NAME = "spring-boot-simple";

    public static final String SEND_REGISTER_MAIL_QUEUE_NAME = "send_register_mail_queue_name";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Queue sendRegisterMailQueueName() {
        return new Queue(SEND_REGISTER_MAIL_QUEUE_NAME);
    }
}
