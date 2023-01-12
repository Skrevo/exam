package com.example.demo.secure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.demo.models.User.Role.TEACHER;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authManager(HttpSecurity security,
                                             BCryptPasswordEncoder passwordEncoder,
                                             UserDetailsService userDetailsService) throws Exception {
        return security
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and().build();

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers(
                        "/error"

                )
                .permitAll()
                //
                .antMatchers(
                        "/",
                        "myAccount"

                )
                .authenticated()
                //
                .antMatchers(
                        "/studentInfo",
                        "/students"
                )
                .hasAnyAuthority(
                        TEACHER.name()
                )
                //

                .and()
                .formLogin()
                .loginPage(
                        "/authorization"
                )
                //
                .and()
                .logout()
                .logoutSuccessUrl(
                        "/authorization"
                )
        ;
        return httpSecurity.build();
    }
}
