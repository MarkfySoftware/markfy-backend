package com.app.markfy.GerenciamentoDeCompras.service;

import com.app.markfy.GerenciamentoDeCompras.dto.login.CadastroLoginDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.login.DetalhamentoLoginDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.LoginException;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Login;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.app.markfy.GerenciamentoDeCompras.repository.LoginRepository;
import com.app.markfy.GerenciamentoDeCompras.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepository LoginRepository;

    @Autowired
    private UsuarioService usuarioService;
    
    public DetalhamentoLoginDTO logar(CadastroLoginDTO cadastroLoginDTO) throws NotFoundResourceException, LoginException {
        try {
            Usuario usuario = usuarioService.buscarUsuarioPorEmail(cadastroLoginDTO.email());

            if(!usuario.getSenha().equals(cadastroLoginDTO.senha())){
                throw new LoginException("Email ou senha inválidos!");
            }

            Login login = new Login(cadastroLoginDTO.email(), cadastroLoginDTO.senha(), usuario);
            LoginRepository.save(login);
            return new DetalhamentoLoginDTO(login);
        }catch (NotFoundResourceException e){
            throw new LoginException("Email ou senha inválidos!");
        }
    }
    
    public List<DetalhamentoLoginDTO> listarLogins(){
        List<Login> logins = LoginRepository.findAll();
        List<DetalhamentoLoginDTO> loginsDetalhados = new ArrayList<>();

        for(Login login : logins){
            DetalhamentoLoginDTO detalhamentoLoginDTO = new DetalhamentoLoginDTO(login);
            loginsDetalhados.add(detalhamentoLoginDTO);
        }

        return loginsDetalhados;
    }
    
    public Login buscarLoginPorId(Long id) throws NotFoundResourceException {
        Optional<Login> login = LoginRepository.findById(id);
    
        if(!login.isPresent()){
            throw new NotFoundResourceException("Não foi possivel encontrar o login");
        }

        return login.get();
    }
}

