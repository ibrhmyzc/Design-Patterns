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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ibrahim yazici");

        final PlaneFactory[] planeFactory = {new PlaneModelDomestic()};

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().add("Domestic");
        comboBox.getItems().add("Eurasia");
        comboBox.getItems().add("Other");
        comboBox.getSelectionModel().selectFirst();
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String choice = (String)comboBox.getSelectionModel().getSelectedItem();
                if(choice.equals("Domestic"))
                    planeFactory[0] = new PlaneModelDomestic();
                else if(choice.equals("Eurasia"))
                    planeFactory[0] = new PlaneModelEurasia();
                else
                    planeFactory[0] = new PlaneModelOther();

            }
        });

        Label label = new Label();
        Button[] buttons = new Button[3];
        buttons[0] = new Button("Order TPX 100");
        buttons[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TPXPlane tpxPlane = planeFactory[0].orderPlane("TPX 100");
                label.setText(tpxPlane.toString());
            }
        });
        buttons[1] = new Button("Order TPX 200");
        buttons[1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TPXPlane tpxPlane = planeFactory[0].orderPlane("TPX 200");
                label.setText(tpxPlane.toString());
            }
        });
        buttons[2] = new Button("Order TPX 300");
        buttons[2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TPXPlane tpxPlane = planeFactory[0].orderPlane("TPX 300");
                label.setText(tpxPlane.toString());
            }
        });

        for(int i = 0; i < buttons.length; ++i) {
            grid.add(buttons[i], 0, i);
        }
        grid.add(comboBox, 0, buttons.length);
        grid.add(label, 0, buttons.length + 1);
        Scene scene = new Scene(grid, 500, 500);





        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
