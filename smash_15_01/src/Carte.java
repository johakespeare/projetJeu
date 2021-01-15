/**
 * Carte représente la carte du jeu
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */

import Exceptions.IllegalHauteurException;
import Exceptions.IllegalLargeurException;

public class Carte {

    //**********************************************ATTRIBUTS***********************************************************

    private int hauteur;
    private int largeur;

    private static final int HAUTEUR_DEFAUT = 200;
    private static final int LARGEUR_DEFAUT = 300;
    private static final int HAUTEUR_MIN = 100;
    private static final int LARGEUR_MIN=100;
    //*********************************************CONSTRUCTEUR*********************************************************

    /**
     * Constructeur de classe Carte
     */
    public Carte(){
        this.hauteur = HAUTEUR_DEFAUT;
        this.largeur = LARGEUR_DEFAUT;
    }
    /**
     * Constructeur de la classe Carte
     * @param hauteur
     * @param largeur
     */
    public Carte(int hauteur,int largeur){
        if(hauteur<HAUTEUR_MIN){
            throw new IllegalHauteurException("la hauteur de la carte doit être au moins égale à 1");
        }
        if(largeur<LARGEUR_MIN){
            throw new IllegalLargeurException("la largeur de la carte doit être au moins égale à 1");
        }
        this.hauteur=hauteur;
        this.largeur=largeur;
    }

    //************************************************GETTERS***********************************************************

    public int getHauteur() {
        return hauteur;
    }
    public int getLargeur() {
        return largeur;
    }

    //************************************************SETTERS***********************************************************

    public void setHauteur(int hauteur) {
        if(hauteur<HAUTEUR_MIN){
            throw new IllegalHauteurException("la hauteur de la carte doit être au moins égale à 1");
        }
        this.hauteur = hauteur;
    }
    public void setLargeur(int largeur) {
        if(largeur<LARGEUR_MIN){
            throw new IllegalLargeurException("la largeur de la carte doit être au moins égale à 1");
        }
        this.largeur = largeur;
    }

    //***********************************************METHODES***********************************************************


    @Override
    public String toString() {
        return "la Carte a une dimension de "+this.hauteur +"x"+this.largeur;
    }
}
