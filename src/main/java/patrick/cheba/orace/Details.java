package patrick.cheba.orace;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Details implements Initializable {
        @FXML
        public Button btn_afficher;
        @FXML
        private TableColumn<ModelDetails, Double> K;

        @FXML
        private TableColumn<ModelDetails, Double> N;

        @FXML
        private TableColumn<ModelDetails, Double>P;

        @FXML
        private TableColumn<ModelDetails, String> exploitation;

        @FXML
        private TableColumn<ModelDetails, Integer> pieds;

        @FXML
        private TableColumn<ModelDetails, String> plante;

        @FXML
        private TableView<ModelDetails> table;
        private  ObservableList<ModelDetails> data = FXCollections.observableArrayList();
        Connection connection;
       public void view(){
               try{
                       String url = "jdbc:sqlite:dosage.db";
                       Class.forName("org.sqlite.JDBC");
                        connection = DriverManager.getConnection(url);
                       String sql = "SELECT * FROM mesdosage,mesexploitation";
                       PreparedStatement stat = connection.prepareStatement(sql);
                       ResultSet rs = stat.executeQuery();
                       while (rs.next()) {
                               data.add(new ModelDetails( rs.getString(1),rs.getString(2), rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getInt(6)));
                       }
                       connection.close();

               }catch (Exception e){
                       e.printStackTrace();
               }
               exploitation.setCellValueFactory(new PropertyValueFactory<ModelDetails,String>("exploitation"));
               plante.setCellValueFactory(new PropertyValueFactory<ModelDetails,String>("plante"));
               N.setCellValueFactory(new PropertyValueFactory<ModelDetails,Double>("N"));
               P.setCellValueFactory(new PropertyValueFactory<ModelDetails,Double>("P"));
               K.setCellValueFactory(new PropertyValueFactory<ModelDetails,Double>("K"));
               pieds.setCellValueFactory(new PropertyValueFactory<ModelDetails,Integer>("pieds"));
               table.setItems(data);
       }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
