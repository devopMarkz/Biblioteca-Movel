package io.github.devopMarkz.library_system.utils;

import io.github.devopMarkz.library_system.dtos.UsuarioCreateDTO;
import io.github.devopMarkz.library_system.dtos.UsuarioResponseDTO;
import io.github.devopMarkz.library_system.model.Usuario;
import io.github.devopMarkz.library_system.model.enums.Perfil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    private final PasswordEncoder passwordEncoder;

    public UsuarioMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario convertToUsuario(UsuarioCreateDTO createDTO){
        return new Usuario(
                null,
                createDTO.email(),
                passwordEncoder.encode(createDTO.senha()),
                createDTO.nome(),
                Perfil.valueOf(createDTO.perfil())
        );
    }

    public UsuarioResponseDTO convertToUsuarioResponseDTO(Usuario usuario){
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getNome(),
                usuario.getPerfil().name()
        );
    }

}
