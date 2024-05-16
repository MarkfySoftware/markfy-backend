package com.app.markfy.GerenciamentoDeCompras.dto.redefinirSenha;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnviarEmailDTO(
    @NotNull
            @NotBlank
            @Email
    String email
){ }
