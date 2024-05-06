package com.app.markfy.GerenciamentoDeCompras.model;

import com.app.markfy.GerenciamentoDeCompras.dto.compra.AtualizacaoCompraDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table
@Entity
@Data
@NoArgsConstructor
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataDaCompra;
    private Boolean statusDaCompra;

    @ManyToOne
    private Login login;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item> items;
    private Float valorTotal;

    public Compra(Login login, List<Item> items, Float valorTotal) {
        this.login = login;
        this.statusDaCompra = false;
        this.dataDaCompra = LocalDate.now();
        this.items = items;
        this.valorTotal = valorTotal;
    }

    public void atualizarCompra(AtualizacaoCompraDTO atualizacaoCompraDTO) {
        if(atualizacaoCompraDTO.dataDaCompra() != null)this.dataDaCompra = atualizacaoCompraDTO.dataDaCompra();
        if(atualizacaoCompraDTO.statusDaCompra() != null) this.statusDaCompra = atualizacaoCompraDTO.statusDaCompra();
    }

    public void confirmarCompra() {
        this.statusDaCompra = true;
    }
}
