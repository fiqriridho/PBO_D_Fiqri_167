package com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import com.praktikum.main.LoginSystem;
import com.praktikum.users.*;

public class LoginPane extends VBox {
    private MainApp mainApp;

    private Label titleLabel;
    private ComboBox<String> userTypeComboBox;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label messageLabel;



    public LoginPane(MainApp mainApp) {
        this.mainApp = mainApp;

        this.setPadding(new Insets(20));
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);

        titleLabel = new Label("Login Cuy");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        userTypeComboBox = new ComboBox<>();
        userTypeComboBox.getItems().addAll("Mahasiswa", "Admin");
        userTypeComboBox.setPromptText("Pilih Tipe User");
        userTypeComboBox.setMinWidth(200);

        usernameField = new TextField();
        usernameField.setPromptText("Nama Pengguna");
        usernameField.setMinWidth(200);
        usernameField.setMaxWidth(200);

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setMinWidth(200);
        passwordField.setMaxWidth(200);

        loginButton = new Button("Login");
        loginButton.setMinWidth(200);

        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red;");

        loginButton.setOnAction(event -> {
            String selectedUserType = userTypeComboBox.getValue();
            String input1 = usernameField.getText();
            String input2 = passwordField.getText();

            User user = LoginSystem.login(input1, input2, selectedUserType);

            if (user != null) {
                messageLabel.setText("Login berhasil!");
                messageLabel.setStyle("-fx-text-fill: green;");

                if (user instanceof Admin) {
                    mainApp.showAdminDashboard(user);
                } else if (user instanceof Mahasiswa) {
                    mainApp.showMahasiswaDashboard(user);
                }
            } else {
                messageLabel.setText("Login gagal BOSSS");
                messageLabel.setStyle("-fx-text-fill: red;");
            }
        });
        this.getChildren().addAll(
                titleLabel,
                userTypeComboBox,
                usernameField,
                passwordField,
                loginButton,
                messageLabel
        );
    }
}