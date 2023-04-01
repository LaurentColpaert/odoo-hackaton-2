package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdk.jfr.internal.tool.Main;

import java.io.IOException;

public class PageDeGardeController {

    @FXML
    private TextField email_text;

    @FXML
    private Button login_button;

    @FXML
    private TextField password_text;

    @FXML
    private Button signup_button;

    @FXML
    public void login_click(ActionEvent event) {
        try{
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/main.fxml"));

        Parent root  = loader.load();
        MainController chatLayout = loader.getController();
        chatLayout.setStage(stage);
        stage.setScene(new Scene(root, 800, 420));
        stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void signup_click(ActionEvent event) {

    }

}
