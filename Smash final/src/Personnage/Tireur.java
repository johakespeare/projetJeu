/**
 * Tireur est une classe représentant un personnage qui possède une Arme de Tir avec des munitions
 * Classe fille de Personnage
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Personnage;
import Armes.ArmeDeTir;
import Exceptions.NullArmeDeTirException;
import Objets.Munition;


public class Tireur extends Personnage implements CourirPlusVite{

    //**********************************************ATTRIBUTS***********************************************************

    private  ArmeDeTir armeDeTir;

    //*********************************************CONSTRUCTEUR*********************************************************

    /**
     * Constructeur de la classe Tireur
     */
    public Tireur(){
        this.armeDeTir = new ArmeDeTir();
    }
    /**
     * Constructeur de la classe Tireur
     * @param nom
     * @param pv
     * @param nbVies
     * @param hauteur
     * @param largeur
     * @param poids
     * @param vitesse
     * @param direction
     * @param armeDeTir
     */
    public Tireur(String nom, int pv, int nbVies, int hauteur, int largeur, int poids, int vitesse, int direction,
                  ArmeDeTir armeDeTir){
        super(nom,pv, nbVies,hauteur,largeur,poids,vitesse,direction);
        if(armeDeTir==null){
            throw new NullArmeDeTirException("l'arme de Tir est nulle");
        }
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
        if(this.armeDeTir.getNbMunitions()<=this.armeDeTir.getNbMunitionsMax()/2){
            this.accelerer();
            super.seDeplacer();
            this.decelerer();
            this.armeDeTir.getMunition().setPosX(this.posX);
            assert(this.posX == this.armeDeTir.getMunition().getPosX()):"les positions ne sont pas bonnes";
        }
        else{
            super.seDeplacer();
            this.armeDeTir.getMunition().setPosX(this.posX);
            assert(this.posX == this.armeDeTir.getMunition().getPosX()):"les positions ne sont pas bonnes";
        }
    }



    @Override
    public void attaquer(Personnage adversaire)  {
        if(!this.armeDeTir.isCharge()) {
            this.armeDeTir.charger();
            }

        this.armeDeTir.tirer();

        Munition m = this.armeDeTir.getMunition();

        m.deplacer();
        if (this.direction== DIR_DROITE){
            while(m.getPosX()<this.posXmax){
                m.deplacer();
                if(adversaire.collision(m)){
                    adversaire.collisionEffet(m);
                    m.setPosX(this.posXmax);
                }

            }
        }
        else{
            while(m.getPosX()>0){
                m.deplacer();
                if(adversaire.collision(m)){
                    adversaire.collisionEffet(m);
                    m.setPosX(0);
                }
             }
        }

    }

    @Override
    public void augmenterDegats() {
        this.armeDeTir.getMunition().ajouterDegats();
    }


    @Override
    public void accelerer() {
        this.vitesse = 2*this.vitesse;
    }

    @Override
    public void decelerer() {
        this.vitesse = this.vitesse/2;
    }


}



