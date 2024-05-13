package com.app.markfy.GerenciamentoDeCompras.dto.item;

import com.app.markfy.GerenciamentoDeCompras.model.enums.TamanhoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroItemDTO(

        @NotNull
            @NotBlank
        String nome,

        @NotNull
        Float valor,
        @NotNull
        String marca,
        @NotNull
        TamanhoEnum tamanho,
        @NotNull
        Integer estoque
) {
}
