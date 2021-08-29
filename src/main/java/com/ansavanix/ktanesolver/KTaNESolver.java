package com.ansavanix.ktanesolver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class KTaNESolver extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KTaNESolver.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("KTaNE Solver");
        stage.setScene(scene);
        stage.show();
    }
    public static void showSimpleWires() throws IOException {
        FXMLLoader wiresLoader = new FXMLLoader(KTaNESolver.class.getResource("simple-wires.fxml"));

        Stage wireStage = new Stage();
        wireStage.setTitle("Simple Wires");
        Scene wireScene = new Scene(wiresLoader.load(), 600, 400);
        wireStage.setScene(wireScene);
        wireStage.showAndWait();




    }

    public static void main(String[] args) {
        launch();
    }
}