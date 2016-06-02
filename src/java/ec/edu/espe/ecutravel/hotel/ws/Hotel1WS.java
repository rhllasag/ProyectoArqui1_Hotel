/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.hotel.ws;

import ec.edu.espe.ecutravel.hotel.controllers.HabitacionController;
import ec.edu.espe.ecutravel.hotel.controllers.ReservaController;
import ec.edu.espe.ecutravel.hotel.controllers.ReservaHabitacionController;
import ec.edu.espe.ecutravel.hotel.entities.Habitacion;
import ec.edu.espe.ecutravel.hotel.entities.Reserva;
import ec.edu.espe.ecutravel.hotel.entities.ReservarHabitacion;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author homer
 */
@WebService(serviceName = "Hotel1WS")
public class Hotel1WS {

    @EJB
    private HabitacionController ejbHab;
    @EJB
    private ReservaController ejbRes;
    @EJB
    private ReservaHabitacionController ejbRha;

    @WebMethod(operationName = "registrarReserva")
    public boolean registrarReserva(
            @WebParam(name = "persona") Integer persona,
            @WebParam(name = "paquete") Integer paquete,
            @WebParam(name = "inicio") String inicio,
            @WebParam(name = "fin") String fin,
            @WebParam(name = "habitaciones") List<Integer> habitaciones,
            @WebParam(name = "desayuno") boolean desayuno
    ) {

        if (new Date(inicio).before(new Date(fin))) {
            Reserva reserva = new Reserva();
            reserva.setPaquete(paquete);
            reserva.setPersona(persona);
            ejbRes.insert(reserva);
            for (Integer habitacione : habitaciones) {

                Habitacion hab = ejbHab.getByCodigo(habitacione);
                System.out.println(hab);

                ReservarHabitacion reservarhabitacion = new ReservarHabitacion();
                reservarhabitacion.setFechaFin(new Date(fin));
                reservarhabitacion.setFechaInicio(new Date(inicio));
                reservarhabitacion.setPrecioReserva(hab.getPrecioCatalogo());
                if (desayuno) {
                    reservarhabitacion.setDesayuno(BigDecimal.ONE);
                }
                else{
                reservarhabitacion.setDesayuno(BigDecimal.ZERO);
                }
                reservarhabitacion.setHabCodigo(hab);
                System.out.println("habitacion" + ejbHab.getByCodigo(habitacione).toString());
                reservarhabitacion.setResCodigo(reserva);
                System.out.println(reserva.toString());

                System.out.println(reservarhabitacion.toString1());
                ejbRha.insert(reservarhabitacion);
            }
            return true;
        }
        return false;
    }

    @WebMethod(operationName = "buscarHabitacionesEnFechas")
    public List<Habitacion> listReservasHabitacionesPorFechas(
            @WebParam(name = "fecha1") String inicio,
            @WebParam(name = "fecha2") String fin
    ) {
        List<Habitacion> totalHabitaciones = ejbHab.listHabitaciones();
        List<Habitacion> Reservadas = ejbHab.listReservadasPorfechas(new Date(inicio), new Date(fin));
        for (int i = 0; i < totalHabitaciones.size(); i++) {
            for (int j = 0; j < Reservadas.size(); j++) {
                if (totalHabitaciones.get(i).getHabCodigo() == Reservadas.get(j).getHabCodigo()) {
                    totalHabitaciones.remove(i);
                }
            }
        }

        return totalHabitaciones;
    }

}