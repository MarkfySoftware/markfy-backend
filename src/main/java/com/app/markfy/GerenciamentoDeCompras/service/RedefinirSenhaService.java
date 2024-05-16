package com.app.markfy.GerenciamentoDeCompras.service;

import com.app.markfy.GerenciamentoDeCompras.dto.redefinirSenha.RedefinirSenhaDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.app.markfy.GerenciamentoDeCompras.repository.UsuarioRepository;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedefinirSenhaService {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void redefinirSenha(String token, String novaSenha) throws NotFoundResourceException {
        String email = JWT.decode(token).getSubject();
            Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);
        usuario.setSenha(novaSenha);
        usuarioRepository.save(usuario);
    }
}
