package Armes;

import Exceptions.IllegalDegatsException;
import Exceptions.NullPorteeException;

public abstract class Arme {
    //**********************************************ATTRIBUTS***********************************************************

    protected int portee ;
    protected int degats ;

    //********************************************CONSTRUCTEURS*********************************************************

    public Arme(Portee portee, int degats){

        if( portee == null ){
            throw new NullPorteeException("la portée est nulle");
        }

        if( degats < 0){
            throw new IllegalDegatsException("les dégats doivent être positifs");
        }

        this.portee = portee.getDistance();
        this.degats = degats;

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
