package com.Jeffs.Home.Library.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // Support for JDBC (grabbing users from Database)
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //Query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT username, password, active FROM member WHERE username=?");
        //Query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT username, role FROM roles WHERE username=?");

        return jdbcUserDetailsManager; //tells Spring Security to use JDBC authentication with our data source
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configuer ->
                configuer
                        .requestMatchers("/api/login").hasRole("MEMBER")
                        .requestMatchers("/api/login").hasRole("LIBRARIAN")
                        .requestMatchers("/api/authors").hasRole("MEMBER")
                        .requestMatchers("/api/authors").hasRole("LIBRARIAN")
                        .requestMatchers("/api/authors/showAuthorFormForAdd/**").hasRole("LIBRARIAN")
                        .requestMatchers("/api/authors/showAuthorFormForUpdate/**").hasRole("LIBRARIAN")
                        .requestMatchers("/api/authors/save/**").hasRole("LIBRARIAN")
                        .requestMatchers("/api/authors/deleteAuthor/**").hasRole("LIBRARIAN")
                        .requestMatchers("/api/books").hasRole("MEMBER")
                        .requestMatchers("/api/books").hasRole("LIBRARIAN")
                        .requestMatchers("/api/books/showBookFormForAdd/**").hasRole("LIBRARIAN")
                        .requestMatchers("/api/books/showBookFormForUpdate/**").hasRole("LIBRARIAN")
                        .requestMatchers("/api/books/save/**").hasRole("LIBRARIAN")
                        .requestMatchers("/api/books/deleteBook/**").hasRole("LIBRARIAN")
                        .requestMatchers("/api/publishers").hasRole("MEMBER")
                        .requestMatchers("/api/publishers").hasRole("LIBRARIAN")
                        .requestMatchers("/api/publishers/showPublisherFormForAdd/**").hasRole("LIBRARIAN")
                        .requestMatchers("/api/publishers/showPublisherFormForUpdate/**").hasRole("LIBRARIAN")
                        .requestMatchers("/api/publishers/save/**").hasRole("LIBRARIAN")
                        .requestMatchers("/api/publishers/deletePublisher/**").hasRole("LIBRARIAN")
                        .anyRequest().authenticated())
                .formLogin(form ->
                        form
                                .loginPage("/api/login")
                                .loginProcessingUrl("/api/authenticateTheMember")
                                .defaultSuccessUrl("/api/home", true) //redirect to home page
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configure ->
                        configure.accessDeniedPage("/api/access-denied")
                );
        return http.build();
    }

    //in memory for security login
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails jeff = User.builder()
//                .username("jeff")
//                .password("{noop}test123")
//                .roles("MEMBER")
//                .build();
//
//        UserDetails kyleigh = User.builder()
//                .username("kyleigh")
//                .password("{noop}test123")
//                .roles("MEMBER", "LIBRARIAN")
//                .build();
//
//        return new InMemoryUserDetailsManager(jeff, kyleigh);
//    }
}
