package Exceptions;

public class IllegalPoidsException extends IllegalArgumentException {

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalPoidsException(){            }

    public IllegalPoidsException( String msg ){
        super("IllegalPoidsException : " + msg );
    }
}
