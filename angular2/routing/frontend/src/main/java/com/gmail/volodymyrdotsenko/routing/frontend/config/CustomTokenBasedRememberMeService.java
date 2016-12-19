package com.gmail.volodymyrdotsenko.routing.frontend.config;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Volodymyr Dotsenko on 12/19/16.
 */
public class CustomTokenBasedRememberMeService extends TokenBasedRememberMeServices {

    public CustomTokenBasedRememberMeService(String key, UserDetailsService userDetailsService) {
        super(key, userDetailsService);
    }

    private final String HEADER_SECURITY_TOKEN = "Header name for token goes here";

    /**
     * Locates the Spring Security remember me token in the request and returns its value.
     *
     * @param request the submitted request which is to be authenticated
     * @return the value of the request header (which was originally provided by the cookie - API expects it in header)
     */
    @Override
    protected String extractRememberMeCookie(HttpServletRequest request) {
        String token = request.getHeader(HEADER_SECURITY_TOKEN);
        if ((token == null) || (token.length() == 0)) {
            return null;
        }

        return token;
    }
}