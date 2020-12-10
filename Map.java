package Gestion;

import perso.Personnage;

import java.beans.PersistenceDelegate;
import java.util.ArrayList;

public class Map {
    private int taille_x;
    private int taille_y;
    private ArrayList<Personnage> mesPersos;


    public Map(int taille_x, int taille_y, ArrayList<Personnage>mesPersos){
        this.taille_x=taille_x;
        this.taille_y=taille_y;
        this.mesPersos=mesPersos;
        for (Personnage p: mesPersos){
            p.setPositionMax_x(this.taille_x);
            p.setPositionMax_y(this.taille_y);
        }
    }


    public void setTaille_y(int taille_y){
        this.taille_y=taille_y;
    }

    public int getTaille_x() {
        return this.taille_x;
    }

    public int getTaille_y(){
        return this.taille_y;
    }
}
