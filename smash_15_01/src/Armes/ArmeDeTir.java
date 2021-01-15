/**
 * ArmeDeTir est une classe abstraite représentant une arme de Tir du Jeu
 * Classe fille de Arme
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */

package Armes;
import Exceptions.IllegalNbMunitionsMaxException;
import Exceptions.IllegalTempsRechargeException;
import Exceptions.NullMunitionException;
import Objets.Munition;
import java.util.Timer;

public class ArmeDeTir extends Arme{

    //**********************************************ATTRIBUTS***********************************************************

    private int nbMunitionsMax;
    private int tempsRecharge;
    private int nbMunitions;
    private Munition munition;

    private static final int NB_MUNITIONS_DEFAUT = 10;
    private static final int TEMPS_RECHARGE_DEFAUT = 3;

    private static final int NB_MUNITIONS_MIN = 1;
    private static final int TEMPS_RECHARGE_MIN = 1;



    //*********************************************CONSTRUCTEUR*********************************************************

    /**
     * Constructeur de la classe ArmeDeTir
     */
    public ArmeDeTir(){
        this.nbMunitions = NB_MUNITIONS_DEFAUT;
        this.tempsRecharge = TEMPS_RECHARGE_DEFAUT;
        this.munition = new Munition();
    }

    /**
     * Constructeur de la classe ArmeDeTir
     * @param portee
     * @param nbMunitionsMax
     * @param tempsRecharge
     * @param munition
     */
    public ArmeDeTir(Portee portee, int nbMunitionsMax, int tempsRecharge, Munition munition)  {
        super(portee);

        if( nbMunitionsMax < NB_MUNITIONS_MIN ){
            throw new IllegalNbMunitionsMaxException("le nombre de munitions maximum doit être au moins égale à "+ NB_MUNITIONS_MIN);
        }

        if( tempsRecharge < TEMPS_RECHARGE_MIN ){
            throw new IllegalTempsRechargeException("le temps de recharge doit être positif "+ TEMPS_RECHARGE_MIN);
        }

        if( munition == null ){
            throw new NullMunitionException("la munition est nulle");
        }

        this.nbMunitionsMax = nbMunitionsMax;
        this.tempsRecharge = tempsRecharge;
        this.munition = munition;
        this.nbMunitions = this.nbMunitionsMax ;
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

    public void setNbMunitions(int nbMunitions) {
        if( nbMunitions < NB_MUNITIONS_MIN ){
            throw new IllegalNbMunitionsMaxException("le nombre de munitions maximum doit être au moins égale à "+NB_MUNITIONS_MIN);
        }
        this.nbMunitions = nbMunitions;
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
        Timer chrono = new Timer();
        ChronoRecharge chronoRecharge = new ChronoRecharge(this);
        chrono.schedule(chronoRecharge,this.tempsRecharge);
    }

    /**
     * la méthode permet de tirer une munition,
     * si elle n'est pas chargée, elle rechargera l'arme avant de tirer,
     * une fois que la munition s'est déplacée,on la retire du stock
     */
    public void tirer(){
        if(this.nbMunitions <=0){
            this.charger();
        }
        this.nbMunitions-=1;
    }

    /**
     * méthode qui renvoie true si le nombre de munitions est différent de 0
     * @return boolean
     */
    public boolean isCharge(){
        return nbMunitions>0;
    }

    @Override
    public boolean equals(Object obj) {
        return(obj instanceof ArmeDeTir &&
                ((ArmeDeTir) obj).getNbMunitionsMax()==this.getNbMunitionsMax())&&
                ((ArmeDeTir) obj).getPortee()==this.getPortee();

    }


}
