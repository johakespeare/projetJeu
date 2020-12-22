package Objets;

import Exceptions.IllegalDirectionException;
import Personnage.Personnage;

public class Munition extends Objet {
    //**********************************************ATTRIBUTS***********************************************************

    private int vitesse;
    private int direction;
    //*********************************************CONSTRUCTEUR*********************************************************

    public Munition(int posX, int posY,int posXMax,int posYMax, int largeur, int hauteur, int vitesse){
        super(posX,posY,posXMax,posYMax,largeur,hauteur);
        this.vitesse = vitesse;
    }

    //************************************************GETTERS***********************************************************

    public int getVitesse() {
        return vitesse;
    }
    public int getDirection(){return this.direction;}

    //************************************************SETTERS***********************************************************

    public void setVitesse(int vitesse) {this.vitesse = vitesse;}
    public void setPosXMax(int posXMax) {
        this.posXmax = posXMax;
    }
    public void setPosYMax(int posYMax) {
        this.posYmax = posYMax;
    }
    public void setDirection(int direction){if((direction!=1)&(direction!=-1)){
        throw new IllegalDirectionException("la direction du personnage doit être égale à 1 ou -1");

    }this.direction = direction;}
    //***********************************************METHODES***********************************************************

    @Override
    public void effet(Personnage perso) {

        System.out.println(this.vitesse* (this.hauteur/this.largeur));
        perso.enleverPv(this.vitesse* (this.hauteur/this.largeur));

    }

    /**
     * methode qui fait deplacer la munition
     * si direction =-1 --> avance vers la gauche
     * si direction =1 --> avance vers la droite
     */

    public void deplacer(){
        if(this.posX + this.direction*this.vitesse > this.posXmax){ //rajouter ou0
            throw new RuntimeException("limite de map");
        }
        this.posX += this.direction*this.vitesse;

    }





}
