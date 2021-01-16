/**
 * NullEpeeException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Exceptions;

public class NullEpeeException extends NullPointerException{

    //*********************************************CONSTRUCTEUR*********************************************************


    public NullEpeeException( String msg ){
        super( "NullEpeeException : " + msg );
    }

    public NullEpeeException() {
    }
}
