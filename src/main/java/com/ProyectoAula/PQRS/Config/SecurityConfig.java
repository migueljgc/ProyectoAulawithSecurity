package com.ProyectoAula.PQRS.Config;

import com.ProyectoAula.PQRS.domain.common.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
    @EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
    public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers(publicEndpoinds()).permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(sess ->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();

    }
    private RequestMatcher publicEndpoinds(){
        return new OrRequestMatcher(
          new AntPathRequestMatcher("/api/greeting/sayHelloPublic"),
                new AntPathRequestMatcher("/api/auth/**"),
                new AntPathRequestMatcher("/api/user/**"),
        new AntPathRequestMatcher("/api/identification_type/get"),
        new AntPathRequestMatcher("/api/person_type/get")
        );
    }

    }

