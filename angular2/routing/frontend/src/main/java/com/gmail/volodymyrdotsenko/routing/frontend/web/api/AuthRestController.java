package com.gmail.volodymyrdotsenko.routing.frontend.web.api;

import com.gmail.volodymyrdotsenko.routing.backend.domain.users.User;
import com.gmail.volodymyrdotsenko.routing.backend.services.UserService;
import com.gmail.volodymyrdotsenko.routing.frontend.config.CustomPersistentTokenBasedRememberMeServices;
import com.gmail.volodymyrdotsenko.routing.frontend.config.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Volodymyr Dotsenko on 12/12/16.
 */
@RestController
@RequestMapping("/auth")
public class AuthRestController {

    private final UserService userService;
    private final CustomPersistentTokenBasedRememberMeServices rememberMeServices;

    @Autowired
    public AuthRestController(UserService userService,
                              CustomPersistentTokenBasedRememberMeServices rememberMeServices) {
        this.userService = userService;
        this.rememberMeServices = rememberMeServices;
    }

    @RequestMapping(value = "/signout", method = RequestMethod.POST)
    public ResponseEntity<?> signOut(HttpServletRequest request, HttpServletResponse response) {
        rememberMeServices.logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return ResponseEntity.ok("ok");
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> signIn() {
        return ResponseEntity.ok("ok");
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> getToken() {
        if (SecurityContextHolder.getContext() != null
                && SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null
                && SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal() instanceof UserDetailsServiceImpl.CurrentUser) {

            return ResponseEntity.ok("{\"token\":\"" +
                    ((UserDetailsServiceImpl.CurrentUser) SecurityContextHolder.getContext()
                            .getAuthentication()
                            .getPrincipal()).getUser().getToken()
                    + "\"}");
        } else
            return ResponseEntity.ok("{\"token\":\"\"}");
    }

    @RequestMapping(value = "/profiles", method = RequestMethod.POST)
    public ResponseEntity<?> getProfiles() {
        if (SecurityContextHolder.getContext() != null
                && SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null
                && SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal() instanceof UserDetailsServiceImpl.CurrentUser) {

            User user = ((UserDetailsServiceImpl.CurrentUser) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal()).getUser();

            return ResponseEntity.ok(userService.findProfilesByUserId(user.getId()));
        } else
            return ResponseEntity.notFound().build();
    }
}