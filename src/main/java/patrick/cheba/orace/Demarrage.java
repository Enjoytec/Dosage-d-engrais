package patrick.cheba.orace;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Demarrage extends Application {

    private ProgressBar bar;
    private Stage stage;
    public Parent demarreur;
    private static Stage stage1;
    @Override
    public void start(Stage stage) throws IOException {

        Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(Demarrage.class.getResource("Demarrage.fxml")));
//        Scene scene = new Scene();
//        scene.setFill(Color.TRANSPARENT);

        stage.setTitle("Bienvenue");
        demarreur.getChi
//        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        //stage.hide();
    }

    public void otherScene(String fxml) throws IOException {
        Parent scene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stage1.getScene().setRoot(scene);
    }

    public void handleStateChangeNotification(Preloader.StateChangeNotification stateChangeNotification) {
        if (stateChangeNotification.getType() == Preloader.StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }

    public void handleProgressNotification(Preloader.ProgressNotification progressNotification) {
        bar.setProgress(progressNotification.getProgress());
    }

    public static Stage getStage(){
        return stage1;
    }
    public static void main(String[] args) {
        launch();
   }
}