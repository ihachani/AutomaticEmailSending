package com.ihachani.iac.emails.configuration;

import com.ihachani.iac.emails.emailcreation.EmailFileReader;
import com.ihachani.iac.emails.emailcreation.EmailFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.net.URISyntaxException;

@Configuration
@PropertySource("classpath:application.properties")
public class EmailCreationConfiguration {

    @Value("${email.text.path}")
    private String emailTextPath;

    @Bean
    public EmailFormatter emailFormatter(EmailFileReader emailFileReader) throws IOException, URISyntaxException {
        EmailFormatter emailFormatter = new EmailFormatter();
        System.out.println("EmailCreationConfiguration.emailFormatter");
        System.out.println(emailTextPath);
        emailFormatter.setEmailText(emailFileReader.putFileString(emailTextPath));

        return emailFormatter;
    }
}
