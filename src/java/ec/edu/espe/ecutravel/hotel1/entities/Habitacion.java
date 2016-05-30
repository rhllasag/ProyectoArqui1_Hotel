/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ecutravel.hotel1.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author homer
 */
@Entity
@Table(name = "HABITACION")
@XmlRootElement
@NamedQueries({ //AND h.fechaInicio BETWEEN :fechaInicio AND :fechaFin OR h.fechaFin BETWEEN :fechaInicio AND :fechaFin
    @NamedQuery(name = "Habitacion.findAll", query = "SELECT h FROM Habitacion h"),
/*    @NamedQuery(name = "Habitacion.findPrecioDesayuno", query = "SELECT h FROM Habitacion h WHERE h.precioDesayuno = :precioDesayuno"),
    @NamedQuery(name = "Habitacion.findPrecioCatalogo", query = "SELECT h FROM Habitacion h WHERE h.precioCatalogo = :precioCatalogo"),*/
    @NamedQuery(name = "Habitacion.findReservadasEnFechas", query = "SELECT h FROM Habitacion h, ReservarHabitacion r WHERE h.habCodigo = r.habCodigo.habCodigo AND r.fechaInicio BETWEEN :fechaInicio AND :fechaFin OR r.fechaFin BETWEEN :fechaInicio AND :fechaFin"),
    @NamedQuery(name = "Habitacion.findByHabCodigo", query = "SELECT h FROM Habitacion h WHERE h.habCodigo = :habCodigo"),
    @NamedQuery(name = "Habitacion.findByNumero", query = "SELECT h FROM Habitacion h WHERE h.numero = :numero"),
    @NamedQuery(name = "Habitacion.findByPrecioCatalogo", query = "SELECT h FROM Habitacion h WHERE h.precioCatalogo = :precioCatalogo"),
    @NamedQuery(name = "Habitacion.findByDescripcion", query = "SELECT h FROM Habitacion h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "Habitacion.findByHotel", query = "SELECT h FROM Habitacion h WHERE h.hotel = :hotel"),
    @NamedQuery(name = "Habitacion.findByPrecioDesayuno", query = "SELECT h FROM Habitacion h WHERE h.precioDesayuno = :precioDesayuno")})
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="seq2", sequenceName = "SEQUENCE_2",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
    @NotNull
    @Column(name = "HAB_CODIGO")
    private Integer habCodigo;
    @Column(name = "NUMERO")
    private BigInteger numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_CATALOGO")
    private BigDecimal precioCatalogo;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "HOTEL")
    private String hotel;
    @Column(name = "PRECIO_DESAYUNO")
    private BigDecimal precioDesayuno;
    @OneToMany(mappedBy = "habCodigo",cascade=CascadeType.ALL)
    private Collection<ReservarHabitacion> reservarHabitacionCollection;
    @JoinColumn(name = "TIP_CODIGO", referencedColumnName = "TIP_CODIGO")
    @ManyToOne
    private TipoHabitacion tipCodigo;

    public Habitacion() {
    }

    public Habitacion(Integer habCodigo) {
        this.habCodigo = habCodigo;
    }

    public Habitacion(Integer habCodigo, BigDecimal precioCatalogo) {
        this.habCodigo = habCodigo;
        this.precioCatalogo = precioCatalogo;
    }

    public Integer getHabCodigo() {
        return habCodigo;
    }

    public void setHabCodigo(Integer habCodigo) {
        this.habCodigo = habCodigo;
    }

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
        this.numero = numero;
    }

    public BigDecimal getPrecioCatalogo() {
        return precioCatalogo;
    }

    public void setPrecioCatalogo(BigDecimal precioCatalogo) {
        this.precioCatalogo = precioCatalogo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public BigDecimal getPrecioDesayuno() {
        return precioDesayuno;
    }

    public void setPrecioDesayuno(BigDecimal precioDesayuno) {
        this.precioDesayuno = precioDesayuno;
    }

    @XmlTransient
    public Collection<ReservarHabitacion> getReservarHabitacionCollection() {
        return reservarHabitacionCollection;
    }

    public void setReservarHabitacionCollection(Collection<ReservarHabitacion> reservarHabitacionCollection) {
        this.reservarHabitacionCollection = reservarHabitacionCollection;
    }

    public TipoHabitacion getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(TipoHabitacion tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (habCodigo != null ? habCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.habCodigo == null && other.habCodigo != null) || (this.habCodigo != null && !this.habCodigo.equals(other.habCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ecutravel.hotel1.entities.Habitacion[ habCodigo=" + habCodigo + " ]";
    }
    
}
