package patrick.cheba.orace;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class Home implements Initializable {

    private Parent demareur;
    @FXML
    private Button acceuil;

    @FXML
    private Button creerDosage;

    @FXML
    private Button creerExploitation;

    @FXML
    private Button details;

    @FXML
    private VBox panneau;

    @FXML
    private Button param;

    @FXML
    private Button verifier;

    @FXML
    void details() {
        try {
            demareur = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Details.fxml")));
            panneau.getChildren().removeAll();
            panneau.getChildren().setAll(demareur);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    void dosage() {
        try {
            demareur = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreerDosage.fxml")));
            panneau.getChildren().removeAll();
            panneau.getChildren().setAll(demareur);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    void exploitation() {
        try {
            demareur = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreerExploitation.fxml")));
            panneau.getChildren().removeAll();
            panneau.getChildren().setAll(demareur);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    void openAcceuil() {
        try {
            demareur = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Aide.fxml")));
            panneau.getChildren().removeAll();
            panneau.getChildren().setAll(demareur);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    void parametre() {

    }

    @FXML
    void verifie() {
        try {
            demareur = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Reste.fxml")));
            panneau.getChildren().removeAll();
            panneau.getChildren().setAll(demareur);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(Global.userName);
        openAcceuil();
    }
}
