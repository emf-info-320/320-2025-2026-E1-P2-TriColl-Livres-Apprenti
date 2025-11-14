package controllers;

import java.util.ArrayList;

import models.LivreAlire;

public interface IControllerForListeSelectionView {

    void supprimerLivre(LivreAlire livre);

    void triParAuteur();

    void triParAnneePublication();

    ArrayList<LivreAlire> getListeSelectionDeLivres();
}
