import Armes.*;
import Objets.*;
import Personnage.*;

import java.util.ArrayList;

public class Match {

    public static void main(String[] args) {

        int nbJoueurs = 2;
        int nbViesMax = 2;
        int hauteurCarte = 250;
        int largeurCarte = 500;
        int nbMunitionsMax = 4;
        int tempsRecharge = 3;

        Carte carte = new Carte(hauteurCarte, largeurCarte);
        Epee epeeKirby = new Epee(Portee.COURTE, 10);
        Munition fleches = new Munition();
        ArmeDeTir arcLink = new ArmeDeTir(Portee.LONGUE, nbMunitionsMax, tempsRecharge, fleches);
        Epeiste Kirby = new Epeiste("Kirby", 10, nbViesMax, 10, 10, 20, 2, 1, epeeKirby);
        Tireur Link = new Tireur("Link", 10, nbViesMax, 10, 5, 15, 5, -1, arcLink);
        ArrayList<Personnage> joueurs = new ArrayList<Personnage>();


        System.out.println("----------INITIALISATION DU MATCH------------");
        joueurs.add(Kirby);
        joueurs.add(Link);
        System.out.println("la partie est composée de " + nbJoueurs + " qui ont " + nbViesMax);

        for (int i = 0; i < joueurs.size(); i++) {
            Personnage j = joueurs.get(i);
            System.out.println(joueurs.get(i).toString());
            j.setPosXmax(largeurCarte);
            j.setPosYmax(hauteurCarte);
            if (j instanceof Tireur) {
                ((Tireur) j).getArmeDeTir().getMunition().setPosXMax(largeurCarte);
                ((Tireur) j).getArmeDeTir().getMunition().setPosYMax(hauteurCarte);
                ((Tireur) j).getArmeDeTir().getMunition().setDirection(j.getDirection());
            }
        }

        System.out.println(carte.toString());

        System.out.println("----------PERSONNAGES EN POSITION-------------");
        int positionDebut = largeurCarte / 10;
        Kirby.setPosX(positionDebut);
        Link.setPosX(largeurCarte - positionDebut);
        for (int i = 0; i < joueurs.size(); i++) {
            System.out.println(joueurs.get(i) + " est en (" + joueurs.get(i).getPosX() + "," + joueurs.get(i).getPosY() + ")");
        }

        System.out.println("--------------DEBUT DU MATCH------------------");

        while (Kirby.getPosX() < Link.getPosX()) {
            Kirby.seDeplacer();
        }
        Kirby.attaquer(Link);
        System.out.println(Kirby.getNom() + " attaque " + Link.getNom() + " il perd " + Kirby.getDegats() + " pv il a "+
                           Link.getNom() + " a " + Link.getPv() + " pv");

        Kirby.setDirection(-1);
        while (Kirby.getPosX() != positionDebut) {
            Kirby.seDeplacer();
        }
        System.out.println(Kirby.getNom() + " s'est déplacé en (" + Kirby.getPosX() + "," + Kirby.getPosY() + ")");

        Kirby.garde();
        System.out.print("Kirby se met en garde");

        Link.attaquer(Kirby);
        System.out.println(Link.getNom() + " attaque " + Kirby.getNom() + "il perd " + fleches.getDegats()/2 + " pv"+
        "et il a " + Kirby.getPv() + " pv");
        System.out.print("Kirby n'est plus en garde");
        Kirby.garde();

        PowerUp pw = new PowerUp(25,0, largeurCarte, hauteurCarte, 3 ,3);
        System.out.println(pw.toString()+" est apparu ");

        while (Kirby.getPosX() != positionDebut) {
            Kirby.seDeplacer();
        }
        if(Kirby.collision(pw)){
            Kirby.collisionEffet(pw);
        }
        System.out.println(Kirby.getNom() + " s'est déplacé en (" + Kirby.getPosX() + "," + Kirby.getPosY() + ") et " +
                "ramasse l'objet powerUp! ses dégats ont augmentés!");

        Kirby.setDirection(1);
        while (Kirby.getPosX() < Link.getPosX()) {
            Kirby.seDeplacer();
        }
        System.out.println(Kirby.getNom() + " s'est déplacé en (" + Kirby.getPosX() + "," + Kirby.getPosY() + ")");
        Kirby.attaquer(Link);

        System.out.println(Kirby.getNom() + " attaque " + Link.getNom() + " il perd " + Kirby.getDegats() + " pv et il a "
                + Link.getPv() + " pv");
        Kirby.attaquer(Link);
        System.out.println(Kirby.getNom() + " attaque " + Link.getNom() + " il perd " + Kirby.getDegats() + " pv et il a "
                + Link.getPv() + " pv");

        Link.setDirection(1);
        Link.seDeplacer();
        Link.setDirection(-1);
        Link.attaquer(Kirby);

        System.out.println(Link.getNom() + " attaque " + Kirby.getNom() + " il perd " + fleches.getDegats() + " pv"
                + " et il a " + Kirby.getPv() + " pv");
        Kirby.attaquer(Link);
        System.out.println(Kirby.getNom() + " attaque " + Link.getNom() + " il perd " + Kirby.getDegats() + " pv"
                + "et il a " + Link.getPv() + " pv");
        Kirby.attaquer(Link);
        System.out.println(Kirby.getNom() + " attaque " + Link.getNom() + " il perd " + Kirby.getDegats() + " pv, " +
                "il a " + Link.getPv() + " pv et il lui reste qu'une vie");

        Link.setPosX(largeurCarte/2);
        System.out.println(Link.getNom() + " se repositionnne au milieu de la carte suite à sa mort ");
        Link.setDirection(1);
        Link.attaquer(Kirby);
        System.out.println(Link.getNom() + " attaque " + Kirby.getNom() + " il perd " + fleches.getDegats() + " pv " +
                " et il a " + Kirby.getPv() + " pv");
        Kirby.setDirection(-1);

        while (Kirby.getPosX() > Link.getPosX()) {
            Kirby.seDeplacer();
        }

        Kirby.attaquer(Link);
        System.out.println(Kirby.getNom() + " attaque " + Link.getNom() + " il perd " + Kirby.getDegats() + " pv et il" +
                        " a " + Link.getPv() + " pv");
        Kirby.attaquer(Link);
        System.out.println(Kirby.getNom() + " attaque " + Link.getNom() + " il perd " + Kirby.getDegats() + " pv"
                + " il a " + Link.getPv() + " pv et il lui reste qu'une vie");

        Coeur c = new Coeur(30,0,largeurCarte,hauteurCarte,4,4);
        while (Kirby.getPosX() > Link.getPosX()) {
            Kirby.seDeplacer();
        }
        System.out.println(c.toString()+" est apparu ");

        while (Kirby.getPosX() > 30) {
            Kirby.seDeplacer();
        }
        if(Kirby.collision(c)){
            Kirby.collisionEffet(c);
        }

        System.out.println(Kirby.getNom() + " s'est déplacé en (" + Kirby.getPosX() + "," + Kirby.getPosY() + ") et " +
                "ramasse l'objet Coeur ses pv ont augmentés!");
        System.out.println(Kirby.getNom()+" a "+ Kirby.getPv()+"pv");


        Kirby.setDirection(1);

        while (Kirby.getPosX() < Link.getPosX()) {
            Kirby.seDeplacer();
        }

        Link.setDirection(-1);
        Link.attaquer(Kirby);
        System.out.println(Link.getNom() + " attaque " + Kirby.getNom() + " il perd " + fleches.getDegats() +
                " pv  il  a " + Kirby.getPv() + " pv");
        Kirby.attaquer(Link);
        System.out.println(Kirby.getNom() + " attaque " + Link.getNom() + " il perd " + Kirby.getDegats() + " pv il a "
                + Link.getPv() + " pv");
        Kirby.attaquer(Link);
        System.out.println(Kirby.getNom() + " attaque " + Link.getNom() + " il perd " + Kirby.getDegats() + " pv il a "
                + Link.getPv() + " pv et il lui reste qu'une vie");
        Kirby.attaquer(Link);
        System.out.println(Kirby.getNom() + " attaque " + Link.getNom() + " il perd " + Kirby.getDegats() + " pv");
        System.out.println(Link.getNom() + " est Mort ! ");

        System.out.println("-------------------FIN------------------------");
        System.out.println("-------------KIRBY VAINQUEUR------------------");
        System.out.println(" (>'-')> <('-'<) ^('-')^ v('-')v(>'-')> (^-^)");
        System.out.println("             **kirby dance**");








    }


}
