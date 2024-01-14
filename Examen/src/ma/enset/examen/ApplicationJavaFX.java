package ma.enset.examen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationJavaFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationJavaFX.class.getResource("views/fxml/main_pane.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        //scene.getStylesheets().add(getClass().getResource("css/style.css").toString());
        stage.setTitle("Produits");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}