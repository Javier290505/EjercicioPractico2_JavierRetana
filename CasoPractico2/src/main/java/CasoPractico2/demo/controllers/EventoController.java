/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CasoPractico2.demo.controllers;

import CasoPractico2.demo.domain.Evento;
import CasoPractico2.demo.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jareg
 */

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("eventos", eventoService.getEventos());
        return "eventos/listado";
    }

    @GetMapping("/publico")
    public String publico(Model model) {
        model.addAttribute("eventos", eventoService.getEventosActivos());
        return "eventos/publico";
    }

    @GetMapping("/nuevo")
    public String nuevoEvento(Evento evento) {
        return "eventos/modifica";
    }

    @PostMapping("/guardar")
    public String guardarEvento(Evento evento) {
        eventoService.save(evento);
        return "redirect:/eventos/listado";
    }

    @GetMapping("/modificar/{idEvento}")
    public String modificarEvento(@PathVariable("idEvento") Long idEvento, Model model) {
        Evento evento = new Evento();
        evento.setId(idEvento);
        evento = eventoService.getEvento(evento);

        model.addAttribute("evento", evento);
        return "eventos/modifica";
    }

    @GetMapping("/eliminar/{idEvento}")
    public String eliminarEvento(@PathVariable("idEvento") Long idEvento) {
        Evento evento = new Evento();
        evento.setId(idEvento);
        eventoService.delete(evento);
        return "redirect:/eventos/listado";
    }
}
