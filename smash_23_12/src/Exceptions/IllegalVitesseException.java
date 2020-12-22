package Exceptions;

public class IllegalVitesseException extends IllegalArgumentException{
    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalVitesseException(){            }

    public IllegalVitesseException( String msg ){
        super("IllegalVitesseException: " + msg );
    }
}
