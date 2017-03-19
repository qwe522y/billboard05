package com.sotas.billboard05.service;

import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.util.Properties;

public class MailMsgService implements MsgService {
    private static Logger log = Logger.getLogger(MailMsgService.class.getName());
    private String mail;
    private String password;
    private String host;

    public MailMsgService(String mail, String password, String host) {
        this.mail = mail;
        this.password = password;
        this.host = host;
    }

    @Override
    public void send(String addr, String msg) {
        log.info("MailMsgProvider.send (addr=" + addr + " msg=" + msg + ")");
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "25");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(mail, password);
                        }
                    }
            );
            Message message = new MimeMessage(session);
            message.setSubject("system");
            message.setFrom(new InternetAddress(mail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addr));
            message.setText(msg);
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendFile(String addr, byte[] file, String subject, String filename) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "25");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(mail, password);
                        }
                    });
            Message message = new MimeMessage(session);
            message.setSubject(subject);
            message.setFrom(new InternetAddress(mail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addr));
            Multipart multipart = new MimeMultipart();

            BodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new ByteArrayDataSource(file, "text/plain");
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(MimeUtility.encodeText(filename));
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);
            Transport.send(message);
        } catch (Exception e) {
            log.error("MailMsgProvider.send error addr=" + addr + ", subject=" + subject + ", filename=" + filename);
            throw new RuntimeException(e);
        }
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
