package patrick.cheba.orace;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CreerDosage implements Initializable {


    @FXML
    private Button btn_dosage;

    @FXML
    private Button btn_voirDosage;
    private Parent loader;

    @FXML
    void do_dosage() {
        Stage stage = new Stage();
        try {
            loader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dosage.fxml")));
            Scene scene = new Scene(loader);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void voirDosage() {
        Stage stage = new Stage();
        try {
            loader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dose.fxml")));
            Scene scene = new Scene(loader);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
