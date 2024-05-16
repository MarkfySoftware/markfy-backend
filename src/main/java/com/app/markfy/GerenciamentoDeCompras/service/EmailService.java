package com.app.markfy.GerenciamentoDeCompras.service;

import com.app.markfy.GerenciamentoDeCompras.exceptions.BusinessException;
import com.app.markfy.GerenciamentoDeCompras.exceptions.NotFoundResourceException;
import com.app.markfy.GerenciamentoDeCompras.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static com.app.markfy.GerenciamentoDeCompras.service.JwtTokenService.*;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtTokenService jwtTokenService;

    public void enviarEmail(String emailDestino) throws NotFoundResourceException, BusinessException {
        Usuario usuario = usuarioService.buscarUsuarioPorEmail(emailDestino);

        if(usuario == null){
            throw new BusinessException("Este usuário não possui um cadastro no Markfy");
        }

        SimpleMailMessage message = new SimpleMailMessage();

        String assunto = "Esqueci minha senha do Markfy...";
        String corpo = "Olá, " + usuario.getNome() + "! Tudo bem?" +
                "\nVocê solicitou uma nova senha de acesso ao Markfy. Clique no link abaixo para redefinir a sua senha:" +
                "\nhttp://localhost:3000/link-redefinicao/" + jwtTokenService.generateToken(usuario);

        message.setTo(emailDestino);
        message.setSubject(assunto);
        message.setText(corpo);
        mailSender.send(message);
    }
}
