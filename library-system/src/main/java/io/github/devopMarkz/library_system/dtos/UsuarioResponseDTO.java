package io.github.devopMarkz.library_system.dtos;

public record UsuarioResponseDTO(
        Long id,
        String email,
        String nome,
        String perfil,
        EscolaDTO escola
) {}
