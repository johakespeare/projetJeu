import Armes.ArmeDeTir;
import Armes.Portee;
import Objets.Munition;

public class test {

    public static void main(String[] args) {
       /** Objets.Objet o1 = new Objets.Objet(2,3);
        Objets.Objet o2 = new Objets.Objet(2,3);
        Objets.Objet o3 = new Objets.Objet(4,5);

        System.out.println( o1.equals(o2));
        System.out.println( o1.equals(o3));
**/

       //TEST ARC
        Munition fleches = new Munition(-1,5,5,20);
        ArmeDeTir arc = new ArmeDeTir(Portee.COURTE, 10,10,2,fleches);
        System.out.println(Portee.COURTE.getDistance());
       System.out.println( arc.getPortee());
       arc.setPortee(Portee.LONGUE);
        System.out.println(Portee.LONGUE.getDistance());
        System.out.println( arc.getPortee());
       /* arc.isCharge();
        System.out.println("est chargé [10]  "+ arc.getStockMunitions());
        arc.decharger();
        System.out.println("est chargé [9]  "+ arc.getStockMunitions());
        while (arc.isCharge() ){
            arc.decharger();
        }
        System.out.println("est chargé [0]  "+ arc.getStockMunitions());
        arc.decharger();
        System.out.println("est chargé [9]  "+ arc.getStockMunitions());
        System.out.println(" est chargé[true]"+arc.isCharge());*/



    }
}
