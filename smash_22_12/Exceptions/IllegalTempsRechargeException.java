package Exceptions;

public class IllegalTempsRechargeException extends IllegalArgumentException {

    public IllegalTempsRechargeException(){            }

    public IllegalTempsRechargeException( String msg ){
        super("IllegalTempsRechargeException: " + msg );
    }

}
