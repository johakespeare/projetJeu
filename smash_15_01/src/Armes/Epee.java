/**
 * Epee est une classe abstraite représentant une Epee du Jeu
 * Classe fille de Arme
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */

package Armes;

import Exceptions.IllegalPoidsException;

public class Epee extends Arme{

    //**********************************************ATTRIBUTS***********************************************************

    private int poids;
    private static final int POIDS_DEFAUT = 10;

    private static final int POIDS_MIN = 1;
    //*********************************************CONSTRUCTEUR*********************************************************

    /**
     * Constructeur de la classe Epee
     */
    public Epee(){
        this.poids = POIDS_DEFAUT;
    }

    /**
     * Constructeur de la classe Epee
     * @param portee
     * @param poids
     */
    public Epee(Portee portee, int poids) {
        super(portee);
        if( poids < portee.getDistance()){
            throw new IllegalPoidsException("le poids doit être plus grand que la portée");
        }
        if( poids < POIDS_MIN ){
            throw new IllegalPoidsException("le poids doit être au moins égal à 1");
        }

        this.poids = poids;
    }

    //************************************************GETTERS***********************************************************

    public int getPoids() {
        return this.poids;
    }

    //************************************************SETTERS***********************************************************

    public void setPoids(int poids) {

        if(poids<POIDS_MIN){
            throw new IllegalPoidsException();
        }
        this.poids = poids;
    }

    //***********************************************METHODES***********************************************************


    /**
     * fonction qui calcul les dégats qu'infligent l'épe selon son poids et sa portée
     * @return degats
     */
    public int calculDegats() {
        return this.poids/this.portee;
    }


}
