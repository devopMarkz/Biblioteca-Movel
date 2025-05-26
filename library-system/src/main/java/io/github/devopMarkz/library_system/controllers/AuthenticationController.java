package io.github.devopMarkz.library_system.controllers;

import io.github.devopMarkz.library_system.dtos.LoginDTO;
import io.github.devopMarkz.library_system.services.TokenService;
import io.github.devopMarkz.library_system.services.UsuarioService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, UsuarioService usuarioService, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
        this.tokenService = tokenService;
    }

    @PostMapping
    public String login(@RequestBody LoginDTO loginDTO) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.senha());
        authenticationManager.authenticate(authenticationToken);
        return tokenService.obterToken(loginDTO);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    public String testeEndpoint() {
        return "Ok";
    }
}
