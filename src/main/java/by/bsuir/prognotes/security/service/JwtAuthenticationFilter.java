package by.bsuir.prognotes.security.service;

import by.bsuir.prognotes.security.handler.RestAuthenticationFailureHandler;
import by.bsuir.prognotes.security.model.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 07.09.2017 16:08
 */
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationFilter(final AuthenticationManager authenticationManager) {
        super(request -> true);
        setAuthenticationManager(authenticationManager);
        setAuthenticationFailureHandler(new RestAuthenticationFailureHandler());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        try {
            String token = getToken(httpServletRequest);
            if(token == null) {
                throw new BadCredentialsException("Token not found in request`s header.");
            }
            JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(token);
            return this.getAuthenticationManager().authenticate(jwtAuthenticationToken);
        } catch (AuthenticationException exception) {
            unsuccessfulAuthentication(httpServletRequest, httpServletResponse, exception);
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        if (this.eventPublisher != null) {
            this.eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(authResult, this.getClass()));
        }
        chain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String authenticationHeaderName = AuthenticationHelper.AUTHENTICATION_TOKEN_HEADER;
        return Optional.ofNullable(request.getHeader(authenticationHeaderName)).orElse(null);
    }
}
