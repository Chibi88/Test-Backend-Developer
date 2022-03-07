package com.mobydigital.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("user")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .logout();
    }
}

// Si no corre automaticamente el archivo import.sql crear roles,
// Usuarios y sus relaciones
// INSERT INTO ROLES(ID, NAME) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USUARIO');
//INSERT INTO USERS(ID, NAME, PASSWORD) VALUES (1, 'admin', 'admin'), (2, 'user', 'user');
//INSERT INTO USER_ROLES (ID_USER, ID_ROL) VALUES (1, 1), (1,2), (2, 2);