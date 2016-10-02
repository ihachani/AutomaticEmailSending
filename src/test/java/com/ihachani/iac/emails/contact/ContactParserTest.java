package com.ihachani.iac.emails.contact;

import com.ihachani.iac.emails.domain.Contact;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactParserTest {
    private ContactParser contactParser;
    private final String CONTACT_STRING = "company\tperson@server.com\t55322082\tname\t";
    private final String FILE_PATH = "TestMaleSponsorsList.txt";

    @Before
    public void setUp() throws Exception {
        contactParser = new ContactParser();
    }

    @Test
    public void testParseMaleContactString() {
        Contact maleContact = contactParser.parseMaleContactString(CONTACT_STRING);
        Contact expectedMaleContact = new Contact("name", "Monsieur", "person@server.com", "company");
        assertThat("The 2 contacts should be equal", maleContact, is(expectedMaleContact));
    }

    @Test
    public void testParseFemaleContactString() throws Exception {
        Contact femaleContact = contactParser.parseFemaleContactString(CONTACT_STRING);
        Contact expectedFemaleContact = new Contact("name", "Madame", "person@server.com", "company");
        assertThat("The 2 contacts should be equal", femaleContact, is(expectedFemaleContact));
    }

    @Test
    public void testParseMaleContactFile() throws Exception {
        List<Contact> contacts = contactParser.parseMaleContactFile(FILE_PATH);
        List<Contact> expectedContacts = new ArrayList<Contact>();
        expectedContacts.add(new Contact("name1", "Monsieur", "person@server.tn", "companyName1"));
        expectedContacts.add(new Contact("name2", "Monsieur", "person@server.tn", "companyName2"));

        assertThat("The contacts should contain the same data as the file",
                contacts,containsInAnyOrder(expectedContacts.toArray())
                );
    }

    @Test
    public void testParseFemaleContactFile() throws Exception {
        List<Contact> contacts = contactParser.parseFemaleContactFile(FILE_PATH);
        List<Contact> expectedContacts = new ArrayList<Contact>();
        expectedContacts.add(new Contact("name1", "Madame", "person@server.tn", "companyName1"));
        expectedContacts.add(new Contact("name2", "Madame", "person@server.tn", "companyName2"));

        assertThat("The contacts should contain the same data as the file",
                contacts,containsInAnyOrder(expectedContacts.toArray())
                );
    }
}