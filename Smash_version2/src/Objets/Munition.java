package Objets;

public class Munition extends Objet {
    // ATTRIBUTS
    private int direction;
    private int vitesse;
    private int posXMax=0;
    private int posYMax=0;

    //CONSTRUCTEURS
    public Munition(int direction, int posX, int posY, int vitesse){
        super(posX,posY);
        this.vitesse = vitesse;
        this.direction = direction;
    }

    //GETTERS
    public int getVitesse() {
        return vitesse;
    }
    public int getDirection() {
        return direction;
    }

    //SETTERS
    public void setVitesse(int vitesse) {this.vitesse = vitesse;}
    public void setDirection(int direction) {this.direction = direction;}

    public void setPosXMax(int posXMax) {
        this.posXMax = posXMax;
    }

    public void setPosYMax(int posYMax) {
        this.posYMax = posYMax;
    }
    //METHODES

    /**
     * methode qui fait deplacer la munition
     * si direction =-1 --> avance vers la gauche
     * si direction =1 --> avance vers la droite
     */
    public void deplacer(){
        if(this.posX +this.direction*this.vitesse <= this.posXMax){
            this.posX += this.direction*this.vitesse;
        }


    }





}
