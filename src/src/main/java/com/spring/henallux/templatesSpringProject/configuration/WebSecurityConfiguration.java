package com.spring.henallux.templatesSpringProject.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    public static final String LOGIN_REQUEST = "/login";
    private static final String[] AUTHORIZED_REQUESTS_ANYBODY = new String[]{
            "/",
            "/css/**",
            "/images/**",
            "/js/**",
            "/webfonts/**",

            "/register",
            "/login",

            "/cart/**",
            "/category/**",
            "/product/**",
            "/more_details"
    };
    private static final String[] AUTHORIZED_REQUESTS_ADMIN = new String[]{"/admin"};

    private UserDetailsService userDetailsServiceImpl;

    @Autowired
    public WebSecurityConfiguration(UserDetailsService userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http
                .authorizeRequests()
                .antMatchers(AUTHORIZED_REQUESTS_ADMIN).hasRole("ADMIN")
                .antMatchers(AUTHORIZED_REQUESTS_ANYBODY).permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                .loginPage(LOGIN_REQUEST)
                .permitAll()

                .and()
                .logout()
                .permitAll();
    }
}
