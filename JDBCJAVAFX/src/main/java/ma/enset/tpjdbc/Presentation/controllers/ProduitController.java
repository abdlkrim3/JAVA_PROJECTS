package ma.enset.tpjdbc.Presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProduitController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}