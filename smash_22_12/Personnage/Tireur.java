package Personnage;

import Armes.ArmeDeTir;
import Objets.Munition;

public class Tireur extends Personnage{

    //**********************************************ATTRIBUTS***********************************************************

    ArmeDeTir armeDeTir;

    //*********************************************CONSTRUCTEUR*********************************************************

    public Tireur(String nom, int pv, int hauteur, int largeur, int poids, int vitesse, int direction,
                  ArmeDeTir armeDeTir){
        super(nom,pv,hauteur,largeur,poids,vitesse,direction);
        this.armeDeTir=armeDeTir;

    }

    //************************************************GETTERS***********************************************************

    public ArmeDeTir getArmeDeTir() {
        return armeDeTir;
    }

    //************************************************SETTERS***********************************************************

    public void setArmeDeTir(ArmeDeTir armeDeTir) {
        this.armeDeTir = armeDeTir;
    }

    //***********************************************METHODES***********************************************************


    @Override
    public void attaquer(Personnage adversaire)  {
        if(!this.armeDeTir.isCharge()) {
            this.armeDeTir.charger();
            }

        this.armeDeTir.tirer();

        Munition m = this.armeDeTir.getMunition(); //peut être clonage

        m.deplacer(this.direction);
        adversaire.collision(m);


    }}



