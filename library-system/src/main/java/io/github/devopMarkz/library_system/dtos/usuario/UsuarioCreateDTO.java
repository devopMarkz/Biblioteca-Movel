package io.github.devopMarkz.library_system.dtos.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioCreateDTO(
        @NotBlank(message = "E-mail não pode estar nulo.")
        @Email(message = "Formato de e-mail incorreto.")
        String email,

        @NotBlank(message = "Senha não pode estar vazia.")
        String senha,

        @NotBlank(message = "Nome não pode estar vazio.")
        String nome,

        @NotBlank(message = "Perfil não pode estar vazio.")
        String perfil,

        @NotNull(message = "Escola deve ser informada.")
        Long escolaId
) {}
