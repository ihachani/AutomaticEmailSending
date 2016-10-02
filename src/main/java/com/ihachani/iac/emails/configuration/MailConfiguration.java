package com.ihachani.iac.emails.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"com.ihachani.iac.emails"})
public class MailConfiguration {
    @Bean
    public JavaMailSender javaMailSender(Environment env) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mailserver.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("mailserver.port")));
        mailSender.setUsername(env.getProperty("mailserver.username"));
        mailSender.setPassword(env.getProperty("mailserver.password"));
        mailSender.setJavaMailProperties(getMailProperties());
        return mailSender;
    }

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.debug", "true");
//        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        properties.put("mail.smtp.socketFactory.fallback", "false");
        return properties;
    }
}
