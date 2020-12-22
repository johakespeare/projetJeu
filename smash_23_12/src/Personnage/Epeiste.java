package Personnage;
import Armes.Epee;
import Exceptions.NullEpeeException;

public class Epeiste extends Personnage{

    //**********************************************ATTRIBUTS***********************************************************

    Epee epee;

    //*********************************************CONSTRUCTEUR*********************************************************

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
}
