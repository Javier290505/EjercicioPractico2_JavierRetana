/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CasoPractico2.demo.controllers;

import CasoPractico2.demo.domain.Rol;
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
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("roles", rolService.getRoles());
        return "roles/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoRol(Rol rol) {
        return "roles/modifica";
    }

    @PostMapping("/guardar")
    public String guardarRol(Rol rol) {
        rolService.save(rol);
        return "redirect:/roles/listado";
    }

    @GetMapping("/modificar/{idRol}")
    public String modificarRol(@PathVariable("idRol") Long idRol, Model model) {
        Rol rol = new Rol();
        rol.setId(idRol);
        rol = rolService.getRol(rol);
        model.addAttribute("rol", rol);
        return "roles/modifica";
    }

    @GetMapping("/eliminar/{idRol}")
    public String eliminarRol(@PathVariable("idRol") Long idRol) {
        Rol rol = new Rol();
        rol.setId(idRol);
        rolService.delete(rol);
        return "redirect:/roles/listado";
    }
}
