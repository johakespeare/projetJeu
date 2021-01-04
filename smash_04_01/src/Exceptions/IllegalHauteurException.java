/**
 * IllegalHauteurException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */

package Exceptions;

public class IllegalHauteurException extends IllegalArgumentException{

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalHauteurException(){            }

    public IllegalHauteurException( String msg ){
        super("IllegalHauteurException: " + msg );
    }
}
