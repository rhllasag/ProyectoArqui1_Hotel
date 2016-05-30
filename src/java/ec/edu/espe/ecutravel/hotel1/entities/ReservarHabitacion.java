/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.hotel1.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author homer
 */
@Entity
@Table(name = "RESERVAR_HABITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservarHabitacion.findAll", query = "SELECT r FROM ReservarHabitacion r"),
    @NamedQuery(name = "ReservarHabitacion.findByResHabCodigo", query = "SELECT r FROM ReservarHabitacion r WHERE r.resHabCodigo = :resHabCodigo"),
    @NamedQuery(name = "ReservarHabitacion.findByFechaInicio", query = "SELECT r FROM ReservarHabitacion r WHERE r.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "ReservarHabitacion.findByFechaFin", query = "SELECT r FROM ReservarHabitacion r WHERE r.fechaFin = :fechaFin"),
    @NamedQuery(name = "ReservarHabitacion.findByPrecioReserva", query = "SELECT r FROM ReservarHabitacion r WHERE r.precioReserva = :precioReserva"),
    @NamedQuery(name = "ReservarHabitacion.findByDesayuno", query = "SELECT r FROM ReservarHabitacion r WHERE r.desayuno = :desayuno")})
public class ReservarHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "seq4", sequenceName = "SEQUENCE_4", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq4")
    @Column(name = "RES_HAB_CODIGO")
    private Integer resHabCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_RESERVA")
    private BigDecimal precioReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESAYUNO")
    private BigDecimal desayuno;
    @JoinColumn(name = "HAB_CODIGO", referencedColumnName = "HAB_CODIGO")
    @ManyToOne
    private Habitacion habCodigo;
    @JoinColumn(name = "RES_CODIGO", referencedColumnName = "RES_CODIGO")
    @ManyToOne
    private Reserva resCodigo;

    public ReservarHabitacion() {
    }

    public ReservarHabitacion(Integer resHabCodigo) {
        this.resHabCodigo = resHabCodigo;
    }

    public ReservarHabitacion(Integer resHabCodigo, Date fechaInicio, Date fechaFin, BigDecimal precioReserva, BigDecimal desayuno) {
        this.resHabCodigo = resHabCodigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioReserva = precioReserva;
        this.desayuno = desayuno;
    }

    public Integer getResHabCodigo() {
        return resHabCodigo;
    }

    public void setResHabCodigo(Integer resHabCodigo) {
        this.resHabCodigo = resHabCodigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(BigDecimal precioReserva) {
        this.precioReserva = precioReserva;
    }

    public BigDecimal getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(BigDecimal desayuno) {
        this.desayuno = desayuno;
    }

    public Habitacion getHabCodigo() {
        return habCodigo;
    }

    public void setHabCodigo(Habitacion habCodigo) {
        this.habCodigo = habCodigo;
    }

    public Reserva getResCodigo() {
        return resCodigo;
    }

    public void setResCodigo(Reserva resCodigo) {
        this.resCodigo = resCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resHabCodigo != null ? resHabCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservarHabitacion)) {
            return false;
        }
        ReservarHabitacion other = (ReservarHabitacion) object;
        if ((this.resHabCodigo == null && other.resHabCodigo != null) || (this.resHabCodigo != null && !this.resHabCodigo.equals(other.resHabCodigo))) {
            return false;
        }
        return true;
    }

    public String toString1() {
        return "ReservarHabitacion{" + "resHabCodigo=" + resHabCodigo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", precioReserva=" + precioReserva + ", desayuno=" + desayuno + ", habCodigo=" + habCodigo + ", resCodigo=" + resCodigo + '}';
    }

    
    
    @Override
    public String toString() {
        return "ec.edu.espe.ecutravel.hotel1.entities.ReservarHabitacion[ resHabCodigo=" + resHabCodigo + " ]";
    }
    
}
