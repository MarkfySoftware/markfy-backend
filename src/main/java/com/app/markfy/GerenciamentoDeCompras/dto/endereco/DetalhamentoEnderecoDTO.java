package com.app.markfy.GerenciamentoDeCompras.dto.endereco;

import com.app.markfy.GerenciamentoDeCompras.model.Endereco;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
public record DetalhamentoEnderecoDTO(
         Long id,
         String cep,
         String rua,
         int numero,
         String complemento,
         Usuario usuario
) {
    public DetalhamentoEnderecoDTO(Endereco endereco) {
        this(endereco.getId(), endereco.getCep(), endereco.getRua(), endereco.getNumero(), endereco.getComplemento(), endereco.getUsuario());
    }
}
