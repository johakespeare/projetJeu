package perso;


import Gestion.Map;
import atta.Attaque;

import java.awt.event.*;
import java.util.ArrayList;

public abstract class Personnage {
    private String nom;
    private int pv;
    private int nbVies;
    private double x=0;
    private double y=0;
    private double[] position;
    private int vitesse;
    private int direction = 1;
    private double poids;
    private boolean garde=false;
    private ArrayList<Attaque> mesattaques;
    private int positionMax_x;
    private int positionMax_y;



   /** public Personnage(String nom, int pv, int vitesse, double poids){
        this.nom=nom;
        this.position= new double[]{x, y};
        this.pv=pv;
        this.vitesse=vitesse;
        this.poids=poids;
        mesattaques= new ArrayList<Attaque>();
    }
**/

    //rajouter armes dans ce constructeur
    public Personnage(String nom, int pv, int vitesse, double poids){
        this.nom=nom;
        this.position= new double[]{x, y};
        this.pv=pv;
        this.vitesse=vitesse;
        this.poids=poids;
        mesattaques= new ArrayList<Attaque>();
    }

    public double getX(){
        return(this.x);
    }

    public double getY(){
        return(this.y);
    }

    /**public void setAttaques(Attaque attaque1, Attaque attaque2, Attaque attaque3){
        mesattaques.add(attaque1);
        mesattaques.add(attaque2);
        mesattaques.add(attaque3);

    }**/

    public String getNom() {
        return nom;
    }

    public abstract void attaquer();

    public void setNbVies(int nbVies){
        this.nbVies=nbVies;
    }

    public int getDirection(){
        return(this.direction);
    }



    public void sauter(){
        this.y+=100/poids;
        this.position= new double []{this.x,this.y};
    }

    public void seDéplacer(){
        // Rajouter exception quand on sort de la map
        this.x= this.x+this.direction*this.vitesse;
        if (this.x>this.positionMax_x){
            throw  new IllegalArgumentException("tu peux pas aller là, pd");
        }
    }

    public void setPositionMax_y(int posmax) {
        this.positionMax_y=posmax;
    }

    public void setPositionMax_x(int posmax){
        this.positionMax_x=posmax;
    }



    public void setDirection(int dir){
        this.direction=dir;

    }


    public void setPv(int pv){
        this.pv=pv;
    }

    public void damage(int damage){
        if (this.garde==false){
            this.pv-=damage;
        }else{
            this.pv-=damage*0.5;
        }
    }

    public int getPv(){
        return this.pv;
    }

    public void garde(){
        this.garde=true;
    }



    public String toString(){
        return("Personnage "+this.nom + " Nombre de pv: "+ this.pv);
    }

    public boolean equals(Object obj){
        return(obj instanceof  Personnage && ((Personnage) obj).getNom()==this.getNom());
    }


}
