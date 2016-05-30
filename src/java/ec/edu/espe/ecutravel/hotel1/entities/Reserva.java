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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author homer
 */
@Entity
@Table(name = "RESERVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByResCodigo", query = "SELECT r FROM Reserva r WHERE r.resCodigo = :resCodigo"),
    @NamedQuery(name = "Reserva.findByPersona", query = "SELECT r FROM Reserva r WHERE r.persona = :persona"),
    @NamedQuery(name = "Reserva.findByPaquete", query = "SELECT r FROM Reserva r WHERE r.paquete = :paquete")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="seq3", sequenceName = "SEQUENCE_3",allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq3")
    @NotNull
    @Column(name = "RES_CODIGO")
    private Integer resCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONA")
    private Integer persona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAQUETE")
    private Integer paquete;
    @OneToMany(mappedBy = "resCodigo")
    private Collection<ReservarHabitacion> reservarHabitacionCollection;

    public Reserva() {
    }

    public Reserva(Integer resCodigo) {
        this.resCodigo = resCodigo;
    }

    public Reserva(Integer resCodigo, Integer persona, Integer paquete) {
        this.resCodigo = resCodigo;
        this.persona = persona;
        this.paquete = paquete;
    }

    public Integer getResCodigo() {
        return resCodigo;
    }

    public void setResCodigo(Integer resCodigo) {
        this.resCodigo = resCodigo;
    }

    public Integer getPersona() {
        return persona;
    }

    public void setPersona(Integer persona) {
        this.persona = persona;
    }

    public Integer getPaquete() {
        return paquete;
    }

    public void setPaquete(Integer paquete) {
        this.paquete = paquete;
    }

    @XmlTransient
    public Collection<ReservarHabitacion> getReservarHabitacionCollection() {
        return reservarHabitacionCollection;
    }

    public void setReservarHabitacionCollection(Collection<ReservarHabitacion> reservarHabitacionCollection) {
        this.reservarHabitacionCollection = reservarHabitacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resCodigo != null ? resCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.resCodigo == null && other.resCodigo != null) || (this.resCodigo != null && !this.resCodigo.equals(other.resCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ecutravel.hotel1.entities.Reserva[ resCodigo=" + resCodigo + " ]";
    }
    
}
