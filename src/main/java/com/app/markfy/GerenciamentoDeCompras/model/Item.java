package com.app.markfy.GerenciamentoDeCompras.model;

import com.app.markfy.GerenciamentoDeCompras.dto.item.AtualizacaoItemDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.item.CadastroItemDTO;
import com.app.markfy.GerenciamentoDeCompras.model.enums.TamanhoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity
@Data
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Float valor;
    private String marca;
    private TamanhoEnum tamanho;
    private Integer estoque;

    @ManyToMany
    @JsonIgnore
    private List<Compra> compras;

    public Item(CadastroItemDTO cadastroItemDTO) {
        this.nome = cadastroItemDTO.nome();
        this.valor = cadastroItemDTO.valor();
        this.marca = cadastroItemDTO.marca();
        this.tamanho = cadastroItemDTO.tamanho();
        this.estoque = cadastroItemDTO.estoque();
    }

    public void atualizarItem(AtualizacaoItemDTO atualizacaoItemDTO) {
        if(atualizacaoItemDTO.nome() != null) this.nome = atualizacaoItemDTO.nome();
        if(atualizacaoItemDTO.valor() != null) this.valor = atualizacaoItemDTO.valor();
        if(atualizacaoItemDTO.marca() != null) this.marca = atualizacaoItemDTO.marca();
        if(atualizacaoItemDTO.tamanhoEnum() != null) this.tamanho = atualizacaoItemDTO.tamanhoEnum();
        if(atualizacaoItemDTO.estoque() != null) this.estoque = atualizacaoItemDTO.estoque();
    }
}
