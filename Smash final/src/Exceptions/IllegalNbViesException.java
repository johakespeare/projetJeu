/**
 * IllegalNbViesException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Exceptions;

public class IllegalNbViesException extends IllegalArgumentException {

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalNbViesException(){            }

    public IllegalNbViesException( String msg ){
        super("IllegalNbViesException : " + msg );
    }
}


