/**
 * IllegalPvException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Exceptions;

public class IllegalPvException extends IllegalArgumentException {
    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalPvException(){            }

    public IllegalPvException( String msg ){
        super("IllegalPvException : " + msg );
    }


}
