package com.ht.blog.service.ext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CommonService
{
    public Boolean verifyCaptcha(HttpSession session, String captcha)
    {
        String kaptcha = (String) session.getAttribute("verifyCode");
        if (!captcha.equals(kaptcha)) {
            return false;
        }
        return true;
    }
}
