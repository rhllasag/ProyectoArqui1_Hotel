/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.hotel.controllers;

import ec.edu.espe.ecutravel.hotel.dao.ReservaFacade;
import ec.edu.espe.ecutravel.hotel.entities.Reserva;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author homer
 */
@Stateless
public class ReservaController {
    
    @EJB
    private ReservaFacade facade;
    
    public List<Reserva> listReservas(){
    return facade.findAll();
    }
    public void insert(Reserva reserva)
    {
        facade.create(reserva);
    }
}
