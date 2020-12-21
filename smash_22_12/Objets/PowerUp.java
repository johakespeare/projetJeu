package Objets;

import Personnage.Personnage;

public class PowerUp extends Objet {

    //**********************************************ATTRIBUTS***********************************************************

    //********************************************CONSTRUCTEUR**********************************************************
    public PowerUp(int posX, int posY , int posXmax,int posYmax,int largeur, int hauteur) {
        super(posX, posY,posXmax,posYmax,largeur,hauteur);
    }

    //***********************************************METHODES***********************************************************

    @Override
    public void effet(Personnage perso) {

    }
}
