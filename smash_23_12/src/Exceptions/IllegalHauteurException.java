package Exceptions;

public class IllegalHauteurException extends IllegalArgumentException{

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalHauteurException(){            }

    public IllegalHauteurException( String msg ){
        super("IllegalHauteurException: " + msg );
    }
}
