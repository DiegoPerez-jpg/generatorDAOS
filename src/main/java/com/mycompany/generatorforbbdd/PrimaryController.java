package com.mycompany.generatorforbbdd;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private CheckBox modeloChecker;
    @FXML
    private CheckBox daoChecker;
    @FXML
    private CheckBox conexionChecker;
    @FXML
    private Button generate;
    @FXML
    private TextField urlFIeld;
    @FXML
    private TextField passwordFIeld;
    @FXML
    private TextField rootFIeld;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
