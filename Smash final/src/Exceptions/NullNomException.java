/**
 * NullNomException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Exceptions;

public class NullNomException extends NullPointerException {

    //*********************************************CONSTRUCTEUR*********************************************************


    public NullNomException( String msg ){
        super( "NullNomException : " + msg );
    }

    public NullNomException() {
    }
}
