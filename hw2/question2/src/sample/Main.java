package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Ibrahim Yazici");

        Label[] labels = new Label[5];
        labels[0] = new Label("Flame Thrower");
        labels[1] = new Label("AutoRifle");
        labels[2] = new Label("Rocket Launcher");
        labels[3] = new Label("Laser");
        labels[4] = new Label("");

        TextField[] textFields = new TextField[4];
        textFields[0] = new TextField("0");
        textFields[1] = new TextField("0");
        textFields[2] = new TextField("0");
        textFields[3] = new TextField("0");

        Button decButton = new Button("DEC");
        decButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ExoskeletonArmoredSuit exoskeletonArmoredSuit = new SuitDec();
                exoskeletonArmoredSuit = addParts(exoskeletonArmoredSuit, textFields);
                labels[4].setText(exoskeletonArmoredSuit.cost().toString());

            }
        });

        Button oraButton = new Button("ORA");
        oraButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ExoskeletonArmoredSuit exoskeletonArmoredSuit = new SuitOra();
                exoskeletonArmoredSuit = addParts(exoskeletonArmoredSuit, textFields);
                labels[4].setText(exoskeletonArmoredSuit.cost().toString());
            }
        });

        Button torButton = new Button("TOR");
        torButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ExoskeletonArmoredSuit exoskeletonArmoredSuit = new SuitTor();
                exoskeletonArmoredSuit = addParts(exoskeletonArmoredSuit, textFields);
                labels[4].setText(exoskeletonArmoredSuit.cost().toString());
            }
        });


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(labels[0], 0, 1);
        grid.add(labels[1], 0, 2);
        grid.add(labels[2], 0, 3);
        grid.add(labels[3], 0, 4);
        grid.add(textFields[0], 1, 1);
        grid.add(textFields[1], 1, 2);
        grid.add(textFields[2], 1, 3);
        grid.add(textFields[3], 1 ,4);
        grid.add(decButton, 0, 5);
        grid.add(oraButton, 1, 5);
        grid.add(torButton, 2, 5);
        grid.add(labels[4], 0, 6);

        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public ExoskeletonArmoredSuit addParts(ExoskeletonArmoredSuit ex, TextField[] amounts) {

        for(int i = 0 ; i < amounts.length; ++i) {
            int amount = 0;
            try{
                amount = Integer.parseInt(amounts[i].getText().toString());
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a valid integer number. The number is set to 0");
            }
            if(amount < 0 || amount > 5) {
                System.out.println("Maximum number of items you can purchase per suit is 5. You are not Ironman. Amount is set to 1");
                amount = 1;
            }
            for(int j = 0; j < amount; ++j) {
                switch (i){
                    case 0:
                        ex = new PartFlameThrower(ex);
                        break;
                    case 1:
                        ex = new PartAutoRifle(ex);
                        break;
                    case 2:
                        ex = new PartRocketLauncher(ex);
                        break;
                    case 3:
                        ex = new PartLaser(ex);
                        break;
                }
            }
        }
        return ex;
    }
}
