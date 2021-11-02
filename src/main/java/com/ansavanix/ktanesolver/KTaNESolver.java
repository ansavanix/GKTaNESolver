package com.ansavanix.ktanesolver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KTaNESolver extends Application {
    static void showModule(String moduleName) throws IOException {
        FXMLLoader moduleLoader = new FXMLLoader(KTaNESolver.class.getResource(moduleName + ".fxml"));
        Stage moduleStage = new Stage();
        moduleStage.setTitle(moduleName);
        moduleStage.setResizable(false);
        Scene moduleScene = new Scene(moduleLoader.load(), 600, 400);
        moduleStage.setScene(moduleScene);
        moduleStage.showAndWait();

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KTaNESolver.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setResizable(false);
        stage.setTitle("KTaNE Solver");
        stage.setScene(scene);
        stage.show();
    }
}