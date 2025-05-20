package io.github.devopMarkz.library_system.config;

import io.github.devopMarkz.library_system.model.Usuario;
import io.github.devopMarkz.library_system.repositories.UsuarioRepository;
import io.github.devopMarkz.library_system.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    public AuthenticationFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = obterToken(request);

        if(token != null) {
            String login = tokenService.validarTokenERetornarLogin(token);

            if(login != null) {
                Usuario usuario = usuarioRepository.findByEmail(login).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
                var usernamePassswordAuthentication = new UsernamePasswordAuthenticationToken(usuario, usuario.getPassword(), usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePassswordAuthentication);
            }

        }

        filterChain.doFilter(request, response);
    }

    private String obterToken(HttpServletRequest request) {
        var auth = request.getHeader("Authorization");

        if(auth == null || !auth.startsWith("Bearer ")) {
            return null;
        }

        return auth.split(" ")[1];
    }

}
