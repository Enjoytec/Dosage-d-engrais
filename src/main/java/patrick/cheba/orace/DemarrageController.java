package patrick.cheba.orace;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class DemarrageController implements Initializable {
    @FXML
    private Label welcomeText;
    public static Stage second;
    Connection connection = null;

    Statement statement;

    public void mesDosage(){
        try{
        String url = "jdbc:sqlite:dosage.db";
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(url);
        statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS mesdosage " +
                    "(Nom_de_plante varchar(128) NOT NULL, " +
                    " Nbr_P int(64) NOT NULL, " +
                    " Nbr_K int(64) NOT NULL, " +
                    "UserName_id varchar(258) NOT NULL,"+
                    " Nbr_N int(64) NOT NULL,"+"PRIMARY KEY (Nom_de_plante))";
            statement.executeUpdate(query);
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void mesExploitation(){
        try{
            String url = "jdbc:sqlite:dosage.db";

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS mesexploitation " +
                    "(NomExploitation varchar(128) NOT NULL, " +
                    " NombreDePieds int(64) NOT NULL, " +
                    "UserName_id varchar(258) NOT NULL,"+
                    " NomPlante varchar(128) NOT NULL,"+"PRIMARY KEY (NomPlante))";
            statement.executeUpdate(query);
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void connection(){
        try{
            String url = "jdbc:sqlite:dosage.db";

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS admin" +
                    "(Nom varchar(258) NOT NULL,"+
                    "Prenom varchar(258) NOT NULL,"+
                    "Password varchar(258) NOT NULL,"+
                    "UserName varchar(258) NOT NULL,"+
                    "Tel varchar(258) NOT NULL,"+
                    "Ville varchar(128) NOT NULL,"+"PRIMARY KEY (Password))";
            statement.executeUpdate(query);
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void selecte() {

    }
    @FXML
    private ImageView close_windows;

    Demarrage panel = new Demarrage();

    public ImageView getClose_windows() {
        return close_windows;
    }
    @FXML
    void dispose(MouseEvent event) {
        if (event.getSource() == close_windows){
            System.exit(0);
        }
    }
    @FXML
    protected void onHelloButtonClick() throws IOException {

        connection();
        mesDosage();
        mesExploitation();

        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sign-In.fxml"))));

        second = new Stage();
        second.setScene(scene);
        second.setResizable(false);
        second.initOwner(Demarrage.getStage());
        second.initModality(Modality.WINDOW_MODAL);
        second.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}