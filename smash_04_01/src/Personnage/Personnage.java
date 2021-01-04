/**
 * Personnage est une classe abstraite représentant un personnage du Jeu
 * Classe mère de Tireur et Epeiste
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */

package Personnage;
import java.awt.*;

import Exceptions.*;
import Objets.*;

public abstract  class Personnage {

    //**********************************************ATTRIBUTS***********************************************************

    protected String nom;
    ////VIE
    protected double pv;
    protected int pvMax;
    protected int nbVies;
    protected boolean garde;
    protected boolean vivant;

    //POSITION
    protected int posX;
    protected int posY;
    protected int posXmax;
    protected int posYmax;
    protected int direction;

    //CARACTERISTIQUE
    protected int hauteur;
    protected int largeur;
    protected int poids;
    protected int vitesse;
    protected int degats;

    //compteur
    public static int compteur =0;

    public static final int PV_DEFAUT = 80;
    public static final int NB_VIES_DEFAUT = 3;
    public static final int HAUTEUR_DEFAUT = 10;
    public static final int LARGEUR_DEFAUT = 5;
    public static final int POIDS_DEFAUT = 25;
    public static final int VITESSE_DEFAUT = 10;
    public static final int DIRECTION_DEFAUT = 1;

    public static final int PV_MIN =1;
    public static final int NB_VIES_MIN = 1;
    public static final int HAUTEUR_MIN = 1;
    public static final int LARGEUR_MIN = 1;
    public static final int POIDS_MIN = 1;
    public static final int VITESSE_MIN =1;
    public static final int DIR_GAUCHE=-1;
    public static final int DIR_DROITE =1;
    public static final int DEGATS_MIN = 1;
    public static final int DEGATS_COEFF=1;


    //*********************************************CONSTRUCTEUR*********************************************************


    /**
     * Constructeur de la classe Personnage
     */
    public Personnage(){
        compteur+=1;
        this.nom="toto"+compteur;
        this.pv= PV_DEFAUT;
        this.nbVies= NB_VIES_DEFAUT;
        this.hauteur= HAUTEUR_DEFAUT;
        this.largeur= LARGEUR_DEFAUT;
        this.poids = POIDS_DEFAUT;
        this.vitesse= VITESSE_DEFAUT;
        this.direction= DIRECTION_DEFAUT;

    }

    /**
     * Constructeur de la classe Personnage
     * @param nom  nom du personnage
     * @param pv nombre de points de vie du personnage
     * @param nbVies nombre de vie du personnage
     * @param hauteur la taille du personnage
     * @param largeur la largeur du personnage
     * @param poids le poids du personnage
     * @param vitesse la vitesse du personnage
     * @param direction la direction du personnage
     */
    public Personnage(String nom, int pv, int nbVies,int hauteur, int largeur, int poids, int vitesse,int direction){
        if(nom==null){
            throw new NullNomException("le nom du personnage est nul");
        }
        if(nom.equals("")){
            throw new IllegalNomException("le nom du personnage est vide");
        }
        if(pv<PV_MIN){
            throw new IllegalPvException("pv doit être au moins égal à 1");
        }
        if(nbVies<NB_VIES_MIN){
            throw new IllegalNbViesException("le nombre de vie doit être au moins égal à 1");
        }
        if(hauteur<HAUTEUR_MIN){
            throw new IllegalHauteurException("la hauteur du personnage doit être au moins égale à 1");
        }
        if(largeur<LARGEUR_MIN){
            throw new IllegalLargeurException("la largeur du personnage doit être au moins égale à 1");
        }
        if(poids<POIDS_MIN){
            throw new IllegalPoidsException("le poids du personnage doit être au moins égal à 1");
        }
        if(vitesse<VITESSE_MIN){
            throw new IllegalVitesseException("la vitesse du personnage doit être au moins égale à 1");
        }
        if((direction!=DIR_GAUCHE)&(direction!=DIR_DROITE)){
            throw new IllegalDirectionException("la direction du personnage doit être égale à 1 ou -1");

        }

        this.nom=nom;
        this.pvMax=pv;
        this.pv= pv;
        this.nbVies=nbVies;

        this.hauteur=hauteur;
        this.largeur=largeur;
        this.poids=poids;

        this.vitesse=vitesse;
        this.direction=direction;

        this.vivant=true;
        this.garde=false;
        this.degats= (this.poids/this.hauteur)/this.vitesse; //peut être à enlever
        compteur+=1;

    }


    //************************************************GETTERS***********************************************************

    public String getNom(){return this.nom;}
    public boolean isGarde(){ return this.garde;}
    public double getPv(){return this.pv;}
    public int getPvMax(){return this.pvMax;}
    public boolean isVivant() {
        return this.vivant;
    }
    public int getPosX(){return(this.posX);}
    public int getPosY(){return(this.posY);}
    public int getDirection(){
        return(this.direction);
    }
    public int getNbVies(){return(this.nbVies);}
    public double getDegats(){return this.degats;}

    //************************************************SETTERS***********************************************************

