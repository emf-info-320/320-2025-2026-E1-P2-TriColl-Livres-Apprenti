package services;

import models.Livre;

import java.util.ArrayList;


/**
 * Service d'indexation et de consultation rapide d'une collection de {@link models.Livre}.
 * <p>
 * À partir d'une liste de livres ce service :
 * </p>
 * <ul>
 *   <li>élimine les doublons;</li>
 *   <li>compte le nombre de titres distincts ;</li>
 *   <li>détermine le livre ayant le nombre d'éditions le plus élevé ;</li>
 *   <li>constitue des index pour des recherches rapides :</li>
 *   <ul>
 *     <li>par année de publication ;</li>
 *     <li>par auteur ;</li>
 *     <li>par langue ;</li>
 *     <li>par couple (auteur, langue).</li>
 *   </ul>
 * </ul>
 * 
 * @author      Votre Nom
 * @version     1.0
 **/
 

public class ServiceIndexationLivres {


     /**
     * Constructeur, instancie et initialise les attributs de la classe.
     */
    public ServiceIndexationLivres(){
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


    /**
    * Indexe la liste des livres afin que différentes informations puissent être
    * retrouvées très rapidement, en cohérence avec les méthodes get de cette classe
    * 
    * @param livres la liste des livres avec de potentiels doublons
    */
    public void indexerLivres(ArrayList<Livre> livres){
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

    /**
     * Retourne très rapidement le nombre total de livres présents dans la liste de 
     * base fournie, sans compter les doublons de livre.
     * 
     * @return Le nombre de livre
     */
    public Integer getNombreDeLivre(){
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

    /**
     * Retourn très rapidement le livre ayant le nombre d'éditions le plus élevé.
     * (Cette méthode est prévue d'être utilisée par l'application ultérieurement)
     * 
     * @return un objet de la classe Livre
     */
    public Livre getLivreAvecNbrEditionMax(){
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

    /**
     * Retourne très rapidement une liste de toutes les années de publication, sans doublons, 
     * triées par ordre croissant.
     * 
     * @return une ArrayList des années 
     */

    public ArrayList<Integer> getAnneesDePublication(){
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

      /**
     * Retourne très rapidement une liste de toutes les auteurs différents trouvés dans la
     * liste des livres fournie. 
     * La liste est triées par ordre alphabétique.
     * 
     * @return une ArrayList des auteurs 
     */

    public ArrayList<String> getAuteurs(){
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

    
      /**
     * Retourne très rapidement une liste de toutes les langues différentes trouvées dans la
     * liste des livres fournie, triées par ordre alphabétique.
     * 
     * @return une ArrayList des langues 
     */

    public ArrayList<String> getLangues(){
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

      /**
     * Retourne très rapidement la liste complète des livres sans doublons
     * Si aucun livre n'est trouvé, une liste vide est retournée.
     * La liste est triée par ordre alphabétique des titres.
     * 
     * @return une Array liste de livres
     */

     public ArrayList<Livre> getLivresSansDoublons(){
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

    
    /**
     * Retourne très rapidement la liste des livres correspondant à l'année de publication passée
     * en paramètre
     * La liste est triées par ordre alphabétique des titres
     * Si aucun livre de correspond, une liste vide est retournée.
     * 
     * @param annee l'année pour laquelle la liste de livre est souhaitée
     * @return une Array liste de livres
     */

    public ArrayList<Livre> getLivresParAnneePublication(Integer annee){
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

        /**
     * Retourne très rapidement la liste des livres correspondant à l'auteur passée
     * en paramètre.
     * Le livre est sélectinné même si l'auteur ne l'a pas écrit seul.
     * La liste est triées par ordre alphabétique des titres
     * Si aucun livre de correspond, une liste vide est retournée.
     * 
     * @param auteur l'auteur pour lequel la liste de livre est souhaitée
     * @return une Array liste de livres
     */

    public ArrayList<Livre> getLivresParAuteur(String auteur){
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

    /**
     * Retourne très rapidement la liste des livres correspondant à la langue passée
     * en paramètre.
     * La liste est triées par ordre alphabétique des titres
     * Si aucun livre de correspond, une liste vide est retournée.
     * 
     * @param langue la langue pour laquelle la liste de livre est souhaitée
     * @return une Array liste de livres
     */

    public ArrayList<Livre> getLivresParLangue(String langue){
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

        /**
     * Retourne très rapidement la liste des livres correspondant à l'auteur et à la langue passés
     * en paramètres.
     * Le livre est sélectinné même si l'auteur ne l'a pas écrit seul.
     * La liste est triées par ordre alphabétique des titres      
     * Si aucun livre de correspond, une liste vide est retournée.
     * 
     * @param annee l'auteur pour laquelle la liste de livre est souhaitée
     * @param annee la langue pour laquelle la liste de livre est souhaitée
     * @return une Array liste de livres
     */

    public ArrayList<Livre> getlivresParAuteurEtLangue(String auteur, String langue){
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
}
