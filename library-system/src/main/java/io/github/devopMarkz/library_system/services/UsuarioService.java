package io.github.devopMarkz.library_system.services;

import io.github.devopMarkz.library_system.dtos.UsuarioCreateDTO;
import io.github.devopMarkz.library_system.dtos.UsuarioResponseDTO;
import io.github.devopMarkz.library_system.model.Usuario;
import io.github.devopMarkz.library_system.repositories.UsuarioRepository;
import io.github.devopMarkz.library_system.utils.UsuarioMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Transactional
    public UsuarioResponseDTO createUsuario(UsuarioCreateDTO createDTO){
        Usuario usuario = usuarioMapper.convertToUsuario(createDTO);
        usuarioRepository.save(usuario);
        return usuarioMapper.convertToUsuarioResponseDTO(usuario);
    }
}
