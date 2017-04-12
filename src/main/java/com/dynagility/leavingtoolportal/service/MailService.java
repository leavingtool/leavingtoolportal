package com.dynagility.leavingtoolportal.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    MailSender mailSender;
    private SimpleMailMessage simpleMailmessage;

    public String sendMail() throws IOException {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/main/resources/application.properties");
            prop.load(input);
            this.simpleMailmessage = new SimpleMailMessage();
            this.simpleMailmessage.setFrom(prop.getProperty("spring.mail.smtp.mail.from"));
            this.simpleMailmessage.setTo("leaving.tool@yandex.com");
            SimpleMailMessage msg = new SimpleMailMessage(this.simpleMailmessage);
            msg.setText("test");
            try {
                mailSender.send(msg);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "OK";
    }
}