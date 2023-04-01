package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class MainController {

    private Stage stage;

    @FXML
    private CheckBox happy_chechbox;

    @FXML
    private CheckBox neutral_chechbox;

    @FXML
    private ChoiceBox<?> place_choice;

    @FXML
    private Button return_button;

    @FXML
    private CheckBox sad_chechbox;

    @FXML
    private Button send_button;

    @FXML
    private ChoiceBox<?> tag_choice;

    @FXML
    private TextArea textarea_descriptoion;

    @FXML
    private CheckBox veryhappy_chechbox;

    @FXML
    private CheckBox verysad_chechbox;

    @FXML
    void click_return(ActionEvent event) {

    }

    @FXML
    void clicked_send(ActionEvent event) {

    }

    public void setStage(Stage stage){
        this.stage = stage;
        // For action on close
//        this.stage.setOnCloseRequest(event -> client.logOut());

    }

}
