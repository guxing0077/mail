package com.lee.component;

import com.lee.dto.MailDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @ClassName: Sendmail
 * @Description: 发送Email
 * @author: 孤傲苍狼
 * @date: 2015-1-12 下午9:42:56
 *
 */
@Component
public class SendMailComponent {

    @Value("${mail.host}")
    private String mailHost;

    @Value("${mail.from.user}")
    private String sendUser;

    @Value("${mail.from.password}")
    private String sendPassword;

    /**
     * 发送邮件
     * @param mailInfo 邮件信息
     */
    public void sendMail(MailDTO mailInfo) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host", mailHost);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect(mailHost, sendUser, sendPassword);
        //4、创建邮件
        Message message = createSimpleMail(session, mailInfo);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     * @Anthor:孤傲苍狼
     *
     * @param session
     * @param mailInfo 邮件信息
     * @return
     * @throws Exception
     */
    private MimeMessage createSimpleMail(Session session, MailDTO mailInfo)
            throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress(sendUser));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailInfo.getRecipient()));
        //邮件的标题
        message.setSubject(mailInfo.getTitle());
        //邮件的文本内容
        message.setContent(mailInfo.getContent(), "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }


    public static void main(String[] args) {
        int i = 1;
        do{
            System.out.println("x:" + i);
            i++;
        }while (i<=4);
    }
}