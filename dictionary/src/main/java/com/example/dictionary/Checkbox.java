package com.example.dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Checkbox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("sample.fxml"));
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root, 851, 640));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
