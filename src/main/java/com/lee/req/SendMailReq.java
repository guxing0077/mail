package com.lee.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("发送邮件req")
public class SendMailReq {

    @NotBlank(message = "姓名不能为空")
    private String userName;

    @NotBlank(message = "留言人邮箱")
    private String mail;

    @NotBlank(message = "留言内容")
    private String content;
}
