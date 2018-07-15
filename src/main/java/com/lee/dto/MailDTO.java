package com.lee.dto;

import lombok.Data;

/**
 * 邮件dto
 */
@Data
public class MailDTO {
    //收件人
    private String recipient;
    //标题
    private String title;
    //内容
    private String content;
}
