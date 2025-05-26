package io.github.devopMarkz.library_system.dtos;

public record EscolaDTO(
        Long id,
        String nome,
        String cnpj,
        EnderecoDTO endereco,
        String status
) {}