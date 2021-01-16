/**
 * IllegalNomException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Exceptions;

public class IllegalNomException extends IllegalArgumentException{

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalNomException(){            }

    public IllegalNomException( String msg ){
        super("IllegalNomException: " + msg );
    }
}
