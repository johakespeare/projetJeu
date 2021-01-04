/**
 * IllegalDirectionException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */

package Exceptions;

public class IllegalDirectionException extends IllegalArgumentException {

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalDirectionException(){            }

    public IllegalDirectionException( String msg ){
        super("IllegalDirectionException: " + msg );
    }
}
