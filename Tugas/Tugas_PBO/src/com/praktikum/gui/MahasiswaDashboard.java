package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import com.praktikum.users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MahasiswaDashboard extends VBox {
    private final MainApp mainApp;
    private final User currentUser;
    private final TextField itemNameField = new TextField();
    private final TextField itemDescriptionField = new TextField();
    private final TextField itemLocationField = new TextField();
    private final TableView<Item> reportsTable = new TableView<>();
    private final ObservableList<Item> tableData = FXCollections.observableArrayList();

    public MahasiswaDashboard(MainApp mainApp, User user) {
        this.mainApp = mainApp;
        this.currentUser = user;

        setPadding(new Insets(20));
        setSpacing(15);
        setAlignment(Pos.TOP_CENTER);

        Label welcomeLabel = label("Selamat datang BOS " + currentUser.getNama() + "!", 16);
        Label reportTitle = label("Laporkan Barang Hilang/Temuan", 14);
        Label tableTitle = label("Daftar Laporan Anda", 14);

        itemNameField.setPromptText("Nama Barang");
        itemDescriptionField.setPromptText("Deskripsi Barang");
        itemLocationField.setPromptText("Lokasi Terakhir");

        Button reportButton = new Button("Laporkan");
        reportButton.setOnAction(e -> handleReport());

        HBox form = new HBox(10, itemNameField, itemDescriptionField, itemLocationField, reportButton);
        form.setAlignment(Pos.CENTER_LEFT);

        setupTable();

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> mainApp.showLoginView());

        VBox bottom = new VBox(logoutButton);
        bottom.setAlignment(Pos.CENTER_RIGHT);
        bottom.setPadding(new Insets(10, 0, 0, 0));

        getChildren().addAll(welcomeLabel, reportTitle, form, tableTitle, reportsTable, bottom);
        loadReportedItemsToTable();
    }

    private void setupTable() {
        TableColumn<Item, String> nameCol = new TableColumn<>("Nama");
        TableColumn<Item, String> descCol = new TableColumn<>("Deskripsi");
        TableColumn<Item, String> locCol = new TableColumn<>("Lokasi");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        locCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        nameCol.prefWidthProperty().bind(reportsTable.widthProperty().multiply(0.30));
        descCol.prefWidthProperty().bind(reportsTable.widthProperty().multiply(0.40));
        locCol.prefWidthProperty().bind(reportsTable.widthProperty().multiply(0.30));

        reportsTable.getColumns().addAll(nameCol, descCol, locCol);
        reportsTable.setItems(tableData);
        reportsTable.setMinWidth(500);
        reportsTable.setMaxHeight(200);
    }

    private void handleReport() {
        String name = itemNameField.getText();
        String desc = itemDescriptionField.getText();
        String loc = itemLocationField.getText();

        if (name.isEmpty() || desc.isEmpty() || loc.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Tidak Lengkap", "Mohon lengkapi semua field.");
            return;
        }

        Item item = new Item(name, desc, loc, "Reported");
        LoginSystem.reportedItems.add(item);

        showAlert(Alert.AlertType.INFORMATION, "Laporan Terkirim", "Laporan '" + name + "' berhasil dikirim.");
        itemNameField.clear(); itemDescriptionField.clear(); itemLocationField.clear();
        loadReportedItemsToTable();
    }

    private void loadReportedItemsToTable() {
        tableData.clear();
        for (Item item : LoginSystem.getReportedItems()) {
            if ("Reported".equalsIgnoreCase(item.getStatus())) {
                tableData.add(item);
            }
        }
    }

    private Label label(String text, int size) {
        Label lbl = new Label(text);
        lbl.setFont(Font.font("Arial", FontWeight.BOLD, size));
        return lbl;
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
