package Exceptions;

public class IllegalNbJoueursException extends IllegalArgumentException {
    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalNbJoueursException(){            }

    public IllegalNbJoueursException( String msg ){
        super("IllegalNbJoueursMaxException: " + msg );
    }


}
