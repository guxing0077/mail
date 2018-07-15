package com.lee.component;

import com.lee.BaseTest;
import com.lee.dto.MailDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SendMailTest extends BaseTest {

    @Autowired
    private SendMail sendMail;

    @Test
    public void sendMail() throws Exception {
        MailDTO mailInfo = new MailDTO();
        mailInfo.setContent("测试邮件发送的");
        mailInfo.setRecipient("308374811@qq.com");
        mailInfo.setTitle("lee");
        sendMail.sendMail(mailInfo);
    }
}