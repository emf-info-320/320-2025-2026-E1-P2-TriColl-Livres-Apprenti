package controllers;

import java.util.ArrayList;

import models.Livre;

public interface IControllerForLivreView {

    void afficherListe(String langue);

    ArrayList<String> getAuteurs();

    ArrayList<String> getLangues();

    ArrayList<Integer> getAnnees();

    ArrayList<Livre> getLivres();

    int getNbrLivres();

    ArrayList<Livre> getLivresParAuteur(String auteur);

    ArrayList<Livre> getLivresParLangue(String langue);

    ArrayList<Livre> getLivresParAnneePublication(Integer annee);

    ArrayList<Livre> getlivresParAuteurEtLangue(String auteur, String langue);


    void ajouterLivre(Livre livre);

}
