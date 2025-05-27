package io.github.devopMarkz.library_system.services;

import io.github.devopMarkz.library_system.dtos.usuario.UsuarioCreateDTO;
import io.github.devopMarkz.library_system.dtos.usuario.UsuarioResponseDTO;
import io.github.devopMarkz.library_system.model.Escola;
import io.github.devopMarkz.library_system.model.Usuario;
import io.github.devopMarkz.library_system.repositories.EscolaRepository;
import io.github.devopMarkz.library_system.repositories.UsuarioRepository;
import io.github.devopMarkz.library_system.utils.UsuarioMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final EscolaRepository escolaRepository;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          UsuarioMapper usuarioMapper,
                          EscolaRepository escolaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.escolaRepository = escolaRepository;
    }

    @Transactional
    public UsuarioResponseDTO createUsuario(UsuarioCreateDTO createDTO){
        Escola escola = escolaRepository.findById(createDTO.escolaId())
                .orElseThrow(() -> new IllegalArgumentException("Escola não encontrada com id: " + createDTO.escolaId()));

        Usuario usuario = usuarioMapper.convertToUsuario(createDTO, escola);

        usuarioRepository.save(usuario);

        return usuarioMapper.convertToUsuarioResponseDTO(usuario);
    }
}
