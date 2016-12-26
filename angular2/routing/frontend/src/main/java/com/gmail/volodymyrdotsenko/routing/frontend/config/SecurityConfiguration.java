package com.gmail.volodymyrdotsenko.routing.frontend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.sql.DataSource;

/**
 * Configure Spring Security
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private DataSource dataSource;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider ap = new DaoAuthenticationProvider();
        ap.setUserDetailsService(userDetailsService);
        ap.setPasswordEncoder(getPasswordEncoder());
        return ap;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public CustomPersistentTokenBasedRememberMeServices tokenBasedRememberMeService() {
        CustomPersistentTokenBasedRememberMeServices service =
                new CustomPersistentTokenBasedRememberMeServices("qwqwqwqw", userDetailsService, persistentTokenRepository());
        service.setAlwaysRemember(true);
        return service;
    }

    @Bean
    public RememberMeAuthenticationFilter rememberMeAuthenticationFilter() throws Exception {
        return new RememberMeAuthenticationFilter(authenticationManager(), tokenBasedRememberMeService());
    }

    @Bean
    public BasicAuthenticationFilter basicAuthenticationFilter() throws Exception {
        BasicAuthenticationFilter filter = new BasicAuthenticationFilter(authenticationManagerBean());
        filter.setRememberMeServices(tokenBasedRememberMeService());
        return filter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/auth/*").authenticated()
                .and()
                .addFilter(basicAuthenticationFilter())
                .addFilterBefore(rememberMeAuthenticationFilter(),
                        BasicAuthenticationFilter.class)
        //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        //.and()
        //.exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint())
        //.logout()
        //.rememberMe().tokenRepository(persistentTokenRepository()).tokenValiditySeconds(3600).key("qwqwqwqw")
        // .rememberMeServices()
        //.userDetailsService(userDetailsService)
        ;
    }
}