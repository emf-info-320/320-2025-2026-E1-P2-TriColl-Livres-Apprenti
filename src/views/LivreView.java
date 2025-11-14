package views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import controllers.IControllerForLivreView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Livre;

public class LivreView implements ILivreViewForController, Initializable {
    @FXML
    private ComboBox<Integer> cbbx_annee;

    @FXML
    private ComboBox<String> cbbx_auteurs;

    @FXML
    private ComboBox<String> cbbx_langues;

    @FXML
    private CheckBox chckbx_annee;

    @FXML
    private CheckBox chckbx_auteur;

    @FXML
    private CheckBox chckbx_langue;

    @FXML
    private Text txtNbrLivre;

    @FXML
    private Button btnAjouter;

    @FXML
    private TextArea txtInformations;

    @FXML
    private Button btnVoirListe;

    @FXML
    private ListView<Livre> lstLivres;

    @FXML
    private Text txtNom;

    IControllerForLivreView controller;

    private String langueCourante = "fr"; // Langue par défaut

    public LivreView(IControllerForLivreView controller) {
        this.controller = controller;
    }

    @Override
    public void start() {
        start(langueCourante);
    }

    public void start(String langue) {
        try {
            langueCourante = langue;
            Stage livreStage = new Stage();
            Locale locale = new Locale(langue);
            ResourceBundle bundle = ResourceBundle.getBundle("ressources/MessageBundle", locale);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("livreView.fxml"), bundle);
            fxmlLoader.setControllerFactory(type -> this);
            Parent root = fxmlLoader.load();
            Scene secondaryScene = new Scene(root);

            secondaryScene.getStylesheets().add(getClass().getResource("/css/css2.css").toExternalForm());
            livreStage.setScene(secondaryScene);
            livreStage.setMinWidth(500);
            livreStage.setMinHeight(400);
            livreStage.setMaxWidth(900);
            livreStage.setMaxHeight(600);
            livreStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
            Platform.exit();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnVoirListe.setDefaultButton(true);

        lstLivres.getSelectionModel().selectedItemProperty().addListener((observable, ancienLivre, nouveauLivre) -> {
            afficherInfo(nouveauLivre);
        });

        btnVoirListe.setOnAction((ActionEvent ae) -> {
            afficherListe();
        });

        btnAjouter.setOnAction((ActionEvent ae) -> {
            controller.ajouterLivre(lstLivres.getSelectionModel().getSelectedItem());
        });

        chckbx_auteur.setOnAction((ActionEvent ae) ->{
            chckbx_annee.setSelected(false);
            gererFiltre();
        });

        chckbx_langue.setOnAction((ActionEvent ae) ->{
            chckbx_annee.setSelected(false);
            gererFiltre();
        });

        chckbx_annee.setOnAction((ActionEvent ae) ->{
            chckbx_auteur.setSelected(false);
            chckbx_langue.setSelected(false);
            gererFiltre();
        });

        cbbx_auteurs.setOnAction((ActionEvent ae)->{
            gererFiltre();
        });

        cbbx_langues.setOnAction((ActionEvent ae)->{
            gererFiltre();
        });

        cbbx_annee.setOnAction((ActionEvent ae)->{
            gererFiltre();
        });

        initialiserDonnee();
        gererFiltre();
    }

    public void initialiserDonnee(){
        chargerAuteurs();
        chargerLangues();
        chargerAnnee();
        chargerLivre();
    }

    public void afficherListe() {
        controller.afficherListe(langueCourante);
    }

    public void setPrenom(String nom) {
        txtNom.setText(" " + nom);
    }

    public void chargerAuteurs() {
        cbbx_auteurs.getItems().addAll(controller.getAuteurs());
        cbbx_auteurs.getSelectionModel().selectFirst();
    }

    public void chargerLangues() {
        cbbx_langues.getItems().addAll(controller.getLangues());
        cbbx_langues.getSelectionModel().selectFirst();
    }

    public void chargerAnnee() {
        cbbx_annee.getItems().addAll(controller.getAnnees());
        cbbx_annee.getSelectionModel().selectFirst();
    }

    public void chargerLivre() {
        lstLivres.getItems().addAll(controller.getLivres());
        txtNbrLivre.setText(controller.getNbrLivres() + " livres à disposition!"); 
    }

    private void gererFiltre(){
        lstLivres.getItems().clear();
        //appel des filtres
        if(chckbx_auteur.isSelected() && chckbx_langue.isSelected()){
            lstLivres.getItems().addAll(controller.getlivresParAuteurEtLangue(cbbx_auteurs.getValue(), cbbx_langues.getValue()));
        }
        else if(chckbx_auteur.isSelected()){
            lstLivres.getItems().addAll(controller.getLivresParAuteur(cbbx_auteurs.getValue())); 
        }
        else if(chckbx_langue.isSelected()){
            lstLivres.getItems().addAll(controller.getLivresParLangue(cbbx_langues.getValue())); 
        }
        else if(chckbx_annee.isSelected()){
            lstLivres.getItems().addAll(controller.getLivresParAnneePublication(cbbx_annee.getValue())); 
        }
        else  lstLivres.getItems().addAll(controller.getLivres());
        lstLivres.getSelectionModel().selectFirst();
    }

    private void afficherInfo(Livre nouveauLivre) {
        
        ArrayList<String> langues = new ArrayList<>();
        String datePublication;

        langues.add("Non défini");
        datePublication = "Non défini";

        if (nouveauLivre != null) {
            if (nouveauLivre.getLangues() != null) {
                langues = nouveauLivre.getLangues();
            }

            if (nouveauLivre.getAnneePublication() != null) {
                datePublication = String.valueOf(nouveauLivre.getAnneePublication());
            }
            txtInformations.setText(  nouveauLivre.getTitre() + "\n" 
                                    + nouveauLivre.getAuteurs() + "\n" 
                                    + langues.toString() + "\n" 
                                    + datePublication);
        }
    }
}
