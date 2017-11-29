package by.bsuir.prognotes.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 07.09.2017 12:26
 */
public class InvalidTokenAuthenticationException extends AuthenticationException {

    public InvalidTokenAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public InvalidTokenAuthenticationException(String msg) {
        super(msg);
    }
}
