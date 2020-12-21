package Exceptions;

public class NullPersonnageException extends NullPointerException{
    //*********************************************CONSTRUCTEUR*********************************************************


    public NullPersonnageException( String msg ){
        super( "NullPersonnageException : " + msg );
    }

    public NullPersonnageException() {
    }
}
