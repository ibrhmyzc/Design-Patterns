package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Ibrahim Yazici");

        Button button = new Button("Execute Demo");
        TextArea textArea = new TextArea();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(button, 0, 0);
        gridPane.add(textArea, 0, 1);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                runDemo();
                try{
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("output.txt")));
                    String line;
                    while((line = bufferedReader.readLine()) != null) {
                        textArea.setText(textArea.getText() + System.lineSeparator() + line);
                    }
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("output exception");
                }
            }
        });


        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void runDemo() {
        // Personal Emails
        PersonalEmail personalEmail = new PersonalEmail(new Email("ibrahim yazici", "iyazici@hotmail.com"));
        PersonalEmail personalEmail2 =  new PersonalEmail(new Email("murat eynehan", "meynehan@hotmail.com"));
        PersonalEmail personalEmail3 = new PersonalEmail(new Email("mikael ingemansson", "miki@hotmail.com"));

        EmailService rootEmailCategory = new Hw3Composite("All Emails", true);

        EmailService personalCategory = new Hw3Composite(null, false);

        personalCategory.addEmail(personalEmail);
        personalCategory.addEmail(personalEmail2);
        personalCategory.addEmail(personalEmail3);

        // iyte
        PersonalEmail personalEmail4 =  new PersonalEmail(new Email("Daniel Ocean", "docean@iyte.edu.tr"));
        PersonalEmail personalEmail5 = new PersonalEmail(new Email("IYTE Support", "idestek@iyte.edu.tr"));

        EmailService iyteCategory = new Hw3Composite("IYTE", true);

        iyteCategory.addEmail(personalEmail4);
        iyteCategory.addEmail(personalEmail5);

        // ege
        PersonalEmail personalEmail6 =  new PersonalEmail(new Email("CS Society", "iizmir@ege.edu.tr"));
        PersonalEmail personalEmail7 = new PersonalEmail(new Email("Student Affairs", "saffairs@ege.edu.tr"));

        EmailService egeCategory = new Hw3Composite("EGE U.", true);

        egeCategory.addEmail(personalEmail6);
        egeCategory.addEmail(personalEmail7);

        // gtu
        PersonalEmail personalEmail8 =  new PersonalEmail(new Email("Yusuf Akgul", "ysa@gtu.edu.tr"));
        PersonalEmail personalEmail9 = new PersonalEmail(new Email("Erhan Aptoluka", "eap@gtu.edu.tr"));

        EmailService gtuCategory = new Hw3Composite("GTU", true);

        gtuCategory.addEmail(personalEmail8);
        gtuCategory.addEmail(personalEmail9);

        // kou
        PersonalEmail personalEmail10 =  new PersonalEmail(new Email("Orcun Bronzkilic", "okilic@kou.edu.tr"));
        PersonalEmail personalEmail11 = new PersonalEmail(new Email("Kou erasmus", "kouerasmus@kou.edu.tr"));

        EmailService kouCategory = new Hw3Composite("Kocaeli U.", true);

        kouCategory.addEmail(personalEmail10);
        kouCategory.addEmail(personalEmail11);


        EmailService izmirUnis = new Hw3Composite("Unis that are located in Izmir", true);
        izmirUnis.addEmail(iyteCategory);
        izmirUnis.addEmail(egeCategory);

        EmailService kocaeliUnis = new Hw3Composite("Unis that are located in Kocaeli", true);
        kocaeliUnis.addEmail(gtuCategory);
        kocaeliUnis.addEmail(kouCategory);

        EmailService universities = new Hw3Composite("Universities", true);
        universities.addEmail(izmirUnis);
        universities.addEmail(kocaeliUnis);

        PersonalEmail personalEmail12 = new PersonalEmail(new Email("Boss of all universities", "boss@uni.edu.tr"));
        universities.addEmail(personalEmail12);

        // adding to each other
        rootEmailCategory.addEmail(personalCategory);
        rootEmailCategory.addEmail(universities);

        Client client = new Client(rootEmailCategory);

        client.printEmails();
    }
}
