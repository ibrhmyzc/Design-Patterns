package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Hw3Composite extends EmailService {
    private String nameOftTheGroup;
    private boolean isGroup;
    private Set<EmailService> listOfEmailAddresses = new HashSet<>();

    /**
     * Constructor for composite object
     * @param nameOftTheGroup
     * @param isGroup
     */
    public Hw3Composite(String nameOftTheGroup, boolean isGroup) {
        if(!isGroup)
            this.nameOftTheGroup = "Personal";
        else
            this.nameOftTheGroup = nameOftTheGroup;
        this.isGroup = isGroup;
    }

    public boolean addEmail(EmailService emailService) {
        return listOfEmailAddresses.add(emailService);
    }

    public boolean removeEmail(EmailService emailService) {
        return listOfEmailAddresses.add(emailService);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>").append(System.lineSeparator());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        sb.append(nameOftTheGroup).append(System.lineSeparator());
        System.out.println(nameOftTheGroup);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("output.txt"), true));
            bufferedWriter.write(sb.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("output error");
        }
        for(EmailService e: listOfEmailAddresses) {
            e.print();
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("output.txt"), true));
            bufferedWriter.write("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + System.lineSeparator());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("output error");
        }

        return sb.toString();
    }

}
