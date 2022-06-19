package patrick.cheba.orace;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reste implements Initializable {
    @FXML
    private TextField txt_input;
    @FXML
    private TextField txt_quantite;

    double totale;
    ObservableList<Object> choix = FXCollections.observableArrayList();
    @FXML
    ComboBox<Object> comboBox = new ComboBox<>(choix);
    Connection con = null;
    PreparedStatement prepare = null;

    ResultSet rs = null;

    ArrayList<HashMap<String, String>> liste = new ArrayList<>();
    HashMap<String, String> hm;
    double K;
    double N;
    double P;
    int Pieds;
    double reste;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        transation();
        txt_input.setText("0");

    }
    public void transation(){
        try {
            String url = "jdbc:sqlite:dosage.db";
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(url);
            String query = "SELECT * FROM mesdosage,mesexploitation WHERE  mesdosage.Nom_de_plante = mesexploitation.NomPlante";
            prepare = con.prepareStatement(query);
            rs = prepare.executeQuery();

            while(rs.next()) {
                hm = new HashMap<>();
                if(!choix.contains(rs.getString("Nom_de_plante"))) {
                    choix.add(rs.getString("Nom_de_plante"));
                    hm.put("Pieds", rs.getString("NombreDePieds"));
                    hm.put("Nombre de N", rs.getString("Nbr_N"));
                    hm.put("Nombre de P", rs.getString("Nbr_P"));
                    hm.put("Nombre de K", rs.getString("Nbr_K"));
                }
                liste.add(hm);

            }

            comboBox.setItems(choix);
            prepare.close();
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(Exploitation.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @FXML
    void clickCombo(ActionEvent event) throws SQLException {
        transation();
        int indexCombo = comboBox.getSelectionModel().getSelectedIndex();

            P = Double.parseDouble(liste.get(indexCombo).get("Nombre de P"));
            N = Double.parseDouble(liste.get(indexCombo).get("Nombre de N"));
            K = Double.parseDouble(liste.get(indexCombo).get("Nombre de K"));
            Pieds = Integer.parseInt(liste.get(indexCombo).get("Pieds"));
    }
    @FXML
    void calculer() {
            double quantite = Integer.parseInt(txt_input.getText());
            double somme = N+P+K;
            totale = somme * Pieds;
            reste = totale - quantite;
        txt_quantite.setText(String.valueOf(reste));
    }
}