package com.app.markfy.GerenciamentoDeCompras.dto.endereco;

import com.app.markfy.GerenciamentoDeCompras.model.Usuario;

public record CadastroEnderecoDTO(
        String cep,
        String rua,
        int numero,
        String complemento,
        Long idUsuario
) {
}
