package by.bsuir.prognotes.security;

import by.bsuir.prognotes.exception.auth.AuthenticationFailedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 07.09.2017 19:47
 */
public class SecurityHelper {

    public static Authentication getAuthenticationWithCheck() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean checkAuthenticationExist = authentication != null && authentication.isAuthenticated();
        if (checkAuthenticationExist) {
            return authentication;
        }
        throw new AuthenticationFailedException("Authentication failed.");
    }
}
