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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ibrahim yazici");

        PlaneFactory planeFactory = new PlaneModel();


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);

        Label label = new Label();
        Button[] buttons = new Button[3];
        buttons[0] = new Button("Order TPX 100");
        buttons[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TPXPlane tpxPlane = planeFactory.orderPlane("TPX 100");
                label.setText(tpxPlane.getModel());
            }
        });
        buttons[1] = new Button("Order TPX 200");
        buttons[1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TPXPlane tpxPlane = planeFactory.orderPlane("TPX 200");
                label.setText(tpxPlane.getModel());
            }
        });
        buttons[2] = new Button("Order TPX 300");
        buttons[2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TPXPlane tpxPlane = planeFactory.orderPlane("TPX 300");
                label.setText(tpxPlane.getModel());
            }
        });

        for(int i = 0; i < buttons.length; ++i) {
            grid.add(buttons[i], 0, i);
        }
        grid.add(label, 0, buttons.length);
        Scene scene = new Scene(grid, 300, 300);





        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
