/**
 * Epeiste est une classe représentant un personnage qui possède une épée
 * Classe fille de Personnage
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Personnage;

import Armes.Epee;
import Exceptions.NullEpeeException;

public class Epeiste extends Personnage{

    //**********************************************ATTRIBUTS***********************************************************

    private Epee epee;
    private static final double COEFF_DEG = 0.5 ;

    //*********************************************CONSTRUCTEUR*********************************************************

    /**
     * Constructeur de classe Epeiste
     */
    public Epeiste(){
        this.epee = new Epee();
    }
    /**
     * Constructeur de la classe Epeiste
     * @param nom
     * @param pv
     * @param nbVies
     * @param hauteur
     * @param largeur
     * @param poids
     * @param vitesse
     * @param direction
     * @param epee
     */
    public Epeiste (String nom, int pv, int nbVies,int hauteur, int largeur, int poids, int vitesse,int direction, Epee epee){
       super(nom,pv, nbVies,hauteur,largeur,poids,vitesse,direction);
       if(epee == null){
           throw new NullEpeeException("l'épée est nulle");
       }
       this.epee = epee;
       this.degats = epee.calculDegats();
    }

    //************************************************GETTERS***********************************************************

    public Epee getEpee() {
        return epee;
    }


    //************************************************SETTERS***********************************************************

     public void setEpee(Epee epee){
         if(epee == null){
             throw new NullEpeeException("l'épée est nulle");
         }
       this.epee=epee;
     }

    //***********************************************METHODES***********************************************************


    @Override
    public void attaquer(Personnage adversaire) {

            if(this.collision(adversaire)){
                adversaire.enleverPv(this.degats);
            }

    }

    @Override
    public void augmenterDegats() {
        this.degats+=this.degats*COEFF_DEG;
    }


}
