package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PersonalEmail extends EmailService {
    private Email email;

    public PersonalEmail(Email email) {
        this.email = email;
    }

    public String print() {
        System.out.println(email.getEmailAddress() + " " + email.getOwnerName());
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("output.txt"), true));
            bufferedWriter.write(email.getEmailAddress() + " " + email.getOwnerName() + System.lineSeparator());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("output error");
        }
        return email.getEmailAddress() + " " + email.getOwnerName();
    }
}
