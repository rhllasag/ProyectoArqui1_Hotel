/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.hotel.dao;

import ec.edu.espe.ecutravel.hotel.entities.TipoHabitacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author homer
 */
@Stateless
public class TipoHabitacionFacade extends AbstractFacade<TipoHabitacion> {

    @PersistenceContext(unitName = "Hotel1WSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoHabitacionFacade() {
        super(TipoHabitacion.class);
    }
    
}
