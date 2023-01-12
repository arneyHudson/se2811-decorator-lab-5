package network;/*
 * Course:     SE 2811
 * Term:       Winter 2022-23
 * Assignment: Lab 5: Decorators
 * Author:     MSOE Faculty and Hudson Arney
 * Date:       1/11/2023
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLOutput;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("simpleCanvas.fxml")));
            primaryStage.setTitle("Neural Network Visualizer");
            primaryStage.setScene(new Scene(root, 850, 650));
            primaryStage.show();
        } catch(Exception e) {
            System.out.println("No controller could be found");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
