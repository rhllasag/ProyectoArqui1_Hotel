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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TIPO_HABITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoHabitacion.findAll", query = "SELECT t FROM TipoHabitacion t"),
    @NamedQuery(name = "TipoHabitacion.findByTipCodigo", query = "SELECT t FROM TipoHabitacion t WHERE t.tipCodigo = :tipCodigo"),
    @NamedQuery(name = "TipoHabitacion.findByNombre", query = "SELECT t FROM TipoHabitacion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoHabitacion.findByDescripcion", query = "SELECT t FROM TipoHabitacion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoHabitacion.findByCapacidad", query = "SELECT t FROM TipoHabitacion t WHERE t.capacidad = :capacidad")})
public class TipoHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "seq1", sequenceName = "SEQUENCE_1", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
    @NotNull
    @Column(name = "TIP_CODIGO")
    private BigDecimal tipCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACIDAD")
    private BigInteger capacidad;
    @OneToMany(mappedBy = "tipCodigo")
    private Collection<Habitacion> habitacionCollection;

    public TipoHabitacion() {
    }

    public TipoHabitacion(BigDecimal tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public TipoHabitacion(BigDecimal tipCodigo, String nombre, BigInteger capacidad) {
        this.tipCodigo = tipCodigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public BigDecimal getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(BigDecimal tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(BigInteger capacidad) {
        this.capacidad = capacidad;
    }

    @XmlTransient
    public Collection<Habitacion> getHabitacionCollection() {
        return habitacionCollection;
    }

    public void setHabitacionCollection(Collection<Habitacion> habitacionCollection) {
        this.habitacionCollection = habitacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipCodigo != null ? tipCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoHabitacion)) {
            return false;
        }
        TipoHabitacion other = (TipoHabitacion) object;
        if ((this.tipCodigo == null && other.tipCodigo != null) || (this.tipCodigo != null && !this.tipCodigo.equals(other.tipCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ecutravel.hotel1.entities.TipoHabitacion[ tipCodigo=" + tipCodigo + " ]";
    }

}
