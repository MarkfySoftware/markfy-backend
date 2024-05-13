package com.app.markfy.GerenciamentoDeCompras.dto.endereco;

import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroEnderecoDTO(
        @NotNull
                @NotBlank
        String cep,
        @NotNull
        String rua,
        @NotNull
        int numero,
        String complemento,
        @NotNull
        Long idUsuario
) {
}
