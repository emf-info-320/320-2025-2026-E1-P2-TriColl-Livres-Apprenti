package views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import controllers.IControllerForListeSelectionView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.LivreAlire;


public class ListeSelectionView implements IListeSelectionViewForController, Initializable {

    @FXML
    private Button btnOk;

    @FXML
    private Button btnSupprimer;

    @FXML
    private ListView<LivreAlire> lstLivresALire;

    @FXML
    private TextField txtFldRecherche;

    @FXML
    private TextArea txtInformations;

    @FXML
    private RadioButton rdbtn_triParAuteur;

    @FXML
    private RadioButton rdbtn_triParDate;

    private final IControllerForListeSelectionView controller;

    private Stage listeStage;


    public ListeSelectionView(IControllerForListeSelectionView controller) {
        this.controller = controller;
    }


    @Override
    public void start() {
        start("fr");
    }

    public void start(String langue) {
        try {
            listeStage = new Stage();
            Locale locale = new Locale(langue);
            ResourceBundle bundle = ResourceBundle.getBundle("ressources/MessageBundle", locale);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listeSelectionView.fxml"), bundle);
            fxmlLoader.setControllerFactory(type -> this);
            Parent root = fxmlLoader.load();
            Scene secondaryScene = new Scene(root);

            secondaryScene.getStylesheets().add(getClass().getResource("/css/css2.css").toExternalForm());
            listeStage.setScene(secondaryScene);
            listeStage.initModality(Modality.APPLICATION_MODAL);
            listeStage.setMinWidth(500);
            listeStage.setMinHeight(400);
            listeStage.setMaxWidth(900);
            listeStage.setMaxHeight(600);
            listeStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
            Platform.exit();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnOk.setDefaultButton(true);
        
        raffraichirListe(controller.getListeSelectionDeLivres());

        btnOk.setOnAction(event -> {
            Stage stage = (Stage) btnOk.getScene().getWindow();
            stage.close();
        });

        btnSupprimer.setOnAction(event -> {
            supprimerLivre();
        });

        rdbtn_triParAuteur.setOnAction(event ->{
            tris();
        });

        rdbtn_triParDate.setOnAction(event ->{
            tris();
        });
    }

    @Override
    public void raffraichirListe(ArrayList<LivreAlire> livres){
        lstLivresALire.getItems().clear();
        lstLivresALire.getItems().addAll(livres);
        lstLivresALire.getSelectionModel().selectFirst();
        afficherInfo();
    }

    public void afficherInfo() {
        lstLivresALire.getSelectionModel().selectedItemProperty().addListener((observable, ancienLivre, nouveauLivre) -> {
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

                txtInformations.setText(nouveauLivre.getTitre() + "\n" +
                        nouveauLivre.getAuteurs() + "\n" +
                        langues + "\n" +
                        datePublication + "\n" +
                        "date de sélection: " + "\n" + nouveauLivre.getDateSelection());
                        // "date de sélection: " + "\n" + ServiceFormatageDate.formaterDate(nouveauLivre.getDateSelection()));
            }
        });
    }

    private void tris(){
        if(rdbtn_triParAuteur.isSelected()){
            controller.triParAuteur(); 
            lstLivresALire.refresh();
        }
        else if(rdbtn_triParDate.isSelected())
        {
            controller.triParAnneePublication(); 
        }
    }

    //à décommenter par apprenti ?
    private void supprimerLivre() {
        //Cette instruction vous retourne l'instanc du livre sélectionné
        LivreAlire livreAlire = lstLivresALire.getSelectionModel().getSelectedItem();

        //à coder par apprenti
        //à coder par apprenti
        controller.supprimerLivre(livreAlire);
    }
}
