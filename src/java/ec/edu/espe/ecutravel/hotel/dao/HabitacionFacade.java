/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.hotel.dao;

import ec.edu.espe.ecutravel.hotel.entities.Habitacion;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author homer
 */
@Stateless
public class HabitacionFacade extends AbstractFacade<Habitacion> {

    @PersistenceContext(unitName = "Hotel1WSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Habitacion> getListPorFechas(Date inicio,Date fin) {
        return (List<Habitacion>)em.createNamedQuery("Habitacion.findReservadasEnFechas").
                setParameter("fechaInicio", inicio).setParameter("fechaFin", fin).getResultList();                
    }

    public HabitacionFacade() {
        super(Habitacion.class);
    }

    public Habitacion getByCodigo(Integer codigo) {
        return (Habitacion)em.createNamedQuery("Habitacion.findByHabCodigo").setParameter("habCodigo", codigo).getSingleResult();
    }
    
}
