/**
 * Objet est une classe abstraite représentant un objet du Jeu
 * Classe mère de Coeur, PowerUp et Munition
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Objets;
import Exceptions.IllegalHauteurException;
import Exceptions.IllegalLargeurException;
import Exceptions.IllegalPositionException;
import Personnage.Personnage;
import java.awt.*;

public abstract class Objet {

    //**********************************************ATTRIBUTS***********************************************************

    protected int posX;
    protected int posY;
    protected int posXmax;
    protected int posYmax;
    protected int largeur;
    protected int hauteur;


    //*********************************************CONSTRUCTEUR*********************************************************

    public Objet(){

            }
    /**
     * Constructeur de la classe Objet
     * @param posX
     * @param posY
     * @param posXmax
     * @param posYmax
     * @param largeur
     * @param hauteur
     */
    public Objet(int posX, int posY,int posXmax, int posYmax, int largeur, int hauteur) {
        if(posXmax< 0){
            throw new IllegalPositionException("la position max en X de l'objet doit être positive");
        }
        if(posYmax< 0){
            throw new IllegalPositionException("la position max en Y de l'objet doit être positive");
        }
        if((posXmax<posX)|(posX<0)){
            throw new IllegalPositionException("la position en X de l'objet doit être comprise entre 0 et"+ posXmax);
        }
        if((posYmax<posY)|(posY<0)){
            throw new IllegalPositionException("la position en Y de l'objet doit être comprise entre 0 et"+ posYmax);
        }

        if(largeur<0){
            throw new IllegalLargeurException("la largeur doit être positive");
        }

        if(hauteur<0){
            throw new IllegalHauteurException("la hauteur doit être positive");
        }

        this.posX = posX;
        this.posY = posY;
        this.posXmax = posXmax;
        this.posYmax = posYmax;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    //************************************************GETTERS***********************************************************

    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }

    //************************************************SETTERS***********************************************************

    public void setPosX(int posX) {
        if((posXmax<posX)|(posX<0)){
            throw new IllegalPositionException("la position en X de l'objet doit être comprise entre 0 et"+ posXmax);
        }
        this.posX = posX;
    }
    public void setPosY(int posY) {
        if((posYmax<posY)|(posY<0)){
            throw new IllegalPositionException("la position en Y de l'objet doit être comprise entre 0 et "+ posYmax);
        }
        this.posY = posY;
    }

    //***********************************************METHODES***********************************************************

    /**
     * fonction qui créer un rectangle représentant le personnage pour les collisions
     * @return un rectangle
     */
    public Rectangle creationRectangle() {
        return new Rectangle(this.posX, this.posY, this.largeur, this.hauteur);
    }

    /**
     * fonction qui active un effet sur le personnage
     * @param perso : n'importe quel personnage
     */
    public abstract void effet(Personnage perso);

    public void disparaitre(){
        //trouver une manière de supprimer élément
    }

    //******************************************EQUALS ET TOSTRING******************************************************

    @Override
    public boolean equals(Object o) {
        boolean result;

        if (this == o) {
            result = true;
        }
        else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            Objet objet = (Objet) o;
            result = (posX == objet.posX) && (posY == objet.posY);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Objets.Objet{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }

}