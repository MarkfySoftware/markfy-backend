package com.app.markfy.GerenciamentoDeCompras.service;

import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.app.markfy.GerenciamentoDeCompras.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioRepository = userRepository.findByEmail(username);

        if(usuarioRepository.isPresent()){
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }

        return User.withUsername(usuarioRepository.get().getEmail())
                .password(usuarioRepository.get().getSenha())
                .accountExpired(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
