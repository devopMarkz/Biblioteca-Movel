package io.github.devopMarkz.library_system.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import io.github.devopMarkz.library_system.dtos.LoginDTO;
import io.github.devopMarkz.library_system.model.Usuario;
import io.github.devopMarkz.library_system.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    private UsuarioRepository usuarioRepository;

    public TokenService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String obterToken(LoginDTO loginDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginDTO.email())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário inexistente."));
        return gerarToken(usuario);
    }

    private String gerarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withIssuer("Biblioteca API")
                    .withSubject(usuario.getEmail())
                    .withClaim("Role", usuario.getPerfil().name())
                    .withExpiresAt(Instant.now().plus(72L, ChronoUnit.HOURS))
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new JWTCreationException("Erro ao tentar gerar token.", e);
        }
    }

    public String validarTokenERetornarLogin(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.require(algorithm)
                    .withIssuer("Biblioteca API")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException e){
            throw new JWTCreationException("Erro ao tentar gerar token.", e);
        }
    }
}
