/**
 * IllegalNbMunitionsMaxException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */

package Exceptions;

public class IllegalNbMunitionsMaxException extends IllegalArgumentException {

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalNbMunitionsMaxException(){            }

    public IllegalNbMunitionsMaxException( String msg ){
        super("IllegalNbMunitionsMaxException: " + msg );
    }


}
