/**
 * ChronoRecharge est le chronomètre lors de la recharge d'une arme de Tir
 * Classe fille de TimerTask
 * D'après la vidéo https://www.youtube.com/watch?v=He1Pvyewr_M
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Armes;
import Exceptions.NullArmeDeTirException;

import java.util.TimerTask;

public class ChronoRecharge extends TimerTask {
    //**********************************************ATTRIBUTS***********************************************************
    private ArmeDeTir arme;

    //*********************************************CONSTRUCTEUR*********************************************************

    /**
     * Constructeur de la classe ChronoRecharge()
     */
    public ChronoRecharge(){}
    /**
     * Constructeur de la classe ChronoRecharge
     * @param arme
     */
    public ChronoRecharge(ArmeDeTir arme){
        if(arme==null){
            throw new NullArmeDeTirException("l'arme est nulle");
        }
        this.arme = arme;
        this.run();
    }

    //***********************************************METHODES***********************************************************

    @Override
    public void run(){
        int maximum = arme.getNbMunitionsMax();
        this.arme.setNbMunitions(maximum);
    }
}
