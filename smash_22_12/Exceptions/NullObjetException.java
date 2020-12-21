package Exceptions;

public class NullObjetException extends NullPointerException{

    //*********************************************CONSTRUCTEUR*********************************************************


    public NullObjetException( String msg ){
        super( "NullObjetException : " + msg );
    }

    public NullObjetException() {
    }
}
