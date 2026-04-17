/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CasoPractico2.demo.service;

import CasoPractico2.demo.domain.Rol;
import java.util.List;


/**
 *
 * @author jareg
 */

public interface RolService {
    List<Rol> getRoles();
    Rol getRol(Rol rol);
    void save(Rol rol);
    void delete(Rol rol);
}
