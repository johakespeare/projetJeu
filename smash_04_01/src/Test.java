import Armes.*;
import Objets.*;
import Personnage.*;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        GestionMatch match = new GestionMatch(2,1,250,100);


        Map<String,Integer> s = new HashMap<String, Integer>();

        s.put("Roger",28);
        s.put("g",5);


        for(Map.Entry<String,Integer> element : s.entrySet()){

            System.out.println(element.getKey()+" a marqué "+ element.getValue() +" points") ;
        }





    ;}
}
