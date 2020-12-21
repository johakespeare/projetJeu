package Exceptions;

public class NullMunitionException extends NullPointerException {
    //*********************************************CONSTRUCTEUR*********************************************************


    public NullMunitionException( String msg ){
        super( "NullMunitionException : " + msg );
    }

    public NullMunitionException() {
    }

}