    public void setPosX(int posX) {
        if((posX>posXmax)|(posX<0)){
            throw new IllegalPositionException("la positionX doit être comprise entre 0 et "+ this.posXmax);
        }
        this.posX = posX;
    }
    public void setPosY(int posY) {
        if((posY>posYmax)|(posY<0)){
            throw new IllegalPositionException("la positionY doit être comprise entre 0 et "+ this.posYmax);
        }
        this.posY = posY;
    }
    public void setPosXmax(int posX) {
        if(posX<0){
            throw new IllegalPositionException("la positionXmax doit être positivie");
        }
        this.posXmax = posX;
    }
    public void setPosYmax(int posY) {
        if(posY<0){
            throw new IllegalPositionException("la positionYmax doit être positivie");
        }
        this.posYmax = posY;
    }
    public void setDirection(int direction){
        if((direction!=DIR_DROITE)&(direction!=DIR_GAUCHE)){
            throw new IllegalDirectionException("la direction du personnage doit être égale à 1 ou -1");

        }
        this.direction=direction;
    }

    //***********************************************METHODES***********************************************************

    ////********************************************DEPLACEMENT*********************************************************

    /**
     * fonction qui vérifie si le personnage est bien dans les limites de la carte
     * @param newPosX  nouvelle position en x
     * @param newPosY nouvelle position en y
     * @param posXmax position maximum en x
     * @param posYmax position minimum en y
     * @return vrai si c'est bon , faux sinon
     */
    private boolean estDedans(int newPosX, int newPosY, int posXmax, int posYmax){
        return (newPosX<=posXmax)&(newPosY<=posYmax)&(newPosX>=0)&(newPosY>=0);
    }

    /**
     * fonction qui fait sauter le personnage
     */
    public void sauter(){
        int hauteurSaut = this.hauteur/this.poids;
        this.posY+= hauteurSaut;
        this.posY-= hauteurSaut;
    }

    /**
     * fonction qui permet de déplacer le personnage en prenant en compte sa largeur
     */
    public void seDeplacer(){
        int newPosX= this.posX+this.direction*this.vitesse+this.largeur;
        if (!estDedans(newPosX,this.posY,this.posXmax,this.posYmax)){
            throw  new IllegalPositionException("limite de map");
        }
        this.posX=newPosX-this.largeur;

    }

    ////********************************************COLLISIONS**********************************************************

    /**
     * fonction qui créer un rectangle autour du personnage
     * @return rectangle
     */
    private Rectangle creationRectangle(){
        return new Rectangle(this.posX, this.posY, this.largeur, this.hauteur);
    }

    /**
     * fonction qui retourne vrai si il y'a une collision entre deux personnages
     * @param adversaire l'adversaire du personnage
     * @return vrai/faux
     */
    public boolean collision(Personnage adversaire){
        if(adversaire==null){
            throw new NullPersonnageException("l'adversaire est null");
        }
        return this.creationRectangle().intersects(adversaire.creationRectangle());
    }


    /**
     * fonction qui retourne vrai si il y'a une collision entre un personnage et un objet
     * @param objet objet du jeu
     * @return vrai/faux
     */
    public boolean collision(Objet objet){
        if(objet==null){
            throw new NullObjetException("l'objet est null");
        }

        return this.creationRectangle().intersects(objet.creationRectangle());

    }

    /**
     * si il y'a collision entre un personnage et un objet, alors l'objet active son effet sur le personnage
     * @param objet
     */
    public void collisionEffet(Objet objet){
        if(objet==null){
            throw new NullObjetException("l'objet est null");
        }

        if(collision(objet)){
            objet.effet(this);
            objet.disparaitre();
        }
    }


    ////*******************************************POINTSdeVIES*********************************************************

    public void garde(){
        this.garde= true;
    }

    /**
     * fonction qui ajoute des pv au personnage
     * @param pv
     */
    public void ajouterPv(int pv){
        if(pv<PV_MIN){
            throw new IllegalPvException("le pv donné doit être au moins égal à 1");
        }
        if(this.pv+pv>pvMax){
            this.pv=pvMax;
        }
        else{
            this.pv+=pv;
        }
    }

    /**
     * fonction qui enleve des pv au personnage, si il n'en a plus, il perd une vie
     * @param degats
     */
    public void enleverPv(double degats){
        if(degats<DEGATS_MIN){
            throw new IllegalDegatsException("les dégats doivent être au moins égaux à 1");
        }
        if (isGarde()){
            degats-= degats/DEGATS_COEFF;
        }
        double soustraction = this.pv - degats;

        if(soustraction<=0){
            this.pv=0;
            enleverNbVies();
        }
        else{
            this.pv=soustraction;
        }
   }

    /**
     * fonction qui enlève une vie au personnage, si il en a plus, le personnage meurt
     */
    private void enleverNbVies(){
            this.nbVies+=-1;
            if(this.nbVies<=0){
                this.vivant=false;
            }
            else{
                this.pv=this.pvMax;
            }



   }

    ////*******************************************ATTAQUER*************************************************************

    public abstract void attaquer(Personnage adversaire);

    public abstract void augmenterDegats();

    //******************************************EQUALS ET TOSTRING******************************************************

    public String toString(){
        return("Personnage "+this.nom + " Nombre de pv: "+ this.pv);
    }

    public boolean equals(Object obj){
        return(obj instanceof  Personnage && ((Personnage) obj).getNom().equals(this.getNom()));
    }


}