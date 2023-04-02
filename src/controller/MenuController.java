package controller;

import database.Request;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.Login;

import java.io.*;
import java.util.ArrayList;

public class MenuController {

    public ArrayList<ImageView> matches_view = new ArrayList<>();
    public ArrayList<Integer> matches = new ArrayList<>();

    public ImageView image_profil;
    public Label profil_label;
    public HBox box_match;
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
            main.setup(1);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void setup() {
        profil_label.setText(Login.getInstance().getPerson().getName());
        load_match();
    }

    private void load_match() {
        matches = Request.getMatch(Login.getInstance().getPerson().getId_person());
        System.out.println(matches);
        for (Integer i:matches){
            Pane im = generatePlane(i);
            im.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    try{
                        int index = box_match.getChildren().indexOf(im);
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/matchn.fxml"));

                        Parent root  = loader.load();
                        MatchController main = loader.getController();
                        main.setup(matches.get(index));
                        stage.setScene(new Scene(root));
                        stage.show();
                    } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            });
            box_match.setSpacing(10);
            box_match.getChildren().add(im);

        }
    }

    private ImageView generateImageView(int i) {
        ImageView im = new ImageView();
        im.setFitHeight(49);
        im.setFitWidth(49);
        im.setPickOnBounds(true);
        im.setPreserveRatio(true);
        //            FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"/src/assets/peopfillg.jpg");
//        File file = new File(System.getProperty("user.dir")+"/src/assets/peofillg.jpg");
        File file = new File("/src/assets/ppeofilfille.jpg");
        im.setImage(new Image(file.toURI().toString()));
        return im;
    }
    private Pane generatePlane(int i) {
        Pane im = new Pane();
        im.setPrefHeight(49);
        im.setPrefWidth(49);
        im.setPickOnBounds(true);
        im.setStyle("-fx-background-color: #852222; -fx-background-radius: 90");
        return im;
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
            main.setup(2);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
