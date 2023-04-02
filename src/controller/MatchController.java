package controller;

import database.Request;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Capsule;
import model.Experience;
import model.Person;

import java.io.IOException;
import java.util.ArrayList;

public class MatchController {
    public ArrayList<Capsule> capsules;

    public VBox vbox;
    public Text match_label;
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
            main.setup(0);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void setup(int id) {
        Person person = Request.getPerson(id);
        capsules = person.getCapsules();
        for (Capsule cap:capsules){
            System.out.println(cap);
            addCapView(cap);
        }
        match_label.setText(person.getName());
    }

    private void addCapView(Capsule cap) {
        AnchorPane pane = new AnchorPane();
        pane.setPrefSize(515,87);
        pane.setStyle("-fx-background-color: #F0ECE2; -fx-background-radius: 20;");
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int index = vbox.getChildren().indexOf(pane);
                int id = capsules.get(index).getId_capsule();
                try{
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/balloon.fxml"));

                    Parent root  = loader.load();
                    BalloonController main = loader.getController();
                    main.setup(id);
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        });
        Text text = new Text("Capsule from "+cap.getDate_begin()+" to "+ cap.getDate_end());
        text.setFill(Color.web("#852222",1.0));
        text.setLayoutX(10);
        text.setLayoutY(50);
        text.setStrokeType(StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setFont(new Font("System",23));
        pane.getChildren().add(text);
        vbox.getChildren().add(pane);
    }
}
