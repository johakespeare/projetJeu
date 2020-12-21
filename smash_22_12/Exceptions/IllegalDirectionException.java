package Exceptions;

public class IllegalDirectionException extends IllegalArgumentException {

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalDirectionException(){            }

    public IllegalDirectionException( String msg ){
        super("IllegalDirectionException: " + msg );
    }
}
