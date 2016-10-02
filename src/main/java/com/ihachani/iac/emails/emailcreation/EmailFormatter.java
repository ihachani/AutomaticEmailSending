package com.ihachani.iac.emails.emailcreation;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Formatter;

@Service
public class EmailFormatter {


    private String emailText;
    // For Some reason the MessageFormatter didn't work with the whole text message.
//    private MessageFormat emailMessageFormatter;
    public EmailFormatter() {

    }

    public EmailFormatter(String emailText) {
        this.emailText = emailText;
//        emailMessageFormatter = new MessageFormat(this.emailText);
    }

    public String formatEmail(String description, String companyName) {
        return String.format(emailText,description,companyName,description);
//        return emailMessageFormatter.format(new Object[]{description, companyName}).toString();
    }

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
//        emailMessageFormatter = new MessageFormat(this.emailText);
    }
}
