package io.github.devopMarkz.library_system.dtos;

import io.github.devopMarkz.library_system.model.enums.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioCreateDTO(
    @NotBlank(message = "E-mail não pode estar nulo.")
    @Email(message = "Formato de e-mail incorreto.")
    String email,

    @NotBlank(message = "Senha não pode estar vazia.")
    String senha,

    @NotBlank(message = "Nome não pode estar vazio.")
    String nome,

    @NotBlank(message = "Perfil não pode estar vazio.")
    String perfil
) {
}
