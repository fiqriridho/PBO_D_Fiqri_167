package com.praktikum.gui;

import com.praktikum.users.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Lost & Found Kampus");
        showLoginView();
    }

    public void showLoginView() {
        LoginPane loginView = new LoginPane(this);
        Scene scene = new Scene(loginView, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showMahasiswaDashboard(User user) {
        MahasiswaDashboard mahasiswaDashboard = new MahasiswaDashboard(this, user);
        Scene scene = new Scene(mahasiswaDashboard, 800, 600);
        primaryStage.setScene(scene);
    }

    public void showAdminDashboard(User user) {
        AdminDashboard adminDashboard = new AdminDashboard(this, user);
        Scene scene = new Scene(adminDashboard, 1000, 700);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}