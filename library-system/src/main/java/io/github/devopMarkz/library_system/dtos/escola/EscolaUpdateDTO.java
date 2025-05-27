package io.github.devopMarkz.library_system.dtos;

import io.github.devopMarkz.library_system.dtos.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EscolaUpdateDTO(
        @NotNull(message = "ID da escola é obrigatório")
        Long id,

        @NotBlank(message = "Nome não pode estar vazio")
        String nome,

        @NotBlank(message = "CNPJ não pode estar vazio")
        String cnpj,

        @Valid
        EnderecoDTO endereco,

        @NotBlank(message = "Status não pode estar vazio")
        String status
) {}
