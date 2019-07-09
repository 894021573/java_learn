package com.ht.blog.service.rabbitListenser;

import com.ht.blog.service.ext.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SendRegisterMailService
{
    @Autowired
    private MailService mailService;

    @RabbitListener(queues = "send_register_mail_queue_name")
    public void receiveMessage(Map<String,String> map) {
        mailService.sendMail(map.get("title"),map.get("content"),map.get("email"));
    }
}
