package com.app.markfy.GerenciamentoDeCompras.dto.item;

import com.app.markfy.GerenciamentoDeCompras.model.enums.TamanhoEnum;

public record CadastroItemDTO(
        String nome,
        Float valor,
        String marca,
        TamanhoEnum tamanho,
        Integer estoque
) {
}
