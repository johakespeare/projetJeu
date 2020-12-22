package Armes;

import Exceptions.IllegalPoidsException;

public class Epee extends Arme{

    //**********************************************ATTRIBUTS***********************************************************

    private int poids;

    //*********************************************CONSTRUCTEUR*********************************************************

    public Epee(Portee portee, int poids) {
        super(portee);
        if( poids < 1 ){
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

        if(poids<0){
            throw new IllegalPoidsException();
        }
        this.poids = poids;
    }

    //***********************************************METHODES***********************************************************


    public int calculDegats() {
        return (this.poids/this.portee);
    }


}
