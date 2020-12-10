package Armes;

import Objets.Munition;
import java.util.ArrayList;

public class ArmeDeTir extends Arme{
    //ATTRIBUTS
    private int nbMunitionsMax;
    private int tempsRecharge;
    private Munition munition;
    private ArrayList<Munition> stockMunitions = new ArrayList<Munition>();

    //CONSTRUCTEUR
    public ArmeDeTir(Portee portee,int degats, int nbMunitionsMax, int tempsRecharge, Munition munition) {
        super(portee,degats);
        this.nbMunitionsMax= nbMunitionsMax;
        this.tempsRecharge= tempsRecharge;
        this.munition = munition;
        charger();

    }

    //GETTERS
    public int getNbMunitionsMax() {
        return nbMunitionsMax;
    }
    public int getTempsRecharge() {
        return tempsRecharge;
    }
    public int getStockMunitions(){
        return stockMunitions.size();
    }

    //SETTERS
    public void setNbMunitions(int nbMunitionsMax) {
        this.nbMunitionsMax = nbMunitionsMax;
    }
    public void setTempsRecharge(int tempsRecharge) {
        this.tempsRecharge = tempsRecharge;
    }

    //METHODES

    /**
     * méthode qui permet de charger automatiquement l'arme lorsqu'elle n'est plus chargée
     * ( ie lorsque stockMunitions est vide)
     */
    private void charger(){
        //Thread.sleep(tempsRecharge*1000);
        if (!isCharge()) {
            for (int i = 0; i < this.nbMunitionsMax; i++) {
                Munition m = new Munition(this.munition.getDirection(), this.munition.getPosX(), this.munition.getPosY(),
                             this.munition.getVitesse());
                stockMunitions.add(m);
            }
        }
    }

    /**
     * la méthode permet de tirer une munition,
     * si elle n'est pas chargée, elle rechargera l'arme avant de tirer,
     * une fois que la munition s'est déplacée,on la retire du stock
     */
    public void tirer(){
        if(!isCharge()){
            charger();
        }
        Munition derniereMunition = stockMunitions.get(stockMunitions.size()-1);
        derniereMunition.deplacer();
        stockMunitions.remove(derniereMunition);
    }


    /**
     * méthode qui renvoie true si le nombre de munitions est différent de 0
     * @return boolean
     */
    private boolean isCharge(){
        return stockMunitions.size()!=0;
    }


    @Override
    public int calculDegats() {
        return degats;
    }
}
