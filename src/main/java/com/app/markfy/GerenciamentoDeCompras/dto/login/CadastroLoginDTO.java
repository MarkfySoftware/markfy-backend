package com.app.markfy.GerenciamentoDeCompras.dto.login;

import com.app.markfy.GerenciamentoDeCompras.model.Usuario;

import java.time.LocalDate;

public record CadastroLoginDTO(
    String email,
    String senha,
    Long idUsuario
) {
}
