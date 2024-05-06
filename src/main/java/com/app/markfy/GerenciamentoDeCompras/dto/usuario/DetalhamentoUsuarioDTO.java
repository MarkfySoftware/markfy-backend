package com.app.markfy.GerenciamentoDeCompras.dto.usuario;

import com.app.markfy.GerenciamentoDeCompras.model.Endereco;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.app.markfy.GerenciamentoDeCompras.model.enums.EstadoCivilEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.NivelEducacionalEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.OcupacaoEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.SexoEnum;

import java.time.LocalDate;

public record DetalhamentoUsuarioDTO(
        Long id,
        String nome,
        LocalDate dataDeNasciemto,
        String email,
        String senha,
        SexoEnum sexoEnum,
        String cpf,
        EstadoCivilEnum estadoCivilEnum,
        NivelEducacionalEnum nivelEducacionalEnum,
        Float rendaAnual,
        OcupacaoEnum ocupacaoEnum,
        Endereco endereco
) {
    public DetalhamentoUsuarioDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getDataDeNasciemto(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getSexo(),
                usuario.getCpf(),
                usuario.getEstadoCivil(),
                usuario.getNivelEducacional(),
                usuario.getRendaAnual(),
                usuario.getOcupacao(),
                usuario.getEndereco()
        );
    }
}
