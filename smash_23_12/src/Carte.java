import Exceptions.IllegalHauteurException;
import Exceptions.IllegalLargeurException;

public class Carte {

    //**********************************************ATTRIBUTS***********************************************************

    private int hauteur;
    private int largeur;

    //*********************************************CONSTRUCTEUR*********************************************************

    public Carte(int hauteur,int largeur){
        if(hauteur<1){
            throw new IllegalHauteurException("la hauteur de la carte doit être au moins égale à 1");
        }
        if(largeur<1){
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
        if(hauteur<1){
            throw new IllegalHauteurException("la hauteur de la carte doit être au moins égale à 1");
        }
        this.hauteur = hauteur;
    }
    public void setLargeur(int largeur) {
        if(largeur<1){
            throw new IllegalLargeurException("la largeur de la carte doit être au moins égale à 1");
        }
        this.largeur = largeur;
    }

    //***********************************************METHODES***********************************************************
}
