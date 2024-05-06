package com.app.markfy.GerenciamentoDeCompras.dto.usuario;
import com.app.markfy.GerenciamentoDeCompras.model.Compra;
import com.app.markfy.GerenciamentoDeCompras.model.Endereco;
import com.app.markfy.GerenciamentoDeCompras.model.enums.EstadoCivilEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.NivelEducacionalEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.OcupacaoEnum;
import com.app.markfy.GerenciamentoDeCompras.model.enums.SexoEnum;

import java.time.LocalDate;
import java.util.List;

public record CadastroUsuarioDTO(
        String nome,
        LocalDate dataDeNasciemto,
        String email,
        String senha,
        SexoEnum sexo,
        String cpf,
        EstadoCivilEnum estadoCivil,
        NivelEducacionalEnum nivelEducacional,
        Float rendaAnual,
        OcupacaoEnum ocupacao,
        Endereco endereco,
        List<Compra> compras
) {
}
