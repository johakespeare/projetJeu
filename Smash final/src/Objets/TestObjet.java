package Objets;

public class TestObjet {

    public static void main(String[] args) {

        //*********************************************Munitions********************************************************

        Munition balle = new Munition(10,10,20,20,2,3);

        balle.setDirection(1);
        balle.deplacer();
        assert(balle.getPosX()==11):"la balle n'est pas allée vers la droite à la bonne position";

        balle.setDirection(-1);
        balle.deplacer();
        assert(balle.getPosX()==10):"la balle n'est pas allée vers la gauche à la bonne position";



        //*******************************************EQUALS ET TOSTRING*************************************************






    }





}
