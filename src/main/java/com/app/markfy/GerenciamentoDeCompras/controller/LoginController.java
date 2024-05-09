package com.app.markfy.GerenciamentoDeCompras.controller;

import com.app.markfy.GerenciamentoDeCompras.dto.login.CadastroLoginDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.login.DetalhamentoLoginDTO;
import com.app.markfy.GerenciamentoDeCompras.dto.security.JwtTokenDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.ErrorMessage;
import com.app.markfy.GerenciamentoDeCompras.exceptions.LoginException;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Login;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.app.markfy.GerenciamentoDeCompras.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Login")
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private ErrorMessage error;

    @Operation(summary = "Realiza o login de um usuário no sistema", responses = {
            @ApiResponse(responseCode = "200", description = "Sucesso",
                    content = @Content(schema = @Schema(implementation = CadastroLoginDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao efetuar login do usuário")})
    @PostMapping("/token")
    public ResponseEntity logar(@RequestBody CadastroLoginDTO cadastroLoginDTO){
        try {
            JwtTokenDTO login = loginService.logar(cadastroLoginDTO);
            return ResponseEntity.status(200).body(login);
        }catch (LoginException | NotFoundResourceException | Exception e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }

    @Operation(summary = "Lista todos os logins que aconteceram no sistema", responses = {
            @ApiResponse(responseCode = "200", description = "Sucesso",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Login.class))))})
    @GetMapping
    public ResponseEntity<List<DetalhamentoLoginDTO>> listar(){
        List<DetalhamentoLoginDTO> logins = loginService.listarLogins();
        return ResponseEntity.status(200).body(logins);
    }

    @Operation(summary = "Retorna um login com base no id", responses = {
            @ApiResponse(responseCode = "200", description = "Sucesso",
                    content = @Content(schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Erro ao buscar login")})
    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        try {
            Login login = loginService.buscarLoginPorId(id);
            return ResponseEntity.status(200).body(login);
        }catch (NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.status(400).body(error);
        }
    }
}
