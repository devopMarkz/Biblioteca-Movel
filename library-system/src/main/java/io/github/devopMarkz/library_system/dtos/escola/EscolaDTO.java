package io.github.devopMarkz.library_system.dtos.escola;

import io.github.devopMarkz.library_system.dtos.endereco.EnderecoDTO;

public record EscolaDTO(
        Long id,
        String nome,
        String cnpj,
        EnderecoDTO endereco,
        String status
) {}