package by.bsuir.prognotes.exception.auth;

import org.springframework.security.core.AuthenticationException;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 13.09.2017 18:43
 */
public class AuthenticationFailedException extends AuthenticationException {

    public AuthenticationFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public AuthenticationFailedException(String msg) {
        super(msg);
    }
}
