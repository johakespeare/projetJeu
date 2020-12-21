package Objets;

import Personnage.Personnage;

public class Coeur extends Objet{
    //**********************************************ATTRIBUTS***********************************************************

    //*********************************************CONSTRUCTEUR*********************************************************
    public Coeur(int posX, int posY ,int posXmax, int posYmax , int largeur, int hauteur) {
        super(posX, posY, posXmax, posYmax,largeur,hauteur);
    }

    //***********************************************METHODES***********************************************************
    @Override
    public void effet(Personnage perso) {
        perso.ajouterPv(perso.getPvMax());
    }
}
