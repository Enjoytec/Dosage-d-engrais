package patrick.cheba.orace;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUP implements Initializable {

    @FXML
    private Button btn_sinscrire;
    private Parent fxml;
    @FXML
    private Label lbl_forgoven1;
    @FXML
    private PasswordField txt_password;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_tel;
    @FXML
    private TextField txt_user;
    @FXML
    private TextField txt_ville;
    Connection con = null;
    PreparedStatement pst = null;

    @FXML
    private Label btn_quitter;

    @FXML
    void quit(MouseEvent event) {
        if (event.getSource() == btn_quitter){
            System.exit(1);
        }
    }
    public boolean validEmail(){
        Pattern p = Pattern.compile(" [a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(txt_user.getText());
        if(m.find() && m.group().equals(txt_user.getText())){
            return true;
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("LE CHAMP DE MAIL");
            alert.setContentText("Entrer un email valide s'il vous plaît!");
            alert.showAndWait();

            return false;
        }
    }

    @FXML
    void openHome() throws SQLException {
        if (!txt_user.getText().trim().isEmpty() || !txt_password.getText().trim().isEmpty() || !txt_ville.getText().trim().isEmpty() || !txt_tel.getText().trim().isEmpty()) {

                try {
                    String query = "INSERT INTO `admin`(`Nom`, `Prenom`, `Password`, `UserName`, `Tel`, `Ville`) VALUES (?, ?, ?, ?, ?, ?)";
                    String url = "jdbc:sqlite:dosage.db";
                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection(url);
                    pst = con.prepareStatement(query);
                    pst.setString(1, txt_nom.getText());
                    pst.setString(2, txt_prenom.getText());
                    pst.setString(3, txt_password.getText());
                    pst.setString(4, txt_user.getText());
                    pst.setString(5, txt_tel.getText());
                    pst.setString(6, txt_ville.getText());
                    pst.executeUpdate();
                    pst.close();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Compte crée avec succès !", ButtonType.OK);
                    alert.showAndWait();
                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Echec !", ButtonType.OK);
                    alert.showAndWait();
                }
                Global.userName = txt_user.getText();
                Stage home = new Stage();
                try {
                    Object fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
                    Scene scene = new Scene((Parent) fxml);
                    home.setScene(scene);
                    home.show();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Erreur");
                alert.setContentText("Veuillez renseigner les champs !");
                alert.showAndWait();
            }
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
