package Armes;

public abstract class Arme {
    //ATTRIBUTS
    protected int portee;
    protected int degats;

    //CONSTRUCTEUR
    public Arme(Portee portee, int degats){
        this.portee=portee.getDistance();
        this.degats=degats;
    }

    //GETTERS
    public int getPortee() {
        return portee;
    }
    public int getDegats(){return degats;}

    //SETTERS
    public void setPortee(Portee portee) {
        this.portee = portee.getDistance();
    }
    public void setDegats(int degats){this.degats =degats;}

    //METHODES
    public abstract int calculDegats();


    //ToSTRING ET EQUALS
    @Override
    public String toString() {
        return "cette arme a une portée de "+ portee ;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
