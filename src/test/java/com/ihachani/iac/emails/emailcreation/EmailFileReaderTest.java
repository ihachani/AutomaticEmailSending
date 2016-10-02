package com.ihachani.iac.emails.emailcreation;

import com.ihachani.iac.emails.emailcreation.EmailFileReader;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EmailFileReaderTest {

    private final String emailText = "Bonjour %s,\n" +
            "\n" +
            "Je suis Aymen Bokri président de l'INSAT Android Club, premier club de\n" +
            "développement Android en Tunisie.\n" +
            "\n" +
            "Pour la 5ème année consécutive, l’IAC, INSAT Android Club organise la nouvelle édition de l’évènement insolite DroidDAY, le Samedi 16 Avril 2016 à la Cité des Sciences de Tunis.\n" +
            "Une édition très spéciale, riche en nouveautés et en surprises est préparée cette année. Des ateliers sont prévus pour tout le public, durant la journée, un espace d’exposition sera dédié aux projets, des centaines de participants entre développeurs, ingénieurs et étudiants sont attendus pour participer à cette édition. Un cycle de conférences sera également réservé pour les intervenants.\n" +
            "\n" +
            "Confiants en votre soutien et votre générosité et afin que notre journée Droid Day 5.0 voit le jour, nous comptons sur %s à être notre partenaire et faire réussir l'événement.\n" +
            "\n" +
            "Vous trouviez joint à cet email le dossier sponsoring ainsi que plus de détails à propos de l'événement.\n" +
            "\n" +
            "Si vous pouviez nous accorder une date pour en discuter.\n" +
            "\n" +
            "Dans l’attente de votre réponse que nous espérons favorable, nous vous prions, %s, d’agréer l’expression de notre immense gratitude.\n" +
            "\n" +
            "Cordialement,\n" +
            "Dossier Sponsoring: https://drive.google.com/file/d/0B64xlltlZxUaMmpPZWI2ODgxVGs/view?usp=sharing\n";
    private final String fileName = "SponsoringMessage.txt";
    private EmailFileReader emailFileReader;

    @Before
    public void setUp() {
        emailFileReader = new EmailFileReader();
    }

    @Test
    public void testPutFileString() throws Exception {
        String result = emailFileReader.putFileString(fileName);
        assertThat(result, is(emailText));
    }
}