package io.github.devopMarkz.library_system.dtos;

public record EnderecoDTO(
        String cep,
        String logradouro,
        String numero,
        String bairro,
        String localidade,
        String uf,
        String estado
) {}