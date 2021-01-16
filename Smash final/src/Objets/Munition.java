/**
 * Munition est une classe représentant une munition
 * Classe fille de la Classe Objet
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */

package Objets;

import Exceptions.IllegalDirectionException;
import Personnage.Personnage;

public class Munition extends Objet {

    //**********************************************ATTRIBUTS***********************************************************
    private int direction;
    private double degats;

    private static final int LARGEUR_DEFAUT=2;
    private static final int HAUTEUR_DEFAUT=2;
    private static final int DEGATS_MIN=2;
    private static final int DIREC_GAUCHE=-1;
    private static final int DIREC_DROITE=1;
    private static final double COEFF_DEGAT = 0.5;

    //*********************************************CONSTRUCTEUR*********************************************************

    /**
     * Constructeur de la classe Munition
     */
    public Munition(){
        this.largeur = LARGEUR_DEFAUT;
        this.hauteur= HAUTEUR_DEFAUT;
        this.degats=DEGATS_MIN+(this.hauteur/this.largeur);
    }

    /**
     * Constructeur de la classe Munition
     * @param posX
     * @param posY
     * @param posXMax
     * @param posYMax
     * @param largeur
     * @param hauteur
     */
    public Munition(int posX, int posY,int posXMax,int posYMax, int largeur, int hauteur){
        super(posX,posY,posXMax,posYMax,largeur,hauteur);
        this.degats=DEGATS_MIN+(this.hauteur/this.largeur);

    }



    //************************************************GETTERS***********************************************************


    public int getDirection(){return this.direction;}

    public double getDegats(){ return this.degats;}

    //************************************************SETTERS***********************************************************


    public void setPosXMax(int posXMax) {
        this.posXmax = posXMax;
    }
    public void setPosYMax(int posYMax) {
        this.posYmax = posYMax;
    }
    public void setDirection(int direction){
        if((direction!=DIREC_DROITE)&(direction!=DIREC_GAUCHE)){
        throw new IllegalDirectionException("la direction du personnage doit être égale à 1 ou -1");
    }
    this.direction = direction;
    }
    //***********************************************METHODES***********************************************************

    @Override
    public void effet(Personnage perso) {
        perso.enleverPv(this.degats);
    }

    /**
     * methode qui fait deplacer la munition
     * si direction =-1 --> avance vers la gauche
     * si direction =1 --> avance vers la droite
     */

    public void deplacer(){
        int deplacement = this.posX + this.direction;
        if(( deplacement > this.posXmax)&&(deplacement <0)){
            throw new RuntimeException("limite de map");
        }
        this.posX += this.direction;

    }

   public void ajouterDegats(){
        this.degats+=this.degats*COEFF_DEGAT;
   }


    @Override
    public String toString() {
        return "Munition{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }

}
