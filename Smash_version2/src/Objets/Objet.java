package Objets;

public abstract class Objet {
    //ATTRIBUTS
    protected int posX;
    protected int posY;

    //CONSTRUCTEURS
    public Objet(int posX,int posY){
        this.posX=posX;
        this.posY=posY;
    }

    //GETTERS
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    //SETTERS
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    //EQUALS ET TOSTRING
    @Override
    public boolean equals(Object o) {
        boolean result=false;

        if (this == o) {
            result=true;
        }
        if (o == null || getClass() != o.getClass()) {
            result = false;}
        else{Objet objet = (Objet) o;
             result = (posX == objet.posX) && (posY == objet.posY);}
        return result;
    }

    @Override
    public String toString() {
        return "Objets.Objet{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
