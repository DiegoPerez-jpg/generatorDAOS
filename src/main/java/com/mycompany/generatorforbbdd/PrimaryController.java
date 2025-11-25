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
        urlFIeld.setText("jdbc:mysql://localhost:3306/empresa");
        passwordFIeld.setText(System.getenv("DB_PASS") == null? "" :  System.getenv("DB_PASS"));
        rootFIeld.setText(System.getenv("DB_USER"));
        MainService ms = new MainService(urlFIeld.getText(), rootFIeld.getText(), passwordFIeld.getText());
//        App.setRoot("secondary");
    }
}
