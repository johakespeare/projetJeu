package Armes;
import Exceptions.IllegalNbMunitionsMaxException;
import Exceptions.IllegalTempsRechargeException;
import Exceptions.NullMunitionException;
import Objets.Munition;
import java.util.ArrayList;

public class ArmeDeTir extends Arme{

    //**********************************************ATTRIBUTS***********************************************************

    private int nbMunitionsMax;
    private int tempsRecharge;
    private int nbMunitions;
    private Munition munition;


    //*********************************************CONSTRUCTEUR*********************************************************

    public ArmeDeTir(Portee portee, int nbMunitionsMax, int tempsRecharge, Munition munition)  {
        super(portee);

        if( nbMunitionsMax < 1 ){
            throw new IllegalNbMunitionsMaxException("le nombre de munitions maximum doit être au moins égale à 1");
        }

        if( tempsRecharge < 0 ){
            throw new IllegalTempsRechargeException("le temps de recharge doit être positif");
        }

        if( munition == null ){
            throw new NullMunitionException("la munition est nulle");
        }

        this.nbMunitionsMax = nbMunitionsMax;
        this.tempsRecharge = tempsRecharge;
        this.munition = munition;
        charger();
    }

    //************************************************GETTERS***********************************************************


    public Munition getMunition() {
        return munition;
    }
    public int getNbMunitionsMax() {
        return nbMunitionsMax;
    }
    public int getTempsRecharge() {
        return tempsRecharge;
    }
    public int getNbMunitions(){
        return nbMunitions;
    }

    //************************************************SETTERS***********************************************************

    public void setNbMunitions(int nbMunitionsMax) {
        if(nbMunitionsMax<1){
            throw new IllegalNbMunitionsMaxException("le nombre de munitions maximum doit être au moins égale à 1");
        }
        this.nbMunitionsMax = nbMunitionsMax;
    }
    public void setTempsRecharge(int tempsRecharge) {
        if(tempsRecharge<0){
            throw new IllegalTempsRechargeException("le temps de recharge doit être positif");
        }
        this.tempsRecharge = tempsRecharge;
    }
    public void setMunition(Munition munition){
        if(munition==null){
            throw new NullMunitionException("la munition est nulle");
        }
        this.munition=munition;
    }
    //***********************************************METHODES***********************************************************

    /**
     * méthode qui permet de charger automatiquement l'arme lorsqu'elle n'est plus chargée
     * ( ie lorsque stockMunitions est vide)
     */
    public void charger() {
        try {
            Thread.sleep(tempsRecharge);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.nbMunitions=this.nbMunitionsMax;
    }

    /**
     * la méthode permet de tirer une munition,
     * si elle n'est pas chargée, elle rechargera l'arme avant de tirer,
     * une fois que la munition s'est déplacée,on la retire du stock
     */
    public void tirer(){
        this.nbMunitions-=1;
    }


    /**
     * méthode qui renvoie true si le nombre de munitions est différent de 0
     * @return boolean
     */
    public boolean isCharge(){
        return nbMunitions!=0;
    }


}
