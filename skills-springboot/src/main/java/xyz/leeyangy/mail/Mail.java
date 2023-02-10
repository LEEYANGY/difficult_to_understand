package xyz.leeyangy.mail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author liyangyang
 * @Date: 2023/02/11 0:59
 * @Package xyz.leeyangy.mail
 * @Version 1.0
 * @Description:
 */

@ApiModel(value = "基本邮件参数",description = "基本邮件参数")
public class Mail {
    @ApiModelProperty("发件人邮箱账号")
    private String sendMailAccount;

    @ApiModelProperty("收件人邮箱账号")
    private String acceptMailAccount;

    @ApiModelProperty("邮件主题")
    private String theme;

    @ApiModelProperty("邮件内容")
    private String mailText;

    @ApiModelProperty("发送时间")
    private Date sendTime = new Date();

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getSendMailAccount() {
        return sendMailAccount;
    }
    public void setSendMailAccount(String sendMailAccount) {
        this.sendMailAccount = sendMailAccount;
    }
    public String getAcceptMailAccount() {
        return acceptMailAccount;
    }
    public void setAcceptMailAccount(String acceptMailAccount) {
        this.acceptMailAccount = acceptMailAccount;
    }
    public Date getSendTime() {
        return sendTime;
    }
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
    public String getMailText() {
        return mailText;
    }
    public void setMailText(String mailText) {
        this.mailText = mailText;
    }

}
