/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CasoPractico2.demo.repository;

import CasoPractico2.demo.domain.Evento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author jareg
 */

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByActivoTrue();
}
