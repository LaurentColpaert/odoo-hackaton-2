package controller;

import database.Request;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Capsule;
import model.Experience;
import model.Person;
import utils.Login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
    private ChoiceBox<String> gender_choicebox;

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
        try{
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));

            Parent root  = loader.load();
            MenuController main = loader.getController();
            main.setup();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    private void retrieve_info(){
        int gender_nr = 2;
      //  String email = email_text.getText();
//        String password = password_text.getText();
        String username = username_text.getText();
        String age = age_text.getText();
        int age_nr = Integer.valueOf(age);
        String gender = (String) gender_choicebox.getValue();
        if (gender == "Male"){
             gender_nr = 1;
        }
        ArrayList<String> language = new ArrayList<>();
        if (french_checkbox.isSelected()){
            language.add("French") ;
        }
        if (english_checkbox.isSelected()){
            language.add("English") ;
        }

        Person person = new Person(username,age_nr,gender_nr,language);
        Request.insertPerson(person);
    }

    public void setup_gender_choice(){
        gender_choicebox.getItems().add("Male");
        gender_choicebox.getItems().add("Female");
    }
}
