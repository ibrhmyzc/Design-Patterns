package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.graphClasses.*;

import java.io.File;
import java.rmi.Naming;
import java.util.List;
import java.util.Map;

public class Main extends Application {
    private static IbrahimsGraph<Object> ibrahimGraph;
    private static RemoteRegisterWallet remoteRegisterWallet;
    private static Graph<Object> graph;
    private static int clientId;
    private static int addBalance;
    private static String resultMatrixStr;
    private static String resultMst;
    private static Wallet wallet;
    private static Map<Integer, Object> genericGraph;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        // Register
        Button buttonRegister = new Button("Register");
        Label labelRegister = new Label("Enter client id");
        TextField textFieldRegister = new TextField("");


        // Create a graph
        Button buttonCreate = new Button("Create");
        Label labelCreate = new Label("Create a graph");

        // Request
        Button buttonRequest = new Button("Request");

        // Show result
        TextArea textArea = new TextArea();
        textArea.setMinHeight(500);
        textArea.setMinWidth(500);

        // Listeners
        buttonRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clientId = Integer.parseInt(textFieldRegister.getText().toString());
                wallet = new Wallet(clientId);
            }
        });


        Button browse = new Button("Browse");
        final File[] selectedFile = {null};
        browse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("txt files", "*.txt"));
                selectedFile[0] = fileChooser.showOpenDialog(primaryStage);
            }
        });

        buttonCreate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                GraphFileOperations<String> graphFileOperations = new GraphFileOperations<>(selectedFile[0].toString());
                graph = graphFileOperations.constructGraphFromFile();
                textArea.setText(textArea.getText() + System.lineSeparator() + graph.printGraph());
            }
        });

        buttonRequest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                runClient();
                textArea.setText(textArea.getText() + System.lineSeparator() + resultMatrixStr);
                textArea.setText(textArea.getText() + System.lineSeparator() + resultMst);
            }
        });


        // Adding components
        GridPane gridPane = new GridPane();

        gridPane.add(labelRegister, 0, 0);
        gridPane.add(textFieldRegister, 1, 0);
        gridPane.add(buttonRegister, 2, 0);

        gridPane.add(labelCreate, 0, 2);
        gridPane.add(browse, 1, 2);
        gridPane.add(buttonCreate, 2, 2);

        gridPane.add(buttonRequest, 0, 3);

        gridPane.add(textArea, 0, 4);

        Scene scene = new Scene(gridPane, 800, 600);

        primaryStage.setTitle("Client");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void runClient(){
        try{
            ibrahimGraph = (IbrahimsGraph) Naming.lookup("rmi://localhost/BulutGraph");
            remoteRegisterWallet = (RemoteRegisterWallet) Naming.lookup("rmi://localhost/WolkesGraphRegister");
        } catch(Exception e){
            System.out.println("Client exception");
        }

        //Register wallet to the system
        try {
            remoteRegisterWallet.register(wallet);
        } catch (Exception e) {
            System.out.println("Exception in remote register wallet");
            e.printStackTrace();
        }


        try {
            double[][] result = ibrahimGraph.getIncidenceMatrix(graph, wallet);
            resultMatrixStr = ArrayPrinter2D.printArray(result);
            resultMst = ibrahimGraph.getMinimumSpanningTree(graph, wallet);
        } catch (Exception e) {
            System.out.println("out of money");

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
