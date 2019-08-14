package com.ht.blog.service.rabbitListenser;

import com.ht.blog.service.ext.MailService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Message;

import java.io.IOException;
import java.util.Map;

@Service
public class SendRegisterMailService
{
    @Autowired
    private MailService mailService;

    @RabbitListener(queues = "send_register_mail_queue_name",
                concurrency = "3")
    public void receiveMessage(Map<String, String> map, Message message, Channel channel)
    {
        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println(Thread.currentThread().hashCode() + " 接~1消息");
            mailService.sendMail(map.get("title"), map.get("content"), map.get("email"));

            //TODO  通知MQ 消息已被成功消费，可以ACK了y
            channel.basicAck(deliveryTag, false);
        } catch (IOException | MailException e) {
            //处理失败， 重新压入MQ
            try {
                channel.basicRecover();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @RabbitListener(queues = "send_register_mail_queue_name2",concurrency = "2")
    public void receiveMessage2(Map<String, String> map, Message message, Channel channel)
    {
        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println(Thread.currentThread().hashCode() + " 接~2消息");
            //mailService.sendMail(map.get("title"), map.get("content"), map.get("email"));

            //TODO  通知MQ 消息已被成功消费，可以ACK了y
            channel.basicAck(deliveryTag, false);
        } catch (IOException | MailException e) {
            //处理失败， 重新压入MQ
            try {
                channel.basicRecover();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
//
//    @RabbitListener(queues = "send_register_mail_queue_name")
//    public void receiveMessage3(Map<String, String> map, Message message, Channel channel)
//    {
//        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        try {
//            System.out.println(Thread.currentThread().hashCode() + " 接~3消息");
//            //mailService.sendMail(map.get("title"), map.get("content"), map.get("email"));
//
//            //TODO  通知MQ 消息已被成功消费，可以ACK了y
//            channel.basicAck(deliveryTag, false);
//        } catch (IOException | MailException e) {
//            //处理失败， 重新压入MQ
//            try {
//                channel.basicRecover();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//        }
//    }
}
