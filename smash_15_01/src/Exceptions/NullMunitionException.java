/**
 * NullMunitionException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Exceptions;

public class NullMunitionException extends NullPointerException {
    //*********************************************CONSTRUCTEUR*********************************************************


    public NullMunitionException( String msg ){
        super( "NullMunitionException : " + msg );
    }

    public NullMunitionException() {
    }

}
