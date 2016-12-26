package com.gmail.volodymyrdotsenko.routing.frontend.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Volodymyr Dotsenko on 11/30/16.
 */
public class CustomPersistentTokenBasedRememberMeServices extends PersistentTokenBasedRememberMeServices {

    private static final String HEADER_TOKEN_ACCESS = "TOKEN_ACCESS";

    private final PersistentTokenRepository tokenRepository;

    public CustomPersistentTokenBasedRememberMeServices(String key, UserDetailsService userDetailsService,
                                                        PersistentTokenRepository tokenRepository) {
        super(key, userDetailsService, tokenRepository);
        this.tokenRepository = tokenRepository;
    }

    @Override
    protected String extractRememberMeCookie(HttpServletRequest request) {
        String token = request.getHeader(HEADER_TOKEN_ACCESS);
        if ((token == null) || (token.length() == 0)) {
            return null;
        }

        return token;
    }

    /**
     * Creates a new persistent login token with a new series number, stores the data in
     * the persistent token repository and adds the corresponding cookie to the response.
     */
    @Override
    protected void onLoginSuccess(HttpServletRequest request,
                                  HttpServletResponse response, Authentication successfulAuthentication) {
        String username = successfulAuthentication.getName();

        logger.debug("Creating new persistent login for user " + username);

        PersistentRememberMeToken persistentToken = new PersistentRememberMeToken(
                username, generateSeriesData(), generateTokenData(), new Date());
        try {
            tokenRepository.createNewToken(persistentToken);
            addHeader(persistentToken, request, response);
            addCookie(persistentToken, request, response);
        } catch (Exception e) {
            logger.error("Failed to save persistent token ", e);
        }
    }

    private void addHeader(PersistentRememberMeToken token, HttpServletRequest request,
                           HttpServletResponse response) {
        String[] tokens = new String[]{token.getSeries(), token.getTokenValue()};
        String cookieValue = encodeCookie(tokens);
        response.addHeader(HEADER_TOKEN_ACCESS, cookieValue);

        if (SecurityContextHolder.getContext() != null
                && SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal()
                instanceof UserDetailsServiceImpl.CurrentUser) {

            ((UserDetailsServiceImpl.CurrentUser) SecurityContextHolder.getContext()
                    .getAuthentication().getPrincipal()).getUser().setToken(cookieValue);
        }
    }

    private void addCookie(PersistentRememberMeToken token, HttpServletRequest request,
                           HttpServletResponse response) {
        setCookie(new String[]{token.getSeries(), token.getTokenValue()},
                getTokenValiditySeconds(), request, response);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response,
                       Authentication authentication) {
        super.logout(request, response, authentication);

        authentication.setAuthenticated(false);
    }
}