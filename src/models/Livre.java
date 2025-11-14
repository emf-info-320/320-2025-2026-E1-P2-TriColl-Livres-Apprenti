package models;

import java.util.ArrayList;

public class Livre {
    private String titre;
    private ArrayList<String> auteurs;
    private ArrayList<String> langues;
    private Integer anneePublication;
    private Integer editionCount;

    /**
     * Constructeur par défaut
     */
    public Livre(){
        auteurs = new ArrayList<>();
        langues = new ArrayList<>(); 
    };

   /**
    * Constructeur de copie.
    * 
    * @param livre le livre de base
    */
    public Livre(Livre livre){
        auteurs = new ArrayList<>();
        langues = new ArrayList<>(); 

        this.titre = livre.titre;
        for (String auteur : livre.auteurs) {
           this.auteurs.add(auteur); 
        }
        for (String langue : livre.langues) {
           this.langues.add(langue);
        }
        this.anneePublication = livre.anneePublication;
        this.editionCount = livre.editionCount;
    }

    public Integer getEditionCount() {
        return editionCount;
    }

    public void setEditionCount(Integer edition_count) {
        this.editionCount = edition_count;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ArrayList<String> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(ArrayList<String> auteurs) {
        this.auteurs.addAll(auteurs);
    }

    public ArrayList<String> getLangues() {
        return langues;
    }

    public void setLangues(ArrayList<String> langues) {
        this.langues.addAll(langues);
    }

    public Integer getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(Integer anneePublication) {
        this.anneePublication = anneePublication;
    }


    @Override
    public String toString() {
        return titre;
    }
}