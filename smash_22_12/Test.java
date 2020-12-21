import Armes.*;
import Objets.*;
import Personnage.*;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        GestionMatch match = new GestionMatch(2,1,250,100);

        Epee epee = new Epee(Portee.COURTE,20,15);
        Munition fleche = new Munition(1,1,1,100,1,1,251,1);

        ArmeDeTir arc = new ArmeDeTir(Portee.LONGUE,20,20,20,fleche);

        Tireur legolas = new Tireur("Legolas",100,20,10,40,2,1,arc);
        legolas.setPosXmax(100);
        Epeiste arthur= new Epeiste("Arthur",500,2,5,5,2,-1,epee);


        match.ajouterJoueur(legolas);
        match.ajouterJoueur(arthur);
        //match.match();

        //TEST ATTAQUER EPEE OK
        arthur.attaquer(legolas);
        System.out.println(legolas.getPv());
        System.out.println(legolas.isVivant());
        arthur.attaquer(legolas);
        System.out.println(legolas.getPv());
        System.out.println(legolas.isVivant());


        //TEST ATTAQUER ARC OK
        System.out.println(arthur.getPv());
        legolas.attaquer(arthur);
        System.out.println("apres attaque"+arthur.getPv());
        System.out.println(arthur.isVivant());
        legolas.attaquer(arthur);
        System.out.println(arthur.getPv());
        System.out.println(arthur.isVivant());





    }
}
