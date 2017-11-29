package by.bsuir.prognotes.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 07.09.2017 12:18
 */
public class ExpiredTokenAuthenticationException extends AuthenticationException {

    public ExpiredTokenAuthenticationException() {
        super("Authentication token is expired.");
    }
}
