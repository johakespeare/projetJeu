package Exceptions;

public class IllegalNomException extends IllegalArgumentException{

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalNomException(){            }

    public IllegalNomException( String msg ){
        super("IllegalNomException: " + msg );
    }
}
