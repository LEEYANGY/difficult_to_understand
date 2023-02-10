package xyz.leeyangy;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.leeyangy.mail.Mail;
import xyz.leeyangy.mail.SendMailBuilder;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SkillsSpringbootApplicationTests {

    @Autowired
    private SendMailBuilder sendMailBuilder;

    @Test
    void contextLoads() {
        Mail mail = new Mail();
        mail.setTheme("主题：测试 " + new Date());
        mail.setSendTime(new Date());
        mail.setSendMailAccount("null@foxmail.com");
        mail.setMailText("有内鬼终止交易");
        mail.setAcceptMailAccount("null@qq.com");

        sendMailBuilder.sendSimpleMail(mail);
    }

}
