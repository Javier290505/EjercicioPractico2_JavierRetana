/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CasoPractico2.demo.service;

import CasoPractico2.demo.domain.Usuario;
import CasoPractico2.demo.domain.Rol;
import CasoPractico2.demo.repository.UsuarioRepository;
import CasoPractico2.demo.repository.RolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author jareg
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioRepository.findById(usuario.getId()).orElse(null);
    }

    @Override
    public void save(Usuario usuario, boolean enviarCorreo) {
        boolean esNuevo = (usuario.getId() == null);

        if (usuario.getRol() != null && usuario.getRol().getId() != null) {
            Rol rolCompleto = rolRepository.findById(usuario.getRol().getId()).orElse(null);
            usuario.setRol(rolCompleto);
        }

        if (esNuevo) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        } else {
            Usuario usuarioBD = usuarioRepository.findById(usuario.getId()).orElse(null);
            if (usuarioBD != null) {
                if (usuario.getPassword() == null || usuario.getPassword().isBlank()) {
                    usuario.setPassword(usuarioBD.getPassword());
                } else {
                    usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
                }
            }
        }

        usuarioRepository.save(usuario);

        if (esNuevo && enviarCorreo) {
            mailService.enviarCorreoBienvenida(usuario.getEmail(), usuario.getNombre());
        }
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }
}
