/**
 * IllegalNbJoueursException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Exceptions;

public class IllegalNbJoueursException extends IllegalArgumentException {
    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalNbJoueursException(){            }

    public IllegalNbJoueursException( String msg ){
        super("IllegalNbJoueursMaxException: " + msg );
    }


}
