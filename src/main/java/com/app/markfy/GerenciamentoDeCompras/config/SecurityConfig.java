package com.app.markfy.GerenciamentoDeCompras.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserAuthenticationFilter userAuthenticationFilter;

    protected List<AntPathRequestMatcher> listaDeUrlsLiberadas = null;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        listaDeUrlsLiberadas = carregarListaUrlsLiberadas();

        http.authorizeHttpRequests((authorize) -> {
              for (AntPathRequestMatcher e: listaDeUrlsLiberadas){
                  authorize.requestMatchers(e).permitAll();
              }
        });
        http.authorizeHttpRequests((a) -> a.anyRequest().authenticated());

        http.headers(httpSecurityHeadersConfigurer -> {
            httpSecurityHeadersConfigurer.frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin().httpStrictTransportSecurity(d -> d.includeSubDomains(true).maxAgeInSeconds(31536000)));
        });
        http.addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class).httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected List<AntPathRequestMatcher> carregarListaUrlsLiberadas(){
        List<AntPathRequestMatcher> listaDeUrlsLiberadas = new ArrayList<>();
        listaDeUrlsLiberadas.add(new AntPathRequestMatcher("/swagger-ui.html"));
        listaDeUrlsLiberadas.add(new AntPathRequestMatcher("/swagger-ui/**"));
        listaDeUrlsLiberadas.add(new AntPathRequestMatcher("/login/token"));
        listaDeUrlsLiberadas.add(new AntPathRequestMatcher("/usuario/cadastro"));

        return listaDeUrlsLiberadas;
    }

}