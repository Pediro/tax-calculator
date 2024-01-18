package taxcalc.exceptions;

public class ArgumentException extends RuntimeException {
    public ArgumentException(String errorMessage) {
        super(errorMessage);
    }
}