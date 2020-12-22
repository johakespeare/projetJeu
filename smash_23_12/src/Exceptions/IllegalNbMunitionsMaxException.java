package Exceptions;

public class IllegalNbMunitionsMaxException extends IllegalArgumentException {

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalNbMunitionsMaxException(){            }

    public IllegalNbMunitionsMaxException( String msg ){
        super("IllegalNbMunitionsMaxException: " + msg );
    }


}
