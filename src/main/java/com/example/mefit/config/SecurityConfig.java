package com.example.mefit.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//noroff template: https://gitlab.com/noroff-accelerate/java/projects/spring-security-demo/-/blob/main/src/main/java/no/accelerate/springsecdemo/config/SecurityConfig.java
//zoom time: 30:00
//
@EnableWebSecurity
@Configuration //but why?
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //enable swagger
        http
                .cors().and()
                .sessionManagement().disable()
                .csrf().disable()
                .authorizeHttpRequests(authorize -> authorize
                        // Add a new public endpoint
                        .requestMatchers(new AntPathRequestMatcher("/public")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**")).permitAll() // Add this line
                        .requestMatchers(new AntPathRequestMatcher("/workouts/**")).permitAll() // Add this line

                        // Modify access control for /users and /workouts
                        .requestMatchers(new AntPathRequestMatcher("/users/**")).hasRole("USER")
                        //.requestMatchers(new AntPathRequestMatcher("/workouts/**")).hasRole("USER")
                        .requestMatchers(new AntPathRequestMatcher("/goal/**")).hasRole("USER")
                        .requestMatchers(new AntPathRequestMatcher("/exercises/newExercise/**")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/exercises/updateExercise/**")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/exercises/deleteExercise/**")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/workouts/createWorkout/**")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/workouts/updateWorkout/**")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/workouts/deleteWorkoutById/**")).hasRole("ADMIN")
                        .anyRequest().authenticated()
                ).oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtRoleAuthenticationConverter());




        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtRoleAuthenticationConverter() {

        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        // Use roles claim as authorities
        grantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
        // Add the ROLE_ prefix - for hasRole
        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }

}
