package com.app.markfy.GerenciamentoDeCompras.service;

import com.app.markfy.GerenciamentoDeCompras.dto.redefinirSenha.RedefinirSenhaDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.app.markfy.GerenciamentoDeCompras.repository.UsuarioRepository;
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


    public void redefinirSenha(RedefinirSenhaDTO redefinirSenhaDTO) throws NotFoundResourceException {
        String subjectFromToken = jwtTokenService.getSubjectFromToken(redefinirSenhaDTO.token());
        Usuario usuario = usuarioService.buscarUsuarioPorEmail(subjectFromToken);
        usuario.setSenha(redefinirSenhaDTO.novaSenha());
        usuarioRepository.save(usuario);
    }
}
