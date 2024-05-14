package com.app.markfy.GerenciamentoDeCompras.config;

import com.app.markfy.GerenciamentoDeCompras.exceptions.AuthenticationException;
import com.app.markfy.GerenciamentoDeCompras.exceptions.ErrorMessage;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.app.markfy.GerenciamentoDeCompras.repository.UsuarioRepository;
import com.app.markfy.GerenciamentoDeCompras.service.JwtTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class    UserAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recoveryToken(request);
        if (token != null) {

            String usuario = jwtTokenService.getSubjectFromToken(token);
            Usuario user = userRepository.findByEmail(usuario).get();
            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getSenha(), null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else{
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Token ausente");
        }
    }

    private String recoveryToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }


}
