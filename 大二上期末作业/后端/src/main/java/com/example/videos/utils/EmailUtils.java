package com.example.videos.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * 邮件工具类
 * 参考文章: https://blog.csdn.net/qq_52208113/article/details/123180330
 */
@Slf4j
public class EmailUtils {
    private static final Session session;

    // 用户名
    private static final String mail_user = "3412735825@qq.com";
    // 密码
    private static final String mail_smtp_password = "qycgbcuojhibchac";
    // debug模式
    private static final Boolean debug = false;

    static {
        try {
            Properties prop = new Properties();
            prop.setProperty("mail.host", "smtp.qq.com");
            prop.setProperty("mail.transport.protocol", "smtp");
            prop.setProperty("mail.smtp.auth", "true");
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            prop.put("mail.smtp.ssl.enable", "false");
            prop.put("mail.smtp.ssl.socketFactory", sf);
            session = Session.getDefaultInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //发件人邮件用户名，授权码
                    return new PasswordAuthentication(mail_user, mail_smtp_password);
                }
            });
            session.setDebug(debug);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean send(MimeMessage message) {
        try {
            Transport ts = session.getTransport();
            ts.connect("smtp.qq.com", mail_user, mail_smtp_password);
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
            return true;
        } catch (MessagingException e) {
            log.error("邮件发送失败信息错误:" + e);
            return false;
        }
    }

    /**
     * 发送简单文本(html)信息
     *
     * @param to    String 目标邮箱
     * @param title String 邮件标题
     * @param msg   String 邮件内容
     * @return boolean 发送成功为true
     */
    public static boolean sendSimpleMessage(String to, String title, String msg) {
        try {
            MimeMessage message = new MimeMessage(session);
            //指明邮件的发起人
            message.setFrom(new InternetAddress(mail_user));
            //指明邮件的收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //邮件的标题
            message.setSubject(title);
            //邮件的文本内容（也可写为HTML语句）
            message.setContent(msg, "text/html;charset=UTF-8");
            // 判断是否发送成功
            if (send(message)) {
                return true;
            }
        } catch (AddressException e) {
            log.error("邮件发送失败地址错误:" + e);
            return false;
        } catch (MessagingException e) {
            log.error("邮件发送失败信息错误:" + e);
            return false;
        }
        return false;
    }
}
