package com.app.markfy.GerenciamentoDeCompras.model;

import com.app.markfy.GerenciamentoDeCompras.dto.endereco.AtualizacaoEnderecoDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.endereco.CadastroEnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Bater em api do cep para tentar pegar o tamano da cidade residente
    private String cep;

    private String rua;
    private int numero;
    private String complemento;

    @OneToOne
    @JsonIgnore
    private Usuario usuario;

    public Endereco(CadastroEnderecoDTO cadastroEnderecoDTO, Usuario usuario) {
        this.cep = cadastroEnderecoDTO.cep();
        this.rua = cadastroEnderecoDTO.rua();
        this.numero = cadastroEnderecoDTO.numero();
        this.complemento = cadastroEnderecoDTO.complemento();
        this.usuario = usuario;
    }

    public void atualizarEndereco(AtualizacaoEnderecoDTO atualizacaoEnderecoDTO) {
        if(atualizacaoEnderecoDTO.cep() != null) this.cep = atualizacaoEnderecoDTO.cep();
        if(atualizacaoEnderecoDTO.rua() != null) this.rua = atualizacaoEnderecoDTO.rua();
        if(atualizacaoEnderecoDTO.numero() != null) this.numero = atualizacaoEnderecoDTO.numero();
        if(atualizacaoEnderecoDTO.complemento() != null) this.complemento = atualizacaoEnderecoDTO.complemento();
    }
}
