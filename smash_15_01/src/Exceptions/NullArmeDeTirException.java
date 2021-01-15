package Exceptions;
/**
 * NullArmeDeTirException
 * @author Johanna Fericean & Ghinevra Comiti
 * @version 1.0
 */
public class NullArmeDeTirException extends NullPointerException {

    //*********************************************CONSTRUCTEUR*********************************************************

    public NullArmeDeTirException() {

    }

    public NullArmeDeTirException(String msg) {
        super("NullEpeeException : " + msg);
    }

}
