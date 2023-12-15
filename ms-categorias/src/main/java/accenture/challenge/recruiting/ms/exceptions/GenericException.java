package accenture.challenge.recruiting.ms.exceptions;

public class GenericException extends RuntimeException {

    public GenericException(String error) {
        super(error);
    }

    public GenericException(String error, Throwable ex) {
        super(error, ex);
    }

}
