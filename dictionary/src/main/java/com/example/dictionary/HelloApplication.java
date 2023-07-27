package com.example.dictionary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application  {
    Stage window;
    Scene scene1, scene2;
    Button button, button2;
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("My app");
        button = new Button("Cancel");
        button.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Alert Information");
            alert.setContentText("Choose your option");
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
            ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(yes, no, cancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get().getButtonData() == ButtonBar.ButtonData.YES) {
                System.out.println("code for yes");
            } else if (result.get().getButtonData() == ButtonBar.ButtonData.NO) {
                System.out.println("code for no");
            } else {
                System.out.println("code for cancel");
            }
            String message = result.get().getText();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Information");
            alert1.setHeaderText("Notification");
            alert1.setContentText(message);
            alert1.show();

        });
        VBox layout = new VBox();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}