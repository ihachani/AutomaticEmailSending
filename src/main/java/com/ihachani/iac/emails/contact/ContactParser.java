package com.ihachani.iac.emails.contact;

import com.ihachani.iac.emails.domain.Contact;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactParser {


    public Contact parseMaleContactString(String contact_string) {
        String[] rawInformations = contact_string.split("\t");
        Contact contact = createMaleContact(rawInformations);
        return contact;
    }

    private Contact createMaleContact(String[] rawInformations) {
        Contact contact = createContactFromInformationArray(rawInformations);
        contact.setSex("Monsieur");
        return contact;
    }

    private Contact createContactFromInformationArray(String[] rawInformations) {
        Contact contact = new Contact();
        contact.setCompanyName(rawInformations[0]);
        contact.setEmail(rawInformations[1]);
        try {
            contact.setName(rawInformations[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            //Move on
        }

        return contact;
    }

    public Contact parseFemaleContactString(String contact_string) {
        String[] rawInformations = contact_string.split("\t");
        Contact contact = createFemaleContact(rawInformations);
        return contact;
    }

    private Contact createFemaleContact(String[] rawInformations) {
        Contact contact = createContactFromInformationArray(rawInformations);
        contact.setSex("Madame");
        return contact;
    }

    public List<Contact> parseMaleContactFile(String filePath) throws URISyntaxException, IOException {
        URI uri = ContactParser.class.getClassLoader().getResource(filePath).toURI();
        return Files.lines(Paths.get(uri)).map(this::parseMaleContactString).collect(Collectors.toList());
    }

    public List<Contact> parseFemaleContactFile(String filePath) throws URISyntaxException, IOException {
        URI uri = ContactParser.class.getClassLoader().getResource(filePath).toURI();
        return Files.lines(Paths.get(uri)).map(this::parseFemaleContactString).collect(Collectors.toList());
    }
}
