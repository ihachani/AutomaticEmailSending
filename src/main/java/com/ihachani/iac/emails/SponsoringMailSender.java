package com.ihachani.iac.emails;

import com.ihachani.iac.emails.configuration.MailConfiguration;
import com.ihachani.iac.emails.contact.ContactParser;
import com.ihachani.iac.emails.domain.Contact;
import com.ihachani.iac.emails.emailcreation.EmailFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class SponsoringMailSender {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    EmailFormatter emailFormatter;
    @Autowired
    ContactParser contactParser;

    @Value("${dossier.path}")
    private String dossierPath;

    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("hachani.ilyes@gmail.com");
        message.setSubject("Message Using Spring ");
        message.setText(emailFormatter.formatEmail("Monsieur", "ihachani"));

        mailSender.send(message);
    }

    public void sendMail(Contact contact) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("contact@insatandroidclub.org");
        message.setTo(contact.getEmail());
        message.setSubject("Sponsoring DroidDay5");
        message.setText(emailFormatter.formatEmail(contact.getSex(), contact.getCompanyName()));

        mailSender.send(message);
    }

    public void sendMailWithAttachement(Contact contact) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("contact@insatandroidclub.org");
        helper.setTo(contact.getEmail());
        helper.setSubject("Sponsoring DroidDay5");
        helper.setText(emailFormatter.formatEmail(contact.getSex(), contact.getCompanyName()));
        FileSystemResource couponImage =
                new FileSystemResource(dossierPath);

        mailSender.send(message);
    }


    public static void main(String[] args) throws MessagingException, IOException, URISyntaxException {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(MailConfiguration.class);
        SponsoringMailSender mm = (SponsoringMailSender) context.getBean("sponsoringMailSender");
        mm.sendMailWithAttachement(new Contact("Ilyes", "Monsieur", "hachani.ilyes@gmail.com", "IAC"));

        List<Contact> malecontacts = mm.contactParser.parseMaleContactFile("SponsorsListMale.txt");
        List<Contact> femaleontacts = mm.contactParser.parseFemaleContactFile("SponsorsListFemale.txt");
        System.out.println("Male#############################################");
        System.out.println(malecontacts);
        System.out.println("Female#############################################");
        System.out.println(femaleontacts);
//        mm.sendMailsToContactList(malecontacts);
        mm.sendMailsToContactList(femaleontacts);
//        mm.sendMail();
    }

    private void sendMailsToContactList(List<Contact> contacts) {
        contacts.stream().forEach(this::sendMail);
    }
}
