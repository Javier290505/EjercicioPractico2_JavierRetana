/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CasoPractico2.demo.controllers;

import CasoPractico2.demo.domain.Usuario;
import CasoPractico2.demo.service.UsuarioService;
import CasoPractico2.demo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jareg
 */

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @GetMapping("/usuarios/listado")
    public String listado(Model model) {
        model.addAttribute("usuarios", usuarioService.getUsuarios());
        return "usuarios/listado";
    }

    @GetMapping("/usuarios/nuevo")
    public String nuevoUsuario(Usuario usuario, Model model) {
        model.addAttribute("roles", rolService.getRoles());
        return "usuarios/modifica";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(Usuario usuario) {
        usuarioService.save(usuario, true);
        return "redirect:/usuarios/listado";
    }

    @GetMapping("/usuarios/modificar/{idUsuario}")
    public String modificarUsuario(@PathVariable("idUsuario") Long idUsuario, Model model) {
        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);
        usuario = usuarioService.getUsuario(usuario);

        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", rolService.getRoles());
        return "usuarios/modifica";
    }

    @GetMapping("/usuarios/eliminar/{idUsuario}")
    public String eliminarUsuario(@PathVariable("idUsuario") Long idUsuario) {
        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);
        usuarioService.delete(usuario);
        return "redirect:/usuarios/listado";
    }

    @GetMapping("/usuarios/detalle/{idUsuario}")
    public String detalleUsuario(@PathVariable("idUsuario") Long idUsuario, Model model) {
        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);
        usuario = usuarioService.getUsuario(usuario);

        model.addAttribute("usuario", usuario);
        return "usuarios/detalle";
    }

    @GetMapping("/registro")
    public String registro(Usuario usuario, Model model) {
        model.addAttribute("roles", rolService.getRoles());
        return "registro";
    }

    @PostMapping("/guardarRegistro")
    public String guardarRegistro(Usuario usuario) {
        usuarioService.save(usuario, true);
        return "redirect:/login";
    }
}
