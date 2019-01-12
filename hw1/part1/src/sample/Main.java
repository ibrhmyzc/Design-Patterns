package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Ibrahim Yazici 131044011");

        VBox vBox = new VBox();
        Scene scene = new Scene(vBox, 350, 350);


        ComboBox comboBoxMethods = new ComboBox();
        comboBoxMethods.getItems().add("Gaussian Elimination");
        comboBoxMethods.getItems().add("Inverse Matrix");
        comboBoxMethods.getSelectionModel().selectLast();
        vBox.getChildren().add(comboBoxMethods);


        Label fileName = new Label("Input will be read from system.txt.");
        vBox.getChildren().add(fileName);
        Label textField = new Label();
        textField.setMinWidth(200);
        textField.setMinHeight(250);
        vBox.getChildren().add(textField);

        Button button = new Button("Calculate");
        vBox.getChildren().add(button);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(comboBoxMethods.getValue().equals("Gaussian Elimination")){
                    Solver s = new Solver();
                    s.setSolutionStrategy(new GaussianEliminationStrategy());
                    StringBuilder result = s.solveEquation();
                    if(result != null)
                        textField.setText(result.toString());

                } else {
                    Solver s = new Solver();
                    s.setSolutionStrategy(new InverseMatrixStrategy());
                    StringBuilder result = s.solveEquation();
                    if(result != null)
                        textField.setText(result.toString());
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

