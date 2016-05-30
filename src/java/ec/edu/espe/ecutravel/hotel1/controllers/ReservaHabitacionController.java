/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.hotel1.controllers;

import ec.edu.espe.ecutravel.hotel1.dao.HabitacionFacade;
import ec.edu.espe.ecutravel.hotel1.dao.ReservaFacade;
import ec.edu.espe.ecutravel.hotel1.dao.ReservarHabitacionFacade;
import ec.edu.espe.ecutravel.hotel1.entities.Habitacion;
import ec.edu.espe.ecutravel.hotel1.entities.Reserva;
import ec.edu.espe.ecutravel.hotel1.entities.ReservarHabitacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author homer
 */
@Stateless
public class ReservaHabitacionController {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private ReservarHabitacionFacade facade;

    public List<ReservarHabitacion> listReservarHabitaciones() {
        return facade.findAll();
    }
    public void insert(ReservarHabitacion reserva)
    {
        facade.create(reserva);
    }
}
