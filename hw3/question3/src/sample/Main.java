package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Ibrahim Yazici");

        Label label = new Label("Input will be provided from input.txt" +
                System.lineSeparator() + "that must be in the same directory with executable" +
                System.lineSeparator() + "Every line is a row and numbers seperated by a white space" +
                System.lineSeparator() + "is an element in the matrix");

        Button button = new Button();
        button.setText("Print");

        TextField text = new TextField();
        text.setMinWidth(500);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SatelliteData turkishSpaceAgency = new SatelliteData("input.txt");
                for (Object o : turkishSpaceAgency)
                    text.setText(text.getText() + "  " + o.toString());
            }
        });



        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(button, 0, 0);
        grid.add(text, 0, 1);
        grid.add(label,0, 2);

        Scene scene = new Scene(grid, 750, 175);
        primaryStage.setScene(scene);
        primaryStage.show();

        System.out.println("\nFinished");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
