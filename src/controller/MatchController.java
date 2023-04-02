package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MatchController {

    @FXML
    private AnchorPane capsule_to_click;

    @FXML
    private ScrollBar scroll_bar;

    @FXML
    void clck_to_rturn_to_nu(ActionEvent event) {
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

    @FXML
    void go_to_capsule(MouseEvent event) {
        try{
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/balloon.fxml"));

            Parent root  = loader.load();
            BalloonController main = loader.getController();
            main.setup();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void setup() {
    }
}
