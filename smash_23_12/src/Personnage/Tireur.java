package Personnage;

import Armes.ArmeDeTir;
import Objets.Munition;
import Objets.Objet;

public class Tireur extends Personnage{

    //**********************************************ATTRIBUTS***********************************************************

    ArmeDeTir armeDeTir;

    //*********************************************CONSTRUCTEUR*********************************************************

    public Tireur(String nom, int pv, int nbVies, int hauteur, int largeur, int poids, int vitesse, int direction,
                  ArmeDeTir armeDeTir){
        super(nom,pv, nbVies,hauteur,largeur,poids,vitesse,direction);
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

    @Override
    public void setPosX(int posX) {
        super.setPosX(posX);
        this.armeDeTir.getMunition().setPosX(this.posX);
        assert(this.posX == this.armeDeTir.getMunition().getPosX()):"les positions ne sont pas bonnes";

    }

    @Override
    public void setDirection(int direction) {
        super.setDirection(direction);
        this.armeDeTir.getMunition().setDirection(direction);
        assert(this.direction == this.armeDeTir.getMunition().getDirection()):"les positions ne sont pas bonnes";
    }

    //***********************************************METHODES***********************************************************


    @Override
    public void seDeplacer() {
        super.seDeplacer();
        this.armeDeTir.getMunition().setPosX(this.posX);
        assert(this.posX == this.armeDeTir.getMunition().getPosX()):"les positions ne sont pas bonnes";
    }



    @Override
    public void attaquer(Personnage adversaire)  {
        if(!this.armeDeTir.isCharge()) {
            this.armeDeTir.charger();
            }

        this.armeDeTir.tirer();

        Munition m = this.armeDeTir.getMunition();

        m.deplacer();
        while(m.getPosX()!=this.posXmax){
                m.deplacer();
                adversaire.collisionEffet(m);

        }



    }}



