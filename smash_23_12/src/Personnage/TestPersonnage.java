package Personnage;

import Armes.ArmeDeTir;
import Armes.Epee;
import Armes.Portee;
import Objets.Munition;

public class TestPersonnage {

    public static void main(String[] args) {

          int POSXMAX = 100;
          int POSYMAX = 100;
        //***************************************CREATION PERSONNAGES***************************************************
        Epee excalibur = new Epee(Portee.COURTE,10);
        Munition fleche = new Munition(10,10,POSXMAX,POSYMAX,2,2,1);
        ArmeDeTir arc = new ArmeDeTir(Portee.LONGUE,5,3,fleche);

        Epeiste arthur = new Epeiste("Arthur",100,2,10,2,20,5,1,excalibur);
        Tireur legolas = new Tireur("Legolas",80,2,10,2,20,5,-1,arc);


        Epeiste arthur2 = new Epeiste("Arthur",100,2,10,2,20,5,1,excalibur);
        Tireur legolas2 = new Tireur("Legolas",80,3,10,2,20,5,-1,arc);
        //*******************************************POINTSdeVIES*******************************************************

          arthur.enleverPv(50);
          assert(arthur.pv==50):"arthur n'a pas 50pv";
          arthur.ajouterPv(30);
          assert(arthur.pv==80):"arthur n'a pas 80 pv";

          legolas.enleverPv(80);
          assert(legolas.isVivant()):"legolas est mort";
          assert(legolas.getNbVies()==1):"legolas n'a pas qu'une vie "+legolas.getNbVies();
          assert(legolas.getPv()== legolas.pvMax):"legolas n'a pas été soigné"+legolas.getPv();
          legolas.enleverPv(80);
          assert(legolas.getPv()== 0):"legolas a encore de la vie"+legolas.getPv();
          assert(legolas.getNbVies()==0):"legolas n'a pas 0 vie "+legolas.getNbVies();
          assert(!legolas.isVivant()):"legolas est vivant";



        //********************************************DEPLACEMENTS******************************************************

            arthur2.setPosXmax(POSXMAX);
            legolas2.setPosXmax(POSXMAX);
            arthur2.setPosYmax(POSYMAX);
            legolas2.setPosYmax(POSYMAX);
            arthur2.setPosX(10);
            legolas2.setPosX(10);
            arthur2.setPosY(10);
            legolas2.setPosY(10);



            arthur2.seDeplacer();
            assert(arthur2.getPosX()==15):"la posX d'arthur n'est pas égale à 15"+arthur2.getPosX();
            legolas2.seDeplacer();
            assert(legolas2.getPosX()==5):"la posX d'arthur n'est pas égale à 5"+legolas2.getPosX();
            legolas2.setDirection(1);
            legolas2.seDeplacer();
            legolas2.seDeplacer();
            assert(legolas2.getPosX()==15):"la posX d'arthur n'est pas égale à 15"+legolas2.getPosX();

        //*********************************************COLLISION********************************************************

            assert(arthur2.collision(legolas2)):"arthur et legolas ne se collisionnent pas";

            arthur2.attaquer(legolas2);
            assert(legolas2.getPv()==78):"legolas n'a pas ce nb de pv"+legolas2.getPv();

            legolas2.setDirection(-1);
            legolas2.seDeplacer();
            assert(legolas2.getPosX()==10):"la posX d'arthur n'est pas égale à 10"+legolas2.getPosX();
            assert(!arthur2.collision(legolas2)):"arthur et legolas se collisionnent";

            legolas2.setDirection(1);
            legolas2.attaquer(arthur2);

            assert(arthur2.getPv()==97):"arthur n'a pas ce nb de pv "+arthur2.getPv();

        //********************************************EXCEPTIONS********************************************************





        //*******************************************EQUALS ET TOSTRING**************************************************













    }
}
