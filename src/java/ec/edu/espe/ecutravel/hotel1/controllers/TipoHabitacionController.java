/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.hotel1.controllers;

import ec.edu.espe.ecutravel.hotel1.dao.TipoHabitacionFacade;
import ec.edu.espe.ecutravel.hotel1.entities.TipoHabitacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author homer
 */
@Stateless
public class TipoHabitacionController {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private TipoHabitacionFacade facade;
    
    public List<TipoHabitacion> listTipoHabitaciones(){
    return facade.findAll();
    }
}
