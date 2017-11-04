/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_kuis1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ChaVaZaSRL
 */
public class FXMLDataController implements Initializable {

    @FXML
    private JFXTextField dataNama;
    @FXML
    private JFXTextField dataUmur;
    @FXML
    private JFXTextField dataAlamat;
    @FXML
    private JFXTextField dataNoHp;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXTextField dataGenre;
    @FXML
    private JFXTextField dataGame;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setdata(String Nama, String Umur, String Alamat, String NoHp, String Genre, String Game){
        dataNama.setText(Nama);
        dataUmur.setText(Umur);
        dataAlamat.setText(Alamat);
        dataNoHp.setText(NoHp);
        dataGenre.setText(Genre);
        dataGame.setText(Game);
    }
    
    @FXML
    private void Close(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    
}
