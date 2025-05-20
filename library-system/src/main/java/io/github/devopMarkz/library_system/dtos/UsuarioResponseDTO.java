package io.github.devopMarkz.library_system.dtos;

import io.github.devopMarkz.library_system.model.enums.Perfil;

public record UsuarioResponseDTO(
        Long id,
        String email,
        String nome,
        String perfil
) {
}
