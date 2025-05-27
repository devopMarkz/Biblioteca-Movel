package io.github.devopMarkz.library_system.dtos.usuario;

import io.github.devopMarkz.library_system.model.enums.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateDTO(

        @NotBlank(message = "Nome não pode estar nulo.")
        String nome,

        @NotNull(message = "Perfil deve ser definido.")
        Perfil perfil,

        @Size(min = 2, max = 20, message = "Senha deve conter no mínimo 2 caracteres.")
        String novaSenha
) {
}
