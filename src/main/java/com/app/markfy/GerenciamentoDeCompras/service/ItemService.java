package com.app.markfy.GerenciamentoDeCompras.service;

import com.app.markfy.GerenciamentoDeCompras.dto.item.CadastroItemDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.item.AtualizacaoItemDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.item.DetalhamentoItemDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Item;
import com.app.markfy.GerenciamentoDeCompras.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public DetalhamentoItemDTO cadastrarItem(CadastroItemDTO cadastroItemDTO){
        Item item = new Item(cadastroItemDTO);
        itemRepository.save(item);
        DetalhamentoItemDTO itemDTO = new DetalhamentoItemDTO(item);
        return itemDTO;
    }

    public List<Item> listarItems(){
        List<Item> items = itemRepository.findAll();
        return items;
    }

    public Item buscarItemPorId(Long id) throws NotFoundResourceException {
        Optional<Item> item = itemRepository.findById(id);

        if(!item.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar o item");
        }

        return item.get();
    }

    public DetalhamentoItemDTO atualizarItem(Long id, AtualizacaoItemDTO atualizacaoItemDTO) throws NotFoundResourceException {
        Optional<Item> item = itemRepository.findById(id);

        if(!item.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar o item");
        }

        item.get().atualizarItem(atualizacaoItemDTO);
        itemRepository.save(item.get());

        DetalhamentoItemDTO itemDTO = new DetalhamentoItemDTO(item.get());
        return itemDTO;
    }

    public void deletarItem(Long id) throws NotFoundResourceException {
        Optional<Item> item = itemRepository.findById(id);

        if(!item.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar o item");
        }

        itemRepository.delete(item.get());
    }
}
