/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CasoPractico2.demo.service;

import CasoPractico2.demo.domain.Evento;
import java.util.List;

/**
 *
 * @author jareg
 */

public interface EventoService {
    List<Evento> getEventos();
    List<Evento> getEventosActivos();
    Evento getEvento(Evento evento);
    void save(Evento evento);
    void delete(Evento evento);
}
