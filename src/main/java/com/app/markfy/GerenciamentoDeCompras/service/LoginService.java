package com.app.markfy.GerenciamentoDeCompras.service;

import com.app.markfy.GerenciamentoDeCompras.dto.login.CadastroLoginDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.login.DetalhamentoLoginDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.security.JwtTokenDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.LoginException;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Login;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.app.markfy.GerenciamentoDeCompras.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
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
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    
    public JwtTokenDTO logar(CadastroLoginDTO cadastroLoginDTO) throws NotFoundResourceException, LoginException {
        try {
            Usuario usuario = usuarioService.buscarUsuarioPorEmail(cadastroLoginDTO.email());
            Login login = new Login(cadastroLoginDTO.email(), cadastroLoginDTO.senha(), usuario);
            JwtTokenDTO token = this.authenticateUser(cadastroLoginDTO);
            LoginRepository.save(login);
            return token;
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

    public JwtTokenDTO authenticateUser(CadastroLoginDTO loginUserDto) throws LoginException {
        try {
            Usuario usuario = usuarioService.buscarUsuarioPorEmail(loginUserDto.email());

            if(!usuario.getSenha().equals(loginUserDto.senha())){
                throw new LoginException("Email ou senha inválidos!");
            }

            return new JwtTokenDTO(jwtTokenService.generateToken(usuario));
        } catch (NotFoundResourceException e) {
            throw new LoginException("Email ou senha inválidos!");
        }
    }
}

