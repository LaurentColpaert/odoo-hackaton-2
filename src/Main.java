import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    /**
     * Start the login scene and allow the scene to be resizable on click and drag
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/pagegarde.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 540, 960);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}