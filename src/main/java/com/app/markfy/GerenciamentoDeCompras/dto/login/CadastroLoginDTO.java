package com.app.markfy.GerenciamentoDeCompras.dto.login;

import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CadastroLoginDTO(
        @NotNull
                @NotBlank
        String email,
        @NotNull
                @NotBlank
        String senha
) {
}
