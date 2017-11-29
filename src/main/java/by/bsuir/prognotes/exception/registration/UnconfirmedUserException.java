package by.bsuir.prognotes.exception.registration;

public class UnconfirmedUserException extends RuntimeException {

    public UnconfirmedUserException() {
        super("User not confirmed.");
    }
}
