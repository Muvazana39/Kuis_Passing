/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_kuis1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ChaVaZaSRL
 */
public class FXMLMainController implements Initializable {

    @FXML
    private JFXTextField Nama;
    @FXML
    private JFXTextField Umur;
    @FXML
    private JFXTextField Alamat;
    @FXML
    private ChoiceBox Genre;
    @FXML
    private JFXTextField NoHp;
    @FXML
    private ChoiceBox Game;
    @FXML
    private JFXButton btnOk;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXButton btnRefresh;
    
    ObservableList<String> GenreList = FXCollections.observableArrayList("Action","Adventure","Fantasy");
    
    ObservableList<String> GameAction = FXCollections.observableArrayList("BattleField","Call Of Duty","Medal Of Honor");
    ObservableList<String> GameAdventure = FXCollections.observableArrayList("BattleGround","MineCraft","Assasin's Creed");
    ObservableList<String> GameFantasy = FXCollections.observableArrayList("Final Fantasy","Toy Story","The Hobbit");

    String nama,umur,alamat,hp,genreisi,gameisi;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Genre.setValue("Action");
        Genre.setItems(GenreList);
        Game.setValue("BattleField");
        Game.setItems(GameAction);
    }    
    
    void Kirim(){
        nama = Nama.getText();
        umur = Umur.getText();
        alamat = Alamat.getText();
        hp = NoHp.getText();
        genreisi = Genre.getValue().toString();
        gameisi = Game.getValue().toString();
    }
    
    @FXML
    private void Proses(ActionEvent event) throws IOException {
        Kirim();
        try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLData.fxml"));
            
            
            
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("TomboLuwe");
            stage.show();
            
            FXMLDataController Data = new FXMLDataController();
            Data = fxmlLoader.getController();
            
            Data.setdata(nama, umur, alamat, hp, genreisi, gameisi);
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
        
    }

    @FXML
    private void Hapus(ActionEvent event) {
        Nama.setText("");
        Umur.setText("");
        Alamat.setText("");
        NoHp.setText("");
        Genre.setValue("Action");
        Game.setValue("");
    }
    
    @FXML
    void Refresh(ActionEvent event) {
        if(Genre.getValue() == "Action"){
            Game.setItems(GameAction);
        }else if(Genre.getValue() == "Adventure"){
            Game.setItems(GameAdventure);
        }else if(Genre.getValue() == "Fantasy"){
            Game.setItems(GameFantasy);
        }
    }

}
