package xyz.leeyangy.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * @Author liyangyang
 * @Date: 2023/02/11 0:54
 * @Package xyz.leeyangy.mail
 * @Version 1.0
 * @Description:
 */

@Component
public class SendMailBuilder {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送简单邮件
     */
    public void sendSimpleMail(Mail model) {

        //构建邮件内容对象
        SimpleMailMessage msg  = new SimpleMailMessage();
        //邮件发送者
        msg.setFrom(model.getSendMailAccount());
        //邮件接收者
        msg.setTo(model.getAcceptMailAccount());
        //邮件主题
        msg.setSubject(model.getTheme());
        //邮件正文
        msg.setText(model.getMailText());
        //邮件发送时间
        msg.setSentDate(model.getSendTime());
        //邮件发送
        javaMailSender.send(msg);
    }

}
