package controller;

import database.Request;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Experience;

import java.io.IOException;
import java.util.ArrayList;

public class BalloonController {

    public VBox vbox;

    @FXML
    void clck_to_rturn_to_tch(ActionEvent event) {
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

    public void setup(int id_capsule) {
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        ArrayList<Experience> exps = Request.getExperiences(id_capsule);
        for(Experience exp: exps){
            addExperienceView(exp);
        }
    }

    private void addExperienceView(Experience experience) {
        AnchorPane pane = new AnchorPane();
        pane.setPrefSize(480,90);
        pane.setStyle("-fx-background-color: #852222; -fx-background-radius: 20;");
        Text text = new Text("Place : "+experience.getPlace()+" \nDate : "+ experience.getDate());
        text.setFill(Color.web("#F0ECE2",1.0));
        text.setLayoutX(10);
        text.setLayoutY(50);
        text.setStrokeType(StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setFont(new Font("System",23));
        pane.getChildren().add(text);
        vbox.getChildren().add(pane);
    }
}
