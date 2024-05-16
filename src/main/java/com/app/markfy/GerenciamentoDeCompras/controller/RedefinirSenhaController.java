package com.app.markfy.GerenciamentoDeCompras.controller;

import com.app.markfy.GerenciamentoDeCompras.dto.redefinirSenha.EnviarEmailDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.BusinessException;
import com.app.markfy.GerenciamentoDeCompras.exceptions.ErrorMessage;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.service.EmailService;
import com.app.markfy.GerenciamentoDeCompras.service.RedefinirSenhaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Redefinir Senha")
@Controller
@RequestMapping("/redefinir-senha")
public class RedefinirSenhaController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private RedefinirSenhaService redefinirSenhaService;

    @Autowired
    private ErrorMessage error;

    @Operation(summary = "Envia e-mail para usuário redefinir a senha", responses = {
            @ApiResponse(responseCode = "200", description = "Sucesso",
                    content = @Content(schema = @Schema(implementation = EnviarEmailDTO.class)))})
    @PostMapping
    public ResponseEntity enviarEmail(@RequestBody EnviarEmailDTO enviarEmailDTO){
        try{
            emailService.enviarEmail(enviarEmailDTO.email());
            return ResponseEntity.ok("E-mail enviado para: " + enviarEmailDTO.email());
        }catch (BusinessException | NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PostMapping("/nova-senha")
    public ResponseEntity redefinirSenha(@RequestBody EnviarEmailDTO enviarEmailDTO){
        try{
            emailService.enviarEmail(enviarEmailDTO.email());
            return ResponseEntity.ok("E-mail enviado para: " + enviarEmailDTO.email());
        }catch (BusinessException | NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    //gerar um token na url de envio que contenha o usuário  DTO(token, novaSenha), depois da página ser acessada uma vez o token expira

}
