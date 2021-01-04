/**
 * Arme est une classe abstraite représentant une arme du Jeu
 * Classe mère de ArmeDeTir et Epee
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Armes;

import Exceptions.IllegalDegatsException;
import Exceptions.NullPorteeException;

public abstract class Arme {
    //**********************************************ATTRIBUTS***********************************************************

    protected int portee ;
    protected int degats ;

    protected static final int PORTE_DEFAUT = Portee.MOYENNE.getDistance();
    //********************************************CONSTRUCTEURS*********************************************************
    /**
     * Constructeur de la classe Arme
     */
    public Arme(){
        this.portee = PORTE_DEFAUT;
    }

    /**
     * Constructeur de la classe Arme
     * @param portee
     */
    public Arme(Portee portee){

        if( portee == null ){
            throw new NullPorteeException("la portée est nulle");
        }

        this.portee = portee.getDistance();


    }



    //***********************************************GETTERS************************************************************

    public int getPortee() {
        return portee ;
    }
    public int getDegats(){return degats ;}

    //***********************************************SETTERS************************************************************

    public void setPortee(Portee portee) {
        if( portee == null ){
            throw new NullPorteeException("la portée est nulle");
        }
        this.portee = portee.getDistance();
    }
    public void setDegats(int degats){
        if( degats < 0){
            throw new IllegalDegatsException("les dégats doivent être positifs");
        }
        this.degats =degats;}

    //**********************************************METHODES************************************************************


    //*****************************************ToSTRING ET EQUALS*******************************************************

    @Override
    public String toString() {
        return "cette arme a une portée de "+ portee ;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
