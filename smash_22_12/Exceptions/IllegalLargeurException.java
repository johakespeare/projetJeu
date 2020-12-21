package Exceptions;

public class IllegalLargeurException extends IllegalArgumentException {
    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalLargeurException(){            }

    public IllegalLargeurException( String msg ){
        super("IllegalLargeurException: " + msg );
    }
}
