package patrick.cheba.orace;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Dosage  implements Initializable {
    @FXML
    private TextField input_K;
    @FXML
    private TextField input_N;

    @FXML
    private TextField input_P;
    @FXML
    public TextField input_name;
    @FXML
    private Button creerDosage;
    Connection con = null;
    PreparedStatement pst = null;
    @FXML
   public void addDosage() throws SQLException {
        try {
                String query = "INSERT INTO `mesDosage`(`Nom_de_plante`, `Nbr_P`, `Nbr_K` ,UserName_id,`Nbr_N`) VALUES (?, ?, ?, ?,?)";
            String url = "jdbc:sqlite:dosage.db";
            Class.forName("org.sqlite.JDBC");
             con = DriverManager.getConnection(url);
                pst = con.prepareStatement(query);
                pst.setString(1,input_name.getText());
                pst.setString(2,input_P.getText());
                pst.setString(3,input_K.getText());
                pst.setString(4,Global.userName);
                pst.setString(5,input_N.getText());

                pst.executeUpdate();
                pst.close();
                con.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Votre dosage est enregistré avec succes!", ButtonType.OK);
            alert.showAndWait();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING,"Votre dosage est non enregistré !", ButtonType.OK);
            alert.showAndWait();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
