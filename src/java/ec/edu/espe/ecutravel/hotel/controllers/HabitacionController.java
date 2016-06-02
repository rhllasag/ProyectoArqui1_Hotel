/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.hotel.controllers;

import ec.edu.espe.ecutravel.hotel.dao.HabitacionFacade;
import ec.edu.espe.ecutravel.hotel.entities.Habitacion;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author homer
 */
@Stateless
public class HabitacionController {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private HabitacionFacade facade;
    
    public List<Habitacion> listHabitaciones(){
    return facade.findAll();
    }
    public List<Habitacion> listReservadasPorfechas(Date inicio, Date fin){
    return facade.getListPorFechas(inicio, fin);
    }
    public Habitacion getByCodigo(Integer codigo){
    return facade.getByCodigo(codigo);
    }    
}
