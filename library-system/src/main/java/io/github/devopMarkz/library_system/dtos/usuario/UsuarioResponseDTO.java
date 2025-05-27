package io.github.devopMarkz.library_system.dtos.usuario;

import io.github.devopMarkz.library_system.dtos.escola.EscolaDTO;

public record UsuarioResponseDTO(
        Long id,
        String email,
        String nome,
        String perfil,
        EscolaDTO escola
) {}
