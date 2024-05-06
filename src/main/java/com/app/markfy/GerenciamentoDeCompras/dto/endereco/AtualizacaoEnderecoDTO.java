package com.app.markfy.GerenciamentoDeCompras.dto.endereco;

public record AtualizacaoEnderecoDTO(
        String cep,
        String rua,
        Integer numero,
        String complemento
) {
}
