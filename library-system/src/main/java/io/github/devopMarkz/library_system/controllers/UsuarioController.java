package io.github.devopMarkz.library_system.controllers;

import io.github.devopMarkz.library_system.dtos.usuario.UsuarioCreateDTO;
import io.github.devopMarkz.library_system.dtos.usuario.UsuarioResponseDTO;
import io.github.devopMarkz.library_system.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static io.github.devopMarkz.library_system.utils.UriGenerator.generateUri;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> createUsuario(@RequestBody UsuarioCreateDTO createDTO){
        var usuarioResponseDTO = usuarioService.createUsuario(createDTO);
        URI location = generateUri(usuarioResponseDTO.id());
        return ResponseEntity.created(location).body(usuarioResponseDTO);
    }

}
