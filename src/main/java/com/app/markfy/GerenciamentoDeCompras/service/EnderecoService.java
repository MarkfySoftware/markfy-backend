package com.app.markfy.GerenciamentoDeCompras.service;

import com.app.markfy.GerenciamentoDeCompras.dto.endereco.AtualizacaoEnderecoDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Endereco;
import com.app.markfy.GerenciamentoDeCompras.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarEnderecos(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos;
    }

    public Endereco buscarEnderecoPorId(Long id) throws NotFoundResourceException {
        Optional<Endereco> endereco = enderecoRepository.findById(id);

        if(!endereco.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar o endereço");
        }

        return endereco.get();
    }

    public Endereco atualizarEndereco(Long id, AtualizacaoEnderecoDTO atualizacaoEnderecoDTO) throws NotFoundResourceException {
        Optional<Endereco> endereco = enderecoRepository.findById(id);

        if(!endereco.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar o endereço");
        }

        endereco.get().atualizarEndereco(atualizacaoEnderecoDTO);
        enderecoRepository.save(endereco.get());

        return endereco.get();
    }

}
