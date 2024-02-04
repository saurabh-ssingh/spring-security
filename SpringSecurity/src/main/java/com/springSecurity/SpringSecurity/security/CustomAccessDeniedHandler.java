package com.springSecurity.SpringSecurity.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

//When a user tries to access a resource for which they do not have the necessary permissions,
// Spring Security invokes the AccessDeniedHandler to determine how the application should respond to this situation.
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Customize the response, e.g., send a custom error page or JSON response
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write("You do not have permission to access this resource : " + accessDeniedException.getMessage());
    }
}
