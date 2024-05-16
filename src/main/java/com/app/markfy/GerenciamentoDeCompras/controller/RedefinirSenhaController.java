package com.app.markfy.GerenciamentoDeCompras.controller;

import com.app.markfy.GerenciamentoDeCompras.dto.redefinirSenha.EnviarEmailDTO;
import com.app.markfy.GerenciamentoDeCompras.exceptions.BusinessException;
import com.app.markfy.GerenciamentoDeCompras.exceptions.ErrorMessage;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.service.EmailService;
import com.app.markfy.GerenciamentoDeCompras.service.RedefinirSenhaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    @PostMapping("/enviar-email")
    public ResponseEntity enviarEmail(@RequestBody EnviarEmailDTO enviarEmailDTO){
        try{
            emailService.enviarEmail(enviarEmailDTO.email());
            return ResponseEntity.ok("E-mail enviado para: " + enviarEmailDTO.email());
        }catch (BusinessException | NotFoundResourceException e){
            error.setError(e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @Operation(summary = "Endpoint para redefinir a senha do usuário", responses = {
            @ApiResponse(responseCode = "200", description = "Sucesso",
                    content = @Content(schema = @Schema(implementation = EnviarEmailDTO.class)))})
    @PostMapping("/{token}")
    public ResponseEntity redefinirSenha(@PathVariable String token, @RequestBody String novaSenha) throws NotFoundResourceException {
        redefinirSenhaService.redefinirSenha(token, novaSenha);
        return ResponseEntity.ok("Senha atualizada com sucesso");
    }
}
