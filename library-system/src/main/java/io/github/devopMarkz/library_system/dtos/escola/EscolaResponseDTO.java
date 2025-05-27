package io.github.devopMarkz.library_system.dtos.escola;

import io.github.devopMarkz.library_system.dtos.endereco.EnderecoDTO;
import io.github.devopMarkz.library_system.model.enums.Status;

public record EscolaResponseDTO(
        Long id,
        String nome,
        String cnpj,
        EnderecoDTO endereco,
        Status status
) {}
