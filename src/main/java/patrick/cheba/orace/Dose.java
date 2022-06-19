package patrick.cheba.orace;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.ResourceBundle;

public class Dose implements Initializable {
    @FXML
    private TableView<ModelDosage> table;
    @FXML
    private TableColumn<ModelDosage,String> nom;
    @FXML
    private TableColumn<ModelDosage,Double> N;
    @FXML
    private TableColumn<ModelDosage,Double> K;
    @FXML
    private TableColumn<ModelDosage,Double> P;
    private ObservableList<ModelDosage> data = FXCollections.observableArrayList();
    Connection connection = null;
    @FXML
    public void view(){
        try{
            Class.forName("org.sqlite.JDBC");
            String sql = "SELECT * FROM mesdosage WHERE UserName_id = ?";
            String url = "jdbc:sqlite:dosage.db";
             connection = DriverManager.getConnection(url);
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1,Global.userName);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                data.add(new ModelDosage(rs.getString(1), rs.getDouble(5), rs.getDouble(2), rs.getDouble(3)));
            }
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        nom.setCellValueFactory(new PropertyValueFactory<ModelDosage,String>("nom"));
        N.setCellValueFactory(new PropertyValueFactory<ModelDosage,Double>("N"));
        P.setCellValueFactory(new PropertyValueFactory<ModelDosage,Double>("P"));
        K.setCellValueFactory(new PropertyValueFactory<ModelDosage,Double>("K"));
        table.setItems(data);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    void imprimList(ActionEvent event) {

    }
    @FXML
    void newDose(ActionEvent event) {
        Stage stage = new Stage();
        try {
            Object loader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dosage.fxml")));
            Scene scene = new Scene((Parent) loader);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
