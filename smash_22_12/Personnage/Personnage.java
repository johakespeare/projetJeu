package Personnage;
import java.awt.*;

import Exceptions.*;
import Objets.*;

public abstract  class Personnage {

    //**********************************************ATTRIBUTS***********************************************************

    protected String nom;
    ////VIE
    protected int pv;
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

   //SCORE
    protected int nbPersoTues;

    //*********************************************CONSTRUCTEUR*********************************************************

    public Personnage(String nom, int pv, int hauteur, int largeur, int poids, int vitesse,int direction){
        if(nom==null){
            throw new NullNomException("le nom du personnage est nul");
        }
        if(nom.equals("")){
            throw new IllegalNomException("le nom du personnage est vide");
        }
        if(pv<1){
            throw new IllegalPvException("pv doit être au moins égal à 1");
        }
        if(hauteur<1){
            throw new IllegalHauteurException("la hauteur du personnage doit être au moins égale à 1");
        }
        if(largeur<1){
            throw new IllegalLargeurException("la largeur du personnage doit être au moins égale à 1");
        }
        if(poids<1){
            throw new IllegalPoidsException("le poids du personnage doit être au moins égal à 1");
        }
        if(vitesse<1){
            throw new IllegalVitesseException("la vitesse du personnage doit être au moins égale à 1");
        }
        if((direction!=1)&(direction!=-1)){
            throw new IllegalDirectionException("la direction du personnage doit être égale à 1 ou -1");

        }

        this.nom=nom;
        this.pvMax=pv;
        this.pv= pv;

        this.hauteur=hauteur;
        this.largeur=largeur;
        this.poids=poids;

        this.vitesse=vitesse;
        this.direction=direction;

        this.vivant=true;
        this.garde=false;
        this.degats= (this.poids/this.hauteur)/this.vitesse;

    }


    //************************************************GETTERS***********************************************************

    public String getNom(){return this.nom;}
    public boolean isGarde(){ return this.garde;}
    public int getPv(){return this.pv;}
    public int getPvMax(){return this.pvMax;}
    public boolean isVivant() {
        return this.vivant;
    }
    public int getDirection(){
        return(this.direction);
    }

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


    //***********************************************METHODES***********************************************************

    ////********************************************DEPLACEMENT*********************************************************

    private boolean estDedans(int newPosX, int newPosY, int posXmax, int posYmax){
        return (newPosX<=posXmax)&(newPosY<=posYmax)&(newPosX>=0)&(newPosY>=0);
    }
    public void sauter(){
        int hauteurSaut = this.hauteur/this.poids;
        this.posY+= hauteurSaut;
        this.posY-= hauteurSaut;
    }
    public void seDeplacer(){
        int newPosX= this.posX+this.direction*this.vitesse+this.largeur;
        if (!estDedans(newPosX,this.posY,this.posXmax,this.posYmax)){
            throw  new IllegalPositionException("limite de map");
        }
        this.posX=newPosX;

    }

    ////********************************************COLLISIONS**********************************************************

    private Rectangle creationRectangle(){
        return new Rectangle(this.posX, this.posY, this.largeur, this.hauteur);
    }

    public boolean collision(Personnage adversaire){
        if(adversaire==null){
            throw new NullPersonnageException("l'adversaire est null");
        }
        return this.creationRectangle().intersects(adversaire.creationRectangle());
    }



    public void collision(Objet objet){
        if(objet==null){
            throw new NullObjetException("l'objet est null");
        }
        if(this.creationRectangle().intersects(objet.creationRectangle())){
            objet.effet(this);
            objet.disparaitre();

        }
    }

    ////*******************************************POINTSdeVIES*********************************************************

    public void garde(){ this.garde= true;

    }

    public void ajouterPv(int pv){
        if(pv<1){
            throw new IllegalPvException("le pv donné doit être au moins égal à 1");
        }
        if(this.pv+pv>pvMax){
            this.pv=pvMax;
        }
        else{
            this.pv+=pv;
        }

    }
    public void enleverPv(int degats){
        if(degats<1){
            throw new IllegalDegatsException("les dégats doivent être au moins égaux à 1");
        }
        if (isGarde()){
            degats-= degats/4;
        }
        int soustraction = this.pv - degats;

        if(soustraction<=0){
            this.pv=0;
            enleverNbVies();
        }
        else{

            this.pv=soustraction;

        }
   }
    private void enleverNbVies(){
        if(nbVies-1 <=0){
            this.vivant=false;
        }
        else{
            nbVies-=1;
            this.pv=this.pvMax;
        }
   }

    ////*******************************************ATTAQUER*************************************************************

    public abstract void attaquer(Personnage adversaire);

    //******************************************EQUALS ET TOSTRING******************************************************

    public String toString(){
        return("Personnage "+this.nom + " Nombre de pv: "+ this.pv);
    }

    public boolean equals(Object obj){
        return(obj instanceof  Personnage && ((Personnage) obj).getNom().equals(this.getNom()));
    }


}