/**
 * Portee est une enumeration de Portées
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */

package Armes;

public enum Portee {

    //**********************************************ATTRIBUTS***********************************************************

    COURTE(5),
    MOYENNE(15),
    LONGUE(30);

    public int distance;
    public static final int DISTANCE_DEFAUT = 15;
    //********************************************CONSTRUCTEURS*********************************************************

    /**
     * Constructeur de l'énumération Portee
     */
    Portee(){this.distance = DISTANCE_DEFAUT;}

    /**
     * Construceur de l'énumération Portee
     * @param distance
     */
    Portee(int distance) {
        this.distance = distance;
    }

    //***********************************************METHODES***********************************************************

    public int getDistance() {
        return distance;
    }
}