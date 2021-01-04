/**
 * IllegalTempsRechargeException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
package Exceptions;

public class IllegalTempsRechargeException extends IllegalArgumentException {

    public IllegalTempsRechargeException(){            }

    public IllegalTempsRechargeException( String msg ){
        super("IllegalTempsRechargeException: " + msg );
    }

}
