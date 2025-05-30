import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class MyJavaFXApps extends Application {
    private int angkaRahasia;
    private int jumlahTebakan;
    private Label labelFeedback;
    private Label labelPercobaan;
    private TextField inputTebakan;
    private Button tombolAksi;

    private int generateAngka() {
        return new Random().nextInt(100) + 1;
    }

    @Override
    public void start(Stage primaryStage) {
        angkaRahasia = generateAngka();
        jumlahTebakan = 0;

        Label labelJudul = new Label("👻 Tebak Angka dari 1 sampai 100");
        labelJudul.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: blue;");

        labelFeedback = new Label("Masukkan tebakanmu di bawah.");
        labelPercobaan = new Label("Jumlah percobaan: 0");

        inputTebakan = new TextField();
        inputTebakan.setPromptText("Contoh: 42");
        inputTebakan.setMaxWidth(100);

        tombolAksi = new Button("Coba Tebak!");
        tombolAksi.setPrefWidth(120);
        tombolAksi.setOnAction(e -> prosesTebakan());

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 25; -fx-background-color: #f0f8ff;");

        layout.getChildren().addAll(
                labelJudul,
                inputTebakan,
                tombolAksi,
                labelFeedback,
                labelPercobaan
        );

        Scene scene = new Scene(layout, 380, 250);
        primaryStage.setTitle("Game Tebak Angka");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void prosesTebakan() {
        try {
            int tebakan = Integer.parseInt(inputTebakan.getText());
            jumlahTebakan++;

            if (tebakan > angkaRahasia) {
                labelFeedback.setText("Terlalu besar!");
            } else if (tebakan < angkaRahasia) {
                labelFeedback.setText("Terlalu kecil!");
            } else {
                labelFeedback.setText("Tebakan benar!");
                tombolAksi.setText("Main Lagi");
                tombolAksi.setOnAction(e -> resetGame());
                inputTebakan.setDisable(true);
            }

            labelPercobaan.setText("Jumlah percobaan: " + jumlahTebakan);
        } catch (Exception e) {
            labelFeedback.setText("⚠️ Masukkan angka yang valid!");
        }

        inputTebakan.clear();
    }

    private void resetGame() {
        angkaRahasia = generateAngka();
        jumlahTebakan = 0;
        labelFeedback.setText("Masukkan tebakanmu di bawah.");
        labelPercobaan.setText("Jumlah percobaan: 0");
        inputTebakan.clear();
        inputTebakan.setDisable(false);
        tombolAksi.setText("Coba Tebak!");
        tombolAksi.setOnAction(e -> prosesTebakan());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
