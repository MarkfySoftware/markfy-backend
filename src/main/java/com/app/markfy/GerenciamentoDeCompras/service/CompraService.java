package com.app.markfy.GerenciamentoDeCompras.service;

import com.app.markfy.GerenciamentoDeCompras.dto.compra.CadastroCompraDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.compra.DetalhamentoCompraDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.login.DetalhamentoLoginDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.CompraException;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Compra;
import com.app.markfy.GerenciamentoDeCompras.model.Item;
import com.app.markfy.GerenciamentoDeCompras.model.Login;
import com.app.markfy.GerenciamentoDeCompras.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ItemService itemService;

    public DetalhamentoCompraDTO cadastrarCompra(CadastroCompraDTO cadastroCompraDTO) throws Exception {
        try{
            Login login = loginService.buscarLoginPorId(cadastroCompraDTO.idLogin());

            List<Item> items = new ArrayList<>();
            for(Long idItem : cadastroCompraDTO.idsItems()){
                Item item = itemService.buscarItemPorId(idItem);
                items.add(item);
            }

            for(Item item : items){
                if(item.getEstoque() < 1){
                    throw new CompraException("Não é possível efetuar a compra. Item indisponível no estoque");
                }
            }

            float valorTotal = 0f;
            for(Item item : items){
                float valorItem = item.getValor();
                valorTotal += valorItem;
            }

            Compra compra = new Compra(login, items, valorTotal);
            compraRepository.save(compra);
            return new DetalhamentoCompraDTO(compra);
        }catch (NotFoundResourceException e){
            throw new Exception(e.getMessage()); 
        } catch (CompraException e) {
            throw new Exception(e.getMessage());
        }
    }


    public DetalhamentoCompraDTO confirmarCompra(Long id) throws NotFoundResourceException {
        Optional<Compra> compra = compraRepository.findById(id);

        if(!compra.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar a compra");
        }

        compra.get().confirmarCompra();
        List<Item> items = compra.get().getItems();
        for(Item item : items){
            Integer estoque = item.getEstoque();
            Integer novoEstoque = estoque - 1;
            item.setEstoque(novoEstoque);
        }
        compraRepository.save(compra.get());

        DetalhamentoCompraDTO compraDTO = new DetalhamentoCompraDTO(compra.get());
        return compraDTO;
    }

    public List<DetalhamentoCompraDTO> listarCompras(){
        List<Compra> compras = compraRepository.findAll();
        List<DetalhamentoCompraDTO> comprasDetalhadas = new ArrayList<>();

        for(Compra compra : compras){
            DetalhamentoCompraDTO detalhamentoCompraDTO = new DetalhamentoCompraDTO(compra);
            comprasDetalhadas.add(detalhamentoCompraDTO);
        }


        return comprasDetalhadas;
    }

    public Compra buscarCompraPorId(Long id) throws NotFoundResourceException {
        Optional<Compra> compra = compraRepository.findById(id);

        if(!compra.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar a compra");
        }

        return compra.get();
    }

    public void deletarCompra(Long id) throws NotFoundResourceException {
        Optional<Compra> compra = compraRepository.findById(id);

        if(!compra.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar a compra");
        }

        compraRepository.delete(compra.get());
    }
}
