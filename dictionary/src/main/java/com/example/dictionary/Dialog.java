package com.example.dictionary;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Optional;

public class Dialog extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        javafx.scene.control.Dialog<Pair<String, String>> dialog = new javafx.scene.control.Dialog<>();
        dialog.setTitle("login Dialog");
        dialog.setHeaderText("Sign up");
        ButtonType login = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(login, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20,150,10,10));

        TextField userName = new TextField();
        userName.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        grid.add(new Label("Username"), 0, 0);
        grid.add(userName, 1, 0);
        grid.add(new Label("Password"), 0, 1);
        grid.add(password, 1, 1);
//      Hien button login khi nguoi dung nhap vao user
        Node loginButton = dialog.getDialogPane().lookupButton(login);
        loginButton.setDisable(true);
        userName.textProperty().addListener((observableValue, oldValue,newValue) ->{
            loginButton.setDisable(newValue.trim().isEmpty());
        } );
        // Viet ham tra ve kieu du lieu Pair<String, String>
        dialog.getDialogPane().setContent(grid);
        // Kiem tra button khi nao click moi tra ve du lieu
        dialog.setResultConverter(dialogButton ->{
            if (dialogButton == login) {
                return new Pair<>(userName.getText(), password.getText());
            }
            return null;
        });
        //Dung optional de luu ket qua tra ve
        Optional<Pair<String, String>> result = dialog.showAndWait();
        result.ifPresent(userNamePassWord -> {
            System.out.println("Username"+userNamePassWord.getKey()+",Password"+userNamePassWord.getValue());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
