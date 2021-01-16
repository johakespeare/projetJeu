/**
 * PowerUp est une classe représentant l'objet PowerUp qui augment les dégats du personnage si le dernier le touche
 * Classe fille de la Classe Objet
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */


package Objets;

import Personnage.Personnage;

public class PowerUp extends Objet {

    //**********************************************ATTRIBUTS***********************************************************

    //********************************************CONSTRUCTEUR**********************************************************

    /**
     * Constructeur de la classe PowerUp
     */
    public PowerUp() {

    }

    /**
     * Constructeur de la classe PowerUp
     *
     * @param posX
     * @param posY
     * @param posXmax
     * @param posYmax
     * @param largeur
     * @param hauteur
     */
    public PowerUp(int posX, int posY, int posXmax, int posYmax, int largeur, int hauteur) {
        super(posX, posY, posXmax, posYmax, largeur, hauteur);
    }

    //***********************************************METHODES***********************************************************

    @Override
    public void effet(Personnage perso) {
        perso.augmenterDegats();
    }


    @Override
    public String toString() {
        return "PowerUp{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}