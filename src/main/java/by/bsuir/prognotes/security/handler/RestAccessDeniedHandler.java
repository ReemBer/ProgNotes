package by.bsuir.prognotes.security.handler;

import org.springframework.core.env.Environment;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 07.09.2017 19:40
 */
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Resource
    private Environment environment;

    private static final String ACCESS_DENIED_MESSAGE = "security.access_denied.message";

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        String accessDeniedMessage = environment.getProperty(ACCESS_DENIED_MESSAGE);
        httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedMessage);
    }
}
