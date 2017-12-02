/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhirsmt1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
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
public class FXMLnotaController implements Initializable {

    @FXML
    private JFXTextField namabeli;
    @FXML
    private JFXTextField alamatbeli;
    @FXML
    private JFXTextField kasirr;
    @FXML
    private JFXTextField totalharga;
    @FXML
    private JFXTextField donasi;
    @FXML
    private JFXTextField totalbeli;
    @FXML
    private JFXTextArea barang;
    @FXML
    private JFXButton buttonback;
    @FXML
    private JFXButton logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    String kasir1 , nama , alamat;
    
    void setdatafc(String kasir1, String nama, String alamat, int total_tas, int total_sepatu, int total_masker, int total_tas1){
    kasirr.setText(kasir1);
    namabeli.setText(nama);
    alamatbeli.setText(alamat);
    
      
        int Ttl = total_tas+total_sepatu+total_masker+total_tas1;
        totalharga.setText(""+Ttl);
        int Donasikan = Ttl/2;
        donasi.setText(""+Donasikan);
        int Akhir = Ttl - Donasikan;
        totalbeli.setText(""+Akhir);
        
        barang.setText("nama barang : masker "+"\n"+"Jumlah harga masker : "+total_masker+"\n"+
                        "nama barang : tas ransel kecil "+"\n"+"Jumlah harga tas ransel kecil : "+total_tas1+"\n"
                        +"nama barang : tas "+"\n"+"Jumlah harga tas : "+total_tas+"\n"
                        +"nama barang : sepatu "+"\n"+"Jumlah harga sepatu : "+total_sepatu+"\n");
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLTengah.fxml"));
        Scene scene = new Scene (fxmlLoader.load(), 1313,819);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
        
        kasir1 = kasirr.getText();
        nama = namabeli.getText();
        alamat = alamatbeli.getText();

        FXMLTengahController Tengahh = new FXMLTengahController();
        Tengahh = fxmlLoader.getController();
        
        Tengahh.setdatafcc(kasir1,nama,alamat);
        
    }

    @FXML
    private void tombolback(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("FXMLTengah.fxml"));
        Scene scene = new Scene (fxmlLoader.load(), 1313,819);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
        
        kasir1 = kasirr.getText();
        nama = namabeli.getText();
        alamat = alamatbeli.getText();

        FXMLTengahController Tengahh = new FXMLTengahController();
        Tengahh = fxmlLoader.getController();
        
        Tengahh.setdatafcc(kasir1,nama,alamat);
        
        
    }

    @FXML
    private void logoutt(ActionEvent event) {
        System.exit(0);
    }

    }
    

