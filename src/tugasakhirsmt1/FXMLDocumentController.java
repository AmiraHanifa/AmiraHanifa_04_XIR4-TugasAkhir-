/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhirsmt1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Amira Hanifa
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXButton signup;
    @FXML
    private JFXButton exit;
    @FXML
    private JFXButton signin;
    @FXML
    private JFXPasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     String Namaadmin ;

    @FXML
    private void SignUpp(ActionEvent event) throws IOException, SQLException{
        String user = username.getText();
        String p = password.getText();
        
         if(username.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mohon inputkan Username");
        }else if (password.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Password");
            }else{
                try{
                try(Statement statement = (Statement) login_koneksi.GetConnection().createStatement()){
                    statement.executeUpdate("INSERT INTO tb_akun VALUES ('"+user+"', '"+p+"')");
                    } 
                JOptionPane.showMessageDialog(null, "Sign Up Berhasil");
                username.clear();
                password.clear();
                    }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "GAGAL! Silahkan Ulangi");
                    } 
                }                
            }      
    

    @FXML
    private void Exitt(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void SignInn(ActionEvent event) throws IOException, SQLException{
        Connection connection;
        PreparedStatement ps;
        if(username.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Mohon inputkan Username");
        }else if (password.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Password"); 
        }else{
            try {
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ta_pbo", "root", "");
                ps = connection.prepareStatement("SELECT * FROM `tb_akun` WHERE `username` = ? AND `password` = ?");
                ps.setString(1, username.getText());
                ps.setString(2, password.getText());
                ResultSet result = ps.executeQuery();
                if (result.next()) {
                Component rootPane = null;
                javax.swing.JOptionPane.showMessageDialog(rootPane,"Benar!");
                
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("FXMLTengah.fxml"));
                    Scene scene = new Scene (fxmlLoader.load(), 1313,819);
 
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Menu Awal");
                stage.show();
                Namaadmin = username.getText();
        
                FXMLTengahController Document = new FXMLTengahController();
                Document = fxmlLoader.getController();
        
                Document.setdataFC(Namaadmin);

                    }else {
                        Component rootPane = null;
                        JOptionPane.showMessageDialog(rootPane, "Salah!");
                        password.setText("");
                        username.requestFocus();
                        }
                            } catch (SQLException ex) {
                                    Component rootPane = null;
                                    JOptionPane.showMessageDialog(rootPane, "Gagal!");
                                }
                            }
                        }
                    }
