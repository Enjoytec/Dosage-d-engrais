package patrick.cheba.orace;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;

public class Aide implements Initializable {
    @FXML
   private WebView web;
   private WebEngine engine;
    @FXML
    void aide() {
        engine.load("https://www.techno-science.net/glossaire-definition/Engrais-page-4.html");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      engine = web.getEngine();

    }
}
