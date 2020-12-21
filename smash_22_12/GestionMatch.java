import Exceptions.IllegalHauteurException;
import Exceptions.IllegalLargeurException;
import Exceptions.IllegalNbJoueursException;
import Objets.Objet;
import Personnage.Personnage;
import java.util.ArrayList;

public class GestionMatch {

    //**********************************************ATTRIBUTS***********************************************************

    private int nbJoueurs;
    private int nbViesMax;

    private ArrayList<Personnage> listeJoueurs; //liste des joueurs en jeux
    private ArrayList<Personnage> listeMorts;  //liste des personnages morts
    private ArrayList<Objet> listeObjetsPrésents;
    private Carte carte;


    //*********************************************CONSTRUCTEUR*********************************************************

    public GestionMatch(int nbJoueurs,int nbViesMax,int hauteurCarte, int largeurCarte){
        if(nbJoueurs<2){
            new IllegalNbJoueursException("il n'y a pas passez de joueurs (minimum 2)");
        }
        if(nbJoueurs>4){
            new IllegalNbJoueursException("il n'y a trop de joueurs (limité à 4)");
        }
        if(hauteurCarte<1){
            new IllegalHauteurException("la hauteur de la carte doit être au moins égale à 1");
        }
        if(largeurCarte<1){
            new IllegalLargeurException("la largeur de la carte doit être au moins égale à 1");
        }
        this.nbJoueurs=nbJoueurs;
        this.listeJoueurs=new ArrayList<Personnage>(nbJoueurs);
        this.nbViesMax=nbViesMax;
        carte = new Carte(hauteurCarte,largeurCarte);
    }

    //************************************************GETTERS***********************************************************

    public int getNbJoueurs() {
        return nbJoueurs;
    }
    public int getNbViesMax() {
        return nbViesMax;
    }
    public Carte getCarte() {
        return carte;
    }

    public ArrayList<Personnage> getListeJoueurs() {
        return listeJoueurs;
    }
    public ArrayList<Personnage> getListeMorts() {
        return listeMorts;
    }
    public ArrayList<Objet> getListeObjetsPrésents() {
        return listeObjetsPrésents;
    }


    //************************************************SETTERS***********************************************************

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }
    public void setNbViesMax(int nbViesMax) {
        this.nbViesMax = nbViesMax;
    }


    //***********************************************METHODES***********************************************************

    ////*********************************************GESTION************************************************************

    /**
     * méthode qui gère le jeu de manière générale
     */
    public void match()  {
        if( listeJoueurs.size() != nbJoueurs){
                throw new RuntimeException("pas assez de joueurs");
        }

        int tempsApparitionObjet=30000; //millisecondes
        while (listeJoueurs.size()!=1){
            enVie();
           // Thread.sleep(tempsApparitionObjet); //TOUTES LES tempsAppartions on met un objet pb de cette fonction : arrêt pendant 30sec de la boucle
           //faire apparaitre objet


        }

       afficherResultats();
    }

    /**
     * affiche le résultat du match
     * @return le résultat du match
     */

    private void afficherResultats(){


    }

    ////*********************************************JOUEURS************************************************************


    public void ajouterJoueur(Personnage personnage){
        listeJoueurs.add(personnage);
    }
    public void enleverJoueur(Personnage personnage){
        listeMorts.add(personnage);
        listeJoueurs.remove(personnage);
    }

   private void enVie(){
        for(Personnage p: listeJoueurs){
            if(!p.isVivant()){
                enleverJoueur(p);
            }
        }
   }










}
