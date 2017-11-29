package by.bsuir.prognotes.exception.auth;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 25.09.2017 7:17
 */
public class JwtAccountLockedException extends RuntimeException {
    public JwtAccountLockedException() {
    }

    public JwtAccountLockedException(String message) {
        super(message);
    }

    public JwtAccountLockedException(String message, Throwable cause) {
        super(message, cause);
    }

    public JwtAccountLockedException(Throwable cause) {
        super(cause);
    }

    public JwtAccountLockedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
