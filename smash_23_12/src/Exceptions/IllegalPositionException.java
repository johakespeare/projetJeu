package Exceptions;

public class IllegalPositionException extends IllegalArgumentException {

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalPositionException(){            }

    public IllegalPositionException( String msg ){
        super("IllegalPositionException : " + msg );
    }
}
