package com.app.markfy.GerenciamentoDeCompras.dto.login;

import com.app.markfy.GerenciamentoDeCompras.dto.usuario.DetalhamentoUsuarioSemEnderecoDTO;
import com.app.markfy.GerenciamentoDeCompras.model.Login;

import java.time.LocalDate;

public record DetalhamentoLoginDTO (
         Long id,
         String email,
         String senha,
         LocalDate dataAcesso,
         DetalhamentoUsuarioSemEnderecoDTO usuario
) {
    public DetalhamentoLoginDTO(Login login) {
        this(login.getId(), login.getEmail(), login.getSenha(), login.getDataAcesso(), new DetalhamentoUsuarioSemEnderecoDTO(login.getUsuario()));
    }
}
