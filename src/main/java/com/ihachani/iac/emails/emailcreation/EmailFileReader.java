package com.ihachani.iac.emails.emailcreation;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class EmailFileReader {
    public String putFileString(String filePath) throws IOException, URISyntaxException {
        URI uri = EmailFileReader.class.getClassLoader().getResource(filePath).toURI();
        String string = new String(Files.readAllBytes(Paths.get(uri)), Charset.forName("utf-8"));
        return string;
    }

}
