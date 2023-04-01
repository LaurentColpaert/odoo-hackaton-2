package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CreateAccountController {

    @FXML
    private TextField age_text;

    @FXML
    private TextField email_text;

    @FXML
    private CheckBox english_checkbox;

    @FXML
    private CheckBox french_checkbox;

    @FXML
    private ChoiceBox<?> gender_choicebox;

    @FXML
    private TextField password_text;

    @FXML
    private Button picture_button;

    @FXML
    private Button signup_button;

    @FXML
    private TextField username_text;

    @FXML
    void picture_click(ActionEvent event) {

    }

    @FXML
    void signup_click(ActionEvent event) {

    }

}
