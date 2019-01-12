package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

import static java.lang.System.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Ibrahim Yazici");

        Button dftButton = new Button("DFT");
        Button dctButton = new Button("DCT");
        TextArea textArea = new TextArea();
        Label label = new Label();
        CheckBox checkBox = new CheckBox("Show execution time");


        label.setText("The input will be read from \"inputs.txt\" " +
                 System.lineSeparator() +"which must be in the same direction with the executable");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(dftButton, 0, 0);
        gridPane.add(dctButton, 0, 1);
        gridPane.add(textArea, 0, 2);
        gridPane.add(checkBox, 0, 3);
        gridPane.add(label, 0, 4);

        dftButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FourierTransform fourierTransform = new DiscreteFourier();
                try {
                    String result = Arrays.toString(fourierTransform.templateMethod());
                    if(checkBox.isSelected()){
                        result += System.lineSeparator() + "Execution time : " + fourierTransform.timeSpent() + "ms";
                    }
                    textArea.setText(result);
                } catch (IOException e) {
                    out.println("Error with dft");
                }
            }
        });

        dctButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FourierTransform fourierTransform = new DiscreteCosine();
                try {
                    String result = Arrays.toString(fourierTransform.templateMethod());
                    textArea.setText(result);
                } catch (IOException e) {
                    out.println("Error with dct");
                }
            }
        });

        Scene scene = new Scene(gridPane, 350, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
