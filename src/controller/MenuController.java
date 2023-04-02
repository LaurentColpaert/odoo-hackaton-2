package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MenuController {

    public ImageView pseudo_profil_label;
    public ImageView ppfil3;
    public ImageView ppfil2;
    public ImageView ppfil1;
    public ImageView ppfil;
    public ImageView image_profil;
    @FXML
    private Button balloon;

    @FXML
    private Button sendtomatch_button;

    @FXML
    private Button sendtosky_button;



    @FXML
    void click_sendtosky(ActionEvent event) {
        try{
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/experience.fxml"));

            Parent root  = loader.load();
            ExperienceController main = loader.getController();
            main.setup();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    void clicked_balloon(ActionEvent event) {
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

    public void clicked_profile(MouseEvent mouseEvent) {
        try{
            Node node = (Node) mouseEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/modifierprofil.fxml"));

            Parent root  = loader.load();
            ModifierProfilController main = loader.getController();
            main.setup();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void clicked_match(MouseEvent mouseEvent) {
        try{
            Node node = (Node) mouseEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/matchn.fxml"));

            Parent root  = loader.load();
            MatchController main = loader.getController();
            main.setup();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
