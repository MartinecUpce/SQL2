/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idase_projekt;

import databasic.OracleConnector;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import protably.Hodina;
import protably.Obor;
import protably.PracovisteVsech;
import protably.Predmet;
import protably.PredmetOboru;
import protably.Ucitel;

/**
 *
 * @author Vojta
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableColumn<Ucitel, String> columnWorkplace;
    @FXML
    private TableColumn<Ucitel, String> columnJmenoVyucujiciho;
    @FXML
    private TableColumn<Ucitel, String> columnPrijmeniVyucujiciho;
    @FXML
    private TableColumn<Ucitel, String> columnTitulPred;
    @FXML
    private TableColumn<Ucitel, String> columnTitulZa;
    @FXML
    private TableColumn<Ucitel, String> columnMobil;
    @FXML
    private TableColumn<Ucitel, String> columnTelefon;
    @FXML
    private TableColumn<Ucitel, String> columnEmail;
    @FXML
    private ComboBox<String> choicePracoviste;
    @FXML
    private Button buttonVlozUcitele;
    @FXML
    private Button buttonVymazUcitele;
    @FXML
    private Button buttonUpravUcitele;
    @FXML
    private TextField textJmenoVyucujiciho;
    @FXML
    private TextField textPrijmeniVyucujiciho;
    @FXML
    private TextField textEmail;
    @FXML
    private TextField textTitulPred;
    @FXML
    private TextField textTitulZa;
    @FXML
    private TextField textTelefon;
    @FXML
    private TextField textMobil;
    @FXML
    private TableView<PracovisteVsech> tablePracoviste;
    @FXML
    private TableColumn<PracovisteVsech, String> columnFakulta;
    @FXML
    private TableColumn<PracovisteVsech, String> columnFZkratka;
    @FXML
    private TableColumn<PracovisteVsech, String> columnKatedra;
    @FXML
    private TableColumn<PracovisteVsech, String> columnKZkratka;
    @FXML
    private Button buttonPridejFakultu;
    @FXML
    private Button buttonOdeberFakultu;
    @FXML
    private TextField textFakultaName;
    @FXML
    private TextField textFakultaZkratka;
    @FXML
    private Button buttonPridejKatedru;
    @FXML
    private Button buttonOdeberKatedru;
    @FXML
    private Button buttonUpravKatedru;
    @FXML
    private TextField textKatedraName;
    @FXML
    private TextField textKatedraZkratka;
    @FXML
    private ComboBox<String> choiceFakulta;
    @FXML
    private TableView<Predmet> tabulkaPredmet;
     @FXML
    private TableColumn<Predmet, Integer> columnIDPredmetu;
    @FXML
    private TableColumn<Predmet, String> columnNazevPredmetu;
    @FXML
    private TableColumn<Predmet, String> columnZkratkaPredmetu;
    @FXML
    private TableColumn<Predmet, String> columnVyucovanySem;
    @FXML
    private TableColumn<Predmet, String> columnZakonceni;
    @FXML
    private TableColumn<Predmet, Integer> columnDoporucenyRocnik;
    @FXML
    private Button buttonVytvorPredmet;
    @FXML
    private Button buttonVymazPredmet;
    @FXML
    private Button buttonUpravPredmet;
    @FXML
    private TextField textNazevPredmet;
    @FXML
    private TextField textZkratkaPredmet;
    @FXML
    private TextField textDopRocnik;
    @FXML
    private ChoiceBox<String> choiceZakonceni;
    @FXML
    private ChoiceBox<String> choiceVyucovanySemestr;
    @FXML
    private TableView<Obor> tabulkaObor;
    @FXML
    private TableColumn<Obor, String> columnOborZkratka;
    @FXML
    private TableColumn<Obor, String> columnOborKatedra;
    @FXML
    private TableColumn<Obor, String> columnFormaVyuky;
    @FXML
    private TableColumn<Obor, Integer> columnCelkovyPocetStudentu;
    @FXML
    private TableView<PredmetOboru> tabulkaOborPredmet;
    @FXML
    private TableColumn<PredmetOboru, String> columnOborPredmetTa;
    @FXML
    private TableColumn<PredmetOboru, String> columnKategorie;
    @FXML
    private Button buttonVytvorObor;
    @FXML
    private Button buttonZrusObor;
    @FXML
    private Button buttonUpravObor;
    @FXML
    private TextField textZkratkaOboru;
    @FXML
    private ComboBox<String> choiceKatedraOboru;
    @FXML
    private ComboBox<String> choiceFormaVyuky;
    @FXML
    private Button buttonVlozPredObor;
    @FXML
    private Button buttonOdeberZOboru;
    @FXML
    private ComboBox<String> choiceKategorie;
    @FXML
    private ComboBox<String> choicePredmetDoOboru;
    @FXML
    private ComboBox<String> choiceOborProPredmet;
    @FXML
    private TableView<Hodina> tableAkce;
    @FXML
    private TableColumn<Hodina, String> columnAkceJmeno;
    @FXML
    private TableColumn<Hodina, String> columnAkcePrijmeni;
    @FXML
    private TableColumn<Hodina, Integer> columnUciteleAkceID;
    @FXML
    private TableColumn<Hodina, Integer> columnIDAkce;
    @FXML
    private TableColumn<Hodina, Integer> columnOd;
    @FXML
    private TableColumn<Hodina, Integer> columnDo;
    @FXML
    private TableColumn<Hodina, Integer> columnHodinovyFont;
    @FXML
    private TableColumn<Hodina, String> columnTypAkce;
    @FXML
    private Button buttonVytvorAkci;
    @FXML
    private Button buttonZrusAkci;
    @FXML
    private Button buttonZmenAkci;
    @FXML
    private TextField textOd;
    @FXML
    private TextField textDo;
    @FXML
    private TextField textCelkemHodinAkce;
    @FXML
    private ComboBox<String> choiceTypAkce;
    @FXML
    private ComboBox<Integer> choiceUciteleID;
    @FXML
    private TableView<Ucitel> tableVyucujici;
      @FXML
    private TableColumn<Ucitel, Integer> columnIDUciteleK;
    @FXML
    private ComboBox<String> choiceVypisPredmety;
    @FXML
    private TextField textVypisRozsah;
    @FXML
    private TableColumn<Obor, Integer> columnIDObor;
    @FXML
    private ComboBox<String> typCviceni;
    

    //DATA FOR COMBOBOXES
     private ObservableList<String> renevableChoiceVypisPredmety= FXCollections.observableArrayList();
    private ObservableList<String> renevableChoicePracoviste= FXCollections.observableArrayList();
     private ObservableList<String> renevableChoiceFakulta= FXCollections.observableArrayList();
     private ObservableList<String> renevableChoiceZakonceni= FXCollections.observableArrayList();
     private ObservableList<String> renevableChoiceZpusobVyukyPredmet= FXCollections.observableArrayList();
     private ObservableList<String> renevableChoiceVyucovanySemestr= FXCollections.observableArrayList();
     private ObservableList<String> renevableChoiceKatedraOboru= FXCollections.observableArrayList();
     private ObservableList<String> renevableChoiceFormaVyuky= FXCollections.observableArrayList();
     private ObservableList<String> renevableChoiceKategorie= FXCollections.observableArrayList();
     private ObservableList<String> renevableChoicePredmetDoOboru= FXCollections.observableArrayList();
     private ObservableList<String> renevableChoiceOborProPredmet= FXCollections.observableArrayList();
     private ObservableList<String> renevableChoiceTypAkce= FXCollections.observableArrayList();
     private ObservableList<Integer> renevableChoiceUciteleID= FXCollections.observableArrayList();
       private ObservableList<String> renevableTypCviceni = FXCollections.observableArrayList();
        private ObservableList<Integer> renevableVyberSi= FXCollections.observableArrayList();
     
    
    //LOGIN DATA  
    public String username1;
    public String password1;
    
    //TABLEVIEW DATA
    private ObservableList<Hodina> hodinaList = FXCollections.observableArrayList();
    private ObservableList<Obor> oborList= FXCollections.observableArrayList();
    private ObservableList<PracovisteVsech> PracovisteVsechList= FXCollections.observableArrayList();
    private ObservableList<Predmet> predmetList= FXCollections.observableArrayList();
    private ObservableList<PredmetOboru> predmetOboruList= FXCollections.observableArrayList();
    private ObservableList<Ucitel> ucitelList= FXCollections.observableArrayList();
  
    OracleConnector oc;
    @FXML
    private TableColumn<PracovisteVsech, Integer> columnFakID;
    @FXML
    private TableColumn<PracovisteVsech, Integer> columnKatID;
    @FXML
    private ComboBox<Integer> vyberSiPredmet;
    @FXML
    private TextField textDen;
    @FXML
    private TextField textStudentuP;
 
   
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        oc = null;
        
        valueFactories();
        
        login();
        try {
            OracleConnector.myInit(username1, password1);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        obnovListPracovist();
        obnovListUcitelu();
        obnovListHodin();
        obnovPredmet();
        obnovObor();
        
        
        
        
        
        //PreparedStatement stmt = conn.prepareStatement("SELECT * FROM JAVA_TRPASLICI");
        
       
        
    }
    
    private String returnMazaneID(){
        String pom = null;
        int pom2 = 0;
        TextInputDialog dialog = new TextInputDialog("ID mazaneho");
        dialog.setTitle("VYMAZ");

        dialog.setContentText("Vymaz toto ID");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            pom = result.get();
        }

        pom2 = Integer.parseInt(pom);
        return pom;
    }

    public String returnMazanyNazev() {
        String pom = null;
        int pom2 = 0;
        TextInputDialog dialog = new TextInputDialog("Nazev mazaneho");
        dialog.setTitle("VYMAZ");

        dialog.setContentText("Vymaz tento Nazev");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            pom = result.get();
        }

        return pom;
    }
    
    @FXML
    private void vlozUcitele(ActionEvent event) {
        
         Connection conn;

            try {

                conn = OracleConnector.getConnection();

                
                PreparedStatement stmt2 = conn.prepareStatement("SELECT * from SEM_PURE_KATEDRA_VIEW where ZKRATKA = ?");
                String pom3 = choicePracoviste.getValue();
                stmt2.setString(1, pom3);
                int id_Kat = 0;
               ResultSet rset = stmt2.executeQuery();
                while (rset.next()) {
                    id_Kat = rset.getInt("ID_KATEDRY");
                }
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO VYUCUJICI (JMENO, PRIJMENI, TITUL_PRED, TITUL_ZA, \"E-mail\", TELEFON, MOBIL,KATEDRA_ID_KATEDRY) VALUES (?,?,?,?,?,?,?,?)");
                String jmeno = textJmenoVyucujiciho.getText();
                String prijmeni = textPrijmeniVyucujiciho.getText();
                String email = textEmail.getText();
                String titul1 = textTitulPred.getText();
                String titul2 = textTitulZa.getText();
                String telefon = textTelefon.getText();
                String mobil = textMobil.getText();
               

                stmt.setString(1, jmeno);
                stmt.setString(2, prijmeni);
                stmt.setString(3, titul1);
                stmt.setString(4,titul2);
                stmt.setString(5, email);
                stmt.setString(6,telefon);
                stmt.setString(7,mobil);
                String pom = Integer.toString(id_Kat);
                stmt.setString(8,pom);
                stmt.executeUpdate();
                conn.commit();

            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            refreshAll();
        
    }

    @FXML
    private void vymazUcitele(ActionEvent event) {
        
       
       Connection conn;

        try {

            conn = OracleConnector.getConnection();

            PreparedStatement stmt = conn.prepareStatement("DELETE from VYUCUJICI where ID_UCITELE = ?");

            String pom = returnMazaneID();

            stmt.setString(1, pom);
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
     
    }

    @FXML
    private void upravUcitele(ActionEvent event) {
        
         Connection conn;

            try {

                conn = OracleConnector.getConnection();

                String id = returnMazaneID();
                PreparedStatement stmt2 = conn.prepareStatement("SELECT * from SEM_PURE_KATEDRA_VIEW where ZKRATKA = ?");
                String pom3 = choicePracoviste.getValue();
                stmt2.setString(1, pom3);
                int id_Kat = 0;
               ResultSet rset = stmt2.executeQuery();
                while (rset.next()) {
                    id_Kat = rset.getInt("ID_KATEDRY");
                }
                PreparedStatement stmt = conn.prepareStatement("UPDATE VYUCUJICI SET JMENO = ?, PRIJMENI = ?, TITUL_PRED = ?, TITUL_ZA = ?, \"E-mail\" = ?, TELEFON = ?, MOBIL = ?,KATEDRA_ID_KATEDRY= ? where ID_UCITELE = ?");
                String jmeno = textJmenoVyucujiciho.getText();
                String prijmeni = textPrijmeniVyucujiciho.getText();
                String email = textEmail.getText();
                String titul1 = textTitulPred.getText();
                String titul2 = textTitulZa.getText();
                String telefon = textTelefon.getText();
                String mobil = textMobil.getText();
               

                stmt.setString(1, jmeno);
                stmt.setString(2, prijmeni);
                stmt.setString(3, titul1);
                stmt.setString(4,titul2);
                stmt.setString(5, email);
                stmt.setString(6,telefon);
                stmt.setString(7,mobil);
                String pom = Integer.toString(id_Kat);
                stmt.setString(8,pom);
                stmt.setString(9, id);
                stmt.executeUpdate();
                conn.commit();

            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               
            }
            refreshAll();
        
        
        
    }

    @FXML
    private void pridejFakultu(ActionEvent event) {
        
        
         Connection conn;

        try {

            conn = OracleConnector.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO FAKULTA (Nazev,Zkratka) Values(?, ?)");
            String pom = textFakultaName.getText();
            String pom2 = textFakultaZkratka.getText();

            stmt.setString(1,pom);
            stmt.setString(2,pom2);
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
    }

    @FXML
    private void odeberFakultu(ActionEvent event) {
        Connection conn;

        try {

            conn = OracleConnector.getConnection();

            PreparedStatement stmt = conn.prepareStatement("DELETE from FAKULTA where ZKRATKA = ?");

            String pom = null;
            pom = returnMazanyNazev();

            stmt.setString(1, pom);
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
    }

    @FXML
    private void upravFakultu(ActionEvent event) {
        
       if (textFakultaName.getText() != null || textFakultaZkratka.getText() != null) { 
       Connection conn;

        try {

            conn = OracleConnector.getConnection();

           PreparedStatement stmt = conn.prepareStatement("UPDATE FAKULTA SET NAZEV = ?, ZKRATKA = ? WHERE ID_FAKULTA = ?");

            String pom0 = returnMazaneID();
           
                String pom = textFakultaName.getText();
                String pom2 = textFakultaZkratka.getText();

                stmt.setString(1, pom);
                stmt.setString(2, pom2);
                stmt.setString(3, pom0);
                stmt.executeUpdate();
                conn.commit();

           

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
               
       }  
        
       
    }

    @FXML
    private void pridejKatedru(ActionEvent event) {
        if (textKatedraName.getText() != null || choiceFakulta.getValue() != null || textKatedraZkratka.getText() != null) {
            Connection conn;

            try {
                    
                conn = OracleConnector.getConnection();

                PreparedStatement stmt2 = conn.prepareStatement("SELECT * from SEM_PURE_FAKULTA_VIEW where ZKRATKA = ?");
                String pom3 = choiceFakulta.getValue();
                stmt2.setString(1, pom3);
                int pom4 = 0;
                ResultSet rset = stmt2.executeQuery();
                while (rset.next()) {
                    pom4 = rset.getInt("ID_FAKULTA");
                }
                pom3 = Integer.toString(pom4);
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO KATEDRA (Nazev,Zkratka,Katedra.Fakulta_ID_FAKULTA) Values(?, ?, ?)");
                String pom = textKatedraName.getText();
                String pom2 = textKatedraZkratka.getText();
                stmt.setString(1, pom);
                stmt.setString(2, pom2);
                stmt.setInt(3, pom4);

                stmt.executeUpdate();
                //  conn.commit();

            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            refreshAll();
        }
    }

    @FXML
    private void odeberKatedru(ActionEvent event) {
        Connection conn;

        try {

            conn = OracleConnector.getConnection();

            PreparedStatement stmt = conn.prepareStatement("DELETE from KATEDRA where ID_KATEDRY = ?");

            String pom = returnMazaneID();

            stmt.setString(1, pom);
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
     
    }

    @FXML
    private void upravKatedru(ActionEvent event) {
        
        //"UPDATE FAKULTA SET NAZEV = ?, ZKRATKA = ? WHERE ID_FAKULTA = ?"
         if (textKatedraName.getText() != null || choiceFakulta.getValue() != null || textKatedraZkratka.getText() != null) {
            Connection conn;

            try {

                conn = OracleConnector.getConnection();
                String id = returnMazaneID();
                PreparedStatement stmt2 = conn.prepareStatement("SELECT * from SEM_PURE_FAKULTA_VIEW where ZKRATKA = ?");
                String pom3 = choiceFakulta.getValue();
                stmt2.setString(1, pom3);
                int pom4 = 0;
                ResultSet rset = stmt2.executeQuery();
                while (rset.next()) {
                    pom4 = rset.getInt("ID_FAKULTA");
                }
                pom3 = Integer.toString(pom4);
                PreparedStatement stmt = conn.prepareStatement("UPDATE KATEDRA SET Nazev = ? ,Zkratka = ? ,Katedra.Fakulta_ID_FAKULTA = ? where ID_KATEDRY = ?");
                String pom = textKatedraName.getText();
                String pom2 = textKatedraZkratka.getText();
                stmt.setString(1, pom);
                stmt.setString(2, pom2);
                stmt.setInt(3, pom4);
                stmt.setString(4,id);

                stmt.executeUpdate();
                //  conn.commit();

            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            refreshAll();
        }
    }

    @FXML
    private void vytvorObor(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();
            //String mazaneID = returnMazaneID();
            int actualKat = 0;
            int actualFor = 0;
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Studijni_Obor (NAZEV,ODHADOVANY_POCET,KATEDRA_ID_KATEDRY,FORMA_VYUKY_ID_FORMY) Values(?,0,?,?)");
            PreparedStatement valueKatedry = conn.prepareStatement("SELECT * from SEM_PURE_KATEDRA_VIEW where ZKRATKA = ?");
            String choice1 =  choiceKatedraOboru.getValue();
            valueKatedry.setString(1, choice1);
            ResultSet rset1 = valueKatedry.executeQuery();
            while (rset1.next()) {
                    actualKat = rset1.getInt("ID_KATEDRY");
                }
             String choice2 =  choiceFormaVyuky.getValue();
            PreparedStatement valueFormy = conn.prepareStatement("SELECT * from SEM_PURE_Forma_Vyuky where NAZEV = ?");
            valueFormy.setString(1,choice2);
            ResultSet rset2 = valueFormy.executeQuery();
            while (rset2.next()) {
                    actualFor = rset2.getInt("ID_FORMY");
            }
            
            String pom = textZkratkaOboru.getText();
            stmt.setString(1,pom);
            stmt.setInt(2, actualKat);
            stmt.setInt(3,actualFor);
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
    }

    @FXML
    private void zrusObor(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();
            String pom = returnMazaneID();
            PreparedStatement vymaz = conn.prepareStatement("DELETE from Studijni_OBOR where ID_OBOR = ?");
            vymaz.setString(1, pom);
            vymaz.executeUpdate();
            conn.commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
    }

    @FXML
    private void upravObor(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();
            //String mazaneID = returnMazaneID();
            int actualKat = 0;
            int actualFor = 0;
            PreparedStatement stmt = conn.prepareStatement("UPDATE Studijni_Obor set NAZEV = ?,ODHADOVANY_POCET = 0,KATEDRA_ID_KATEDRY = ?,FORMA_VYUKY_ID_FORMY = ? where ID_OBOR = ?");
            PreparedStatement valueKatedry = conn.prepareStatement("SELECT * from SEM_PURE_KATEDRA_VIEW where ZKRATKA = ?");
            String choice1 =  choiceKatedraOboru.getValue();
            String helpful = returnMazaneID();
            valueKatedry.setString(1, choice1);
            ResultSet rset1 = valueKatedry.executeQuery();
            while (rset1.next()) {
                    actualKat = rset1.getInt("ID_KATEDRY");
                }
             String choice2 =  choiceFormaVyuky.getValue();
            PreparedStatement valueFormy = conn.prepareStatement("SELECT * from SEM_PURE_Forma_Vyuky where NAZEV = ?");
            valueFormy.setString(1,choice2);
            ResultSet rset2 = valueFormy.executeQuery();
            while (rset2.next()) {
                    actualFor = rset2.getInt("ID_FORMY");
            }
            
            String pom = textZkratkaOboru.getText();
            stmt.setString(1,pom);
            stmt.setInt(2, actualKat);
            stmt.setInt(3,actualFor);
            stmt.setString(4, helpful);
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
    }

    @FXML
    private void vlozPdoOboru(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();

            String kategorie = choiceKategorie.getValue();
            String obor = choiceOborProPredmet.getValue();
            String pred = choicePredmetDoOboru.getValue();

            PreparedStatement prep = conn.prepareStatement("INSERT INTO PREDMETY_OBORU (STUDIJNI_OBOR_ID_OBOR, KATEGORIE_ID_KATEGORIE,PREDMET_ID_PREDMET) values (?,?,?)");
            PreparedStatement gemmeID1 = conn.prepareStatement("SELECT * FROM SEM_PURE_KATEGORIE where NAZEV = ?");
            gemmeID1.setString(1, kategorie);
            int IDpomocnik = 0;
            ResultSet rset2 = gemmeID1.executeQuery();
            while (rset2.next()) {
                IDpomocnik = rset2.getInt("ID_KATEGORIE");
            }
            PreparedStatement gemmeID2 = conn.prepareStatement("SELECT * FROM SEM_PURE_OBORY_VIEW where \"obor\" = ?");
            gemmeID2.setString(1, obor);
            int IDobor = 0;
            ResultSet rset3 = gemmeID2.executeQuery();
            while (rset3.next()) {
                IDobor = rset3.getInt("ID_OBOR");
            }
            PreparedStatement gemmeID3 = conn.prepareStatement("SELECT * FROM SEM_PURE_PREDMET_VIEW where ZKRATKA = ?");
            gemmeID3.setString(1, pred);
            int IDpred = 0;
            ResultSet rset4 = gemmeID3.executeQuery();
            while (rset4.next()) {
                IDpred = rset4.getInt("ID_PREDMET");
            }
            prep.setInt(1, IDobor);
            prep.setInt(2, IDpomocnik);
            prep.setInt(3, IDpred);
            prep.executeUpdate();
            PreparedStatement secti = conn.prepareStatement("update Studijni_Obor set Odhadovany_pocet = (select sum(Predmet.pocet_studentu) from Studijni_Obor inner join Predmety_Oboru on Studijni_obor.ID_obor = predmety_Oboru.Studijni_obor_id_obor inner join predmet on predmety_oboru.predmet_id_predmet = predmet.id_predmet where Studijni_obor.Nazev = ?) where Studijni_obor.Nazev = ?");
            secti.setString(1, obor);
            secti.setString(2, obor);
            secti.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
//     
        
        
    }

    @FXML
    private void odeberPzOboru(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();

          
            String obor = choiceOborProPredmet.getValue();
            String pred = choicePredmetDoOboru.getValue();

            PreparedStatement prep = conn.prepareStatement("DELETE FROM PREDMETY_OBORU where STUDIJNI_OBOR_ID_OBOR = ? AND PREDMET_ID_PREDMET = ? ");
      
           
            PreparedStatement gemmeID2 = conn.prepareStatement("SELECT * FROM SEM_PURE_OBORY_VIEW where \"obor\" = ?");
            gemmeID2.setString(1, obor);
            int IDobor = 0;
            ResultSet rset3 = gemmeID2.executeQuery();
            while (rset3.next()) {
                IDobor = rset3.getInt("ID_OBOR");
            }
            PreparedStatement gemmeID3 = conn.prepareStatement("SELECT * FROM SEM_PURE_PREDMET_VIEW where ZKRATKA = ?");
            gemmeID3.setString(1, pred);
            int IDpred = 0;
            ResultSet rset4 = gemmeID3.executeQuery();
            while (rset4.next()) {
                IDpred = rset4.getInt("ID_PREDMET");
            }
            prep.setInt(1, IDobor);
           
            prep.setInt(2, IDpred);
            prep.executeUpdate();
            PreparedStatement secti = conn.prepareStatement("update Studijni_Obor set Odhadovany_pocet = (select sum(Predmet.pocet_studentu) from Studijni_Obor inner join Predmety_Oboru on Studijni_obor.ID_obor = predmety_Oboru.Studijni_obor_id_obor inner join predmet on predmety_oboru.predmet_id_predmet = predmet.id_predmet where Studijni_obor.Nazev = ?) where Studijni_obor.Nazev = ?");
            secti.setString(1, obor);
            secti.setString(2, obor);
            secti.executeUpdate();

            conn.commit();

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        refreshAll();        
    }

    @FXML
    private void vytvorAkci(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();
            int od = Integer.parseInt(textOd.getText());
            int doc = Integer.parseInt(textDo.getText());
            int celkem = Integer.parseInt(textCelkemHodinAkce.getText());
            int id_ob = vyberSiPredmet.getValue();
            String day = textDen.getText();
            int id_uc = choiceUciteleID.getValue();
            String typ = choiceTypAkce.getValue();
            PreparedStatement prep = conn.prepareStatement("INSERT INTO ROZVRHOVA_AKCE (POCET_HODIN, VYUCUJICI_ID_UCITELE,ZPUSOB_VYUKY_ID_ZPUSOBU,OD,DO,DEN,PREDMET_ID_PREDMET) values (?,?,?,?,?,?,?)");
            PreparedStatement gemmeID = conn.prepareStatement("SELECT * FROM SEM_PURE_ZPUSOB_VYUKY where NAZEV = ?" );
            gemmeID.setString(1,typ);
            int pomocnik = 0;
            ResultSet rset2 = gemmeID.executeQuery();
            while (rset2.next()) {
                    pomocnik = rset2.getInt("ID_ZPUSOBU");
            }
            prep.setInt(1, celkem);
            prep.setInt(2,id_uc);
            prep.setInt(3,pomocnik);
            prep.setInt(4, od);
            prep.setInt(5, doc);
            prep.setString(6,day);
            prep.setInt(7, id_ob);
            prep.executeUpdate();
                    conn.commit();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
    }

    @FXML
    private void zrusAkci(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();
            String pom = returnMazaneID();
            PreparedStatement vymaz = conn.prepareStatement("DELETE from Rozvrhova_Akce where ID_Akce = ?");
            vymaz.setString(1, pom);
            vymaz.executeUpdate();
            conn.commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
    }

    @FXML
    private void zmenAkci(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();
            int od = Integer.parseInt(textOd.getText());
            int doc = Integer.parseInt(textDo.getText());
            int celkem = Integer.parseInt(textCelkemHodinAkce.getText());
            int id_ob = vyberSiPredmet.getValue();
            String day = textDen.getText();
            int id_uc = choiceUciteleID.getValue();
            String typ = choiceTypAkce.getValue();
            String pomocnik2 = returnMazaneID();
            //UPDATE Studijni_Obor set NAZEV = ?,ODHADOVANY_POCET = 0,KATEDRA_ID_KATEDRY = ?,FORMA_VYUKY_ID_FORMY = ? where ID_OBOR = ?
            PreparedStatement prep = conn.prepareStatement("UPDATE ROZVRHOVA_AKCE SET POCET_HODIN = ?, VYUCUJICI_ID_UCITELE = ?,ZPUSOB_VYUKY_ID_ZPUSOBU = ?,OD = ?,DO = ?,DEN = ?,PREDMET_ID_PREDMET = ? where ID_AKCE = ?");
            PreparedStatement gemmeID = conn.prepareStatement("SELECT * FROM SEM_PURE_ZPUSOB_VYUKY where NAZEV = ?" );
            gemmeID.setString(1,typ);
            int pomocnik = 0;
            ResultSet rset2 = gemmeID.executeQuery();
            while (rset2.next()) {
                    pomocnik = rset2.getInt("ID_ZPUSOBU");
            }
            prep.setInt(1, celkem);
            prep.setInt(2,id_uc);
            prep.setInt(3,pomocnik);
            prep.setInt(4, od);
            prep.setInt(5, doc);
            prep.setString(6,day);
            prep.setInt(7, id_ob);
            prep.setString(8, pomocnik2);
            prep.executeUpdate();
                    conn.commit();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
    }
    
    
    public void login(){
        // Create the custom dialog.
        
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");
   



        ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);


        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);


        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                 username1 = username.getText();
                 password1 = password.getText();
                return new Pair<>(username.getText(), password.getText());
               
                
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword -> {
            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
        });
        
    }

    private void valueFactories() {
        columnAkceJmeno.setCellValueFactory(new PropertyValueFactory<>("jmeno_Hodina"));
        columnAkcePrijmeni.setCellValueFactory(new PropertyValueFactory<>("prijmeni_Hodina"));
        
        columnUciteleAkceID.setCellValueFactory(new PropertyValueFactory<>("id_Uc_Hodina"));
        columnIDAkce.setCellValueFactory(new PropertyValueFactory<>("id_Hodina"));
        columnOd.setCellValueFactory(new PropertyValueFactory<>("odCas"));
        columnDo.setCellValueFactory(new PropertyValueFactory<>("doCas"));
        columnHodinovyFont.setCellValueFactory(new PropertyValueFactory<>("celkemCas"));
        columnTypAkce.setCellValueFactory(new PropertyValueFactory<>("typ_Akce"));
        //OBOR TABLE
        columnIDObor.setCellValueFactory(new PropertyValueFactory<>("ID_OBOR"));
        columnOborZkratka.setCellValueFactory(new PropertyValueFactory<>("zkratka_Obor"));
        columnOborKatedra.setCellValueFactory(new PropertyValueFactory<>("katedra_Obor"));
        columnFormaVyuky.setCellValueFactory(new PropertyValueFactory<>("forma_Vyuky"));
        columnCelkovyPocetStudentu.setCellValueFactory(new PropertyValueFactory<>("celkovy_Pocet_Studentu"));
        //SEPARATE
        columnOborPredmetTa.setCellValueFactory(new PropertyValueFactory<>("zkratkaPredmetuOboru"));
        columnKategorie.setCellValueFactory(new PropertyValueFactory<>("kategorie"));
        //PREDMET TABLE
        columnIDPredmetu.setCellValueFactory(new PropertyValueFactory<>("ID"));
        columnNazevPredmetu.setCellValueFactory(new PropertyValueFactory<>("nazev_Predmet"));
        columnZkratkaPredmetu.setCellValueFactory(new PropertyValueFactory<>("zkratka_Predmet"));
       // columnZpusobVyuky.setCellValueFactory(new PropertyValueFactory<>("zpusob_Vyuky_Predmet"));
        //columnRozsah.setCellValueFactory(new PropertyValueFactory<>("pocetHodin"));

        columnVyucovanySem.setCellValueFactory(new PropertyValueFactory<>("vyucovany_Semestr"));
        columnZakonceni.setCellValueFactory(new PropertyValueFactory<>("zakonceni"));
        columnDoporucenyRocnik.setCellValueFactory(new PropertyValueFactory<>("doporuceny_Rocnik"));
        //PRACOVISTE TABLE
        columnFakulta.setCellValueFactory(new PropertyValueFactory<>("fakulta_pracoviste"));
        columnFZkratka.setCellValueFactory(new PropertyValueFactory<>("fakulta_zkratka_pracoviste"));
        columnKatedra.setCellValueFactory(new PropertyValueFactory<>("katedra_pracoviste"));
        columnKZkratka.setCellValueFactory(new PropertyValueFactory<>("katedra_zkratka_pracoviste"));
        columnFakID.setCellValueFactory(new PropertyValueFactory<>("FakID"));
        columnKatID.setCellValueFactory(new PropertyValueFactory<>("KatID"));

     
        
        //UCITEL TABLE
        columnIDUciteleK.setCellValueFactory(new PropertyValueFactory<>("true_ID_Ucitele"));
        columnWorkplace.setCellValueFactory(new PropertyValueFactory<>("pracoviste_Ucitel"));
        columnJmenoVyucujiciho.setCellValueFactory(new PropertyValueFactory<>("jmeno_Ucitel"));
        columnPrijmeniVyucujiciho.setCellValueFactory(new PropertyValueFactory<>("prijmeni_Ucitel"));
        columnTitulPred.setCellValueFactory(new PropertyValueFactory<>("titulPred"));
        columnTitulZa.setCellValueFactory(new PropertyValueFactory<>("titulZa"));
        columnMobil.setCellValueFactory(new PropertyValueFactory<>("mobil"));
        columnTelefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }
    // FUNKCE KTERE PO KAZDE UPRAVE KTEREKOLIV TABULKY OBNOVI OBSAH TABLEVIEWU
    
    
    
    
    
    void obnovListHodin(){
        Connection conn;
        
        try {
            vyberSiPredmet.getItems().clear();
            renevableVyberSi.clear();
            renevableChoiceUciteleID.clear();
            renevableChoiceTypAkce.clear();
            hodinaList.clear();
        tableAkce.getItems().clear();
        choiceUciteleID.getItems().clear();
        choiceTypAkce.getItems().clear();
            
            conn = OracleConnector.getConnection();
             ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM SEM_VIEW_ROZVRHOVA_AKCE");
            while (rset.next()) {
            hodinaList.add(new Hodina(
                    rset.getString("PRIJMENI"),
                    rset.getString("JMENO"),
                    rset.getInt("ID_UCITELE"),
                    rset.getInt("ID_AKCE"),
                    rset.getInt("OD"),
                    rset.getInt("DO"),
                    rset.getInt("POCET_HODIN"),
                    rset.getString("NAZEV")
                    
            ));
        }
         // conn = OracleConnector.getConnection();
             ResultSet rset1 = conn.createStatement().executeQuery("SELECT * FROM SEM_PURE_UCITELE_VIEW");
            while (rset1.next()) {
            renevableChoiceUciteleID.add(
                    rset1.getInt("ID_UCITELE")
                    );
        }
            ResultSet rset5 = conn.createStatement().executeQuery("SELECT * FROM SEM_PURE_PREDMET_VIEW");
            while (rset5.next()) {
            renevableVyberSi.add(
                    rset5.getInt("ID_PREDMET")
                    );
        }
            ResultSet rset2 = conn.createStatement().executeQuery("SELECT * FROM SEM_PURE_ZPUSOB_VYUKY");
            while (rset2.next()) {
            renevableChoiceTypAkce.add(
                    rset2.getString("NAZEV")
                    );
        }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        vyberSiPredmet.setItems(renevableVyberSi);
        tableAkce.setItems(hodinaList);
        choiceUciteleID.setItems(renevableChoiceUciteleID);
        choiceTypAkce.setItems(renevableChoiceTypAkce);
    }
    
    
    void obnovListUcitelu(){
        Connection conn;
        
        try {
            renevableChoicePracoviste.clear();
            ucitelList.clear();
        tableVyucujici.getItems().clear();
        choicePracoviste.getItems().clear();
            
            conn = OracleConnector.getConnection();
             ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM SEM_VIEW_VYUCUJICI");
            while (rset.next()) {
            ucitelList.add(new Ucitel(
                    rset.getInt("ID_UCITELE"),
                    rset.getString("ZKRATKA"),
                    rset.getString("JMENO"),
                    rset.getString("PRIJMENI"),
                    rset.getString("TITUL_PRED"),
                    rset.getString("TITUL_ZA"),
                    rset.getString("TELEFON"),
                    rset.getString("MOBIL"),
                    rset.getString("E-mail")
                    
            ));
        }
         // conn = OracleConnector.getConnection();
             ResultSet rset1 = conn.createStatement().executeQuery("SELECT * FROM SEM_VIEW_PRACOVISTE");
            while (rset1.next()) {
            renevableChoicePracoviste.add(
                    rset1.getString("Kat. Zkratka")
                    );
        }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableVyucujici.setItems(ucitelList);
        choicePracoviste.setItems(renevableChoicePracoviste);
    }
    
    void obnovListPracovist(){
        Connection conn;
         renevableChoiceFakulta.clear();
            PracovisteVsechList.clear();
        
        try {
           
        tablePracoviste.getItems().clear();
        choiceFakulta.getItems().clear();
            
            conn = OracleConnector.getConnection();
             ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM SEM_VIEW_PRACOVISTE");
            while (rset.next()) {
            PracovisteVsechList.add(new PracovisteVsech(
                    rset.getInt("ID_FAKULTA"),
                    rset.getInt("ID_KATEDRY"),
                    rset.getString("Fak. Nazev"),
                    rset.getString("Fak. Zkratka"),
                    rset.getString("Kat Nazev"),
                    rset.getString("Kat. Zkratka")));
        }
          // Connection conn1 = OracleConnector.getConnection();
             ResultSet rset1 = conn.createStatement().executeQuery("SELECT * FROM SEM_PURE_FAKULTA_VIEW");
            while (rset1.next()) {
            renevableChoiceFakulta.add(
                    rset1.getString("ZKRATKA")
                    );
        }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tablePracoviste.setItems(PracovisteVsechList);
        choiceFakulta.setItems(renevableChoiceFakulta);
                
    }
    void obnovPredmet(){
        Connection conn;
        
        try {
            
            choiceVyucovanySemestr.getItems().clear();
            choiceZakonceni.getItems().clear();
            choiceVypisPredmety.getItems().clear();
            typCviceni.getItems().clear();
            renevableTypCviceni.clear();
            predmetList.clear();
            tabulkaPredmet.getItems().clear();
            
            renevableChoiceVyucovanySemestr.clear();
            renevableChoiceZakonceni.clear();
            renevableChoiceVypisPredmety.clear();
            conn = OracleConnector.getConnection();
            ResultSet rset = conn.createStatement().executeQuery("SELECT * FROM SEM_PURE_PREDMET_VIEW");
            while (rset.next()) {
                predmetList.add(new Predmet(
                        rset.getInt("ID_PREDMET"),
                        rset.getString("predmet"),
                        rset.getString("ZKRATKA"),
                        rset.getString("semestr"),
                        rset.getString("zakonceni"),
                        rset.getInt("DOPORUCENY_ROCNIK")
                ));
            }
            // conn = OracleConnector.getConnection();
            ResultSet rset1 = conn.createStatement().executeQuery("SELECT * FROM SEM_PURE_ZPUSOB_ZAKONCENI");
            while (rset1.next()) {
                renevableChoiceZakonceni.add(
                        rset1.getString("NAZEV")
                );
            }
            ResultSet rset2 = conn.createStatement().executeQuery("SELECT * FROM SEM_PURE_SEMESTR");
            while (rset2.next()) {
                renevableChoiceVyucovanySemestr.add(
                        rset2.getString("NAZEV")
                );
            }
            ResultSet rset3 = conn.createStatement().executeQuery("select distinct \"Nazev Predmetu\", \"Zkratka predmetu\", DOPORUCENY_ROCNIK, \"Zpusob Zakonceni\", \"Semester\" from sem_view_predmet");
            while (rset3.next()) {
                renevableChoiceVypisPredmety.add(
                        rset3.getString("Nazev Predmetu")
                );
            }
            ResultSet rset4 = conn.createStatement().executeQuery("SELECT * FROM SEM_PURE_ZPUSOB_VYUKY");
            while (rset4.next()) {
                renevableTypCviceni.add(
                        rset4.getString("NAZEV")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabulkaPredmet.setItems(predmetList);
        typCviceni.setItems(renevableTypCviceni);
        choiceVypisPredmety.setItems(renevableChoiceVypisPredmety);
        choiceZakonceni.setItems(renevableChoiceZakonceni);
        choiceVyucovanySemestr.setItems(renevableChoiceVyucovanySemestr);
    }

    void obnovObor() {
        Connection conn;

        try {

            choiceKatedraOboru.getItems().clear();
            choiceFormaVyuky.getItems().clear();
            choiceKategorie.getItems().clear();
            choiceOborProPredmet.getItems().clear();
            choicePredmetDoOboru.getItems().clear();
            oborList.clear();
           
            tabulkaObor.getItems().clear();
             predmetOboruList.clear();
            tabulkaOborPredmet.getItems().clear();
            renevableChoiceKatedraOboru.clear();
            renevableChoiceFormaVyuky.clear();
            renevableChoiceKategorie.clear();
            renevableChoiceOborProPredmet.clear();
            renevableChoicePredmetDoOboru.clear();
            conn = OracleConnector.getConnection();
            ResultSet rset = conn.createStatement().executeQuery("select *  from sem_pure_obory_view");
            while (rset.next()) {
                oborList.add(new Obor(
                        rset.getInt("ID_OBOR"),
                        rset.getString("obor"),
                        rset.getString("katedra"),
                        rset.getInt("ODHADOVANY_POCET"),
                        rset.getString("forma vyuky")
                ));
            }
            // conn = OracleConnector.getConnection();
            ResultSet rset1 = conn.createStatement().executeQuery("select * from SEM_PURE_KATEDRA_VIEW");
            while (rset1.next()) {
                renevableChoiceKatedraOboru.add(
                        rset1.getString("ZKRATKA")
                );
            }
            ResultSet rset2 = conn.createStatement().executeQuery("SELECT * FROM SEM_PURE_FORMA_VYUKY");
            while (rset2.next()) {
                renevableChoiceFormaVyuky.add(
                        rset2.getString("NAZEV")
                );
            }
            ResultSet rset3 = conn.createStatement().executeQuery("select * from kategorie");
            while (rset3.next()) {
                renevableChoiceKategorie.add(
                        rset3.getString("NAZEV")
                );
            }
            ResultSet rset4 = conn.createStatement().executeQuery("select * from sem_pure_obory_view");
            while (rset4.next()) {
                renevableChoiceOborProPredmet.add(
                        rset4.getString("obor")
                );
            }
            ResultSet rset5 = conn.createStatement().executeQuery("select * from sem_pure_predmet_view");
            while (rset5.next()) {
                renevableChoicePredmetDoOboru.add(
                        rset5.getString("ZKRATKA")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabulkaObor.setItems(oborList);
        choiceVypisPredmety.setItems(renevableChoiceVypisPredmety);
        choiceZakonceni.setItems(renevableChoiceZakonceni);
        choiceVyucovanySemestr.setItems(renevableChoiceVyucovanySemestr);
        choiceKatedraOboru.setItems(renevableChoiceKatedraOboru);
        choiceFormaVyuky.setItems(renevableChoiceFormaVyuky);
        choiceKategorie.setItems(renevableChoiceKategorie);
        choiceOborProPredmet.setItems(renevableChoiceOborProPredmet);
        choicePredmetDoOboru.setItems(renevableChoicePredmetDoOboru);

        
    }

    @FXML
    private void vypisUdajePredmetu(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();
            String one = typCviceni.getValue();
            String two = choiceVypisPredmety.getValue();
            PreparedStatement stmt = conn.prepareStatement("select sum(POCET_HODIN) from sem_view_predmet where \"Nazev Predmetu\" = ? and \"Zpusob Vyuky\" = ?");
            stmt.setString(1,two);
            stmt.setString(2,one);
            ResultSet rset = stmt.executeQuery();
            
            //ResultSet rset = conn.createStatement().executeQuery("select *  from sem_pure_obory_view");
            while (rset.next()) {
               textVypisRozsah.setText(Integer.toString(rset.getInt("SUM(POCET_HODIN)")));
                     
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void zobrazTabulyPredmetuOboru(ActionEvent event) {
        Connection conn;
        
        try {
            predmetOboruList.clear();
        tabulkaOborPredmet.getItems().clear();
            conn = OracleConnector.getConnection();
            
            PreparedStatement stmt = conn.prepareStatement("SELECT * from sem_view_obor where \"Studijni Obor\" = ?");
            
       
       
         stmt.setString(1,choiceOborProPredmet.getValue());
       
            ResultSet rset = stmt.executeQuery();
    
            //ResultSet rset = conn.createStatement().executeQuery("select *  from sem_pure_obory_view");
            while (rset.next()) {
                predmetOboruList.add(new PredmetOboru(
                       rset.getString("Kategorie"),
                        rset.getString("Predmet")
                        
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabulkaOborPredmet.setItems(predmetOboruList);
        
    }
    void refreshAll(){
        obnovListPracovist();
        obnovListUcitelu();
        obnovListHodin();
        obnovPredmet();
        obnovObor();
        
    }

    @FXML
    private void vytvorPredmet(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();
            String nazev = textNazevPredmet.getText();
            String zkratka = textZkratkaPredmet.getText();
            int sem = Integer.parseInt(textDopRocnik.getText());
            String semestr = choiceVyucovanySemestr.getValue();
            String zakonceni = choiceZakonceni.getValue();
            int pocet = Integer.parseInt(textStudentuP.getText());
            
            PreparedStatement prep = conn.prepareStatement("INSERT INTO PREDMET (NAZEV,DOPORUCENY_ROCNIK,POCET_STUDENTU,ZPUSOB_ZAKONCENI_ID_ZAKONCENI,SEMESTR_ID_SEMESTRU,ZKRATKA) values (?,?,?,?,?,?)");
            PreparedStatement gemmeID = conn.prepareStatement("SELECT * FROM SEM_PURE_SEMESTR where NAZEV = ?" );
            gemmeID.setString(1,semestr);
            int pomocnikSem = 0;
            ResultSet rset2 = gemmeID.executeQuery();
            while (rset2.next()) {
                    pomocnikSem = rset2.getInt("ID_SEMESTRU");
            }
            PreparedStatement gemmeID2 = conn.prepareStatement("SELECT * FROM SEM_PURE_ZPUSOB_ZAKONCENI where NAZEV = ?" );
            gemmeID2.setString(1,zakonceni);
            int pomocnikZak = 0;
            ResultSet rset3 = gemmeID2.executeQuery();
            while (rset3.next()) {
                    pomocnikZak = rset3.getInt("ID_ZAKONCENI");
            }
            prep.setString(1, nazev);
            prep.setInt(2, sem);
            prep.setInt(3,pocet);
            prep.setInt(4, pomocnikZak);
            prep.setInt(5,pomocnikSem);
            prep.setString(6, zkratka);
           
            prep.executeUpdate();
                    conn.commit();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
    }

    @FXML
    private void zrusPredmet(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();
            String pom = returnMazaneID();
            PreparedStatement vymaz = conn.prepareStatement("DELETE from Predmet where ID_Predmet = ?");
            vymaz.setString(1, pom);
            vymaz.executeUpdate();
            conn.commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
    }

    @FXML
    private void upravPredmet(ActionEvent event) {
        Connection conn;
        try {
            conn = OracleConnector.getConnection();
            String nazev = textNazevPredmet.getText();
            String zkratka = textZkratkaPredmet.getText();
            int sem = Integer.parseInt(textDopRocnik.getText());
            String semestr = choiceVyucovanySemestr.getValue();
            String zakonceni = choiceZakonceni.getValue();
            int pocet = Integer.parseInt(textStudentuP.getText());
            String hola = returnMazaneID();
            PreparedStatement prep = conn.prepareStatement("UPDATE PREDMET SET NAZEV = ?,DOPORUCENY_ROCNIK = ?,POCET_STUDENTU = ?,ZPUSOB_ZAKONCENI_ID_ZAKONCENI = ?,SEMESTR_ID_SEMESTRU = ?,ZKRATKA= ? where ID_PREDMET = ?");
            PreparedStatement gemmeID = conn.prepareStatement("SELECT * FROM SEM_PURE_SEMESTR where NAZEV = ?" );
            gemmeID.setString(1,semestr);
            int pomocnikSem = 0;
            ResultSet rset2 = gemmeID.executeQuery();
            while (rset2.next()) {
                    pomocnikSem = rset2.getInt("ID_SEMESTRU");
            }
            PreparedStatement gemmeID2 = conn.prepareStatement("SELECT * FROM SEM_PURE_ZPUSOB_ZAKONCENI where NAZEV = ?" );
            gemmeID2.setString(1,zakonceni);
            int pomocnikZak = 0;
            ResultSet rset3 = gemmeID2.executeQuery();
            while (rset3.next()) {
                    pomocnikZak = rset3.getInt("ID_ZAKONCENI");
            }
            prep.setString(1, nazev);
            prep.setInt(2, sem);
            prep.setInt(3,pocet);
            prep.setInt(4, pomocnikZak);
            prep.setInt(5,pomocnikSem);
            prep.setString(6, zkratka);
            prep.setString(7, hola);
           
            prep.executeUpdate();
                    conn.commit();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshAll();
    }

}
