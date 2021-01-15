/**
 * NullObjetException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Exceptions;

public class NullObjetException extends NullPointerException{

    //*********************************************CONSTRUCTEUR*********************************************************


    public NullObjetException( String msg ){
        super( "NullObjetException : " + msg );
    }

    public NullObjetException() {
    }
}
