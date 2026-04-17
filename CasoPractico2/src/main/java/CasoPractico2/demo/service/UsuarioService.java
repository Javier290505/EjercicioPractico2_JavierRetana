/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CasoPractico2.demo.service;

import CasoPractico2.demo.domain.Usuario;
import java.util.List;
/**
 *
 * @author jareg
 */

public interface UsuarioService {
    List<Usuario> getUsuarios();
    Usuario getUsuario(Usuario usuario);
    void save(Usuario usuario, boolean enviarCorreo);
    void delete(Usuario usuario);
    Usuario findByEmail(String email);
}
