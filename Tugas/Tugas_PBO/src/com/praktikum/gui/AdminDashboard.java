package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import com.praktikum.users.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class AdminDashboard extends VBox {
    private User currentUser;
    private TableView<Item> itemsTable;
    private ObservableList<Item> itemsTableData;
    private TableView<User> studentsTable;
    private ObservableList<User> studentsTableData;
    private TextField studentNameField, studentNimField;

    public AdminDashboard(MainApp mainApp, User user) {
        this.currentUser = user;
        this.setPadding(new Insets(20));
        this.setSpacing(15);
        this.setAlignment(Pos.TOP_CENTER);

        Label welcomeLabel = label("Halo, Administrator " + currentUser.getNama() + "!", 16);
        itemsTable = new TableView<>();
        itemsTableData = FXCollections.observableArrayList();
        itemsTable.setItems(itemsTableData);
        addColumn(itemsTable, "Nama", "itemName", 0.25);
        addColumn(itemsTable, "Deskripsi", "description", 0.35);
        addColumn(itemsTable, "Lokasi", "location", 0.25);
        addColumn(itemsTable, "Status", "status", 0.15);
        itemsTable.setPrefHeight(200);

        Button markAsClaimedButton = new Button("Tandai Claimed");
        markAsClaimedButton.setOnAction(e -> markItemAsClaimed());

        VBox itemsSection = new VBox(5, label("Laporan Barang", 14), itemsTable, markAsClaimedButton);
        itemsSection.setAlignment(Pos.CENTER_LEFT);

        studentsTable = new TableView<>();
        studentsTableData = FXCollections.observableArrayList();
        studentsTable.setItems(studentsTableData);
        addColumn(studentsTable, "Nama", "nama", 0.5);
        addColumn(studentsTable, "NIM", "nim", 0.5);
        studentsTable.setPrefHeight(200);

        studentNameField = new TextField();
        studentNameField.setPromptText("Nama Mahasiswa");
        studentNimField = new TextField();
        studentNimField.setPromptText("NIM");

        Button addStudentButton = new Button("Tambah Mahasiswa");
        Button deleteStudentButton = new Button("Hapus Mahasiswa (Pilih dari tabel)");
        addStudentButton.setOnAction(e -> addStudent());
        deleteStudentButton.setOnAction(e -> deleteStudent());

        VBox studentsSection = new VBox(5,
                label("Data Mahasiswa", 14),
                studentsTable,
                new VBox(5,
                        new HBox(10, studentNameField, studentNimField),
                        new HBox(10, addStudentButton, deleteStudentButton)
                )
        );
        studentsSection.setAlignment(Pos.CENTER_LEFT);

        HBox tablesLayout = new HBox(20, itemsSection, studentsSection);
        tablesLayout.setAlignment(Pos.TOP_CENTER);
        HBox.setHgrow(itemsSection, Priority.ALWAYS);
        HBox.setHgrow(studentsSection, Priority.ALWAYS);

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> mainApp.showLoginView());

        VBox bottomControls = new VBox(logoutButton);
        bottomControls.setAlignment(Pos.CENTER_RIGHT);
        bottomControls.setPadding(new Insets(10, 0, 0, 0));

        this.getChildren().addAll(welcomeLabel, tablesLayout, bottomControls);

        loadItemsData();
        loadStudentsData();
    }

    private <T> void addColumn(TableView<T> table, String title, String prop, double widthPercent) {
        TableColumn<T, String> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(prop));
        col.prefWidthProperty().bind(table.widthProperty().multiply(widthPercent));
        table.getColumns().add(col);
    }

    private Label label(String text, int size) {
        Label lbl = new Label(text);
        lbl.setFont(Font.font("Arial", FontWeight.BOLD, size));
        return lbl;
    }

    private void loadItemsData() {
        itemsTableData.clear();
        itemsTableData.addAll(LoginSystem.getReportedItems());
    }

    private void loadStudentsData() {
        studentsTableData.clear();
        for (User user : LoginSystem.userList) {
            if (user instanceof Mahasiswa) studentsTableData.add(user);
        }
    }

    private void markItemAsClaimed() {
        Item item = itemsTable.getSelectionModel().getSelectedItem();
        if (item == null) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Silakan pilih barang terlebih dahulu.");
        } else if (!"Claimed".equalsIgnoreCase(item.getStatus())) {
            item.setStatus("Claimed");
            itemsTable.refresh();
            showAlert(Alert.AlertType.INFORMATION, "Status Diubah", "Barang '" + item.getItemName() + "' berhasil ditandai Claimed.");
        } else {
            showAlert(Alert.AlertType.INFORMATION, "Informasi", "Barang sudah berstatus Claimed.");
        }
    }

    private void addStudent() {
        String name = studentNameField.getText();
        String nim = studentNimField.getText();

        if (name.isEmpty() || nim.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Tidak Lengkap", "Nama dan NIM tidak boleh kosong.");
            return;
        }

        for (User u : LoginSystem.userList) {
            if (u instanceof Mahasiswa && u.getNim().equals(nim)) {
                showAlert(Alert.AlertType.WARNING, "NIM Sudah Ada", "Mahasiswa dengan NIM tersebut sudah terdaftar.");
                return;
            }
        }

        LoginSystem.userList.add(new Mahasiswa(name, nim));
        loadStudentsData();
        studentNameField.clear();
        studentNimField.clear();
        showAlert(Alert.AlertType.INFORMATION, "Sukses", "Mahasiswa berhasil ditambahkan.");
    }

    private void deleteStudent() {
        User selected = studentsTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih mahasiswa yang ingin dihapus.");
            return;
        }

        if (selected instanceof Mahasiswa) {
            LoginSystem.userList.remove(selected);
            loadStudentsData();
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Mahasiswa '" + selected.getNama() + "' berhasil dihapus.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
