/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hydrasearch.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aherreram
 */
@Entity
@Table(name = "\"CREDIBILIDAD\"")
@NamedQueries({
    @NamedQuery(name = "Credibilidad.findAll", query = "SELECT c FROM Credibilidad c")})
public class Credibilidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_credibilidad")
    private Long idCredibilidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private long valor;
    @JsonIgnore
    @OneToMany(mappedBy = "idCredibilidad")
    private Collection<Transaccion> transaccionCollection;

    public Credibilidad() {
    }

    public Credibilidad(Long idCredibilidad) {
        this.idCredibilidad = idCredibilidad;
    }

    public Credibilidad(Long idCredibilidad, String nombre, long valor) {
        this.idCredibilidad = idCredibilidad;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Long getIdCredibilidad() {
        return idCredibilidad;
    }

    public void setIdCredibilidad(Long idCredibilidad) {
        this.idCredibilidad = idCredibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCredibilidad != null ? idCredibilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credibilidad)) {
            return false;
        }
        Credibilidad other = (Credibilidad) object;
        if ((this.idCredibilidad == null && other.idCredibilidad != null) || (this.idCredibilidad != null && !this.idCredibilidad.equals(other.idCredibilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.hydrasearch.entities.Credibilidad[ idCredibilidad=" + idCredibilidad + " ]";
    }
    
}
