package views;

import java.util.ArrayList;

import models.LivreAlire;

public interface IListeSelectionViewForController {
    void start();
    
    void start(String langue);

    void raffraichirListe(ArrayList<LivreAlire> selectionneLivres);
} 