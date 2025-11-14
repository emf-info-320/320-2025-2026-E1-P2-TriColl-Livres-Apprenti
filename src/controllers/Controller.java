package controllers;

import java.util.ArrayList;

import models.Livre;
import models.LivreAlire;
import services.ServiceImportDonnee;
import services.ServiceIndexationLivres;
import services.ServiceLivreSelection;
import views.IListeSelectionViewForController;
import views.ILivreViewForController;
import views.IViewForController;
import views.ListeSelectionView;
import views.LivreView;
import views.View;

public class Controller implements IControllerForView, IControllerForLivreView, IControllerForListeSelectionView {
    private final IViewForController view;

    private final ILivreViewForController livreView;
    private final IListeSelectionViewForController listeSelectionView;
    
   
    private final ServiceImportDonnee  serviceImportDonnee;
    private final ServiceIndexationLivres serviceIndexationLivres; 
    private final ServiceLivreSelection serviceLivreSelection;

    public Controller() {
        view = new View(this);
        livreView = new LivreView(this);
        listeSelectionView = new ListeSelectionView(this);
        serviceImportDonnee = new ServiceImportDonnee();
        serviceIndexationLivres = new ServiceIndexationLivres();
        serviceLivreSelection = new ServiceLivreSelection();

        ArrayList<Livre> livres = serviceImportDonnee.importFromXML("livres.xml");
        serviceIndexationLivres.indexerLivres(livres);

    }

    public void start() {
        view.start();
    }

    
    //---------------------------------------------------------------
    //Méthode surchargée de l'interface IControllerForView
    //---------------------------------------------------------------
    @Override
    public void connexion(String nomUser, String langue) {
        livreView.start(langue);
        livreView.setPrenom(nomUser);
    }

    //---------------------------------------------------------------
    //Méthodes surchargées de l'interface IControllerForLivreView
    //---------------------------------------------------------------
    public void afficherListe(String langue) {
        listeSelectionView.start(langue);
        listeSelectionView.raffraichirListe(serviceLivreSelection.getListeSelectionDeLivres());
    }

    @Override
    public ArrayList<String> getAuteurs(){
        return serviceIndexationLivres.getAuteurs();
    }

    @Override
    public ArrayList<String> getLangues(){
        return serviceIndexationLivres.getLangues();
    }

    @Override
    public ArrayList<Integer> getAnnees(){
        return serviceIndexationLivres.getAnneesDePublication();
    }

    @Override
    public ArrayList<Livre> getLivres(){
        return serviceIndexationLivres.getLivresSansDoublons();
    }

    @Override
    public int getNbrLivres(){
        return serviceIndexationLivres.getNombreDeLivre();
    }

    @Override
    public ArrayList<Livre> getLivresParAuteur(String auteur){
        return serviceIndexationLivres.getLivresParAuteur(auteur);  
    }

    @Override
    public ArrayList<Livre> getLivresParLangue(String langue){
        return serviceIndexationLivres.getLivresParLangue(langue);
    }

    @Override
    public ArrayList<Livre> getLivresParAnneePublication(Integer annee){
        return serviceIndexationLivres.getLivresParAnneePublication(annee);
    }

    @Override
    public ArrayList<Livre> getlivresParAuteurEtLangue(String auteur, String langue){
        return serviceIndexationLivres.getlivresParAuteurEtLangue(auteur, langue);
    }

    @Override
    public void ajouterLivre(Livre livre){
        serviceLivreSelection.ajouterLivre(livre);
    }

    //---------------------------------------------------------------
    //Méthodes surchargées de l'interface IControllerForListeSelectionView
    //---------------------------------------------------------------

    @Override
    public  void supprimerLivre(LivreAlire livre){
        //
        //               )        (                 ) (           (         (
        //            ( /(   *   ))\ )        (  ( /( )\ )        )\ )  (   )\ )
        //      (   ( )\())` )  /(()/((       )\ )\()|()/(  (    (()/(  )\ (()/(
        //      )\  )((_)\  ( )(_))(_))\    (((_|(_)\ /(_)) )\    /(_)|((_) /(_))
        //     ((_)((_)((_)(_(_()|_))((_)   )\___ ((_|_))_ ((_)  (_)) )\___(_))
        //     __   _____ _____ ___ ___    ___ ___  ___  ___   ___ ___ ___   _
        //     \ \ / / _ \_   _| _ \ __|  / __/ _ \|   \| __| |_ _/ __|_ _| | |
        //      \ V / (_) || | |   / _|  | (_| (_) | |) | _|   | | (__ | |  |_|
        //       \_/ \___/ |_| |_|_\___|  \___\___/|___/|___| |___\___|___| (_)
        //
    }

    @Override 
    public void triParAuteur(){
        listeSelectionView.raffraichirListe(serviceLivreSelection.triParAuteur());
    }

    @Override
    public void triParAnneePublication(){
        listeSelectionView.raffraichirListe(serviceLivreSelection.triParAnneePublication());
    }

    @Override
    public ArrayList<LivreAlire> getListeSelectionDeLivres(){
        return serviceLivreSelection.getListeSelectionDeLivres();
    }
}
