package com.lee.controller;

import com.lee.component.SendMailComponent;
import com.lee.dto.MailDTO;
import com.lee.req.SendMailReq;
import com.lee.res.JsonRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    private SendMailComponent sendMailComponent;

    @PostMapping("send")
    public JsonRes sendMail(@RequestBody SendMailReq sendMailReq) throws Exception {
        MailDTO mailDTO = new MailDTO();
        //todo
        sendMailComponent.sendMail(mailDTO);
        return JsonRes.success();
    }
}
