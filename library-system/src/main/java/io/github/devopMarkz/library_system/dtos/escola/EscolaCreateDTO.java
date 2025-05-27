package io.github.devopMarkz.library_system.dtos.escola;

import io.github.devopMarkz.library_system.dtos.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record EscolaCreateDTO(
        @NotBlank(message = "Nome não pode estar vazio")
        String nome,

        @NotBlank(message = "CNPJ não pode estar vazio")
        String cnpj,

        @Valid
        EnderecoDTO endereco,

        @NotBlank(message = "Status não pode estar vazio")
        String status
) {}
