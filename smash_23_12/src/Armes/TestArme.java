package Armes;

import Objets.Munition;

public class TestArme {
    public static void main(String[] args) {



        ////**********************************************Epee**********************************************************

            Epee excalibur = new Epee(Portee.COURTE,10);

            assert(excalibur.calculDegats()==2):"le calcul des dégats est erroné";


        ////********************************************ArmeDeTir*******************************************************

            Munition fleche = new Munition(1,10,10,20,20,2,3);
            ArmeDeTir arc = new ArmeDeTir(Portee.LONGUE,5,3,fleche);

            //on teste le chargement automatique des munitions
            assert(arc.isCharge()):"l'arc n'est pas chargé";
            assert(arc.getNbMunitions()==5):"l'arc n'a pas 5 munitions"+arc.getNbMunitions();

            arc.tirer();
            assert(arc.isCharge()):"l'arc n'est pas chargé";
            assert(arc.getNbMunitions()==4):"l'arc n'a pas 4 munitions"+arc.getNbMunitions();

            ////ici on le vide complètement
            for(int i=0;i<3;i++){
                arc.tirer();
            }
            assert(!arc.isCharge()):"l'arc est chargé";
            assert(arc.getNbMunitions()==0):"l'arc a des munitions"+arc.getNbMunitions();

            ////si tout se passe bien, l'arc va se recharger tout seul et tirer
            arc.tirer();
            assert(arc.isCharge()):"l'arc n'est pas chargé";
            assert(arc.getNbMunitions()==4):"l'arc n'a pas 4 munitions"+arc.getNbMunitions();

        //********************************************EXCEPTIONS********************************************************





        //*******************************************EQUALS ET TOSTRING*************************************************
           System.out.println(excalibur.toString());
           System.out.println(arc.toString());

            Epee excaliburBis = new Epee(Portee.COURTE,10);
            ArmeDeTir arcBis = new ArmeDeTir(Portee.LONGUE,5,3,fleche);

            Munition flecheDifferente = new Munition(1,10,10,20,20,2,5);

            assert(!arc.equals(excalibur)):"les armes sont égales";
            assert(arc.equals(arcBis)):"les arcs ne sont pas égaux";

            arcBis.setMunition(flecheDifferente);

            assert(!arc.equals(arcBis)):"les arcs sont égaux";

            assert(excalibur.equals(excaliburBis)):"les épées ne sont pas égales";









    }

}
