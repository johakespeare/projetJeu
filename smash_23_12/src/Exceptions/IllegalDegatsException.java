package Exceptions;

public class IllegalDegatsException extends IllegalArgumentException{

    //*********************************************CONSTRUCTEURS********************************************************

    public IllegalDegatsException(){            }

    public IllegalDegatsException( String msg ){
        super("IllegalDegatsException : " + msg );
    }
}
