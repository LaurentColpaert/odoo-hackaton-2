package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class MessageSentBalloonController {

    @FXML
    private Button back_to_menu;

    @FXML
    private ImageView image_ballon_sent;

    @FXML
    void click_to_back_to_menu(ActionEvent event) {
            try{
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));

                Parent root  = loader.load();
                MenuController main = loader.getController();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

    }

}
