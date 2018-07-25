package com.lee.req;

import lombok.Data;

@Data
public class SendMailReq {
    private String userName;
    private String mail;
    private String content;
}
