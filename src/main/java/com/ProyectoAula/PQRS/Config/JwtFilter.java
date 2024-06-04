package com.ProyectoAula.PQRS.Config;

import com.ProyectoAula.PQRS.domain.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    final String autHeader = request.getHeader("Authorization");
    final String jwt;
    final String userUser;
    if (autHeader==null ||!autHeader.startsWith("Bearer")){
        filterChain.doFilter(request, response);
        return;
    }
    jwt = autHeader.substring(7);

    userUser = jwtService.getUserName(jwt);
    if(userUser !=  null && SecurityContextHolder.getContext().getAuthentication() == null ){
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userUser);
        if (jwtService.validateToken(jwt, userDetails)){
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null,
                    userDetails.getAuthorities()
            );
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }

    }
    filterChain.doFilter(request, response);

    }
}
