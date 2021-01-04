/**
 * Coeur est une classe représentant l'objet Coeur qui rajoute des points de vie au personnage si le dernier le touche
 * Classe fille de la Classe Objet
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */

package Objets;
import Personnage.Personnage;

public class Coeur extends Objet{
    //**********************************************ATTRIBUTS***********************************************************

    //*********************************************CONSTRUCTEUR*********************************************************

    /**
     * Constructeur de la classe Coeur
     */
    public Coeur(){

    }
    /**
     * Constructeur de la classe Coeur
     * @param posX
     * @param posY
     * @param posXmax
     * @param posYmax
     * @param largeur
     * @param hauteur
     */
    public Coeur(int posX, int posY ,int posXmax, int posYmax , int largeur, int hauteur) {
        super(posX, posY, posXmax, posYmax,largeur,hauteur);
    }

    //***********************************************METHODES***********************************************************
    @Override
    public void effet(Personnage perso) {
        int maximum = perso.getPvMax();
        perso.ajouterPv(maximum);
    }
}
