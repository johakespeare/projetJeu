package Objets;

import Personnage.Personnage;

public class Munition extends Objet {
    //**********************************************ATTRIBUTS***********************************************************

    private int vitesse;

    //*********************************************CONSTRUCTEUR*********************************************************

    public Munition(int direction, int posX, int posY,int posXMax,int posYMax, int largeur, int hauteur, int vitesse){
        super(posX,posY,posXMax,posYMax,largeur,hauteur);
        this.vitesse = vitesse;
    }

    //************************************************GETTERS***********************************************************

    public int getVitesse() {
        return vitesse;
    }

    //************************************************SETTERS***********************************************************

    public void setVitesse(int vitesse) {this.vitesse = vitesse;}
    public void setPosXMax(int posXMax) {
        this.posXmax = posXMax;
    }
    public void setPosYMax(int posYMax) {
        this.posYmax = posYMax;
    }

    //***********************************************METHODES***********************************************************

    @Override
    public void effet(Personnage perso) {

        perso.enleverPv(this.vitesse* (this.hauteur/this.largeur));
        System.out.println("les degats"+this.vitesse* (this.hauteur/this.largeur));
    }

    /**
     * methode qui fait deplacer la munition
     * si direction =-1 --> avance vers la gauche
     * si direction =1 --> avance vers la droite
     */
    public void deplacer(int direction){
        if(this.posX + direction*this.vitesse <= this.posXmax){
            this.posX += direction*this.vitesse;
        }


    }





}
