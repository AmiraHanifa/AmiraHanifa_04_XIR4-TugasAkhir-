/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhirsmt1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amira Hanifa
 */
public class FXMLTengahController implements Initializable {

    @FXML
    private JFXButton buttonback;
    @FXML
    private JFXButton buttonnota;
    @FXML
    private JFXTextField namapembeli;
    @FXML
    private JFXTextField alamatpembeli;
    @FXML
    private JFXTextField kasir;
    @FXML
    private JFXTextField hargamasker;
    @FXML
    private JFXButton buttonmasker;
    @FXML
    private JFXTextField jumlahmasker;
    @FXML
    private JFXTextField totalmasker;
    @FXML
    private JFXTextField hargasepatu;
    @FXML
    private JFXButton buttonsepatu;
    @FXML
    private JFXTextField jumlahsepatu;
    @FXML
    private JFXTextField totalsepatu;
    @FXML
    private JFXTextField hargatas;
    @FXML
    private JFXButton buttontas;
    @FXML
    private JFXTextField jumlahtas;
    @FXML
    private JFXTextField totaltas;
    @FXML
    private JFXTextField hargatas1;
    @FXML
    private JFXButton buttontas1;
    @FXML
    private JFXTextField jumlahtas1;
    @FXML
    private JFXTextField totaltas1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     String kasir1 , nama , alamat;
    int  total_tas, total_sepatu, total_masker, total_tas1;
    
    void setdataFC(String namaadmin){
    kasir.setText(namaadmin);}
    
    void setdatafcc(String kasir1, String nama, String alamat) {
        kasir.setText(kasir1);
        namapembeli.setText(nama);
        alamatpembeli.setText(alamat);
    }


    @FXML
    private void nota(MouseEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLnota.fxml"));
        Scene scene = new Scene (fxmlLoader.load(), 782,735);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
        
        total_tas=Integer.parseInt(totaltas.getText());
        total_tas1=Integer.parseInt(totaltas1.getText());
        total_masker=Integer.parseInt(totalmasker.getText());
        total_sepatu=Integer.parseInt(totalsepatu.getText());
         
        kasir1 = kasir.getText();
        nama = namapembeli.getText();
        alamat = alamatpembeli.getText();

        FXMLnotaController nota = new FXMLnotaController();
        nota = fxmlLoader.getController();
        
        nota.setdatafc(kasir1,nama,alamat,total_tas,total_sepatu,total_masker,total_tas1);
    }

    @FXML
    private void gotonota(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLnota.fxml"));
        Scene scene = new Scene (fxmlLoader.load(), 782,735);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
        
        total_tas=Integer.parseInt(totaltas.getText());
        total_tas1=Integer.parseInt(totaltas1.getText());
        total_masker=Integer.parseInt(totalmasker.getText());
        total_sepatu=Integer.parseInt(totalsepatu.getText());
         
        kasir1 = kasir.getText();
        nama = namapembeli.getText();
        alamat = alamatpembeli.getText();

        FXMLnotaController nota = new FXMLnotaController();
        nota = fxmlLoader.getController();
        
        nota.setdatafc(kasir1,nama,alamat,total_tas,total_sepatu,total_masker,total_tas1);
        
    }

    @FXML
    private void masker(MouseEvent event) throws SQLException{
         hargamasker.setText("@Rp. 7000");
    }

    @FXML
    private void sepatu(MouseEvent event) {
        hargasepatu.setText("@Rp. 150.000");
    }

    @FXML
    private void tas(MouseEvent event) {
        hargatas.setText("@Rp. 16000");
    }

    @FXML
    private void tas1(MouseEvent event) {
        hargatas1.setText("@Rp. 50.000");
    }

    @FXML
    private void belimasker(ActionEvent event) {
        int Jumlahmasker=Integer.parseInt(jumlahmasker.getText());
        int Ttl=0;
        
        Ttl = Jumlahmasker * 7000;
        totalmasker.setText(""+Ttl);
    }

    @FXML
    private void belisepatu(ActionEvent event) {
        int Jumlahsepatu=Integer.parseInt(jumlahsepatu.getText());
        int Ttl=0;
        
        Ttl = Jumlahsepatu * 150000;
        totalsepatu.setText(""+Ttl);
    }

    @FXML
    private void belitas(ActionEvent event) {
        int Jumlahtas=Integer.parseInt(jumlahtas.getText());
        int Ttl=0;
        
        Ttl = Jumlahtas * 16000;
        totaltas.setText(""+Ttl);
    }

    @FXML
    private void belitas1(ActionEvent event) {
        int Jumlahmasker=Integer.parseInt(jumlahtas1.getText());
        int Ttl=0;
        
        Ttl = Jumlahmasker * 50000;
        totaltas1.setText(""+Ttl);
    }   
}
