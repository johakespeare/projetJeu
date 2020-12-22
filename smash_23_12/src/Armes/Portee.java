package Armes;

public enum Portee {

    //**********************************************ATTRIBUTS***********************************************************

    COURTE(5),
    MOYENNE(15),
    LONGUE(30);

    public int distance;

    //********************************************CONSTRUCTEURS*********************************************************

    Portee(int distance) {
        this.distance = distance;
    }

    //***********************************************METHODES***********************************************************

    public int getDistance() {
        return distance;
    }
}