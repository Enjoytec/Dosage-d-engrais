package patrick.cheba.orace;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignIn implements Initializable {


    @FXML
    private Button btn_seconnecter;

    @FXML
    private Button btn_sinscrire;

    @FXML
    private Label lbl_forgoven;

    @FXML
    private Label lbl_forgoven1;

    @FXML
    private PasswordField txt_userpass;

    @FXML
    private TextField txt_username;
    private Parent fxml;
    @FXML
    private Label lbl_erreur;

    @FXML
    public void openSignUp() {
        Stage signUp = new Stage();
        try {
            fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sign-Up.fxml")));
            Scene scene = new Scene(fxml);
            signUp.setScene(scene);
            signUp.setResizable(false);
            signUp.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Connection con = null;
    PreparedStatement stat = null;
    ResultSet rs = null;

    @FXML
    void openHome(ActionEvent event) throws SQLException, IOException {
        try {
            String sql = "SELECT * FROM admin WHERE UserName = ? AND password = ?";
            String url = "jdbc:sqlite:dosage.db";
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            stat = con.prepareStatement(sql);
            stat.setString(1, txt_username.getText().toString());
            stat.setString(2, txt_userpass.getText().toString());
            rs = stat.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, e);
           Alert alert =  new Alert(Alert.AlertType.ERROR,"ECHEC DE CONNEXION AVEC LA BASE DE DONNEE",ButtonType.OK);
           alert.setHeaderText("ECHEC DE REQUETE");
           alert.showAndWait();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (rs.next()) {
            Global.userName = txt_username.getText();
            lbl_erreur.setText("Connecté !"+Global.userName);
            lbl_erreur.setTextFill(Color.GREEN);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, ("Reussi!").toUpperCase(), ButtonType.OK);
            alert.showAndWait();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            lbl_erreur.setText("Non connecté !");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("REVOIS LA SAISIE");
            alert.setContentText(("Email incorrect ou mot de pass incorrect").toUpperCase());
            alert.showAndWait();
        }
    }



    @FXML
    void password_oblie(MouseEvent event) {


    }
        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }
    }
