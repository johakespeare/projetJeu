package Exceptions;

public class NullEpeeException extends NullPointerException{

    //*********************************************CONSTRUCTEUR*********************************************************


    public NullEpeeException( String msg ){
        super( "NullEpeeException : " + msg );
    }

    public NullEpeeException() {
    }
}
