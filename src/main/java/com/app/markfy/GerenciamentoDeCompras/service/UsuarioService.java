package com.app.markfy.GerenciamentoDeCompras.service;

import com.app.markfy.GerenciamentoDeCompras.dto.usuario.CadastroUsuarioDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.usuario.AtualizacaoUsuarioDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.usuario.DetalhamentoUsuarioDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.BusinessException;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.app.markfy.GerenciamentoDeCompras.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DetalhamentoUsuarioDTO cadastrarUsuario(CadastroUsuarioDTO cadastroUsuarioDTO) throws BusinessException {
        Optional<Usuario> usuarioByEmail = usuarioRepository.findByEmail(cadastroUsuarioDTO.email());

        if(usuarioByEmail.isPresent()){
            throw new BusinessException("O usuário informado já possui um cadasto.");
        }

        Usuario usuario =  new Usuario(cadastroUsuarioDTO);
        usuarioRepository.save(usuario);
        DetalhamentoUsuarioDTO usuarioDTO = new DetalhamentoUsuarioDTO(usuario);
        return usuarioDTO;
    }

    public List<Usuario> listarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    public Usuario buscarUsuarioPorEmail(String email) throws NotFoundResourceException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        if(!usuario.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar o usuário");
        }

        return usuario.get();
    }

    public Usuario buscarUsuarioPorId(Long id) throws NotFoundResourceException {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(!usuario.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar o usuário");
        }

        return usuario.get();
    }

    public DetalhamentoUsuarioDTO atualizarUsuario(Long id, AtualizacaoUsuarioDTO atualizacaoUsuarioDTO) throws NotFoundResourceException {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(!usuario.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar o usuário");
        }

        usuario.get().atualizarUsuario(atualizacaoUsuarioDTO);
        usuarioRepository.save(usuario.get());

        DetalhamentoUsuarioDTO usuarioDTO = new DetalhamentoUsuarioDTO(usuario.get());
        return usuarioDTO;
    }

    public void deletarUsuario(Long id) throws NotFoundResourceException {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(!usuario.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar o usuário");
        }

        usuarioRepository.delete(usuario.get());
    }
}
