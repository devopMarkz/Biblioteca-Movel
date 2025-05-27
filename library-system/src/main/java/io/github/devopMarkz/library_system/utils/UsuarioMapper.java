package io.github.devopMarkz.library_system.utils;

import io.github.devopMarkz.library_system.dtos.escola.EscolaDTO;
import io.github.devopMarkz.library_system.dtos.usuario.UsuarioCreateDTO;
import io.github.devopMarkz.library_system.dtos.usuario.UsuarioResponseDTO;
import io.github.devopMarkz.library_system.model.Escola;
import io.github.devopMarkz.library_system.model.Usuario;
import io.github.devopMarkz.library_system.model.enums.Perfil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    private final PasswordEncoder passwordEncoder;
    private final EscolaMapper escolaMapper;

    public UsuarioMapper(PasswordEncoder passwordEncoder, EscolaMapper escolaMapper) {
        this.passwordEncoder = passwordEncoder;
        this.escolaMapper = escolaMapper;
    }

    public Usuario convertToUsuario(UsuarioCreateDTO dto, Escola escola) {
        return new Usuario(
                null,
                dto.email(),
                passwordEncoder.encode(dto.senha()),
                dto.nome(),
                Perfil.valueOf(dto.perfil()),
                escola
        );
    }

    public UsuarioResponseDTO convertToUsuarioResponseDTO(Usuario usuario) {
        EscolaDTO escolaDTO = escolaMapper.toDTO(usuario.getEscola());

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getNome(),
                usuario.getPerfil().name(),
                escolaDTO
        );
    }
}
