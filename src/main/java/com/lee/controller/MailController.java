package com.lee.controller;

import com.lee.req.SendMailReq;
import com.lee.res.JsonRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "发送邮件相关接口", description = "发送邮件相关接口")
@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sendUser;

    @Value("${mail.to.user}")
    private String recipient;

    @PostMapping("send")
    @ApiOperation(value = "入住接口", notes = "入住接口")
    @CrossOrigin
    public JsonRes sendMail(@RequestBody @Valid SendMailReq sendMailReq) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sendUser);
        message.setTo(recipient);
        message.setSubject(sendMailReq.getUserName() + "的留言信息");
        message.setText("\t" + sendMailReq.getUserName() + "的邮箱为: " + sendMailReq.getMail() + ", 留言信息为：" + sendMailReq.getContent());
        mailSender.send(message);
        return JsonRes.success();
    }
}
