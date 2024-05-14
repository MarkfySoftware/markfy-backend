package com.app.markfy.GerenciamentoDeCompras.config;

import com.app.markfy.GerenciamentoDeCompras.dto.actuator.actuatorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/actuator")
public class actuatorConfig {

    @GetMapping
    public ResponseEntity<actuatorDTO> status(){
        actuatorDTO actuatorDTO = new actuatorDTO("health");
        return ResponseEntity.status(200).body(actuatorDTO);
    }
}
